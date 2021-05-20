package com.dylan.learnbasic.learncollection.learnset;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Dylan
 * @Date : Created in 12:47 2021/5/18
 * @Description :
 * @Function :
 */
public class TestBean {

    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();
        hs.add(new Student("aa", 20));
        hs.add(new Student("aa", 20));
        hs.add(new Student("bb", 21));
        hs.add(new Student("vv", 22));
        hs.add(new Student("dd", 23));
        hs.add(new Student("ee", 23));
        System.out.println(hs.size());
        System.out.println(hs);
    }

}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
