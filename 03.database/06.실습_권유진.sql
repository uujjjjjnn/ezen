-- 연습문제
select * from student;

-- ex01) student 테이블의 주민등록번호 에서 성별만 추출
select jumin
		, substr(jumin, 7,1) 
	from student;

-- ex02) student 테이블의 주민등록번호 에서 월일만 추출
select jumin
		, substr(jumin, 3,4)
	from student;

-- ex03)70년대에 태어난 사람만 추출
select jumin
	from student
	where substr(jumin, 1,2) >= 70 and substr(jumin, 1,2) < 80;
	
select jumin
	from student
	where substr(jumin, 1,2) like '7%';

-- ex04) student 테이블에서 jumin컬럼을 사용, 1전공이 101번인 학생들의
--       이름과 태어난월일, 생일 하루 전 날짜를 출력
select name
	, substr(jumin, 3,4) as 태어난월일
	, substr(jumin, 3,2) || (substr(jumin,5,2)-1) as "생일 하루 전 날" -- 문자열 뒤에 -1 붙이면 문자가 숫자로 자동형변환
	from student
	where deptno1 = 101;
