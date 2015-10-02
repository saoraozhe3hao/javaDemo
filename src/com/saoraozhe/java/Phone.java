package com.saoraozhe.java;


//继承抽象类，实现接口
public class Phone extends Machine implements Caller{
	//成员变量,private成员变量，对其他java文件不可见
	//protected 包和子类可见，默认包可见
	protected float number;
	
	//final 成员变量只能赋值一次
	private final int WORK = 1;
	
	//构造方法，方法名与类名相同，没有返回值
	public Phone(float number){
		//this指向新构造出来的对象
		this.number = number + WORK;
	}
	//方法重载，方法名相同，参数个数不同
	public Phone(){
		this.number = 110;
	}
	public void call(){		
		System.out.println("call.");
	}
	//重写Object的方法
	public String toString(){
		return "";
	}
	public boolean equals(Object object){
		return true;
	}
	//final方法不能被重写
	public final float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	
	//内部类，只能被本文件主类访问，能访问主类的成员
	//final类不能被继承
	public final class inner{
		
	}
    
}
