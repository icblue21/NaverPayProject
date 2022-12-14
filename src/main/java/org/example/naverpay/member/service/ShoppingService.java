package org.example.naverpay.member.service;


import org.example.naverpay.member.dao.ShoppingDAO;
import org.example.naverpay.member.dto.ShoppingDTO;
import org.example.naverpay.member.entity.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;


@Service
public class ShoppingService implements iShoppingService {

    private ShoppingDAO shoppingDAO;

    @Autowired
    public ShoppingService(ShoppingDAO shoppingDAO) {
        this.shoppingDAO = shoppingDAO;
    }


    @Override
    @Transactional(readOnly = true)
    public List<ShoppingDTO> getAllShoppingList(String mId,String startDate, String endDate) {

        List<Shopping> shoppingList = shoppingDAO.selectAll(mId,startDate,endDate);
        if( shoppingList == null ){
            return null;
        }
        List<ShoppingDTO> list = new LinkedList<>();
        for(int i=0; i<shoppingList.size(); i++){
            list.add(shoppingList.get(i).toDTO());
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public ShoppingDTO getShoppingInfo(String sId) {

        Shopping shopping = shoppingDAO.select(sId);
        if(shopping == null){
            return null;
        }
        ShoppingDTO shoppingDTO = shopping.toDTO();
        return shoppingDTO;
    }

    @Override
    @Transactional
    public void deleteShoppingList(String sId) {

        int res = shoppingDAO.delete(sId);
    }
}
