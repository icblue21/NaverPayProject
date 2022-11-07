package org.example.naverpay.member.service;

import org.example.naverpay.member.dao.MembersDAO;
import org.example.naverpay.member.dto.MembersDTO;
import org.example.naverpay.member.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService implements  iMembersService {

    private MembersDAO membersDAO = MembersDAO.getInstance();

    private static MembersService membersService = null;

    public static MembersService getInstance() {
        if (membersService == null) {
            membersService = new MembersService();
        }
        return membersService;
    }

    @Override
    public MembersDTO login(String mId, String mPw) {
        MembersDTO membersDTO = new MembersDTO(mId, mPw);
        if (membersDTO == null) return null;

        Members member = membersDAO.select(membersDTO.getmId());
        if (member == null || member.getmPw() == null) return null;
        if (member.getmPw().equals(membersDTO.getmPw())) {
            return membersDTO;
        }

        return null;
    }
}
