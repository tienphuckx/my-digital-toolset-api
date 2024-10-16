package com.tienphuckx.toolset.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping("/vip")
    public String vip() {
        return "vip";
    }
    @GetMapping("/regular")
    public String regular() {
        return "regular";
    }
}
