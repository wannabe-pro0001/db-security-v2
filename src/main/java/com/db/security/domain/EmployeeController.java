package com.db.security.domain;

import com.db.security.model.EmployeeEntity;
import com.db.security.repository.EmployeeRepository;
import com.db.security.request.EmployeeRequest;
import com.db.security.response.EmployeeResponse;
import com.db.security.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("")
    public String getLogin() {
        return "login";
    }

    @PostMapping("")
    public String postLogin(@ModelAttribute EmployeeRequest request, RedirectAttributes redirectAttributes) {
        String employee = employeeService.getEmployee(request);
        redirectAttributes.addAttribute("userPrincipal", employee);
        return "redirect:/user/view-all";
    }
}
