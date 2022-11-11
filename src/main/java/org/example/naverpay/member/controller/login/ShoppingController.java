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
@RequestMapping("/naver")
public class ShoppingController {

    private SessionMgr sessionMgr;
    private ShoppingService shoppingService;

    @Autowired
    public ShoppingController(SessionMgr sessionMgr, ShoppingService shoppingService){
        this.sessionMgr = sessionMgr;
        this.shoppingService = shoppingService;
    }

    @GetMapping(value = "/pay") // 결제 내역 화면 접근
    public String shoppingPage(Locale locale, Model model, HttpServletRequest request, HttpSession session) {


        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("mId", sessionMgr.get(session));
        }

        String mId = session.getAttribute("SESSION_ID").toString();
        String startDate = getStartDate();
        String endDate = getCurrentDate();

        List<ShoppingDTO> shoppingDTOList = shoppingService.getAllShoppingList(mId,startDate,endDate);
        model.addAttribute("shoppingList",shoppingDTOList);

        // 날짜를 View 에 맞는 형식 변환 및 View Attribute 전달
        toViewDate(startDate, endDate, model);

        return "/member/login/shopping";
    }

    @PostMapping("/pay") // 기간 검색
    public String searchShoppingList(@RequestParam String startDate,
                                     @RequestParam String endDate,
                                     Model model, HttpServletRequest request,
                                     HttpSession session,
                                     HttpServletResponse response){

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }
        // 221109. 날짜를 View 에 맞는 형식 변환 및 View Attribute 전달
        toViewDate(startDate, endDate, model);

        // 221109. View 에서 받은 날짜를 Controller 부터 DB 까지 사용되는 형식으로 변환
        startDate = startDate.substring(0,4)+'.'+startDate.substring(5,7)+'.'+startDate.substring(8,10);
        endDate = endDate.substring(0,4)+'.'+endDate.substring(5,7)+'.'+endDate.substring(8,10);

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

    // 221109. 날짜를 View 에 맞는 형식 변환 및 View Attribute 전달용 메소드
    public void toViewDate(String startDate, String endDate, Model model){
        String toViewstartDate = startDate.substring(0,4)+'-'+startDate.substring(5,7)+'-'+startDate.substring(8,10);
        String toViewendDate = endDate.substring(0,4)+'-'+endDate.substring(5,7)+'-'+endDate.substring(8,10);

        model.addAttribute("startDate",toViewstartDate);
        model.addAttribute("endDate",toViewendDate);
    }

}