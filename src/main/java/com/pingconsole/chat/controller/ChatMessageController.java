package com.pingconsole.chat.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingconsole.chat.domain.ChatMessage;
import com.pingconsole.chat.domain.ChatMessageModel;
import com.pingconsole.chat.repository.ChatMessageRepository;

@Controller
public class ChatMessageController {

	@Autowired
	private ChatMessageRepository chatMessageRepository;
	@Autowired
	private SessionRegistry sessionRegistry;

	@RequestMapping("/getLoggedInUsers")
	@ResponseBody public String getOnlineUsers() {
		List<String> retValue = new ArrayList<String>();
		List<Object> onlineUsers = sessionRegistry.getAllPrincipals();
		for (Object usr : onlineUsers) {
			retValue.add(((User) usr).getUsername());
		}
		return retValue.toString();
	}

	@RequestMapping("/chat")
	public String chat() {
		return "chat/index";
	}

	@RequestMapping(value = "/messages", method = RequestMethod.POST)
	@MessageMapping("/newMessage")
	@SendTo("/topic/newMessage")
	public ChatMessage save(ChatMessageModel chatMessageModel) {
		ChatMessageModel chatMessage = new ChatMessageModel(chatMessageModel.getText(), chatMessageModel.getAuthor(),
				new Date());
		ChatMessageModel message = chatMessageRepository.save(chatMessage);
		List<ChatMessageModel> chatMessageModelList = chatMessageRepository
				.findAll(new PageRequest(0, 1, Sort.Direction.DESC, "createDate")).getContent();
		return new ChatMessage(chatMessageModelList.toString());
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public HttpEntity list() {
		List<ChatMessageModel> chatMessageModelList = chatMessageRepository
				.findAll(new PageRequest(0, 30, Sort.Direction.DESC, "createDate")).getContent();
		return new ResponseEntity(chatMessageModelList, HttpStatus.OK);
	}
}
