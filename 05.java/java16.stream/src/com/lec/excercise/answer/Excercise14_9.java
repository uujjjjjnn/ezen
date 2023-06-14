package com.lec.excercise.answer;

import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student_ {
	String name;
	boolean isMale; // 성별
	int hak; // 학년
	int ban; // 반
	int score;

	Student_(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() { return name;	}
	boolean isMale() { return isMale; }
	int getHak() { return hak; }
	int getBan() { return ban; }
	int getScore() { return score; }

	public String toString() {
		return String.format("[%s, %s, %d학년 %d반 , %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
	}

	enum Level {
		HIGH, MID, LOW
	}
}


public class Excercise14_9 {

	public static void main(String[] args) {
		Student_[] stuArr = { 

				 new Student_("나자바", true, 1, 1, 300), 
				 new Student_("김지미", false, 1, 1, 250), 
				 new Student_("김자바", true, 1, 1, 200), 
				 new Student_("이지미", false, 1, 2, 150), 
				 new Student_("남자바", true, 1, 2, 100), 
				 new Student_("안지미", false, 1, 2, 50), 
				 new Student_("황지미", false, 1, 3, 100), 
				 new Student_("강지미", false, 1, 3, 150), 
				 new Student_("이자바", true, 1, 3, 200),
				 new Student_("나자바", true, 2, 1, 300), 
				 new Student_("김지미", false, 2, 1, 250),
				 new Student_("김자바", true, 2, 1, 200), 
				 new Student_("이지미", false, 2, 2, 150), 
				 new Student_("남자바", true, 2, 2, 100), 
				 new Student_("안지미", false, 2, 2, 50), 
				 new Student_("황지미", false, 2, 3, 100), 
				 new Student_("강지미", false, 2, 3, 150), 
				 new Student_("이자바", true, 2, 3, 200)

}; 

		Map<Integer, Map<Integer, Long>> totalScoreByHakAndBan = Stream.of(stuArr)
																	.collect(groupingBy(Student_::getHak
																			, groupingBy(Student_::getBan
																			, Collectors.summingLong(Student_::getScore))));

				
				/* 
				 * (1)  알맞은 코드를 넣으시오 . 
				 */
				
				

				

		for(Object e : totalScoreByHakAndBan.entrySet()) {  
			System.out.println(e); 
		} 
	}

}