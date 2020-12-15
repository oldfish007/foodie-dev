/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-22 16:33
 */
package com.aicv.service;

import com.aicv.pojo.Stu;

/**
 * @author oldfish
 * @date 2020-11-22 16:33
 * @version 1.0
 */
public interface StudService {

    public Stu getStuInfo(int id);
    public void saveStu();
    public void updateStu(int id);
    public void deleteStu(int id);
    public void saveParent();
    public void saveChildren();
}
