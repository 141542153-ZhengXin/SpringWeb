package com.spring.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/swagger")
@Api(value = "SwaggerController", description = "Spring整合Swagger")
public class SwaggerController {

    private final static Logger logger = LoggerFactory.getLogger(SwaggerController.class);

    /**
     * swagger learning
     */
    @GetMapping("/swaggerExample")
    @ResponseBody
    @ApiOperation(value = "swaggerExample")
    @ApiImplicitParam(name = "param", value = "参数", paramType = "query", dataType = "String")
    public String swaggerExample(@RequestParam("param") String param) {
        logger.info("run swaggerExample - param:" + param);
        return param;
    }
}
