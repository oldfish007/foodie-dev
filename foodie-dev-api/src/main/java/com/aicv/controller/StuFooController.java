/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-21 17:08
 */
package com.aicv.controller;

import com.aicv.service.StudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oldfish
 * @date 2020-11-21 17:08
 * @version 1.0
 */
@RestController
public class StuFooController {

    @Autowired
    private StudService studService;
    @GetMapping("/getStu")
    public Object hello(int id){
        return studService.getStuInfo(id);
    }
    @PostMapping("/saveStu")
    public Object saveStu(){
        studService.saveStu();
        return "OK";
    }
    @PostMapping("/updateStu")
    public Object updateStu(int id){
        studService.updateStu(id);
        return "ok";
    }

    @PostMapping("/deleteStu")
    public Object deleteStu(int id){
        studService.deleteStu(id);
        return "ok";
    }



}
