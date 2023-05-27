package com.lec.ex11_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 	요소를 그룹핑해서 저장하기
 	
 	collect()메서드는 단순히 요소를 수집(저장)하는 기능이외에 컬렉션의 요소들을 특정값으로 그룹핑해서 Map객체를 생성하는 기능을 제공한다.
 	collect()를 호출할 때 Collector의 groupingBy(), groupingByConcurrent()가 리턴하는 Collector를 매개값으로 대입하면 된다.
 	
 	groupingBy()는 쓰레드에 안전하지 않은 Map을 생성하지만 groupingByConcurrent()는 쓰레드에 안전한 ConcurrentMap을 생성한다.
 	
 */
public class CollectMain3 {
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 0, Student.Gender.MALE, Student.City.SEOUL),
				new Student("홍길순", 0, Student.Gender.FEMALE, Student.City.BUSAN),
				new Student("홍길녀", 0, Student.Gender.FEMALE, Student.City.SEOUL),
				new Student("홍길상", 0, Student.Gender.MALE, Student.City.BUSAN)
			);
		
		// 1. 성별 그룹핑
		Map<Student.Gender, List<Student>> by_gender = list.stream().collect(Collectors.groupingBy(Student :: getGender));
		System.out.println(by_gender.getClass());
		System.out.println();
		
		System.out.println(by_gender.get(Student.Gender.MALE).getClass());
		System.out.println();
		
		System.out.print("[남학생] ");
		by_gender.get(Student.Gender.MALE).stream().forEach(s -> System.out.print(s.getName() + ", "));
		System.out.println();
		
		System.out.print("[여학생] ");
		by_gender.get(Student.Gender.FEMALE).stream().forEach(s -> System.out.print(s.getName() + ", "));
		System.out.println("\n-------------------------------------");
		
		// 2. 도시별 그룹핑
		Map<Student.City, List<Student>> by_city = list.stream().collect(Collectors.groupingBy(Student :: getCity));
		System.out.print("[서울] ");
		by_city.get(Student.City.SEOUL).stream().forEach(s -> System.out.print(s.getName() + ", "));
		System.out.println();
		System.out.print("[부산] ");
		by_city.get(Student.City.BUSAN).stream().forEach(s -> System.out.print(s.getName() + ", "));
		System.out.println("\n-------------------------------------");
		
		// 3. Collectors.groupingBy(그룹조건(Function), 매핑(집계))
		// Collectors.groupingBy()메서드는 그룹핑 후에 맵핑이나 집계(평균, 카운팅, 합계 ..)를 할 수 있도록 
		// 두번째 매개변수로 Collectors객체를 정의할 수 있다.
		Map<Student.City, List<String>> by_city1 = list.stream()
													   .collect(Collectors.groupingBy(Student :: getCity, 
				    		  						            Collectors.mapping(Student :: getName, Collectors.toList())));
		System.out.print("[서울] ");
		by_city1.get(Student.City.SEOUL).stream().forEach(s -> System.out.print(s + ", ")); // String으로 받아서 s.getName()하지 않고 s로 바로 출력가능
		System.out.print("\n[부산] ");
		by_city1.get(Student.City.BUSAN).stream().forEach(s -> System.out.print(s + ", "));
		
		
		
		
		
	}
}





