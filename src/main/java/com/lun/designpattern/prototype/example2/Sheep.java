package com.lun.designpattern.prototype.example2;

import java.io.Serializable;
import java.util.Date;

/**
 * 原型模式:深浅克隆
 * Cloneable是一个空接口（标记接口），是一个规范。但是如果要克隆这个类对象的话必须实现Cloneable接口
 */
public class Sheep implements Cloneable,Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7591247361463473335L;
	
	private String sname;
    private Date birthday;
     
    public Sheep(String string, Date date) {
		this.birthday = date;
		this.sname = string;
	}
	/**
	 * 
	 * 浅克隆
     * 重写Object对象的clone方法
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        //直接调用Object对象的clone方法
//        Object obj = super.clone();
//        return obj;
//    }

    /**
     * 
     * 深克隆
     * 重写Object对象的clone方法
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //直接调用Object对象的clone方法
        Object obj = super.clone();
        //深克隆：把对象下的所有属性也克隆出来
        Sheep s = (Sheep) obj;
        s.birthday = (Date) this.birthday.clone();
        return s;
    }    

    
    /**
     * 测试原型模式
     */
    public static void main(String[] args) throws Exception {
        Date date = new Date(1274397294739L);
        Sheep s1 = new Sheep("原型羊",date);
        Sheep s2 = (Sheep) s1.clone();//克隆一个羊
        System.out.println(s1);
        System.out.println(s1.getSname());
        System.out.println("原日期："+s1.getBirthday());
        date.setTime(34732834827389L);//改变原有date的值
        System.out.println("改变后的日期："+date.toString());
         
        //克隆羊的信息
        System.out.println("---------------------------------");
        System.out.println(s2);
        System.out.println(s2.getSname());
        System.out.println(s2.getBirthday());//此时的birthday日期使用的是改变后的日期对象引用
    }



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
}

//浅克隆

/*
designpattern.prototype.example2.Sheep@15db9742
原型羊
原日期：Fri May 21 07:14:54 CST 2010
改变后的日期：Mon Aug 22 17:40:27 CST 3070
---------------------------------
designpattern.prototype.example2.Sheep@5c647e05
原型羊
Mon Aug 22 17:40:27 CST 3070 
*/

//深克隆
/*
designpattern.prototype.example2.Sheep@15db9742
原型羊
原日期：Fri May 21 07:14:54 CST 2010
改变后的日期：Mon Aug 22 17:40:27 CST 3070
---------------------------------
designpattern.prototype.example2.Sheep@5c647e05
原型羊
Fri May 21 07:14:54 CST 2010
*/