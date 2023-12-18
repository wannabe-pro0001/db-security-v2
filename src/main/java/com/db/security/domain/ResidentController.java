package com.db.security.domain;

import com.db.security.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/resident")
@RequiredArgsConstructor
public class ResidentController {
    private final ResidentService residentService;

    @GetMapping("")
    public String getAllResident(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        System.out.println(keyword);
        model.addAttribute("residents", residentService.getAllResident(keyword));
        return "resident";
    }
}
