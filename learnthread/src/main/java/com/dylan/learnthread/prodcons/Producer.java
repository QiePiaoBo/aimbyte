package com.dylan.learnthread.prodcons;

/**
 * @author Dylan
 * @Date : Created in 13:27 2021/5/11
 * @Description :
 * @Function :
 */
public class Producer implements Runnable{

    private Student student;
    private int x = 0;
    public Producer(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true){
            SleepUtil.sleep(500);
            if (x % 2 == 0){
                student.set("AA", 27, Thread.currentThread().getName());
            }else {
                student.set("BB", 22, Thread.currentThread().getName());
            }
            x++;
        }
    }



}
