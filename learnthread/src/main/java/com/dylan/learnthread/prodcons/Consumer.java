package com.dylan.learnthread.prodcons;

/**
 * @author Dylan
 * @Date : Created in 13:27 2021/5/11
 * @Description :
 * @Function :
 */
public class Consumer implements Runnable{

    private Student student;
    private int x = 0;
    public Consumer(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        SleepUtil.sleep(500);
        while (true){
            student.get(Thread.currentThread().getName());
        }
    }

    

}
