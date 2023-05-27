/*
	단일행함수(single function) ; 각 행별로 출력
	
	A. 문자함수
	
	1. upper/lower : 대소문자변환함수 upper('abcde') -> ABCDE / lower('ABCDE') -> abcde
	2. initcap : 첫 글자를 대문자로, 나머지는 소문자 initcap('aBcDe') -> Abcde
	3. length : 문자열의 길이를 리턴 length('abcde') -> 5, length('한글') -> 2 
	4. lengthb : 문자열의 byte단위 리턴(영문 1byte, 한글은 문자셋에 따라 2byte or 3byte리턴)
							length('abcde') -> 5, lengthb('한글') utf-8인 경우 6byte, euc-kr인 경우 4byte
	5. concat : 문자열을 연결(||와 동일) concat('a','b') -> ab
	6. substr : 주어진 문자열에서 특정 위치의 문자를 추출 substr('aBcDe',2,3) -> BcD (문자열,시작점,갯수)
	7. substrb : 주어진 문자열에서 특정 위치의 byte만 추출 
							substrb('한글',1,2) -> (euc-kr) 한
							substrb('한글',1,2) -> (utf-8) 깨진문자
	8. instr : 주어진 문자열에서 특정문자의 위치를 리턴 instr('A*B#C#D','#') -> 4 (중복되면 첫번째 순서)
	9. instrb : 주어진 문자열에서 특정문자의 byte위치를 리턴 instrb('한글로','로') -> 7
	10. lpad : 주어진 문자열에서 특정문자를 앞에서부터 채움 lpad('love',6,'*') -> **love
	11. rpad : 주어진 문자열에서 특정문자를 뒤에서부터 채움 rpad('love',6,'*') -> love**
	12. ltrim : 주어진 문자열에서 앞의 특정문자를 삭제 ltrim('*love','*') -> love
	13. rtrim : 주어진 문자열에서 뒤의 특정문자를 삭제 rtrim('love+','+') -> love
	14. replace : 주어진 문자열에서 A를 B로 치환 replace('AB','A','C') -> CB
	
*/

-- 1. upper/lower
select ename from emp;
select lower(ename) from emp;
select upper(lower(ename)) from emp;

-- 2. initcap
select initcap(ename) from emp;

-- 3. length() / lenghtb()
select ename, length(ename) from emp;
select '소향' from dual; -- dual은 오라클에서 제공해주는 dummy 테이블
select * from dual;
select '소향', dummy from dual;

select '소향', length('소향'), lengthb('소향') from dual;

-- 4. concat() or ||
select name, id, 
	concat(name, id), 
	concat(name, ' - ') "name - ",
	concat(concat(name, ' - '),id) "name - id", 
	concat(concat('홍길동의 직업은 ', '의적입니다!'), '주소는 조선한양입니다!') as 홍길동,
	name || ' - ' || id ad "name - id",
	'홍길동의 직업은 ' || '의적입니다' ||  '주소는 한양입니다' as "홍길동(2)"
from professor;

-- 5. substr(값, from, length) / substrb(값, from, length)
-- from이 음수값이면 뒤에서부터 처리
select 'abcdef'
		, substr('abcdef', 3) cdef
		, substr('abcdef', 3, 2) cd
		, substr('abcdef', -3) def
		, substr('abcdef', -3, 2) de
	from dual;
	
select '홍길동'
		, substr('홍길동', 1, 1) 홍
		, substrb('홍길동', 1, 1) 홍xxx
		, substrb('홍길동', 1, 2) 홍xxx
		, substrb('홍길동', 1, 3) 홍
	from dual;

-- 실습. 991119-1234567에서 성별구분만 추출해보기
select '991119-1234567'
			, substr('991119-1234567',-7,1) as 성별
			-- 1/3이면 남자, 2/4면 여자
	from dual;

-- 6. instr(문자열, 검색글자, from(기본값 1), 몇 번째(기본값 1))
-- 검색글자의 위치를 리턴해준다.
-- 시작위치가 음수이면 뒤에서부터 검색	
select 'A*B*C*D'
		, instr('A*B*C*D','*') "2nd"
		, instr('A*B*C*D','*', 3) "4th"
		, instr('A*B*C*D','*', 1, 2) "4th" -- 처음부터 시작해서 2번째의 *의 위치
		, instr('A*B*C*D','*', -5, 1) "2nd" -- 뒤에서 5번째 위치에서부터
		, instr('A*B*C*D','*', -1, 2) "4th"
	from dual;
	
select 'HELLO WORLD'
		, instr('HELLO WORLD', 'O') "5th"
		, instr('HELLO WORLD', 'O', -1) "8th"
		, instr('HELLO WORLD', 'O', -1, 1) "8th"
		, instr('HELLO WORLD', 'O', -1, 2) "5th"
	from dual;
	
-- 7. lpad(문자열, 자리수, 채울문자) / rpad(문자열, 자리수, 채울문자)
select name, id, length(id)
		, lpad(id, 10) -- 채울 문자가 정의되지 않으면 공란으로 채워진다.
		, lpad(id, 10, '*')
		, rpad(id, 10,'*')
	from student
	where deptno1 = 101;
	
-- 8. ltrim / rtrim
select ename
		, ltrim(ename, 'C')
		, rtrim(ename, 'R')
	from emp
	where deptno = 10;
	
select '   xxx   ' from dual union all
select ltrim('   xxx   ') from dual union all
select rtrim('   xxx   ') from dual;

-- 9. replace(문자열, 변경전문자, 변경후문자)
select ename 
		, replace(ename, 'KI', '**')
		, replace(ename, 'I', '-------')
		-- **ARK, **NG, **LLER substr(), replace()
		, replace(ename, substr(ename, 1, 2), '**') 
	from emp
	where deptno = 10;

-- 연습문제
-- ex01) student 테이블의 주민등록번호 에서 성별만 추출
-- ex02) student 테이블의 주민등록번호 에서 월일만 추출
-- ex03)70년대에 태어난 사람만 추출
-- ex04) student 테이블에서 jumin컬럼을 사용, 1전공이 101번인 학생들의
--       이름과 태어난월일, 생일 하루 전 날짜를 출력
	
-- 형변환함수, 자동(묵시적)형변환, 수동(명시적)형변환


/*
	B. 숫자함수
	
	1. round : 주어진 실수를 반올림
	2. trunc : 주어진 실수를 버림
	3. mod	 : 나누기연산 후 나머지값을 리턴
	4. ceil	 : 주어진 실수값에서 가장 큰 정수값을 리턴
	5. floor : 주어진 실수값에서 가장 작은 정수값을 리턴
	6. power : 주어진 값을 주어진 승수를 리턴 power(3,3) -> 3*3*3 = 27
	7. rownum : 오라클에서만 사용되는 속성으로 모든 객체에 제공된다.
		... rownum은 전체선택자(*)와 같이 사용할 수 없다.
		... rownum은 행번호를 의미
	
*/

-- 1. round(실수, 반올림위치)
select 976.635
		, round(976.635)
		, round(976.635, 0)
		, round(976.635, 1)
		, round(976.635, 2)
		, round(976.635, 3)
		, round(976.635, -1)
		, round(976.635, -2)
	from dual;
	
-- 2. trunc(실수, 버림위치)
select 976.635
		, trunc(976.635)
		, trunc(976.635, 0)
		, trunc(976.635, 1)
		, trunc(976.635, 2)
		, trunc(976.635, 3)
		, trunc(976.635, -1)
		, trunc(976.635, -2)
	from dual;

-- 3. mod, ceil, floor
select 121
		, mod(121,10)
		, ceil(121.1)
		, floor(121.9)
	from dual;

-- 4. power
select '2의 3승 = ', power(2,3) from dual union all
select '3의 3승 = ', power(3,3) from dual;

-- 5. rownum
select rownum, * from student; -- (x) rownum은 *와 같이 사용불가
select rownum, name from student;
select rownum, name, id from student where deptno1 = 101; -- 쿼리결과에 따른 행번호 출력


/*

	C. 날짜함수
	
	1. sysdate : 시스템의 현재일자 (날짜형으로 리턴)
	2. months_between : 두 날짜 사이의 개월 수를 리턴 (숫자형)
	3. add_months : 주어진 일자에 개월 수를 더한 결과를 리턴 (날짜형)
	4. next_day : 주어진 일자를 기준으로 다음 날짜를 리턴. 요일 (날짜형)
	5. last_day : 주어진 일자에 해당하는 월의 마지막일자를 리턴 
	6. round : 주어진 날짜를 반올림
	7. trunc : 주어진 날짜를 버림
	
*/

-- 1. sysdate
select sysdate from dual;

-- 2. months_between
select months_between(sysdate, '20230101') from dual;

-- 근속월수는?
select months_between(sysdate, hiredate) from emp;

-- 3. add_months
select sysdate
		, add_months(sysdate, 2)
		, add_months(sysdate, -3)
	from dual;
	
-- 4. next_day
-- 현재일에서 다음의 요일
select sysdate
		, next_day(sysdate, 1) -- 1~7 : 일~토
		, next_day(sysdate, 2)
		, next_day(sysdate, 3)
		, next_day(sysdate, 4)
		, next_day(sysdate, 5)
		, next_day(sysdate, 6)
		, next_day(sysdate, 7)
	from dual;
	
-- 5. last_day
select sysdate
		, last_day(sysdate)
		, last_day('20230301') -- 자동형변환
		, last_day('2023-03-01')
		, last_day('2023.03.01')
		, last_day('2023/03/01')
		-- , last_day('2023-MAR-01') -- (x)
		-- , last_day('03/01/2023') -- (x)
		-- , last_day('OCT012023') -- (x)
	from dual;
	
	-- 6. round / trunc
	select sysdate
			, round(sysdate)
			, trunc(sysdate)
			-- , round('20230301') -- (x)
			, trunc('20230301')
		from dual;
		

/*
	D. 형변환함수
	
	1. to_char() : 날짜 or 숫자를 문자로 변환함수
	2. to_number() : 문자형숫자를 숫자로 변환 (단, 숫자형식에 맞아야 함)
	3. to_date() : 문자형을 날짜로 변환 (단, 날짜형식에 맞야 함)
	
*/

-- 1. 자동형변환 / 수동형변환

-- 1) 자동(묵시적)형변환
select '2' + 2 from dual -- '22'가 아니라 '2'숫자로 변화되고 연산
union all
select 2 + '2' from dual; -- 즉, 문자와 숫자의 연산의 우선순위는 숫자에 있다.

-- 2) 수동(명시적)형변환
select to_number('2') + 2 from dual
union all
select 2 + to_number('2') from dual;

select '2a' + 2 from dual; -- (x)
select 'A' + 2 from dual; -- (x)

-- 2. to_char()

-- 1) 날짜를 문자로 변환
select sysdate
		, to_char(sysdate)
		, to_char(sysdate, 'YYYY') 년도
		, to_char(sysdate, 'RRRR') 년도
		, to_char(sysdate, 'YY') 년도
		, to_char(sysdate, 'RR') 년도
		, to_char(sysdate, 'yy') 년도
		, to_char(sysdate, 'YEAR') 년도
		, to_char(sysdate, 'year') 년도
	from dual;

select sysdate
		, to_char(sysdate)
		, to_char(sysdate, 'MM') 월
		, to_char(sysdate, 'MON') 월
		, to_char(sysdate, 'MONTH') 월
		, to_char(sysdate, 'mm') 월
		, to_char(sysdate, 'mon') 월
		, to_char(sysdate, 'month') 월
	from dual;
	
select sysdate
		, to_char(sysdate)
		, to_char(sysdate, 'DD') 일
		, to_char(sysdate, 'DAY') 일
		, to_char(sysdate, 'DDTH') 일
		, to_char(sysdate, 'dd') 일
		, to_char(sysdate, 'day') 일
		, to_char(sysdate, 'ddth') 일
	from dual;
	
select sysdate
		, to_char(sysdate)
		, to_char(sysdate, 'YYYY.MM.DD')
		, to_char(sysdate, 'yyyy.mm.dd')
		, to_char(sysdate, 'yyyy.mm.dd hh:mi')
		, to_char(sysdate, 'yyyy.mm.dd hh:mi:ss')
		, to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss')
		, to_char(sysdate, 'MON.DD.YY hh:mi:ss') -- 환경에 따라 MAR.21.2023 나오기도함
	from dual;
	

-- 2) 숫자를 문자로 변환
--12345 -> 12,345 or 12345.00 형태로 변환
select 12345
		, to_char(12345, '99999')
		, to_char(12345, '9999999999')
		, to_char(12345, '09999999999')
		, to_char(12345, 'l99999') -- l자리에 원화표시
		, to_char(12345, '$99999')
		, to_char(12345, '$99999.99')
		, to_char(12345, '$99,999')
		, to_char(123456789, '$99.999') -- 자리수가 안 맞아서 #으로 출력
	from dual;
	
/*
	E. 기타함수
	
	1. nvl() : null값을 다른 값으로 치환하는 함수 nvl(comm, 0)
	2. nvl2() : null값을 다른 값으로 치환하는 감수 vnl2(comm, true, false)
	3. decode() : 오라클에서만 사용하는 함수 if~else
	4. case : decode대신 일반적으로 사용되는 문장
		
		case 조건 when 결과1 then 출력1,
						[when 결과n then 출력n]
						else 출력
			end as 별칭
	
*/


-- 1. nvl()
select name, pay, bonus
		, pay + bonus as total
		, nvl(bonus, 0)
		, to_char(pay + nvl(bonus, 0), '999,999') 총급여
	from professor
	where deptno = 201;
	
-- 2. nvl2(col, null이 아니면, null이면)
select name, pay, bonus
		, nvl2(bonus, bonus, 0) 보너스
		, nvl2(bonus, pay+bonus, pay) 총급여
	from professor
	where deptno = 201;
	
select ename, sal, comm
		, sal + nvl(comm, 0)
		, sal + nvl(comm, 100)
		, nvl2(comm, 'null값이 아닙니다', 'null값입니다')
		, nvl2(comm, 'comm이 없습니다', '사원 '||ename||'은 comm이 없습니다')
	from emp;

-- 실습
-- ex01) professor 테이블에서 201번 학과 교수들의 이름과 급여, bonus, 총 연봉을 출력하세요
--			단 총 연봉은 (pay*12+bonus)로 계산하고 bonus가 없는 교수는 0으로 계산하세요
select * from professor;
select name, pay, bonus
		, pay*12+nvl(bonus,0) "총 연봉"
	from professor
	where deptno = 201;

select name, pay
		, nvl2(bonus, bonus, 0) 보너스
		, nvl2(bonus, pay*12+bonus, pay*12) "총 연봉"
	from professor
	where deptno = 201;
	
-- ex02) 아래 화면과 같이 emp 테이블에서 deptno가 30번인 사원들을 조회하여 comm 값이 있을 경우
--			'Exist'을 출력하고 comm값이 null인 경우 'NULL'을 출력하세요
select * from emp;
select ename, comm
		, nvl2(comm, 'Exist', 'NULL')
	from emp
	where deptno = 30;
	

-- 3. decode함수
-- 1) 통상적으로 if~else문을 decode로 표현한 함수로 오라클에서만 사용된는 함수
-- 2) 오라클에서 자주 사용하는 중요한 함수이다
-- 3) decode(col, true, false) 즉, col결과(값)가 true일 경우 true실행문을 실행, 아니면 false실행문을 실행
-- 4) decode(deptno, 101, true,
--									 102, true,
--									 103, true, false) -> if~else if~else
-- 5) decode(deptno, 101, decode()...) 중첩if문

-- 101이면 컴퓨터공학, 아니면 기타학과
select name, deptno
		, decode(deptno, 101, '컴퓨터공학') --if(true) {}
		, decode(deptno, 101, '컴퓨터공학', '기타학과') --if(true) {} else {}
	from professor;
	
select * from department;

-- 101 컴공, 102 미디어융합, 103 소프트공학, 나머지는 기타학과
select name, deptno
		, decode(deptno, 101, '컴퓨터공학'
									 , 102, '미디어융합'
									 , 103, '소프트공학'
										 , '기타공학') --if(true) {} else if {} else {}
	from professor;
	
-- 중첩decode
-- 101학과 교수 중에서 Audie Murphy 교수는 'Best Professor' 아니면 'Good', 101이외의 학과교수는 N/A
select name, deptno
		, decode(deptno, 101, decode(name, 'Audie Murphy', 'Best Professor', 'Good'), 'N/A')
	from professor;
	
select name, deptno
		, decode(deptno, 101, 'Best Professor', 'N/A')
		, decode(name, 'Audie Murphy', 'Best Professor', 'Good')
		, decode(deptno, 101, decode(name, 'Audie Murphy', 'Best Professor', 'Good'), 'N/A')
	from professor;
	
-- 실습
-- ex01) student에서 전공이 101인 학생들 중에 jumin 성별구분해서
-- 1 or 3 = 남자, 2 or 4 = 여자를 출력
-- name, jumin, gender
-- substr, decode
select name, jumin
		, decode(substr(jumin,7,1), 1, '남자'
															, 3, '남자'
															, 2, '여자'
															, 4, '여자') gender
	from student
	where deptno1 = 101;


-- ex02) student 테이블에서 1전공이(deptno1) 101번인 학생의 이름과 연락처와 지역을 출력하세요
-- 			단, 지역번호 02는 "SEOUL",
-- 			031은 "GYEONGGI", 051은 "BUSAN", 052는 "ULSAN", 055는 "GYEONGNAM" 입니다
-- 			substr, instr, decode
select * from student;
select name, tel
		, decode(instr(tel,')'), 3, 'SEOUL'
													 , decode(substr(tel,1,3), '031', 'GYEONGGI'
																										, '051', 'BUSAN'
																										, '052', 'ULSAN'
																										, '055', 'GYEONGNAM')
	from student;
	
	
select name, tel
		, substr(tel, 1, 3)
		, instr(tel, ')', 1, 1)
		, substr(tel, 1, instr(tel, ')', 1, 1)-1)
		, decode(substr(tel, 1, instr(tel, ')', 1, 1)-1), 
			'02', 'SEOUL',
			'031', 'GYEONGGI',
		  '051', 'BUSAN',
		  '052', 'ULSAN',
		  '055', 'GYEONGNAM',
			'기타') as 지역
	from student;
	
-- 4. case문
-- 1) case 조건 when 결과 then 출력...
select name, tel
		, substr(tel, 1, 3)
		, instr(tel, ')', 1, 1)
		, substr(tel, 1, instr(tel, ')', 1, 1)-1)
		, decode(substr(tel, 1, instr(tel, ')', 1, 1)-1), 
			'02', 'SEOUL',
			'031', 'GYEONGGI',
		  '051', 'BUSAN',
		  '052', 'ULSAN',
		  '055', 'GYEONGNAM',
			'기타') as 지역
		, case substr(tel, 1, instr(tel, ')', 1, 1)-1)
				when '02' then '서울'
				when '031' then '경기'
				when '051' then '부산'
				when '052' then '울산'
				when '055' then '경남'
				else '기타'
			end as 지역
	from student;

-- 2) case when 컬럼 between 값1 and 값2 then 출력...
-- emp테이블에서 sal 1~1000 1등급 1001~2000 2등급 ... 4001보다 크면 5등급
select ename
		, sal
		, case when sal between 1 and 1000 then '1등급'
					 when sal between 1001 and 2000 then '2등급'
					 when sal between 2001 and 3000 then '3등급'
					 when sal between 3001 and 4000 then '4등급'
					 when sal > 4000 then '5등급'
			end as 등급
	from emp;
	
-- 연습문제
-- ex01) student에서 jumin에 월참조해서 해당월의 분기를 출력(1Q, 2Q, 3Q, 4Q)
-- name, jumin, 분기 

-- ex02) dept에서 10=회계부, 20=연구실, 30=영업부, 40=전산실
-- 1) decode
-- 2) case

-- deptno, 부서명
-- ex03) 급여인상율을 다르게 적용하기
-- emp에서 sal < 1000 0.8%인상, 1000~2000 0.5%, 2001~3000 0.3%
-- 그 이상은 0.1% 인상분 출력
-- ename, sal(인상전급여), 인상후급여 
-- 1) decode
-- 2) case 