package com.its.memberboard;

import com.its.memberboard.controller.BoardController;
import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.service.Boardservice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class test {
   @Autowired
    Boardservice service;
   @Autowired
    BoardController controller;
  @Test
  @Transactional
  @Rollback(value = false)
    @DisplayName("글작성 테스트")
    public void saveTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setWriter("테스트 작성자");
        boardDTO.setTitle("테스트 제목");
        boardDTO.setText("테스트 내용");
        service.save(boardDTO);
  }
  @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("글목록 테스트")
    public void listTest(){
      service.findAll();
  }

}
