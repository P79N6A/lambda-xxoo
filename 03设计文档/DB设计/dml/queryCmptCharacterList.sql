
select (case rank4cmpt when 0 then concat(t.cmpt_id, '【', t.cmpt_name, '】') else '-' end) 组件,
			 (case rank4spec when 0 then t.spec_name else '-' end) 规格,
			  -- (case rank4spec when 0 then concat(t.spec_type, '【', t.spec_name, '】') else '-' end) 规格,
			 t.char_id 特征ID,
			 t.char_code 特征代码,
			 t.char_name 特征名称,
			 -- t.char_type_code 特征类型代码,
			 t.char_type_name 特征类型名称
from 
(
select IF(@last4cmpt = t1.cmpt_id, @rank4cmpt:= @rank4cmpt + 1, @rank4cmpt := 0) rank4cmpt,
			 @last4cmpt := t1.cmpt_id cmpt_id,
			 t1.cmpt_code,
			 t1.cmpt_name,
			 IF(@last4spec = t3.spec_id and @rank4cmpt != 0, @rank4spec:= @rank4spec + 1, @rank4spec := 0) rank4spec,
			 @last4spec := t3.spec_id spec_id,
			 -- (case t3.spec_type when 1 then '输入内容' when 2 then '输出内容' when 3 then '调用执行' when 4 then '执行调优' else '组件参数' end) spec_type,
			 t3.spec_name,
			 t5.char_id,
			 t5.char_code,
			 t5.char_name,
			 t6.char_type_code,
			 t6.char_type_name
	from cf_component t1,
			 cf_cmpt_spec_rel t2,
			 cf_specification t3,
			 cf_spec_char_rel t4,
			 cf_characteristic t5,
			 cf_char_type t6,
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
) t;





select C.spec_id, C.char_id, concat(B.SPEC_NAME, '，', SUBSTRING_INDEX(A.CHAR_NAME, ' | ', -1)) tmpd, 0, SYSDATE() s1 , 'admin' d1, SYSDATE() s2, 'admin' d2 
from cf_characteristic A, cf_specification B, cf_spec_char_rel_copy C 
where C.char_id = A.char_id and C.spec_id = B.SPEC_ID



insert into wf_cfg_module_prop_ctrl 
select mdl.module_id * 10000 + 2 * 100 + tt.rank4spec + 1 as control_id,
	IF(tt.char_type_id = 104 or tt.char_type_id = 106, concat(tt.char_code, ".value"), tt.char_code) as control_code,
	tt.display_name as control_label,
	tt.char_type_code as control_type,
	mdl.module_id as owner_module_id,
	2 as tab_id,
	tt.char_code as bind_char_code,
  tt.rank4spec + 1 as sequence,
  concat("请输入", tt.display_name) as place_holder,
	null as tooltip,
	null as long_tooltip,
	0 as is_disabled,
  null as description,
  0 as status,
  SYSDATE() as last_update_time,
	'admin' as last_update_oper,
	SYSDATE() as create_time,
	'admin' as create_oper
 

-- select (case rank4cmpt when 0 then concat(t.cmpt_id, '【', t.cmpt_name, '】') else '-' end) 组件,
-- 			 (case rank4spec when 0 then t.spec_name else '-' end) 规格,
-- 			 rank4spec 规格序号,
			  -- (case rank4spec when 0 then concat(t.spec_type, '【', t.spec_name, '】') else '-' end) 规格,
-- 			 t.char_id 特征ID,
-- 			 t.char_code 特征代码,
-- 			 t.char_name 特征名称,
			 -- t.char_type_code 特征类型代码,
-- 			 t.char_type_name 特征类型名称
from 
(
select IF(@last4cmpt = t1.cmpt_id, @rank4cmpt:= @rank4cmpt + 1, @rank4cmpt := 0) rank4cmpt,
			 @last4cmpt := t1.cmpt_id cmpt_id,
			 t1.cmpt_code,
			 t1.cmpt_name,
			 IF(@last4spec = t3.spec_id and @rank4cmpt != 0, @rank4spec:= @rank4spec + 1, @rank4spec := 0) rank4spec,
			 @last4spec := t3.spec_id spec_id,
			 -- (case t3.spec_type when 1 then '输入内容' when 2 then '输出内容' when 3 then '调用执行' when 4 then '执行调优' else '组件参数' end) spec_type,
			 t3.spec_name,
			 t5.char_id,
			 t5.char_code,
			 t5.char_name,
			 t5.display_name,
			 t6.char_type_id,
			 t6.char_type_code,
			 t6.char_type_name
	from wf_cfg_component t1,
			 wf_cfg_cmpt_spec_rel t2,
			 wf_cfg_specification t3,
			 wf_cfg_spec_char_rel t4,
			 wf_cfg_characteristic t5,
			 wf_cfg_char_type t6,
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
	 and t3.spec_type = 4
	 and t5.char_id not like "com-param.char.ml.tune.$%"
 order by t1.cmpt_id, t3.spec_type, t5.char_id
) tt, wf_cfg_module mdl
where mdl.pkg_cmpt_id = tt.cmpt_id;
