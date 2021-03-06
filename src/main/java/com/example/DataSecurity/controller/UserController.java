package com.example.DataSecurity.controller;

import com.example.DataSecurity.model.PortalUser;
import com.example.DataSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String usersList(Model model,
                            @RequestParam("page")Optional<Integer> page,
                            @RequestParam("size")Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);

        Page<PortalUser> portalUserPage = userService.findAllPagainated(
                PageRequest.of(currentPage-1, currentSize)
        );

        model.addAttribute("userPage", portalUserPage);
        model.addAttribute("size", currentSize);

        int totalPages = portalUserPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "users";
    }

    @GetMapping("/login")
    public String login() {return "login";}

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/admin/page")
    public String admin() {
        return "admin";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @Secured("ADMIN")
    @GetMapping("/user")
    public String user(Authentication authentication) {
        /*if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "user";
        } else {
            return "home";
        }*/
        return "user";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("portalUser", new PortalUser());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@Valid PortalUser portalUser, BindingResult result){
        if (result.hasErrors()){
            return "register";
        }
        else {
            userService.save(portalUser);
            return "redirect:/login";
        }
    }

}
