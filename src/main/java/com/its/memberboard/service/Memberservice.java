package com.its.memberboard.service;

import com.its.memberboard.dto.MemberDTO;
import com.its.memberboard.entity.Memberentity;
import com.its.memberboard.repository.Memberrepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Memberservice {
    final Memberrepository mr;
    public void save(MemberDTO memberDTO) {
        Memberentity Me = Memberentity.tosaveentity(memberDTO);
        mr.save(Me);
    }

    public MemberDTO me(String memail) {
       Optional<Memberentity> mb = mr.findByMemail(memail);
       if(mb.isPresent()){
       MemberDTO md = MemberDTO.tomemberDto(mb.get());
       return md;}
       return null;
    }
}
