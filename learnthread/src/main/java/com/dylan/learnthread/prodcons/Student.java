package com.dylan.learnthread.prodcons;


/**
 * @author Dylan
 * @Date : Created in 13:26 2021/5/11
 * @Description :
 * @Function :
 */
public class Student {

    private String name;
    private Integer age;
    private boolean have;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public synchronized void set(String name, Integer age){
        if (this.have){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        this.have = false;
        this.notify();
    }

    public synchronized void set(String name, Integer age, String threadName){
        if (this.have){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        this.have = false;
        System.out.println(threadName + " : " + name + " - " + age);
        this.notify();
    }

    public synchronized void get(){
        if (!this.have){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "------" + this.age);
        this.have = false;
        this.notify();
    }

    public synchronized void get(String name){
        if (!this.have){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " : " + this.name + "------" + this.age);
        this.have = false;
        this.notify();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
