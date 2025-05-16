package com.server.api.feign.client.config;

import com.server.api.feign.client.dto.FilterListDto;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class UserQueryParamsEncoder implements Encoder {

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (object instanceof FilterListDto) {
            FilterListDto params = (FilterListDto) object;
            Map<String, Object> queryParams = new HashMap<>();
            if(params.getLimit() != null && params.getLimit() > 0)
                queryParams.put("limit", params.getLimit());
            if(params.getSort() != null)
                queryParams.put("sort", params.getSort().name());

            queryParams.forEach((key, value) -> {
                if (value != null) {
                    template.query(key, value.toString());
                }
            });
        } else  if (object instanceof Map) {
            Map<String, Object> params = (Map<String, Object>) object;
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    template.query(entry.getKey(), entry.getValue().toString());
                }
            }
        } else {
            throw new EncodeException("Unsupported type: " + object.getClass().getName());
        }
    }
}