package com.pingconsole.chat.repository;

import com.pingconsole.chat.domain.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long>{
    List<ChatMessageModel> findAllByOrderByCreateDateAsc();
}
