package ru.sixzr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/vk")
@CrossOrigin(origins = "*")
public class VkController {

    @GetMapping
    public String index(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("code");
        if (code == null) {
            return "redirect:" + UriComponentsBuilder.fromPath("https://oauth.vk.com/authorize?client_id=8167417&display=page&redirect_uri=http://localhost:8080/vk&scope=email&response_type=code&v=5.131").build();
        }
//        try {
//            User user = vkService.getUser(code);
//            securityService.signIn(req, user);
//            resp.sendRedirect(context.getContextPath() + "/account");
//        } catch (ValidationException e) {
//            req.setAttribute(Constants.ERROR, e.getMessage());
//            context.getRequestDispatcher("/WEB-INF/views/vk.jsp").forward(req, resp);
//        }
        return "static/index";
    }
}
