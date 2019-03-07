package com.yatop.lambda.workflow.core.framework.chartype.clazz.tune;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TuneLong extends TuneGeneric {

    public static class TuneRange {
        Long start;
        Long end;

        public Long getStart() {
            return start;
        }

        public void setStart(Long start) {
            this.start = start;
        }

        public Long getEnd() {
            return end;
        }

        public void setEnd(Long end) {
            this.end = end;
        }
    }

    public static class TuneParameter {
        private Long value;
        private TuneRange tuneRange = new TuneRange();
        private List<Long> tuneUdps = new ArrayList<Long>();

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public TuneRange getTuneRange() {
            return tuneRange;
        }

        public void setTuneRange(TuneRange tuneRange) {
            this.tuneRange = tuneRange;
        }

        public List<Long> getTuneUdps() {
            return tuneUdps;
        }

        public void setTuneUdps(List<Long> tuneUdps) {
            this.tuneUdps = tuneUdps;
        }
    }

    @Override
    public void createCharValue(CharValueContext context) {
        CharValue charValue = context.getCharValue();
        charValue.setCharValue(charValue.getTextValue());

        if(DataUtil.isEmpty(charValue.getTextValue())) {
            charValue.setCharValue(DataUtil.toJSONString(new TuneParameter()));
        }
    }

    @Override
    public boolean validateCharValue(CharValue charValue) {
        CmptChar cmptChar = charValue.getCmptChar();
        String textValue = charValue.getTextValue();

        TuneParameter tuneParameter = JSONObject.parseObject(textValue, TuneParameter.class);
        if(DataUtil.isNull(tuneParameter) || DataUtil.isNull(tuneParameter.tuneRange) || DataUtil.isNull(tuneParameter.tuneUdps))
            //TODO throw exception ???
            return false;

        if(cmptChar.isRequired()) {
            if(DataUtil.isNull(tuneParameter.value)
                    || DataUtil.isNull(tuneParameter.tuneRange.start)
                    || DataUtil.isNull(tuneParameter.tuneRange.end)
                    || DataUtil.isEmpty(tuneParameter.tuneUdps))
                return false;
        }

        /*try {
            Long value = tuneParameter.value;
            Long start = tuneParameter.tuneRange.start;
            Long end = tuneParameter.tuneRange.end;
            for (Long tune_udp : tuneParameter.tuneUdps) {
                Long udp = tune_udp;
            }
        } catch (Throwable e) {
            return false;
        }*/

        return true;
    }

    @Override
    public Object toJsonValue(CharValue charValue) {
        String textValue = charValue.getTextValue();

        if(DataUtil.isEmpty(textValue)) {
            return null;
        }

        TuneParameter tuneParameter = JSONObject.parseObject(textValue, TuneParameter.class);
        return JSONObject.toJSON(tuneParameter);
    }

    @Override
    public void parseJsonValue(CharValue charValue, Object obj) {

        /*if(obj == null) {
            charValue.setCharValue(null);
            charValue.setTextValue(null);
        }
        if(obj instanceof String && DataUtil.isNumber((String)obj)) {
            String value = (String)obj;
            charValue.setCharValue(value);
            charValue.setTextValue(value);
        }*/
    }
}
