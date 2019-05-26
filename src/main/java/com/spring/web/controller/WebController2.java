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
     * 1.这样就相当于model.addAttribute(“userName”, userName);，
     * 此时对应的页面就是 @RequestMapping 的值 modelAttributeExample3，交给页面解析后就是modelAttributeExample3.jsp
     * 2.@ModelAttribute 注释也可用于 @RequestMapping 方法。在这种情况下，
     *
     * @param userName
     * @return
     * @RequestMapping 方法的返回值被解释为模型属性而不是视图名称。然后根据视图名称约定派生视图名称，就像返回 void 的方法一样
     */
    @RequestMapping(value = "/modelAttributeExample3")
    @ModelAttribute("userName")
    public String modelAttributeExample3(@RequestParam(required = false) String userName) {
        logger.info("userName:" + userName);
        return userName;
    }

    /*--------------------------------------------------------------------------------------*/

    /**
     * 1.方法参数上的 @ModelAttribute 表示应从模型中检索参数。如果模型中不存在，则应首先实例化参数，然后将其添加到模型中。
     * 一旦出现在模型中，参数的字段应该从具有匹配名称的所有请求参数中填充。
     * 2.由于数据绑定，可能存在错误，例如缺少必填字段或类型转换错误。
     * 要检查此类错误，请在 @ModelAttribute 参数后立即添加 BindingResult 参数
     * 使用 BindingResult ，您可以检查是否发现错误在哪种情况下，通常会在Spring的 <errors> 表单标记的帮助下呈现错误的相同表单。
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/modelAttributeExample4")
    public String modelAttributeExample4(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {
                logger.error("error:" + allErrors.get(i));
            }
            return "web2/modelAttributeErrorExample";
        }
        return "web2/modelAttributeExample4";
    }

    /*--------------------------------------------------------------------------------------*/

    /*@ModelAttribute
    public User getUser(Model model) {
        User user = new User("1","Tom");
        return user;
    }*/

    /**
     * 在某些情况下，在没有数据绑定的情况下访问模型中的属性可能很有用。
     * 对于这种情况，您可以将 Model 注入控制器，或者在注释上使用 binding 标志
     * @param user
     * @return
     */
    @RequestMapping(value = "/modelAttributeExample5")
    public String modelAttributeExample5(@ModelAttribute(binding = false, value = "user") User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "web2/modelAttributeErrorExample";
        }
        model.addAttribute("user", user);
        return "web2/modelAttributeExample5";
    }

}
