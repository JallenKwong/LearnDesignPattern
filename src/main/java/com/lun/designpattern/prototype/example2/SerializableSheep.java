package com.lun.designpattern.prototype.example2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializableSheep {
    public static void main(String[] args) throws Exception {
        Date date = new Date(1274397294739L);
        Sheep s1 = new Sheep("原型羊",date);
//      Sheep s2 = (Sheep) s1.clone();//克隆一个羊
         
        //使用序列化和反序列化实现深复制
        //1、将s1对象序列化为一个数组
        //通过ObjectOutputStream流将s1对象读出来给ByteArrayOutputStream流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream    oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        //ByteArrayOutputStream流将对象信息转成byte数组，这样byte数组里就包含了对象的数据
        byte[] bytes = bos.toByteArray();
         
        //2、将字节数组中的内容反序列化为一个Sheep对象
        //通过ByteArrayInputStream流读入bytes字节数组中数据，然后传给ObjectInputStream对象输入流
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream    ois = new ObjectInputStream(bis);
        //通过ObjectInputStream返回一个Sheep对象
        Sheep s2 = (Sheep) ois.readObject();
 
        //原型羊的信息
        System.out.println(s1);
        System.out.println("原日期："+s1.getBirthday());
        date.setTime(34732834827389L);//改变原有date的值
        System.out.println("改变后的日期："+date.toString());
        //克隆羊的信息
        System.out.println("---------------------------------");
        System.out.println(s2);
        System.out.println(s2.getBirthday());
    }
}


//结果像深克隆
/* 
designpattern.prototype.example2.Sheep@3d4eac69
原日期：Fri May 21 07:14:54 CST 2010
改变后的日期：Mon Aug 22 17:40:27 CST 3070
---------------------------------
designpattern.prototype.example2.Sheep@7cca494b
Fri May 21 07:14:54 CST 2010 
*/

