package com.imcp.objects.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class DynamicBean {

    public static void main(String[] args) throws JsonProcessingException {
        //Cglib动态生成对象
        //创建Bean构造器
        BeanGenerator beanGenerator = new BeanGenerator();
        //准备对象数据,用于构造类
        Map<String, Class> map = new HashMap<>();
        map.put("id", Integer.class);
        map.put("name", String.class);
        //遍历Map，添加属性
        for (Map.Entry entry : map.entrySet()) {
            //当然也可以直接使用Map数据获取value的class设置进去
            //如map.put("id",1); entry.getValue().getClass();
            beanGenerator.addProperty(entry.getKey().toString(), (Class) entry.getValue());
        }
        //创建对象
        Object object = beanGenerator.create();
        //查看类名
        System.out.println("查看类名:" + Modifier.toString(object.getClass().getModifiers())
                + " | " + object.getClass().getName());
        //查看构造的类的结构-->属性结构
        for (Field field : object.getClass().getDeclaredFields()) {
            System.out.println("属性结构:" + Modifier.toString(field.getModifiers()) + " | "
                    + field.getType() + " | "
                    + field.getName());
        }
        //查看构造的类的结构-->方法结构
        for (Method method : object.getClass().getDeclaredMethods()) {
            System.out.println("方法结构:" + Modifier.toString(method.getModifiers()) + " | "
                    + method.getReturnType() + " | "
                    + method.getName());
        }

        //给对象赋值
        //使用Cglib相关类进行赋值
        BeanMap beanMap = BeanMap.create(object);
        beanMap.put("id", 2);
        beanMap.put("name", "xx");
        //使用JDK反射赋值
        /*
        Field field = object.getClass().getDeclaredField("$cglib_prop_name");
        field.setAccessible(true);
        field.set(object,"使用反射赋值");
        */
        /*
        Method method = object.getClass().getDeclaredMethod("setName",String.class);
        method.invoke(object,"使用反射赋值");
        */

        //以上几种赋值都是可以的，构造出来的类和源码写出来的类不同之处在结果截图里面已经很明显了

        //序列化输出
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(object));
    }

}
