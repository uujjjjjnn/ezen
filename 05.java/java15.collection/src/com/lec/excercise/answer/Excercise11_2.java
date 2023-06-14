package com.lec.excercise.answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Excercise11_2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
		HashSet set = new HashSet(list); // 중복삭제
		TreeSet tset = new TreeSet(set); // 오름차순 2367
		Stack stack = new Stack();
		stack.addAll(tset);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}

	}
		// 7->6->3->2순으로 출력
}
