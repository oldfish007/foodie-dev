package com.aicv.service;

import com.aicv.pojo.Users;
import com.aicv.pojo.bo.UserBO;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-11-27 16:13
 */
public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameExists(String username);

    /***
     *前端传到后端 用于接受数据的数据体的话用bo对象
     * @return
     */
    public Users  createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     */
    public Users queryUserForLogin(String username, String password);
}
