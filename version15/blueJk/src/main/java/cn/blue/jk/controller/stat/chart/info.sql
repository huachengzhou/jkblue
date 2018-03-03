
# 当日预订时间段(小时)登录压力测试
SELECT
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 00:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 01:00:00'))
  ) as oneNumber, #00:00-01:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 01:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 02:00:00'))
  ) as twoNumber, #01:00-02:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 02:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 03:00:00'))
  ) as threeNumber, #02:00-03:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 03:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 04:00:00'))
  ) as fourNumber, #03:00-04:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 04:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 05:00:00'))
  ) as fiveNumber, #04:00-05:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 05:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 06:00:00'))
  ) as sixNumber, #05:00-06:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 06:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 07:00:00'))
  ) as sevenNumber, #06:00-07:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 07:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 08:00:00'))
  ) as eightNumber, #07:00-08:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 08:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 09:00:00'))
  ) as nineNumber, #08:00-09:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 09:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 10:00:00'))
  ) as tenNumber, #09:00-10:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 10:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 11:00:00'))
  ) as elevenNumber, #10:00-11:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 11:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 12:00:00'))
  ) as twelveNumber, #11:00-12:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 12:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 13:00:00'))
  ) as thirteenNumber, #12:00-13:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 13:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 14:00:00'))
  ) as fourteenNumber, #13:00-14:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 14:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 15:00:00'))
  ) as fifteenNumber, #14:00-15:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 15:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 16:00:00'))
  ) as sixteenNumber, #15:00-16:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 16:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 17:00:00'))
  ) as seventeenNumber, #16:00-17:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 17:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 18:00:00'))
  ) as eighteenNumber, #17:00-18:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 18:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 19:00:00'))
  ) as nineteenNumber, #18:00-19:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 19:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 20:00:00'))
  ) as twentyNumber, #19:00-20:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 20:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 21:00:00'))
  ) as twentyOneNumber, #20:00-21:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 21:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 22:00:00'))
  ) as twentyTwoNumber, #21:00-22:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 22:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 23:00:00'))
  ) as twentyThreeNumber, #22:00-23:00
  (
    select count(*) from login_log_p
    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 23:00:00')) AND
          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 24:00:00'))
  ) as twentyFourNumber #23:00-24:00
from login_log_p group by LOGIN_TIME


#关于mysql日期 DATE_SUB减去一个时间 Seventeen concat(连接)