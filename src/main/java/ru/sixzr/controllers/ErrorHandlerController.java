package ru.sixzr.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

//@Controller
//public class ErrorHandlerController implements ErrorController {
//
//    @RequestMapping(value = "/error")
//    public String error(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (status != null) {
//            int statusCode = Integer.parseInt(status.toString());
//
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "error/not_found";
//            }
//        }
//
//        return "error/unknown";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return null;
//    }
//}
