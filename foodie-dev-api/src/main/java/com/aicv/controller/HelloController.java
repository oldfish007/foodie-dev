/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-21 17:08
 */
package com.aicv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oldfish
 * @date 2020-11-21 17:08
 * @version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello(){
        return "Hello World~~";
    }
}
