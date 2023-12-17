package com.db.security.domain;

import com.db.security.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resident")
@RequiredArgsConstructor
public class ResidentController {
    private final ResidentService residentService;

    @GetMapping("")
    public String getAllResident(Model model) {
        model.addAttribute("residents", residentService.getAllResident());
        return "resident";
    }
}
