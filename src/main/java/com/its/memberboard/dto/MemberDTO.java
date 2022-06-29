package com.its.memberboard.dto;

import com.its.memberboard.entity.Memberentity;
import lombok.Data;

@Data
public class MemberDTO {
    String mp;
    String mn;
    String memail;
    String mphone;

    public static MemberDTO tomemberDto(Memberentity memberentity){
        MemberDTO md = new MemberDTO();
        md.setMemail(memberentity.getMemail());
        md.setMn(memberentity.getMn());
        md.setMp(memberentity.getMp());
        md.setMphone(memberentity.getMphone());
        return md;
    }


}
