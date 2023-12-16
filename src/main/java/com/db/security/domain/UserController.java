package com.db.security.domain;

import com.db.security.mapper.UserMapper;
import com.db.security.model.LocationEntity;
import com.db.security.repository.LocationRepository;
import com.db.security.repository.UserRequestRepository;
import com.db.security.request.UserRequest;
import com.db.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String showForm(Model model) {
        // Example list of items (you can replace this with your own logic to fetch data)
//        List<LocationEntity> locationEntities = List.of(new LocationEntity().setId(1L).setDistrict("Quan1"), new LocationEntity().setId(2L).setDistrict("Quan2"));
        model.addAttribute("locations", userService.getListLocation());
        return "form";
    }

    @PostMapping("")
    public String submitForm(@RequestBody UserRequest request) {
        userService.addUser(request);
        return "redirect:/user";
    }
}
