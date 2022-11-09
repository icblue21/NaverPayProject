package org.example.naverpay.member.controller.login;

import org.example.naverpay.member.dto.ShoppingDTO;
import org.example.naverpay.member.service.ShoppingService;
import org.example.naverpay.session.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/members")
public class ShoppingController {

    private SessionMgr sessionMgr = SessionMgr.getInstance();

    private ShoppingService shoppingService = ShoppingService.getInstance();

    @Autowired
    public ShoppingController(SessionMgr sessionMgr){ this.sessionMgr = sessionMgr; }

    @GetMapping(value = "/shopping") // 결제 내역 화면 접근
    public String shoppingPage(Locale locale, Model model, HttpServletRequest request, HttpSession session) {


        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("mId", sessionMgr.get(session));
        }

        String mId = session.getAttribute("SESSION_ID").toString();
        String startDate = getStartDate();
        String endDate = getCurrentDate();
        List<ShoppingDTO> shoppingDTOList = shoppingService.getAllShoppingList(mId,startDate,endDate);
        model.addAttribute("shoppingList",shoppingDTOList);

        return "/member/login/shopping";
    }

    @PostMapping("/shopping") // 기간 검색
    public String searchShoppingList(@RequestParam String startDate,
                                     @RequestParam String endDate,
                                     Model model, HttpServletRequest request,
                                     HttpSession session,
                                     HttpServletResponse response){

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        // DB에서 로그인한 아이디의 모든 구매내역리스트를 가져온다.
        String mId = session.getAttribute("SESSION_ID").toString();
       // String shoppingList = getAllShoppingList(mId,startDate,endDate);
        List<ShoppingDTO> shoppingDTOList = shoppingService.getAllShoppingList(mId,startDate,endDate);
        model.addAttribute("shoppingList",shoppingDTOList);


        return "/member/login/shopping";
    }

    public String getCurrentDate() {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String currentDate = now.format(formatter);

        return currentDate;
    }

    public String getStartDate(){

        LocalDate now = LocalDate.now().minusYears(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String startDate = now.format(formatter);

        return startDate;
    }

}
