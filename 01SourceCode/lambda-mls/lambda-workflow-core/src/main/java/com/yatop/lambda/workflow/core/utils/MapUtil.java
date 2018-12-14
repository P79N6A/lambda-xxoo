package com.yatop.lambda.workflow.core.utils;

import com.google.common.collect.SetMultimap;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {

    public static <M extends Map<K, V>, K, V> V get(M map, K key) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key))
            return null;

        return map.get(key);
    }

    public static <M extends Map<K, V>, K, V> void put(M map, K key, V value) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key) || DataUtil.isNull(value))
            return;

        map.put(key, value);
    }

    public static <M extends Map<K, V>, K, V> List<V> toList(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        List<V> vlist = new ArrayList<V>(map.size());
        for(Map.Entry<K, V> entry : map.entrySet()) {
            vlist.add(entry.getValue());
        }

        return vlist;
    }

    public static <M extends Map<K, V>, K, V extends IRichModel> void clear(M map) {
        if(DataUtil.isNull(map))
            return;

        for(Map.Entry<K, V> entry : map.entrySet())
        {
            entry.getValue().clear();
        }

        map.clear();
    }

    public static <M extends SetMultimap<K, V>, K, V> List<V> toList(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        List<V> vlist = new ArrayList<V>(map.size());
        for(Map.Entry<K, V> entry : map.entries()) {
            vlist.add(entry.getValue());
        }

        return vlist;
    }
}
