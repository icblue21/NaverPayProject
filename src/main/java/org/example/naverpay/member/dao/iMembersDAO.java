package org.example.naverpay.member.dao;

import org.example.naverpay.member.entity.Members;

public interface iMembersDAO {
    Members select(String uId);

}
