-- 연습문제
-- ex01) student에서 jumin에 월참조해서 해당월의 분기를 출력(1Q, 2Q, 3Q, 4Q)
-- name, jumin, 분기 
select name, jumin 
		, substr(jumin,3,2)
		, case when to_number(substr(jumin,3,2)) between 1 and 3 then '1Q'
					 when to_number(substr(jumin,3,2)) between 4 and 6 then '2Q'
					 when to_number(substr(jumin,3,2)) between 7 and 9 then '3Q'
					 when to_number(substr(jumin,3,2)) between 9 and 12 then '4Q'
					 end as 분기
from student;

select name, jumin 
		, substr(jumin,3,2)
		, case when substr(jumin,3,2) between '01' and '03' then '1Q'
					 when substr(jumin,3,2) between '04' and '06' then '2Q'
					 when substr(jumin,3,2) between '07' and '09' then '3Q'
					 when substr(jumin,3,2) between '09' and '12' then '4Q'
					 end as 분기
from student;


-- ex02) dept에서 10=회계부, 20=연구실, 30=영업부, 40=전산실
-- 1) decode
-- 2) case
-- deptno, 부서명

-- 1) decode
select deptno 
		, decode(deptno, 10, '회계부'
									 , 20, '연구실'
									 , 30, '영업부'
									 , 40, '전산실') 부서명
from emp;

-- 2) case
select deptno,
		  case deptno when 10 then '회계부'
								  when 20 then '연구실'
								  when 30 then '영업부'
								  when 40 then '전산실'
		end as 부서명
from emp;


-- ex03) 급여인상율을 다르게 적용하기
-- emp에서 sal < 1000 0.8%인상, 1000~2000 0.5%, 2001~3000 0.3%
-- 그 이상은 0.1% 인상분 출력
-- ename, sal(인상전급여), 인상후급여 
-- 1) decode
-- 2) case 
-- sign() : 값의 음수 양수 결과를 -1 0 1로 리턴

-- 1) decode
select ename, sal
		, decode(sign(sal-1000),
							-1, sal*1.08,
							 0, sal*1.08,
							 1, decode(sign(sal-2000),
									 -1, sal*1.05,
									  0, sal*1.05,
										1, decode(sign(sal-3000),
												 -1, sal*1.03,
												  0, sal*1.03,
													1, sal*1.01))) as 인상후급여
from emp;

-- 2) case
select ename, sal 인상전급여
		, case when sal between 0 and 1000 then sal+sal*0.8
					 when sal between 1000 and 2000 then sal+sal*0.5
					 when sal between 2001 and 3000 then sal+sal*0.3
					 else sal+sal*0.1	
		end as 인상후급여
from emp;

