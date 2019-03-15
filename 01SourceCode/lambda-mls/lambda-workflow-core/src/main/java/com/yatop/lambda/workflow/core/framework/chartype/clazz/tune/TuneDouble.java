package com.yatop.lambda.workflow.core.framework.chartype.clazz.tune;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

import java.util.ArrayList;
import java.util.List;

public class TuneDouble extends TuneGeneric {

    public static class TuneRange {
        String start;
        String end;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }
    }

    public static class TuneParameter {
        private String value;
        private TuneRange tuneRange = new TuneRange();
        private List<String> tuneUdps = new ArrayList<String>();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public TuneRange getTuneRange() {
            return tuneRange;
        }

        public void setTuneRange(TuneRange tuneRange) {
            this.tuneRange = tuneRange;
        }

        public List<String> getTuneUdps() {
            return tuneUdps;
        }

        public void setTuneUdps(List<String> tuneUdps) {
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

        if(DataUtil.isEmpty(textValue)) {
            return true;
        }

        TuneParameter tuneParameter = JSONObject.parseObject(textValue, TuneParameter.class);
        if(DataUtil.isNull(tuneParameter) || DataUtil.isNull(tuneParameter.tuneRange) || DataUtil.isNull(tuneParameter.tuneUdps))
            //TODO throw exception ???
            return false;

        if(cmptChar.isRequired()) {
            if(DataUtil.isEmpty(tuneParameter.value)
                || DataUtil.isEmpty(tuneParameter.tuneRange.start)
                || DataUtil.isEmpty(tuneParameter.tuneRange.end)
                || DataUtil.isEmpty(tuneParameter.tuneUdps))
             return false;
        }

        try {
            Double value = DataUtil.toDouble(tuneParameter.value);
            Double start = DataUtil.toDouble(tuneParameter.tuneRange.start);
            Double end = DataUtil.toDouble(tuneParameter.tuneRange.end);
            for (String tune_udp : tuneParameter.tuneUdps) {
                Double udp = DataUtil.toDouble(tune_udp);
            }
        } catch (Throwable e) {
            return false;
        }

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
