package com.dylan.learnbasic.learnjdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @Date : 2021/10/31 - 11:45
 * @Description :
 * @Function :
 */
public class Test {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setName("Dylan" + i);
            user.setUserGroup(1);
            userList.add(user);
        }
        userList.stream().forEach(User::print);
    }


}
