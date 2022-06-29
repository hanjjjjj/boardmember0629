package com.its.memberboard.entity;

import com.its.memberboard.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="board1_table")
@Getter @Setter
public class Boardentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column(length = 20)
    String title;

    @Column(length = 20)
    String text;

    @Column(length = 20)
    String writer;

    @Column
    int Hits;

    public static Boardentity tosaveentity(BoardDTO boardDTO) {
        Boardentity be = new Boardentity();
        be.setText(boardDTO.getText());
        be.setTitle(boardDTO.getTitle());
        be.setWriter(boardDTO.getWriter());
        be.setHits(0);
        return be;
    }

    public static Boardentity toentity(BoardDTO boardDTO) {
        Boardentity be = new Boardentity();
        be.setId(boardDTO.getId());
        be.setText(boardDTO.getText());
        be.setTitle(boardDTO.getTitle());
        be.setWriter(boardDTO.getWriter());
        be.setHits(boardDTO.getHits());
        return be;
    }
}
