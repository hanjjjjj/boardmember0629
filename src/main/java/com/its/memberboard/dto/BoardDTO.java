package com.its.memberboard.dto;

import com.its.memberboard.entity.Boardentity;
import lombok.Data;

@Data
public class BoardDTO {
    Long id;
    String title;
    String text;
    String writer;
    int hits;

   public static BoardDTO todto(Boardentity boardentity){
        BoardDTO td=new BoardDTO();
        td.setText(boardentity.getText());
        td.setTitle(boardentity.getTitle());
        td.setWriter(boardentity.getWriter());
        td.setId(boardentity.getId());
        td.setHits(boardentity.getHits());
        return td;
    }
}
