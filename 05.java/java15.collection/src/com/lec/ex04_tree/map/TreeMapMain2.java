package com.lec.ex04_tree.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapMain2 {

	public static void main(String[] args) {

		// 2. TreeMap 정렬하기
		// descendingMap(), descendingEntrySet()
		TreeMap<Integer, String> students = new TreeMap<>();
		students.put(87, "홍길동");
		students.put(98, "손흥민");
		students.put(75, "이강인");
		students.put(95, "김민재");
		students.put(80, "소향");
		
		// 자동정렬하기
		System.out.print("오름차순 : ");
		for(Integer score : students.keySet()) {
			System.out.print(score + ", ");
		}
		System.out.println();
		
		// 내림차순, 오름차순 정렬
		NavigableMap<Integer, String> descMap = students.descendingMap();
		Set<Map.Entry<Integer, String>> desEntry = descMap.entrySet();
		for(Map.Entry<Integer, String> student : desEntry) {
			System.out.println(student.getValue() + "의 점수 = " + student.getKey());
		}
		System.out.println();
		
		// 내림차순
		NavigableMap<Integer, String> ascMap = descMap.descendingMap();
		Set<Map.Entry<Integer, String>> ascEntry = ascMap.entrySet();
		for(Map.Entry<Integer, String> student : ascEntry) {
			System.out.println(student.getValue() + "의 점수 = " + student.getKey());
		}
		System.out.println();
		

//		System.out.print("내림차순 : ");
//		for(Integer score : descMap.keySet()) {
//			System.out.print(score + ", ");
//		}
//		System.out.println();
//		
//		// 내림차순 -> 오름차순
//		NavigableMap<Integer, String> ascMap = descMap.descendingMap();
//		System.out.print("내림 -> 오름차순 : ");
//		for(Integer score : ascMap.keySet()) {
//			System.out.print(score + ", ");
//		}
//		System.out.println();
//		
		
		
	}

}
