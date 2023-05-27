/* 연습문제 */
-- 1. emp 테이블을 사용하여 사원 중에서 급여(sal)와 보너스(comm)를 합친 금액이 가장 많은 경우와 
--    가장 적은 경우 , 평균 금액을 구하세요. 단 보너스가 없을 경우는 보너스를 0 으로 계산하고 
--    출력 금액은 모두 소수점 첫째 자리까지만 나오게 하세요
-- MAX, MIN, AVG
select * from emp;
select 
			min(sal+nvl(comm,0)) 가장낮음
		, max(sal+nvl(comm,0)) 가장높음
		, round(avg(sal+nvl(comm,0)),1) 평균
	from emp;


-- 2. student 테이블의 birthday 컬럼을 참조해서 월별로 생일자수를 출력하세요
-- TOTAL, JAN, ...,  5 DEC
--  20EA   3EA ....
select name, birthday from student;
select concat(count(*),'ea') TOTAL 
	, concat(count(decode(substr(birthday,4,2),'01',1)),'ea') JAN
	, concat(count(decode(substr(birthday,4,2),'02',1)),'ea') FEB
	, concat(count(decode(substr(birthday,4,2),'03',1)),'ea') MAR
	, concat(count(decode(substr(birthday,4,2),'04',1)),'ea') APR
	, concat(count(decode(substr(birthday,4,2),'05',1)),'ea') MAY
	, concat(count(decode(substr(birthday,4,2),'06',1)),'ea') JUN
	, concat(count(decode(substr(birthday,4,2),'07',1)),'ea') JUL
	, concat(count(decode(substr(birthday,4,2),'08',1)),'ea') AUG
	, concat(count(decode(substr(birthday,4,2),'09',1)),'ea') SEP
	, concat(count(decode(substr(birthday,4,2),'10',1)),'ea') OCT
	, concat(count(decode(substr(birthday,4,2),'11',1)),'ea') NOV
	, concat(count(decode(substr(birthday,4,2),'12',1)),'ea') DEC 
	from student;


-- 3. Student 테이블의 tel 컬럼을 참고하여 아래와 같이 지역별 인원수를 출력하세요.
--    단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU, 055-GYEONGNAM
--    으로 출력하세요
select * from student;
select        
       count(case substr(tel,1,(instr(tel,')',1)-1)) when '02' then 1 end) seoul,
       count(case substr(tel,1,(instr(tel,')',1)-1)) when '031' then 1 end) gyeonggi,
       count(case substr(tel,1,(instr(tel,')',1)-1)) when '051' then 1 end) busan,
       count(case substr(tel,1,(instr(tel,')',1)-1)) when '052' then 1 end) ulsan,
       count(case substr(tel,1,(instr(tel,')',1)-1)) when '053' then 1 end) daegu,
       count(case substr(tel,1,(instr(tel,')',1)-1)) when '055' then 1 end) gyeongnam
    from student;


-- 4. emp 테이블을 사용하여 직원들의 급여와 전체 급여의 누적 급여금액을 출력,
-- 단 급여를 오름차순으로 정렬해서 출력하세요.
-- sum() over()
select * from emp;
select ename
		, sal
		, comm
		, sum(sal+nvl(comm,0)) over(order by sal) 누적급여금액
	from emp;


-- 6. student 테이블의 Tel 컬럼을 사용하여 아래와 같이 지역별 인원수와 전체대비 차지하는 비율을 
--    출력하세요.(단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU,055-GYEONGNAM)  
select count(*) || '명(' || (count(name)/ count(name) * 100) || '%)' 전체 
		, count(case substr(tel,1,(instr(tel,')',1)-1)) when '02' then 1 end) || '명(' ||
				(count(case substr(tel,1,(instr(tel,')',1)-1)) when '02' then 1 end) / count(name) * 100) || '%)' 서울
		, count(case substr(tel,1,(instr(tel,')',1)-1)) when '031' then 1 end) || '명(' ||
				(count(case substr(tel,1,(instr(tel,')',1)-1)) when '031' then 1 end) / count(name) * 100) || '%)' 경기	
		, count(case substr(tel,1,(instr(tel,')',1)-1)) when '051' then 1 end) || '명(' ||
				(count(case substr(tel,1,(instr(tel,')',1)-1)) when '051' then 1 end) / count(name) * 100) || '%)' 부산	
		, count(case substr(tel,1,(instr(tel,')',1)-1)) when '052' then 1 end) || '명(' ||
				(count(case substr(tel,1,(instr(tel,')',1)-1)) when '052' then 1 end) / count(name) * 100) || '%)' 울산	
		, count(case substr(tel,1,(instr(tel,')',1)-1)) when '053' then 1 end) || '명(' ||
				(count(case substr(tel,1,(instr(tel,')',1)-1)) when '053' then 1 end) / count(name) * 100) || '%)' 대구	
		, count(case substr(tel,1,(instr(tel,')',1)-1)) when '055' then 1 end) || '명(' ||
				(count(case substr(tel,1,(instr(tel,')',1)-1)) when '055' then 1 end) / count(name) * 100) || '%)' 경남															 
	from student;



-- 7. emp 테이블을 사용하여 부서별로 급여 누적 합계가 나오도록 출력하세요. 
-- ( 단 부서번호로 오름차순 출력하세요. )
select * from emp;
select deptno, sal, 
		 sum(sal) over(partition by deptno order by deptno) 부서별누적합계
	from emp;


-- 8. emp 테이블을 사용하여 각 사원의 급여액이 전체 직원 급여총액에서 몇 %의 비율을 
--    차지하는지 출력하세요. 단 급여 비중이 높은 사람이 먼저 출력되도록 하세요
select ename, sal
		, round(ratio_to_report(sal) over() * 100, 2) 비율
	from emp
	order by 2 desc;

select deptno, ename, sal
		, sum(sum(sal)) over() total
		, round(ratio_to_report(sum(sal)) over() *100, 2) "전체%"
	from emp
	group by deptno, ename, sal
	order by 5 desc;
   
-- 9. emp 테이블을 조회하여 각 직원들의 급여가 해당 부서 합계금액에서 몇 %의 비중을
--     차지하는지를 출력하세요. 단 부서번호를 기준으로 오름차순으로 출력하세요.
select deptno, ename, sal 
		, round(ratio_to_report(sum(sal)) over(partition by deptno) *100, 2) 비율
	from emp
	group by deptno, ename, sal
	order by 1;
	
select deptno, ename, sal
		, sum(sum(sal)) over(partition by deptno order by sal) 부서합계
		, round((ratio_to_report(sum(sal)) over(partition by deptno)) *100, 2) "%"
	from emp
	group by deptno, ename, sal
	order by 1;