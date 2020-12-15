/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-21 17:08
 */
package com.aicv.controller;

import com.aicv.pojo.Users;
import com.aicv.pojo.bo.UserBO;
import com.aicv.service.UserService;
import com.aicv.utils.IMOOCJSONResult;
import com.aicv.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author oldfish
 * @date 2020-11-21 17:08
 * @version 1.0
 */
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameExist(@RequestParam String username){
        //判断用户名是否为null
        if(StringUtils.isBlank(username)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameExists(username);
        if(isExist){
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //3.请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
    }

/**
 * 注册接口
 */
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();
        // 0. 判断用户名和密码必须不为空
            if(StringUtils.isBlank(username)||StringUtils.isBlank(password)||
                StringUtils.isBlank(confirmPassword)){
                return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
            }
        // 1. 查询用户名是否存在
        boolean isExist = userService.queryUsernameExists(username);
         if(isExist){
            return IMOOCJSONResult.errorMsg("用户名已经存在");
         }
        // 2. 密码长度不能少于6位
         if(password.length()<6){
             return IMOOCJSONResult.errorMsg("密码长度不能少于6");
         }
        // 3. 判断两次密码是否一致
         if(!password.equals(confirmPassword)){
             return IMOOCJSONResult.errorMsg("两次密码输入不一致");
         }
        //4. 实现注册
        Users userResult = userService.createUser(userBO);
        userResult = this.setNullProperty(userResult);
        //TODO 写到cookie

        return IMOOCJSONResult.ok();

    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

    @PostMapping("login")
    public IMOOCJSONResult login(@RequestBody UserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        // 0. 判断用户名和密码必须不为空
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }
        //1.实现登录
        Users userResult = null;
        try {
            userResult = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userResult==null){
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }
        userResult = setNullProperty(userResult);
        return IMOOCJSONResult.ok(userResult);
    }

}
