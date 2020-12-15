package com.aicv.service.impl;

import com.aicv.service.StudService;
import com.aicv.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StudService stuService;

    /**
     * 事务传播 - Propagation
     * REQUIRED:使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的；
     *          如果当前存在事务，则加入这个事务，成为一个整体
     *          。当前的事务没有或者不存在，就创建一个新的事物当前任务或者方法本身存在有事物的话
     *          多用作增删 更改这些操作
     * 就不要额外的去创建一个新的事物加入到现有的事物里面去
     *          举例：领导没饭吃，我有钱，我会自己买了自己吃(自己会创建一个事务)；领导有的吃，会分给你一起吃。
     * SUPPORTS:如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。 (主要用作查询)
     *          举例：领导没饭吃，我也没饭吃；领导有饭吃，我也有饭吃。
     *          外层不使用事物，内层也就不使用事物
     * MANDATORY:该传播属性强制必须存在一个事务，如果不存在，则抛出异常
     *           举例：领导必须管饭，不管饭没饭吃，我就不乐意了，就不干了（抛出异常）
     *           会先插入一条数据，进入方法发现后有MANDATORY父方法没有事务则抛出异常
     * REQUIRES_NEW:如果当前有事务，则挂起该事务，并且自己创建一个新的事务给自己使用；
     *             如果当前没有事务，则同 REQUIRED
     *             举例：领导有饭吃，我偏不要，我自己买了自己吃
     *             子方法创建一个新的事物
     * NOT_SUPPORTED: 如果当前有事务，则把事务挂起，自己不适用事务去运行数据库操作
     *                举例：领导有饭吃，分一点给你，我太忙了，放一边，我不吃
     * NEVER: 如果当前有事务存在，则抛出异常
     *        举例：领导有饭给你吃，我不想吃，我热爱工作，我抛出异常
     * NESTED: 如果当前有事务，则开启子事务（嵌套事务），嵌套事务是独立提交或者回滚；
     *              如果当前没有事务，则同 REQUIRED。
     *              但是如果主事务提交，则会携带子事务一起提交。
     *              如果主事务发生异常回滚，则子事务会一起回滚。相反，子事务异常，则父事务可以回滚或不回滚。
     *              举例：领导决策不对，老板怪罪，领导带着小弟一同受罪。小弟出了差错，领导可以推卸责任。
     */

 //   @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();
         try {
        //save point
        stuService.saveChildren();
        } catch (Exception e) {
          e.printStackTrace();
        }
        // delete
        // update 都不会被子事物收到影响
        //stuService.saveParent();
        //int a = 1 / 0;
    }

}
