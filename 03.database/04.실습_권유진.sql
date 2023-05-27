/* 연습문제 */
select * from emp;
select * from dept;

-- ex00) 입사일자가 1980-12-17인 사원을 조회
select * from emp where hiredate = '1980-12-17';

-- ex01) 급여가 1000보다 작은 사원만 출력하기(ename/sal/hiredate 만 출력)
select ename, sal, hiredate from emp where sal < 1000;

-- ex02) 부서(dept)테이블에서 부서번호와, 부서명을 별칭으로 한 sql문을 작성
select deptno 부서번호, dname 부서명 from dept;

-- ex03) 사원테이블에서 직급만 출력하는데 중복되지 않게 출력하는 sql문
select distinct job from emp;

-- ex04) 급여가 800인 사원만 조회
select * from emp where sal = 800;

-- ex05) 사원명이 BLAKE인 사원만 출력
select * from emp where ename = 'BLAKE';

-- ex06) 사원이름 JAMES~MARTIN사이의 사원을 사원번호, 사원명, 급여를 출력
-- and / between 두가지형태로 작성
select empno, ename, sal from emp order by 2;
select empno, ename, sal from emp where ename >= 'JAMES' and ename <= 'MARTIN'; -- 앞에 큰 값이 와도 상관 없음
select empno, ename, sal from emp where ename between 'JAMES' and 'MARTIN'; -- 앞의 값이 작은값


