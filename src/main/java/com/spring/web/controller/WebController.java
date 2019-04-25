package com.spring.web.controller;

import com.spring.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/web")
public class WebController {

    private final static Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "/getExample", method = RequestMethod.GET)
    @ResponseBody
    public void getExample() {
        logger.info("run getExample");
    }

    @RequestMapping(value = "/postExample", method = RequestMethod.POST)
    @ResponseBody
    public void postExample() {
        logger.info("run postExample");
    }

    @GetMapping("/getMappingExample")
    @ResponseBody
    public void getMappingExample(Model model) {
        logger.info("run getMappingExample");
    }

    @PostMapping("/postMappingExample")
    @ResponseBody
    public void postMappingExample() {
        logger.info("run postMappingExample");
    }

    @GetMapping("/pathExample/{pathName}")
    @ResponseBody
    public void pathExample(@PathVariable String pathName, Model model) {
        logger.info("run postMappingExample - pathName:" + pathName);
    }

    @GetMapping("/user/example6/{pathName}/{pathName2}")
    public String example6(@PathVariable Map<String, String> pathMap, Model model) {
        model.addAttribute("pathName", pathMap.get("pathName"));
        model.addAttribute("pathName2", pathMap.get("pathName2"));
        return "user";
    }

    @GetMapping("/user/example7/{pathName}")
    public String example7(@PathVariable String pathName, @MatrixVariable int q, @MatrixVariable int r, Model model) {
        model.addAttribute("pathName", pathName);
        model.addAttribute("q", q);
        model.addAttribute("r", r);
        return "user";
    }

    @GetMapping("/user/example8/{pathName}/{pathName2}")
    public String example8(@MatrixVariable(name = "q", pathVar = "pathName") int q1, @MatrixVariable(name = "q", pathVar = "pathName2") int q2, Model model) {
        model.addAttribute("q1", q1);
        model.addAttribute("q2", q2);
        return "user";
    }

    @GetMapping("/user/example9/{pathName}")
    public String example9(@MatrixVariable(required = false, defaultValue = "1") int q, Model model) {
        model.addAttribute("q", q);
        return "user";
    }
}
