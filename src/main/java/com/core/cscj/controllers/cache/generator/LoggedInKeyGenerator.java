package com.core.cscj.controllers.cache.generator;

import com.core.cscj.authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class LoggedInKeyGenerator implements KeyGenerator {
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        String key = "";
        for(Object item: objects)
            if(item.getClass().equals(String.class))
                key += jwtUtil.getDocumentFromJwtToken((String) item);
            else key += ":actividad#" + ((Integer) item).toString();
        return key;
    }
}
