package com.spring.web.controller;

import com.spring.web.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @SessionAttributes用于在会话中存储Model的属性，一般作用在类的级别。
 * model的属性user会被存储到session中，因为@ModelAttribute与@SessionAttributes有相同的注解。
 */
@Controller
@RequestMapping("/web3")
@SessionAttributes("user")
@Api(value = "WebController3", description = "Spring Web Learn")
public class WebController3 {

    private final static Logger logger = LoggerFactory.getLogger(WebController3.class);

    @ModelAttribute("user")
    public User initUser() {
        User user = new User("1", "Tom");
        return user;
    }

    @RequestMapping("/sessionExample")
    public String sessionExample(@ModelAttribute("user") User user) {
        logger.info("user:" + user);
        return "web3/sessionExample";
    }

    /**
     * @SessionAttribute是用于获取已经存储的session数据，并且作用在方法的层面上。
     * @param user
     * @return
     */
    @RequestMapping("/sessionExample2")
    public String sessionExample2(@SessionAttribute("user") User user) {
        logger.info("user:" + user);
        return "web3/sessionExample2";
    }
}
