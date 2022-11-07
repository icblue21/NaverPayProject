package org.example.naverpay.member.dao;

import org.example.naverpay.member.entity.Members;

import java.util.List;

public interface iMembersDAO {
    Members select(String uId);

}
