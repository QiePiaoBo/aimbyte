package com.dylan.learnbasic.learnreflection;

/**
 * @author Dylan
 * @Date : Created in 13:31 2021/5/20
 * @Description :
 * @Function :
 */
@MyAnnotation("hello")
public class Student extends Person implements MyInterface {
    private int sno;
    double height;
    protected double weight;
    public double score;

    @MyAnnotation("hiMethod")
    public String showInfo() {
        return "我是好人";
    }

    public String showInfo(int a, int b) {
        return "重载，我还是好人";
    }

    private void work() {
        System.out.println("我是个程序员");
    }

    void happy() {
        System.out.println("做人最重要的当然是开心啦");
    }

    protected int getSno() {
        return sno;
    }

    public Student() {
        System.out.println("");
    }

    public Student(double weight, double height){
        this.weight = weight;
        this.height = height;
    }

    private Student(int sno) {
        this.sno = sno;
    }

    Student(int sno, double weight) {
        this.sno = sno;
        this.weight = weight;
    }

    protected Student(double weight) {
        this.weight = weight;
    }

    @Override
    @MyAnnotation("HelloMyMethod")
    public void myMethod() {
        System.out.println("我重写了myMethod方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
