package com.dylan.learnrpc.selector;

/**
 * @author Dylan
 * @Date : 2021/4/21 - 20:11
 * @Description :
 * @Function :
 */
public class MainThread {

    public static void main(String[] args) {
        // 启动各个线程, 不关心业务

        // 1. 创建IO线程
        // SelectorThreadGroup 线程组，负责管理线程
        // 混杂模式，三个线程中只有一个负责accept,每个都会被分配client,进行R/W
        SelectorThreadGroup stg1 = new SelectorThreadGroup(1);
//        SelectorThreadGroup stg2 = new SelectorThreadGroup(3);
        // 2. 把监听的server注册到某一个selector上
        stg1.bind(9999);
    }

}
