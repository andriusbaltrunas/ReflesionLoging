package com.dummy.source.Utils;

import com.dummy.source.annotations.Trace;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by andriusbaltrunas on 6/7/2017.
 */
public class ReflexionLoginUtil {

    /**
     * Print stack trace to log and invoke needed method
     * @param ob - Class object
     * @param methodName method which want to call name
     * @param params method parameters which want to call
     * @param <T>
     * @return result of response
     * @throws NoSuchMethodException
     */
    @Nullable
    public static <T> Object log(Object ob, String methodName, T... params) {
        Class clazz = ob.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Object response = null;
        for (Method method : methods) {
            if (method.getName().contains(methodName) && method.isAnnotationPresent(Trace.class)) {
                try {
                    response = method.invoke(ob, params);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("******************* This is stack trace ****************************\n")
                        .append("Method ").append(method.getName()).append(" called");
                addParametersToStringBuilder(sb, params);
                if(response != null){
                    sb.append("response val ->" + response);
                }
                sb.append("\n******************* End of stack trace *****************************\n");
                System.out.println(sb.toString());
            }
        }

        return response;
    }

    private static <T> void addParametersToStringBuilder(StringBuilder sb, T... params){
        if(params.length > 0) {
            sb.append(" With parameters");
            for (T t: params) {
                sb.append(" ").append(t).append(" ");
            }
        }
    }

}
