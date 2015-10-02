//包声明
package com.saoraozhe.java;


//主类名称必须与文件名相同，public类，对其他java文件可见
public class Man {

	// 主类，即运行该文件时 的入口函数
	public static void main(String[] args) {
		//引用的多态
		Phone phone = new Phone(110);
		//向上（隐式/自动）类型转换
		Phone mobile = new Mobile();
		if(mobile instanceof Mobile){
			//向下（强制）类型转换
			Mobile cell = (Mobile)mobile;	
			try{
				cell.reboot();
			}catch(Exception e){
				//打印异常
				e.printStackTrace();
			}finally{
				
			}
		}
		//方法的多态
		phone.call();
		//此时mobile是Phone类型，没有Mobile中的reboot方法
		mobile.call();		
	}
	

}
