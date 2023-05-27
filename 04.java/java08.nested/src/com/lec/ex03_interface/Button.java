package com.lec.ex03_interface;

public class Button {

	// 중첩인터페이스
	interface OnClickListner {
		void OnClick();
	}
	
	OnClickListner listner ;
	
	public void setListner(OnClickListner listner) {
		this.listner = listner;
	}
	
	void click() {
		listner.OnClick();
	}
}

class Call implements Button.OnClickListner {

	@Override
	public void OnClick() {
		System.out.println("전화를 겁니다!!");		
	}
}
class Message implements Button.OnClickListner {

	@Override
	public void OnClick() {
		System.out.println("문자를 보냅니다!!");
	}
}

