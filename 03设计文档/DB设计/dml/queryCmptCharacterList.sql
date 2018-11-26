
select (case rank4cmpt when 0 then concat(t.cmpt_id, '��', t.cmpt_name, '��') else '-' end) ���,
			 (case rank4spec when 0 then t.spec_name else '-' end) ���,
			  -- (case rank4spec when 0 then concat(t.spec_type, '��', t.spec_name, '��') else '-' end) ���,
			 concat(t.char_code, '��', t.char_name, '��') ����,
			 concat(t.char_type_code, '��', t.char_type_name, '��') ��������
from 
(
select IF(@last4cmpt = t1.cmpt_id, @rank4cmpt:= @rank4cmpt + 1, @rank4cmpt := 0) rank4cmpt,
			 @last4cmpt := t1.cmpt_id cmpt_id,
			 t1.cmpt_code,
			 t1.cmpt_name,
			 IF(@last4spec = t3.spec_id and @rank4cmpt != 0, @rank4spec:= @rank4spec + 1, @rank4spec := 0) rank4spec,
			 @last4spec := t3.spec_id spec_id,
			 -- (case t3.spec_type when 1 then '��������' when 2 then '�������' when 3 then '����ִ��' when 4 then 'ִ�е���' else '�������' end) spec_type,
			 t3.spec_name,
			 t5.char_code,
			 t5.char_name,
			 t6.char_type_code,
			 t6.char_type_name
	from cf_component t1,
			 cf_cmpt_spec_rel t2,
			 cf_cmpt_spec t3,
			 cf_cmpt_spec_char_rel t4,
			 cf_cmpt_char t5,
			 cf_cmpt_char_type t6,
			 (SELECT @last4cmpt:= -1) v1,
			 (SELECT @rank4cmpt:= 0) v2,
			 (SELECT @last4spec:= -1) v3,
			 (SELECT @rank4spec:= 0) v4
 where t1.status = 0
	 and t1.cmpt_id = t2.cmpt_id
	 and t2.spec_id = t3.spec_id
	 and t3.spec_id = t4.spec_id
	 and t4.char_id = t5.char_id
	 and t5.char_type = t6.char_type_id
 order by t1.cmpt_id, t3.spec_type, t5.char_id
) t