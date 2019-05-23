package com.spring.web.controller;

import com.spring.web.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web2")
@Api(value = "WebController2", description = "Spring Web Learn")
public class WebController2 {

    private final static Logger logger = LoggerFactory.getLogger(WebController2.class);

    /**
     * @param userName
     * @param model
     * @ModelAttribute 方法用于使用常用属性填充模型
     * 注意：1.入参绑定的数据如果没有设置可为空，不能接收空数据，否则会报错
     * 2.被 @ModelAttribute 注释的方法会在Controller每个方法执行之前都执行，因此对于一个Controller中包含多个URL的时候，要谨慎使用
     * 3.都可以将数据放入model中，而且对于一次请求，model是共享的，所以在处理方法中的model中存放了@ModelAttribute注解的方法中存放的数据
     */
    /*@ModelAttribute
    public void getUser(@RequestParam(value = "userName", required = false) String userName, Model model) {
        User user = new User("1", userName);
        logger.info("@ModelAttribute - user:" + user);
        model.addAttribute("user", user);
    }*/
    @RequestMapping(value = "modelAttributeIndex")
    public String modelAttributeIndex() {
        return "web2/modelAttributeIndex";
    }

    @RequestMapping(value = "/modelAttributeExample")
    public String modelAttributeExample(ModelMap model) {
        logger.info("user:" + model.get("user"));
        return "web2/modelAttributeExample";
    }

    /*--------------------------------------------------------------------------------------*/

    /**
     * @param user1
     * @param model
     * @return
     * @ModelAttribute("user")中"user"指定别名
     */
    /*@ModelAttribute("user")
    public User getUser(Model model) {
        User user = new User("1", "Tom");
        logger.info("@ModelAttribute - user:" + user);
        return user;
    }*/
    @RequestMapping(value = "/modelAttributeExample2")
    public String modelAttributeExample2(@ModelAttribute("user") User user1, Model model) {
        logger.info("user:" + model.toString());
        logger.info("user1:" + user1);
        return "web2/modelAttributeExample2";
    }

    /*--------------------------------------------------------------------------------------*/

    /**
     * 这样就相当于model.addAttribute(“userName”, userName);，
     * 此时对应的页面就是 @RequestMapping 的值 modelAttributeExample3，交给页面解析后就是modelAttributeExample3.jsp
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/modelAttributeExample3")
    @ModelAttribute("userName")
    public String modelAttributeExample3(@RequestParam(required = false) String userName) {
        logger.info("userName:" + userName);
        return userName;
    }

    /*--------------------------------------------------------------------------------------*/

    @RequestMapping(value = "/modelAttributeExample4")
    public String modelAttributeExample4(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {
                logger.error("error:"+allErrors.get(i));
            }
            return "web2/modelAttributeErrorExample";
        }
        return "web2/modelAttributeExample4";
    }
}
