package com.tjetc.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.domain.Student;

public class DemoFastJson {
    public static void main(String[] args) {
        Student s1 = new Student("张三",1001);
        Student s2 = new Student("李四",1002);
        s1.setStudent(s2);
        s2.setStudent(s2);
        JSON.DEFAULT_GENERATE_FEATURE|= SerializerFeature.DisableCircularReferenceDetect.getMask();
        String string1 = JSON.toJSONString(s1,SerializerFeature.PrettyFormat);
        System.out.println(string1);
        String string2 = JSON.toJSONString(s2,SerializerFeature.PrettyFormat);
        System.out.println(string2);
    }
}
