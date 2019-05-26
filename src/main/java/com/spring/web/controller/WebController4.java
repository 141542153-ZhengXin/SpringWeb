package com.spring.web.controller;

import com.spring.web.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/web4")
@Api(value = "WebController4", description = "Spring Web Learn")
public class WebController4 {

    private final static Logger logger = LoggerFactory.getLogger(WebController4.class);

    /**
     * @SessionAttribute是用于获取已经存储的session数据，并且作用在方法的层面上。
     * @param user
     * @return
     */
    @RequestMapping("/sessionExample")
    public String sessionExample(@SessionAttribute("user") User user) {
        logger.info("user:" + user);
        return "web4/sessionExample";
    }
}
