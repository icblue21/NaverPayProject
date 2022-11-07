package org.example.naverpay.member.service;

import org.example.naverpay.member.dto.ShoppingDTO;

import java.util.List;

public interface iShoppingService {

    List<ShoppingDTO> getAllShoppingList(String uId,String startDate, String endDate);

    ShoppingDTO getShoppingInfo(String sId);

    void deleteShoppingList(String sId);

}
