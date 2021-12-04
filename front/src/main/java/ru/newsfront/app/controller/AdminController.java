package ru.newsfront.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.newsfront.app.feign.UserFeignClient;
import ru.newsfront.app.model.User;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserFeignClient backEndDBFeignCient;

    @GetMapping("/admin")
    public String adminPage(ModelMap modelMap) {

        List<User> listUsers = backEndDBFeignCient.getUserList();
        modelMap.addAttribute("users",listUsers);
        return "adminpage";
    }


}
