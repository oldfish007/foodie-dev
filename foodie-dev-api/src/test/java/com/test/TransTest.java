/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-25 17:41
 */
package com.test;

import com.aicv.Application;
import com.aicv.service.StudService;
import com.aicv.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author oldfish
 * @date 2020-11-25 17:41
 * @version 1.0
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)*/
public class TransTest {
    @Autowired
    private StudService studService;
    @Autowired
    private TestTransService testTransService;

   // @Test
    public void test(){
        testTransService.testPropagationTrans();

    }
}
