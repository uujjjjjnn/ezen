/*
	A. where 조건절
	
	1. 비교연산자
	
	= 
	!=, <>
	>
	>=
	<
	<=
	
	2. 기타연산자
		
	a and b : 논리곱
	a or b : 논리합
	not a : 부정
	between a and b : a와 b사이의 데이터를 검색, a는 b보다 작아야함 (작은 값이 먼저. 큰 값이 나중에)
	in(a,b,b...)		: a,b,c...의 값을 가지고 있는 데이터를 검색
	like (%, _와 같이 사용) : 특정 패턴을 가지고 있는 데이터를 검색
			-> '%A' A로 끝나는 데이터, 'A%' A로 시작되는 데이터, '%A%' A를 포함한 데이터
	is null / in not null : null값 여부를 가지고 있는 데이터를 검색
	
*/

/* A. 비교연산자 */
-- 1. 급여(sal)가 5000인 사원 조회하기
select * from emp;
select * from emp where sal =5000;
select * from emp where sal =1600;

-- 2. 급여(sal)가 900보다 작은 사원?
select * from emp where sal < 900;
select * from emp where sal > 900;
select * from emp where sal >= 900;
select * from emp where sal <> 900;
select * from emp where sal != 900;

-- 3. 이름이 smith인 사원 조회하기
select * from emp where ename = 'SMITH';
select * from emp where ename = 'smith'; -- (x)
-- select * from emp where ename = SMITH; -- (x) SMITH는 열이름으로 인식

-- 대소문자변환함수 upper(), lower()
select * from emp where ename = 'smith'; -- (x)
select ename from emp where ename = upper('smith'); -- 바꿔주는 작업이 들어가서 속도가 더 늦어짐. 권장하지 않음
select ename from emp where lower(ename) = 'smith';

-- 4. 입사일자(hiredate)
-- 입사일자가 1980-12-17인 사원을 조회
-- (hint) date타입은 비교할 때 문자열로 간주
select * from emp;
select * from emp where hiredate = '1980-12-17';