package org.example.naverpay.member.controller.login;

import org.example.naverpay.member.dto.PaymentDTO;
import org.example.naverpay.member.dto.ShoppingDTO;
import org.example.naverpay.member.service.PaymentService;
import org.example.naverpay.member.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/naver")
public class ShoppingDetailController {  /*쇼핑 상세접근 페이지 컨트롤러*/

    private PaymentService paymentService;
    private ShoppingService shoppingService;

    @Autowired
    public ShoppingDetailController(PaymentService paymentService, ShoppingService shoppingService) {
        this.paymentService = paymentService;
        this.shoppingService = shoppingService;
    }

    @GetMapping("/pay/detail")
    public String orderStatusPage(@RequestParam("sId") String sId, HttpSession session, Model model) {
        String view = "/member/login/shoppingDetail";

        if (!(paymentService.isLogin(session))) {  // 로그인을 했는지 여부를 물어봄
            System.out.println("no Login");
            return "redirect:/";

        }
        if (!paymentService.isPurchaseHistory(sId)) { // sId값이 제대로 넘어왔는지 혹은 구매내역이 있는지 여부를 물어봄
            System.out.println("no history");
            return "redirect:/";
        }
        ShoppingDTO shoppingDTO = shoppingService.getShoppingInfo(sId);
        model.addAttribute("shoppingDTO",shoppingDTO);
        PaymentDTO paymentDTO = paymentService.orderStatus(sId);
        model.addAttribute("paymentDTO", paymentDTO);  //로그인과 구매내역이 모두 있는 경우 모델에 저장을 하고 정상적인 페이지를 반환함

        System.out.println("good");
        System.out.println(shoppingDTO);
        System.out.println(paymentDTO);
        return view;
    }
}
