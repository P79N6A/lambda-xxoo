package com.yatop.lambda.portal.common.domain;

import java.util.HashMap;

public class PortalResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public PortalResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public PortalResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public PortalResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
