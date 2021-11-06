package com.dylan.learnalgorithm.xinshou;

import java.util.HashMap;

/**
 * @author Dylan
 * @Date : Created in 1:26 2021/11/5
 * @Description :
 * @Function :
 */
public class Q09_HashMapTreeMap {


    public static void main(String[] args) {
        // 哈希表：记录kv结构的数据的表
        // 哈希表最强的一点:不管存了多少数据，增删改查的时间复杂度都是O(1)也就是常熟操作
        // 但这个1所耗费的时间是相对比较长的，虽然和数据量无关但是速度较慢
        HashMap<String, String> map = new HashMap<>();
        map.put("dql", "DuanQiLun");
        System.out.println(map.containsKey("dql"));
        System.out.println(map.get("dql"));
        map.put("dql", "DQL");
        System.out.println(map.get("dql"));
        map.remove("dql");
        System.out.println(map.get("dql"));

        // 哈希表内部是值传递，也就是说查询时无论给定的基础类型(Integer Double Char Float String等)对应的内存地址是多少，查询结果是都按照参数具体的值去判断
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1234567, "7654321");
        Integer a = 1234567;
        Integer b = 1234567;
        System.out.println(map1.containsKey(a));
        System.out.println(map1.containsKey(b));

        // 如果给定的参数是自定义类型，则按照内存地址的值进行存储



    }

}
