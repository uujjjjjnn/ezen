/* 연습문제 */
-- 1. emp 테이블을 사용하여 사원 중에서 급여(sal)와 보너스(comm)를 합친 금액이 가장 많은 경우와 
--    가장 적은 경우 , 평균 금액을 구하세요. 단 보너스가 없을 경우는 보너스를 0 으로 계산하고 
--    출력 금액은 모두 소수점 첫째 자리까지만 나오게 하세요
-- MAX, MIN, AVG
select * from emp;
select max(sal+nvl(comm,0)) 최대, min(sal+nvl(comm,0)) 최저, trunc(avg(sal+nvl(comm,0)),2) 평균
from emp;


-- 2. student 테이블의 birthday 컬럼을 참조해서 월별로 생일자수를 출력하세요
-- TOTAL, JAN, ...,  5 DEC
--  20EA   3EA ....
select * from student where substr(birthday,6,2) = '01';
select name, substr(birthday,6,2) from student;
select 
    count(*)||'ea' TOTAL,
    count(case substr(birthday,6,2) when '01' then '1' end)||'ea' JAN,
    count(case substr(birthday,6,2) when '02' then '1' end)||'ea' FEB,
    count(case substr(birthday,6,2) when '03' then '1' end)||'ea' MAR,                  
    count(case substr(birthday,6,2) when '04' then '1' end)||'ea' APR,                  
    count(case substr(birthday,6,2) when '05' then '1' end)||'ea' MAY,                  
    count(case substr(birthday,6,2) when '06' then '1' end)||'ea' JUN,                  
    count(case substr(birthday,6,2) when '07' then '1' end)||'ea' JUL,                  
    count(case substr(birthday,6,2) when '08' then '1' end)||'ea' AUG,                  
    count(case substr(birthday,6,2) when '09' then '1' end)||'ea' OCT,                  
    count(case substr(birthday,6,2) when '10' then '1' end)||'ea' SEP,                  
    count(case substr(birthday,6,2) when '11' then '1' end)||'ea' NOV,                  
    count(case substr(birthday,6,2) when '12' then '1' end)||'ea' DEC                  
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
select ename, sal, sum (sal) over(order by sal) 누적급여
    from emp;
    

-- 6. student 테이블의 Tel 컬럼을 사용하여 아래와 같이 지역별 인원수와 전체대비 차지하는 비율을 
--    출력하세요.(단, 02-SEOUL, 031-GYEONGGI, 051-BUSAN, 052-ULSAN, 053-DAEGU,055-GYEONGNAM)
select * from student;
select 
    
     --count(case substr(tel,1,instr(tel,')')-1) when '02' then 1 end)
     count(case substr(tel,1,instr(tel,')')-1) when '02' then 1 end) 서울,
     count(case substr(tel,1,instr(tel,')')-1) when '031' then 1 end) 경기,
     count(case substr(tel,1,instr(tel,')')-1) when '051' then 1 end) 부산,
     count(case substr(tel,1,instr(tel,')')-1) when '052' then 1 end) 울산,
     count(case substr(tel,1,instr(tel,')')-1) when '053' then 1 end) 대구,
     count(case substr(tel,1,instr(tel,')')-1) when '055' then 1 end) 경남
    from student;

select 
    ratio_to_report(count(case substr(tel,1,instr(tel,')')-1) when '055' then 1 end)) over()
    from student
    ;
select substr(tel,1,(instr(tel,')')-1)) 지역, 
    count(substr(tel,1,(instr(tel,')')-1))) 명수,
--    ratio_to_report((count(substr(tel,1,(instr(tel,')')-1)))*100) over()비율
--    ratio_to_report(sum(명수)*100) 비율
    from student
    group by substr(tel,1,(instr(tel,')')-1));
      

-- 7. emp 테이블을 사용하여 부서별로 급여 누적 합계가 나오도록 출력하세요. 
-- ( 단 부서번호로 오름차순 출력하세요. )
select * from emp;
select deptno, sal, nvl(comm,0) 보너스,
sum(sal+nvl(comm,0)) over(partition by deptno order by sal+nvl(comm,0)) 누적합계
from emp;

select deptno, sal, sum(sal) 누적합계
from emp 
group by deptno, rollup(sal)
order by deptno;

-- 8. emp 테이블을 사용하여 각 사원의 급여액이 전체 직원 급여총액에서 몇 %의 비율을 
--    차지하는지 출력하세요. 단 급여 비중이 높은 사람이 먼저 출력되도록 하세요
select * from emp;
select ename, sal,
       round(ratio_to_report(sum(sal))over() *100, 2) 비율
    from emp
    group by ename, sal
    order by 3 desc;

-- 9. emp 테이블을 조회하여 각 직원들의 급여가 해당 부서 합계금액에서 몇 %의 비중을
--     차지하는지를 출력하세요. 단 부서번호를 기준으로 오름차순으로 출력하세요.
select * from emp;
select deptno, ename, sal,
    round(ratio_to_report(sum(sal)) over(partition by deptno) *100,2) 비율
    from emp 
    group by deptno, ename, sal 
    order by deptno;