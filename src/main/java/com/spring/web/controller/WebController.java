package com.spring.web.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@RequestMapping("/web")
@Api(value = "WebController", description = "Spring Web Learn")
public class WebController {

    private final static Logger logger = LoggerFactory.getLogger(WebController.class);

    /**
     * get请求
     */
    @RequestMapping(value = "/getExample", method = RequestMethod.GET)
    @ResponseBody
    public void getExample() {
        logger.info("run getExample");
    }

    /**
     * post请求
     */
    @RequestMapping(value = "/postExample", method = RequestMethod.POST)
    @ResponseBody
    public void postExample() {
        logger.info("run postExample");
    }

    /**
     * @GetMapping相当于get请求
     */
    @GetMapping("/getMappingExample")
    @ResponseBody
    public void getMappingExample() {
        logger.info("run getMappingExample");
    }

    /**
     * @PostMapping相当于post请求
     */
    @PostMapping("/postMappingExample")
    @ResponseBody
    public void postMappingExample() {
        logger.info("run postMappingExample");
    }

    /**
     * @PathVariable获取请求url模板变量的值
     * 例：/pathExample/path
     * @param pathName
     */
    @GetMapping("/pathExample/{pathName}")
    @ResponseBody
    public void pathExample(@PathVariable String pathName) {
        logger.info("run pathExample - pathName:" + pathName);
    }

    /**
     * @PathVariable获取请求url模板变量的值
     * 例：/pathExample/path/path2
     * @param pathMap
     */
    @GetMapping("/pathExample/{pathName}/{pathName2}")
    @ResponseBody
    public void pathExample(@PathVariable Map<String, String> pathMap) {
        logger.info("run pathExample - pathName:" + pathMap.get("pathName") + " - pathName2:" + pathMap.get("pathName"));
    }

    /**
     * @PathVariable获取请求url模板变量的值
     * @MatrixVariable获取矩阵变量的值
     * 例：/pathAndMatrixExample/path;q=1;r=2
     * @param pathName
     * @param q
     * @param r
     */
    @GetMapping("/pathAndMatrixExample/{pathName}")
    @ResponseBody
    public void pathAndMatrixExample(@PathVariable String pathName, @MatrixVariable int q, @MatrixVariable int r) {
        logger.info("run pathAndMatrixExample - pathName:" + pathName + " - q:" + q + " - r:" + r);
    }

    /**
     * @PathVariable获取请求url模板变量的值
     * @MatrixVariable获取矩阵变量的值
     * 例：/pathAndMatrixExample/path;q=1/path2;q=2
     * @param q1
     * @param q2
     */
    @GetMapping("/pathAndMatrixExample/{pathName}/{pathName2}")
    @ResponseBody
    public void pathAndMatrixExample(@MatrixVariable(name = "q", pathVar = "pathName") int q1, @MatrixVariable(name = "q", pathVar = "pathName2") int q2) {
        logger.info("run pathAndMatrixExample - q1:" + q1 + " - q2:" + q2);
    }

    /**
     * @MatrixVariable获取矩阵变量的值,非必需，默认值为1
     * 例：/pathAndMatrixExampleWithoutReq/path
     * @param q
     */
    @GetMapping("/pathAndMatrixExampleWithoutReq/{pathName}")
    @ResponseBody
    public void pathAndMatrixExample(@MatrixVariable(required = false, defaultValue = "1") int q) {
        logger.info("run pathAndMatrixExample - q:" + q);
    }

    /**
     * @MatrixVariable获取矩阵变量的值
     * 例：/pathAndMatrixMapExample/path;q=1;r=1/path2;q=2;r=2
     * @param matrixVars
     * @param matrixVars2
     */
    @GetMapping("/pathAndMatrixMapExample/{pathName}/{pathName2}")
    @ResponseBody
    public void pathAndMatrixMapExample(@MatrixVariable MultiValueMap<String, String> matrixVars, @MatrixVariable(pathVar = "pathName2") MultiValueMap<String, String> matrixVars2) {
        logger.info("run pathAndMatrixMapExample - matrixVars:" + matrixVars + " - matrixVars2" + matrixVars2);
    }

    /**
     * consumes：指定处理请求的提交内容类型（Content-Type），指定application/json类型;
     */
    @GetMapping(value = "/consumesExample", consumes = "application/json")
    @ResponseBody
    public void consumesExample() {
        logger.info("run consumesExample");
    }

    /**
     * consumes：指定处理请求的提交内容类型（Content-Type），指定除application/json之外其他类型;
     */
    @GetMapping(value = "/consumesReverseExample", consumes = "!application/json")
    @ResponseBody
    public void consumesReverseExample() {
        logger.info("run consumesReverseExample");
    }

    /**
     * produces：指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
     */
    @GetMapping(value = "/producesExample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void producesExample() {
        logger.info("run producesExample");
    }

    /**
     * params验证请求参数存在
     */
    @GetMapping(value = "/paramsExample", params = "myParams")
    @ResponseBody
    public void paramsExample() {
        logger.info("run paramsExample");
    }

    /**
     * params验证请求参数不存在
     */
    @GetMapping(value = "/paramsReverseExample", params = "!myParams")
    @ResponseBody
    public void paramsReverseExample() {
        logger.info("run paramsReverseExample");
    }

    /**
     * params验证请求参数为特定值
     */
    @GetMapping(value = "/paramsExampleByValue", params = "myParams=123")
    @ResponseBody
    public void paramsExampleByValue() {
        logger.info("run paramsExampleByValue");
    }

    /**
     * headers验证请求标头的存在/不存在，或者根据特定的请求标头值进行匹配
     */
    @GetMapping(value = "/headersExample", headers = "myHeader=myValue")
    @ResponseBody
    public void headersExample() {
        logger.info("run headersExample");
    }

    /**
     * @RequestParam将请求参数绑定到控制器中的方法参数
     * @param id
     */
    @GetMapping(value = "/paramExample")
    @ResponseBody
    public void paramExample(@RequestParam("id") String id) {
        logger.info("run paramExample - id:" + id);
    }

    /**
     * @RequestParam将请求参数绑定到控制器中的方法参数
     * @param map
     */
    @GetMapping(value = "/paramMapExample")
    @ResponseBody
    public void paramMapExample(@RequestParam MultiValueMap<String, String> map) {
        logger.info("run paramExample - map:" + map);
    }

    /**
     * @RequestBody将方法参数绑定到HTTP请求正文,非必需
     * @param id
     */
    @PostMapping(value = "/requestBodyExample")
    @ResponseBody
    public void requestBodyExample(@RequestBody(required = false) String id) {
        logger.info("run requestBodyExample - id:" + id);
    }

    /**
     * HttpEntity 类似于 @RequestBody 和 @ResponseBody 。除了访问请求和响应主体外，
     * HttpEntity（以及特定于响应的子类 ResponseEntity ）还允许访问请求和响应头
     * @param requestEntity
     * @return
     */
    @PostMapping(value = "/httpEntityExample")
    public ResponseEntity<String> httpEntityExample(HttpEntity<byte[]> requestEntity){
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }

}
