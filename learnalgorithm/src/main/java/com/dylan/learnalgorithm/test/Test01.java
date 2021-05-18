package com.dylan.learnalgorithm.test;

import java.util.Stack;

/**
 * @author Dylan
 * @Date : Created in 16:48 2021/5/18
 * @Description :
 * @Function :
 */
public class Test01 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(getAndRemoveLastElement(stack));
        }
        System.out.println(stack.isEmpty());
    }
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }

    }
}
