create or replace procedure UPDATE_IMEI_REPORT_ECCUSTID(start_time in varchar2,end_time in varchar2,is_week in number,successCnt out varchar2) is
successCnt_ number;
begin
       if(is_week = 0) then
                    update tf_imei_separate_month t set ECCUST_ID = ('10086') where t.data_time between to_date(start_time,'yyyy-MM-dd hh24:mi:ss') and to_date(end_time,'yyyy-MM-dd hh24:mi:ss');
       end if;
       if(is_week = 1) then
                   update tf_imei_separate_week t set ECCUST_ID = ('10086') where t.data_time between to_date(start_time,'yyyy-MM-dd hh24:mi:ss') and to_date(end_time,'yyyy-MM-dd hh24:mi:ss');
       end if;

       successCnt_ := sql%rowcount;
       successCnt := successCnt_;
       commit;
       dbms_output.put_line(successCnt);
end;