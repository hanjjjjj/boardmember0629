package com.its.memberboard.service;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.entity.Boardentity;
import com.its.memberboard.repository.Boardrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Boardservice {
    final Boardrepository Br;

    public Long update(BoardDTO boardDTO) {
        Boardentity boardentity =Boardentity.toentity(boardDTO);
        return Br.save(boardentity).getId();

    }

    public void save(BoardDTO boardDTO) {
        Boardentity Be = Boardentity.tosaveentity(boardDTO);
        Br.save(Be);
    }

    public List<BoardDTO> findAll() {
        List<Boardentity> Bl = Br.findAll();
        List<BoardDTO> list = new ArrayList<>();
        for(int i=0; i<Bl.size(); i++){
           list.add(BoardDTO.todto(Bl.get(i)));
        }
        return list;
    }

    public BoardDTO findById(Long id) {
        Optional<Boardentity> Bd = Br.findById(id);
        if(Bd.isPresent()){
            return BoardDTO.todto(Bd.get());

        }return null;
    }

    public void delete(Long id) {
        Br.deleteById(id);
    }
}
