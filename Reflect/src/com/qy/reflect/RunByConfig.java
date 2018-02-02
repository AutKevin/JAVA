package com.qy.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by Autumn on 2018/2/2.
 */
public class RunByConfig {
    public static void main(String[] args) throws Exception {
        /*BufferedReader br = new BufferedReader(new FileReader("src/config.properties"));
        String line = br.readLine();
        String className = line.split("=")[1];*/
        Properties properties = new Properties();
        properties.load(new FileReader("src/protity.txt"));
        System.out.println(properties.getProperty("class"));
        System.out.println(properties.getProperty("method"));
        //加载配置的类
        Class clazz = Class.forName(properties.getProperty("class"));
        //根据类和配置方法名获取方法
        Method confMethod = clazz.getDeclaredMethod(properties.getProperty("method"), String.class);
        Object instance = clazz.newInstance();
        confMethod.invoke(instance,"aeolian");
    }

    private void run(String words){
        System.out.println("Hello! "+words);
    }
}
