package com.db.security.domain;

import com.db.security.repository.PassportRepository;
import com.db.security.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/passport")
public class PassportController {
    private final PassportService passportService;

    @GetMapping("")
    private String getAlLPassport(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        System.out.println("Keyword: " + keyword);
        if (keyword.equals("LuuTru")) {
            model.addAttribute("passports", passportService.getListLuuTru_Passport());
        }
        else{
            model.addAttribute("passports", passportService.getListPassport(keyword));
        }
        model.addAttribute("keyword", keyword);
        return "passport";
    }
}
