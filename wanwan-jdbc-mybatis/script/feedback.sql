select t.provinceid province, count(1) total, 
       (select count(*) from tf_imei_separate_month s where s.feedback is not null and s.provinceid = t.provinceid) feedbackData,
       (select count(*) from tf_imei_separate_month s where s.feedback is null and s.provinceid = t.provinceid) notFeedbackData

from tf_imei_separate_month t group by t.provinceid 