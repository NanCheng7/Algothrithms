package com.nancheng.study.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wangxz
 * @description:
 * @date 2025/3/14
 */
public abstract class TypeToken<T> {
    private final Type type;

    protected TypeToken() {
        Type superClass = getClass().getGenericSuperclass();
        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }
}