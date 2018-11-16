
select (case rank4cmpt when 0 then t.cmpt_name else '-' end) 组件名称,
			 (case rank4spec when 0 then t.spec_type else '-' end) 规格类型,
				t.char_code 特征代码,
				concat(t.char_type_code, '(', t.char_type_name, ')') 特征类型
from 
(
select IF(@last4cmpt = t1.cmpt_id, @rank4cmpt:= @rank4cmpt + 1, @rank4cmpt := 0) rank4cmpt,
			 @last4cmpt := t1.cmpt_id cmpt_id,
			 t1.cmpt_name,
			 IF(@last4spec = t3.spec_id, @rank4spec:= @rank4spec + 1, @rank4spec := 0) rank4spec,
			 @last4spec := t3.spec_id spec_id,
			 (case t3.spec_type when 0 then '输入内容' when 1 then '输出内容' when 2 then '调用执行' when 3 then '执行调优' else '组件参数' end) spec_type,
			 t5.char_code,
			 t5.char_name,
			 t6.char_type_code,
			 t6.char_type_name
	from pcf_cmpt_def t1,
			 pcf_cmpt_spec_use t2,
			 pcf_cmpt_spec_def t3,
			 pcf_cmpt_spec_char_use t4,
			 pcf_cmpt_spec_char_def t5,
			 pcf_cmpt_spec_char_type_def t6,
			 (SELECT @last4cmpt:= -1) v1,
			 (SELECT @rank4cmpt:= 0) v2,
			 (SELECT @last4spec:= -1) v3,
			 (SELECT @rank4spec:= 0) v4
 where t1.status = 0
	 and t1.cmpt_id = t2.cmpt_id
	 and t2.spec_id = t3.spec_id
	 and t3.spec_id = t4.spec_id
	 and t4.char_id = t5.char_id
	 and t5.char_type_id = t6.char_type_id
 order by t1.cmpt_id, t3.spec_id
) t