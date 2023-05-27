/* 연습문제 */
-- ex01) emp테이블에서 ename, hiredate, 근속년, 근속월, 근속일수 출력, deptno = 10;
-- months_between, round, turnc, 개월수계산(/12), 일수계산(/365, /12)
select * from emp;
select ename, hiredate
		, trunc(((sysdate-hiredate)+1)/365) 근속년
		, trunc(months_between(sysdate, hiredate)) 근속월
		, trunc((sysdate-hiredate)+1) 근속일
	from emp
	where deptno = 10;


-- ex02) student에서 birthday중 생일 1월의 학생의 이름과 생일을 출력(YYYY-MM-DD)
select * from student;

select name, birthday
	from student
	where to_char(birthday, 'MM') = '01';


-- ex03) emp에서 hiredate가 1,2,3월인 사람들의 사번, 이름, 입사일을 출력
select * from emp;

select empno, ename, hiredate
	from emp
	where to_number(to_char(hiredate,'mm')) >=1 and to_number(to_char(hiredate,'mm')) <=3;


-- ex04) emp 테이블을 조회하여 이름이 'ALLEN' 인 사원의 사번과 이름과 연봉을 
--       출력하세요. 단 연봉은 (sal * 12)+comm 로 계산하고 천 단위 구분기호로 표시하세요.
--       7499 ALLEN 1600 300 19,500     
select * from emp;

select empno, ename, sal
		, to_char(sal*12 + comm, '$99,999')
	from emp
	where ename = 'ALLEN';


-- ex05) professor 테이블을 조회하여 201 번 학과에 근무하는 교수들의 이름과 
--       급여, 보너스, 연봉을 아래와 같이 출력하세요. 단 연봉은 (pay*12)+bonus
--       로 계산합니다.
--       name pay bonus 6,970
select * from professor;

select name, pay, bonus
		, to_char(to_number(pay*12 + nvl(bonus,0)), '9,999') 연봉
	from professor
	where deptno = 201;


-- ex06) emp 테이블을 조회하여 comm 값을 가지고 있는 사람들의 empno , ename , hiredate ,
--       총연봉,15% 인상 후 연봉을 아래 화면처럼 출력하세요. 단 총연봉은 (sal*12)+comm 으로 계산하고 
--       15% 인상한 값은 총연봉의 15% 인상 값입니다.
--      (HIREDATE 컬럼의 날짜 형식과 SAL 컬럼 , 15% UP 컬럼의 $ 표시와 , 기호 나오게 하세요)
select * from emp;
	
select empno, ename, hiredate
		, to_char(to_number(sal*12 + comm), '$99,999') 총연봉
		, to_char(to_number((sal*12 + comm)*1.15), '$99,999')  "15%인상"
	from emp
	where comm >= 0;