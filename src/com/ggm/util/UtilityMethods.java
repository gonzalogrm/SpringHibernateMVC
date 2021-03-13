package com.ggm.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtilityMethods {
	//https://java2blog.com/invoke-getters-setters-using-reflection-java/
	public static void invokeSetter(Object obj, String propertyName, Object variableValue)
    {
        PropertyDescriptor descriptor;
        try {
        	descriptor = 
        			new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = 
            		descriptor.getWriteMethod();
            try {
                setter.invoke(obj,variableValue);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
 
    }
	
	public static void invokeGetter(Object obj, String variableName)
    {
        try {
            PropertyDescriptor descriptor = 
            		new PropertyDescriptor(variableName, obj.getClass());
            Method getter = 
            		descriptor.getReadMethod();
            Object o = getter.invoke(obj);
            System.out.println(o);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
