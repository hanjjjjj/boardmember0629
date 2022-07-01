package com.its.memberboard.controller;

import com.its.memberboard.dto.BoardDTO;
import com.its.memberboard.repository.Boardrepository;
import com.its.memberboard.service.Boardservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    final Boardservice service;
    final Boardrepository repository;

    @GetMapping("/save")
    String save() {
        return "save";
    }

    @PostMapping("save")
    String bsave(@ModelAttribute BoardDTO boardDTO) {
        service.save(boardDTO);
        return "index";
    }

    @GetMapping("list")
    String list(Model model) {
        List<BoardDTO> Bd = service.findAll();
        model.addAttribute("list", Bd);
        return "list";
    }

    @GetMapping("detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        repository.re(id);
        BoardDTO Bo = service.findById(id);
        model.addAttribute("detail", Bo);
        return "detail";
    }

    @GetMapping("update/{id}")
    String update(@PathVariable Long id, Model model) {
        BoardDTO Bo = service.findById(id);
        model.addAttribute("detail", Bo);
        return "update";
    }

    @PostMapping("update")
    String update1(@ModelAttribute BoardDTO boardDTO) {
        Long id = service.update(boardDTO);
        return "redirect:/detail/" + id;
    }
    @GetMapping("del/{id}")
    String del(@PathVariable Long id){
        service.delete(id);
        return "redirect:/list";
    }
}
