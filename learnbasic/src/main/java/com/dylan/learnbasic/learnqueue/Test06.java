package com.dylan.learnbasic.learnqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Dylan
 * @Date : Created in 13:01 2021/6/3
 * @Description :
 * @Function :
 */
public class Test06 {
    DelayQueue<Person> dq = new DelayQueue<>();

    // 登陆游戏
    public void login(Person p){
        dq.add(p);
        System.out.println("用户：【" + p.getId() + "】，【" + p.getName()+ "】已登录,预计下机时间为：" + p.getEndTime());
    }
    // 时间到，退出游戏，移出队列
    public void logout(){
        // 打印队列中剩余的人
        try {
            Person p = dq.take();
            System.out.println("用户：【" + p.getId() + "】，【" + p.getName()+ "】上机时间到，自动退出游戏");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // 获取在线人数
    public int onlineSize(){
        return dq.size();
    }

    public static void main(String[] args) {
        Test06 test06 = new Test06();
        test06.login(new Person(1, "Dylan1", System.currentTimeMillis() + 20));
        test06.login(new Person(2, "Dylan2", System.currentTimeMillis() + 15));
        test06.login(new Person(3, "Dylan3", System.currentTimeMillis() + 30));
        // 一直监控
        while (true){
            // 到期自动下线
            test06.logout();
            // 如果队列中的所有元素都被移除，就停止监控，停止程序
            if (test06.onlineSize() == 0){
                break;
            }
        }
    }
}
class Person implements Delayed{

    private int id;
    private String name;
    private long endTime;

    public Person(int id, String name, long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // 计算剩余时间，剩余时间小于等于0说明已经到期
        return this.getEndTime() - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        // 队列中到期时间的比较，谁短谁在前面
        Person person = (Person) o;
        return Long.compare((this.getEndTime()), (person.getEndTime()));
    }
}