package com.its.memberboard.controller;

import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.service.Memberservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("member")

public class MemberController {

    final Memberservice mservice;

   @GetMapping("save-form")
    String saveform(){
       return "/member/save-form";
   }
   @PostMapping("save")
    String save(@ModelAttribute MemberDTO memberDTO){
       mservice.save(memberDTO);
       return "/member/login";
   }
   @PostMapping("login")
    String login(HttpSession session, @RequestParam("memail")String memail, @RequestParam("mp")String mp){
       MemberDTO mr = mservice.me(memail);
       if(mr!=null){
           if(mr.getMp().equals(mp)){
               session.setAttribute("se",mr);
               return "main";
           }
       }
       return "/member/login";
   }
   @GetMapping("/login")
    String login1(){
       return "/member/login";
   }
}
