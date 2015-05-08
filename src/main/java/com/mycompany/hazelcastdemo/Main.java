package com.mycompany.hazelcastdemo;

import com.hazelcast.core.HazelcastInstance;
import java.util.Map;
import java.util.Random;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        
         HazelcastInstance instance = applicationContext.getBean("instance", HazelcastInstance.class);

        Map<String, Integer> map = instance.getMap("map");
        Random r= new Random();
        for(int i=0;i<3;i++){
            map.put("a"+r.nextInt(), r.nextInt());
        }
        
        
        Map<String, Integer> result = instance.getMap("map");
        System.out.println(result.entrySet().size());
        
        while(true){}
    }
}
