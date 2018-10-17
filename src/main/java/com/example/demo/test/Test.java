package com.example.demo.test;

import com.example.demo.model.bean.User;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import org.springframework.lang.Nullable;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) {
       /*
         on:制定拼接符号，如：test1-test2-test3 中的 “-“ 符号
         skipNulls()：忽略NULL,返回一个新的Joiner实例
         useForNull(“Hello”)：NULL的地方都用字符串”Hello”来代替
        */
        StringBuilder sb=new StringBuilder();
        Joiner.on(",").skipNulls().appendTo(sb,"Hello","guava");
        System.out.println(sb);
        System.out.println(Joiner.on(",").useForNull("none").join(1,null,3));
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1,2,3,4,null,6)));
        Map<String,String> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map));


        System.out.println();
           /*
         on():指定分隔符来分割字符串
         limit():当分割的子字符串达到了limit个时则停止分割
         fixedLength():根据长度来拆分字符串
         trimResults():去掉子串中的空格
         omitEmptyStrings():去掉空的子串
         withKeyValueSeparator():要分割的字符串中key和value间的分隔符,分割后的子串中key和value间的分隔符默认是=
        */
        System.out.println(Splitter.on(",").limit(3).trimResults().split(" a,  b,  c,  d"));//[ a, b, c,d]
        System.out.println(Splitter.fixedLength(3).split("1 2 3"));//[1 2,  3]
        System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
        System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,3"));//[1, 2, 3]
        System.out.println(Splitter.on(" ").trimResults().split("1 2 3")); //[1, 2, 3],默认的连接符是,
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));//{a=1, b=2, c=3}

        System.out.println(Splitter.fixedLength(2).split("12 345"));
        System.out.println();

        Multiset<String> set= LinkedHashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        set.setCount("a",7); //添加或删除指定元素使其在集合中的数量是count
        System.out.println(set.count("a")); //给定元素在Multiset中的计数
        System.out.println(set);
        System.out.println(set.size()); //所有元素计数的总和,包括重复元素
        System.out.println(set.elementSet().size()); //所有元素计数的总和,不包括重复元素
        set.clear(); //清空集合
        System.out.println(set);
        System.out.println();


        //记录学生在某门课上的成绩
        Table<String,String,Integer> table= HashBasedTable.create();
        table.put("jack","java",100);
        table.put("jack","c",90);
        table.put("mike","java",93);
        table.put("mike","c",100);
        Set<Table.Cell<String,String,Integer>> cells=table.cellSet();
        for (Table.Cell<String,String,Integer> cell : cells) {
            System.out.println(cell.getRowKey()+" "+cell.getColumnKey()+" "+cell.getValue());
        }
        System.out.println(table.row("jack"));
        System.out.println(table);
        System.out.println(table.rowKeySet());
        System.out.println(table.rowMap());
        System.out.println(table.columnMap());


        System.out.println(table.columnKeySet());
        System.out.println(table.values());
        System.out.println( table.column("java"));


        System.out.println();
        List<String> list= Lists.newArrayList("moon","dad","refer","son");
        Collection<String> palindromeList= Collections2.filter(list, input -> {
            //找回文串
            return new StringBuilder(input).reverse().toString().equals(input);
        });
        System.out.println(palindromeList);
        System.out.println(new StringBuffer("123").charAt(1));

        System.out.println();
        Set<Long> times= Sets.newHashSet();
        times.add(91299990701L);
        times.add(9320001010L);
        times.add(9920170621L);
        test(times);

        /*
         * 集合操作：交集、差集、并集
         */
        Set<Integer> set1= Sets.newHashSet(1,2,3,4,5);
        Set<Integer> set2=Sets.newHashSet(3,4,5,6);
        //交集
        Sets.SetView<Integer> inter=Sets.intersection(set1,set2);
        System.out.println(inter);
        //差集,在A中不在B中
        Sets.SetView<Integer> diff=Sets.difference(set1,set2);
        System.out.println(diff);
        //并集
        Sets.SetView<Integer> union=Sets.union(set1,set2);
        System.out.println(union);


        Supplier<User> personSupplier = User::new;
        personSupplier.get();   // new Person
    }

    private static void test(Set<Long> times) {
        Collection<String> timeStrCol= Collections2.transform(times, new Function<Long, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Long input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        });
        System.out.println(timeStrCol);
    }

}
