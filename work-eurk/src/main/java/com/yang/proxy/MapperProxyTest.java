package com.yang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxyTest implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            }

        } catch (Throwable var5) {

        }

        return null;
    }
}
