package com.lec.ex03_interface;

import com.lec.ex03_interface.Button.OnClickListner;

public class Youtube implements OnClickListner {

	@Override
	public void OnClick() {
		System.out.println("Youtube를 시청합니다");
	}

}
