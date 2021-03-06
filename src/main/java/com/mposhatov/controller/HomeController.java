package com.mposhatov.controller;

import com.mposhatov.exception.LogicException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional(noRollbackFor = LogicException.class)
public class HomeController {

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String goHome() {
        return "welcome";
    }
}
