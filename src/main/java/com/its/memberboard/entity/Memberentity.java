package com.its.memberboard.entity;

import com.its.memberboard.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mtable")
@Getter @Setter
public class Memberentity {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column(length = 20)
    String mp;

    @Column(length = 10)
    String mn;

    @Column(length = 20)
    String memail;

    @Column(length = 30)
    String mphone;

    public static Memberentity tosaveentity(MemberDTO memberDTO){
     Memberentity me = new Memberentity();
     me.setMp(memberDTO.getMp());
     me.setMn(memberDTO.getMn());
     me.setMemail(memberDTO.getMemail());
     me.setMphone(memberDTO.getMphone());
     return me;
    }
 public static Memberentity toentity(MemberDTO memberDTO) {
  Memberentity me = new Memberentity();
  me.setMp(memberDTO.getMp());
  me.setMn(memberDTO.getMn());
  me.setMemail(memberDTO.getMemail());
  me.setMphone(memberDTO.getMphone());
  return me;
 }

}
