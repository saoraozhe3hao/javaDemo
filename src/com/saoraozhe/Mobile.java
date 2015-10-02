package com.saoraozhe;

//继承父类的所有成员
public class Mobile extends Phone{
	private float number = 9;
	//方法重写
	public void call() {
		//访问父类成员		
		System.out.println("Mobile call."+ super.number);
		
	}
	public void reboot() throws Exception{
		if(number > 10){
			//抛出异常
			throw new Exception();
		}
	}
}
