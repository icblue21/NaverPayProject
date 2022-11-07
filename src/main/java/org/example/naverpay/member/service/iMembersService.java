package org.example.naverpay.member.service;

import org.example.naverpay.member.dto.MembersDTO;

public interface iMembersService {

    MembersDTO login(String mId, String mPw);
}
