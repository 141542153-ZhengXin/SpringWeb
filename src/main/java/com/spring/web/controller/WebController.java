package com.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
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
    public void getMappingExample() {
        logger.info("run getMappingExample");
    }

    @PostMapping("/postMappingExample")
    @ResponseBody
    public void postMappingExample() {
        logger.info("run postMappingExample");
    }

    @GetMapping("/pathExample/{pathName}")
    @ResponseBody
    public void pathExample(@PathVariable String pathName) {
        logger.info("run pathExample - pathName:" + pathName);
    }

    @GetMapping("/pathExample/{pathName}/{pathName2}")
    @ResponseBody
    public void pathExample(@PathVariable Map<String, String> pathMap) {
        logger.info("run pathExample - pathName:" + pathMap.get("pathName") + " - pathName2:" + pathMap.get("pathName"));
    }

    @GetMapping("/pathAndMatrixExample/{pathName}")
    @ResponseBody
    public void pathAndMatrixExample(@PathVariable String pathName, @MatrixVariable int q, @MatrixVariable int r) {
        logger.info("run pathAndMatrixExample - pathName:" + pathName + " - q:" + q + " - r:" + r);
    }

    @GetMapping("/pathAndMatrixExample/{pathName}/{pathName2}")
    @ResponseBody
    public void pathAndMatrixExample(@MatrixVariable(name = "q", pathVar = "pathName") int q1, @MatrixVariable(name = "q", pathVar = "pathName2") int q2) {
        logger.info("run pathAndMatrixExample - q1:" + q1 + " - q2:" + q2);
    }

    @GetMapping("/pathAndMatrixExampleWithoutReq/{pathName}")
    @ResponseBody
    public void pathAndMatrixExample(@MatrixVariable(required = false, defaultValue = "1") int q) {
        logger.info("run pathAndMatrixExample - q:" + q);
    }

    @GetMapping("/pathAndMatrixMapExample/{pathName}/{pathName2}")
    @ResponseBody
    public void pathAndMatrixMapExample(@MatrixVariable MultiValueMap<String, String> matrixVars, @MatrixVariable(pathVar = "pathName2") MultiValueMap<String, String> matrixVars2) {
        logger.info("run pathAndMatrixMapExample - matrixVars:" + matrixVars + " - matrixVars2" + matrixVars2);
    }

    @GetMapping(value = "/consumesExample", consumes = "application/json")
    @ResponseBody
    public void consumesExample() {
        logger.info("run consumesExample");
    }

    @GetMapping(value = "/consumesReverseExample", consumes = "!application/json")
    @ResponseBody
    public void consumesReverseExample() {
        logger.info("run consumesReverseExample");
    }

    @GetMapping(value = "/producesExample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void producesExample() {
        logger.info("run producesExample");
    }

    @GetMapping(value = "/paramsExample", params = "myParams")
    @ResponseBody
    public void paramsExample() {
        logger.info("run paramsExample");
    }

    @GetMapping(value = "/paramsReverseExample", params = "!myParams")
    @ResponseBody
    public void paramsReverseExample() {
        logger.info("run paramsReverseExample");
    }

    @GetMapping(value = "/paramsExampleByValue", params = "myParams=123")
    @ResponseBody
    public void paramsExampleByValue() {
        logger.info("run paramsExampleByValue");
    }

    @GetMapping(value = "/headersExample", headers = "myHeader=myValue")
    @ResponseBody
    public void headersExample() {
        logger.info("run headersExample");
    }

    @GetMapping(value = "/paramExample")
    @ResponseBody
    public void paramExample(@RequestParam("id") String id) {
        logger.info("run paramExample - id:" + id);
    }

    @GetMapping(value = "/paramMapExample")
    @ResponseBody
    public void paramMapExample(@RequestParam MultiValueMap<String, String> map) {
        logger.info("run paramExample - map:" + map);
    }

    @PostMapping(value = "/requestBodyExample")
    @ResponseBody
    public void requestBodyExample(@RequestBody(required = false) String id) {
        logger.info("run requestBodyExample - id:" + id);
    }
}
