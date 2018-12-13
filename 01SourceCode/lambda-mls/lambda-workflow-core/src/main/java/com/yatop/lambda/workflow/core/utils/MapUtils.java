package com.yatop.lambda.workflow.core.utils;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.model.IRichModel;

import java.util.Map;

public class MapUtils<M extends Map<K, V>, K, V extends IRichModel> {
/*

    public V get(M map, K key) {
        return map.get(key);
    }
*/

    public void put(M map, K key, V value) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key) || DataUtil.isNull(value))
            return;

        map.put(key, value);
    }

    public void clear(M map) {
        if(DataUtil.isNull(map))
            return;

        for(Map.Entry<K, V> entry : map.entrySet())
        {
            entry.getValue().clear();
        }

        map.clear();
    }
}
