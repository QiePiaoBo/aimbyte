package com.dylan.learnbasic.learncollection.learnstack;

import java.util.Stack;

/**
 * @author Dylan
 * @Date : Created in 12:31 2021/5/26
 * @Description :
 * @Function :
 */
public class Test01 {

    public static void main(String[] args) {
        // Stack extends Vector, Stack的底层也是数组Object[] elementData
        // 也有一个属性记录元素个数 int elementCount

        Stack<String> s = new Stack<>();

        // add -> 对应下标位置上放数据，不够放了会扩容,返回值为true
        // push -> 和add的功能不同，但是返回值是push的对象本身
        s.add("A");
        s.add("B");
        s.push("C");
        s.push("D");
        System.out.println(s);
        while (!s.empty()){
            // 查看栈顶数据但不移除
            System.out.println("peek: " + s.peek());
            // 获取栈顶数据并移除
            System.out.println("pop : " + s.pop());
        }
    }
}
