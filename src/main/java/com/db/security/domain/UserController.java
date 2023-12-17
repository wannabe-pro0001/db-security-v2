package com.db.security.domain;

import com.db.security.mapper.UserMapper;
import com.db.security.model.LocationEntity;
import com.db.security.model.UserRequestEntity;
import com.db.security.model.enum_type.Gender;
import com.db.security.repository.LocationRepository;
import com.db.security.repository.UserRequestRepository;
import com.db.security.request.UserRequest;
import com.db.security.request.UserSearchRequest;
import com.db.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("locations", userService.getListLocation());
        return "user_request_form";
    }

    @PostMapping("")
    public String submitForm(@ModelAttribute UserRequest request) {
        userService.addUser(request);
        return "redirect:user/search";
    }

    @PostMapping("/search")
    public String searchUser(@ModelAttribute UserSearchRequest request, Model model) {
        model.addAttribute("user", userService.getUser(request.getKeyword()));
        return "user_details";
    }
    @GetMapping("/search")
    public String searchUser(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        if (!Objects.isNull(keyword)) {
            model.addAttribute("user", userService.getUser(keyword));
        } else {
            model.addAttribute("user",
                    new UserRequestEntity().setCCCD("").setFullName("").setLocation(null)
                            .setGender(Gender.None).setLocation(null).setPhone("").setNote("").setEmail("").setExtendDuration(0));
        }
        return "user_details";
    }
    @GetMapping("/view-all")
    public String getAllUser(@ModelAttribute("userPrincipal") String userPrincipal, Model model) {
        model.addAttribute("keyword", userPrincipal);
        System.out.println(userPrincipal);
        model.addAttribute("users", userService.getAllUser(userPrincipal));
        if (userPrincipal.equals("XetDuyet")) {
            return "list_user_xet_duyet";
        } else if (userPrincipal.equals("LuuTru")) {
            return "list_user_luu_tru";
        }
        return "list_user";
    }

    @GetMapping("/xt-approve/{id}")
    public String xacThucApprove(@PathVariable long id, @ModelAttribute("userPrincipal") String userPrincipal, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("userPrincipal", userPrincipal);
        userService.modifyUser(id, 1);
        return "redirect:/user/view-all";
    }
    @GetMapping("/xt-reject/{id}")
    public String xacThucReject(@PathVariable long id, @ModelAttribute("userPrincipal") String userPrincipal, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("userPrincipal", userPrincipal);
        userService.modifyUser(id, 0);
        return "redirect:/user/view-all";
    }

    @GetMapping("/xd-approve/{id}")
    public String xetDuyetApprove(@PathVariable long id) {
        userService.modifyUserXetDuyet(id, true);
        return "redirect:/user/view-all";
    }
    @GetMapping("/xd-reject/{id}")
    public String xetDuyetReject(@PathVariable long id) {
        userService.modifyUserXetDuyet(id, false);
        return "redirect:/user/view-all";
    }

//    @GetMapping("/lt-approve/{id}")
//    public String luuTruApprove(@PathVariable long id) {
//        userService.modifyUserLuuTru(id, true);
//        return "list_user_luu_tru";
//    }
//    @GetMapping("/lt-reject/{id}")
//    public String luuTruReject(@PathVariable long id) {
//        userService.modifyUserLuuTru(id, false);
//        return "list_user_luu_tru";
//    }
}
