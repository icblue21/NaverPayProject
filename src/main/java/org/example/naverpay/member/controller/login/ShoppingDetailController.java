package org.example.naverpay.member.controller.login;

import org.example.naverpay.member.dto.PaymentDTO;
import org.example.naverpay.member.dto.ShoppingDTO;
import org.example.naverpay.member.service.PaymentService;
import org.example.naverpay.member.service.ShoppingService;
import org.example.naverpay.session.SessionMgr;
import org.example.naverpay.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/naver")
public class ShoppingDetailController {

    private SessionMgr sessionMgr;
    private PaymentService paymentService;
    private ShoppingService shoppingService;

    @Autowired
    public ShoppingDetailController(SessionMgr sessionMgr,
                                    PaymentService paymentService,
                                    ShoppingService shoppingService){
        this.sessionMgr = sessionMgr;
        this.paymentService = paymentService;
        this.shoppingService = shoppingService;
    }

    @GetMapping(value = "/pay/detail/{sId}") // 결제 내역 화면 접근
    public String shoppingDetailPage(Locale locale, Model model, HttpServletRequest request, HttpSession session,
    @PathVariable String sId) {


        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("mId", sessionMgr.get(session));
        }else {
            System.out.println("no login");
            return "redirect:/"; // 로그인이 되어있지 않을 경우 접근 불가
        }
        model.addAttribute("sId",sId);
        PaymentDTO paymentDTO = paymentService.getPaymentInfo(sId);
        model.addAttribute("paymentDTO",paymentDTO);
        ShoppingDTO shoppingDTO = shoppingService.getShoppingInfo(sId);
        model.addAttribute("shoppingDTO",shoppingDTO);

        if(!session.getAttribute("SESSION_ID").equals(shoppingDTO.getmId())){
            System.out.println("not your product");
            return "redirect:/"; //a로 로그인 했는데 b의 주문내역을 URL로 접근하는상황을 방지하는 로직
        }

        return "/member/login/shoppingDetail";
    }

    @PostMapping("/pay/detail")
    public String deleteShoppingDetailPage(@RequestParam String sId, HttpSession session) {
        String view = "/member/login/shoppingDetail";
        Status respStatus = Status.FAIL;

        if (paymentService.isPaymentInfoRemoved(sId)) {
            shoppingService.deleteShoppingList(sId);
            view = "redirect:/naver/pay";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("delete", respStatus);
        session.setAttribute("alert", true); //redirect 후 경고창(alert) 띄우기 여부 결정하는 값 저장
        return view;
    }
}
