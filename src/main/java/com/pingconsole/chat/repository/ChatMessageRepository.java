package com.pingconsole.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.chat.domain.ChatMessageModel;

public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long>{
	List<ChatMessageModel> findAllByOrderByCreateDateAsc();
}
