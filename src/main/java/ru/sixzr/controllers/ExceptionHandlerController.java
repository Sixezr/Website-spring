package ru.sixzr.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.sixzr.exceptions.NotFoundProductException;

@ControllerAdvice
@CrossOrigin(origins = "*")
public class ExceptionHandlerController {

    @ExceptionHandler(value = {NotFoundProductException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFound(Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", exception.getMessage());
        mav.setViewName("error/product_not_found");
        return mav;
    }
}
