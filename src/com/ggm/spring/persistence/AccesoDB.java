package com.ggm.spring.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ggm.spring.entity.*;

@Repository
public class AccesoDB implements DAO {	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	//Example criteria: "from User e where e.age > 20"
	//Usar el nombre de la clase, no de la tabla de la DB
	public <T> List<T> selectGenericFromCriteria(Class<T> t, String criteria) {
		Session session = sessionFactory.getCurrentSession();		
		Query<T> query = (Query<T>)(session.createQuery(criteria,t));
    	return query.getResultList();
	}
	
	@Transactional
	public <T> T selectFirstGenericFromCriteria(Class<T> t, String criteria) {
		Session session = sessionFactory.getCurrentSession();		
		Query<T> query = (Query<T>)(session.createQuery(criteria,t));
    	return query.getResultList().get(0);
	}
	
	@Transactional
	public void Insert(Object o) {
		Session session = sessionFactory.getCurrentSession();
		session.save(o);
	}
	
	@Transactional
	public <T extends IHasIntID> T selectGenericByID(Class<T> t, int ID) {
		Session session = sessionFactory.getCurrentSession();
    	return t.cast(session.get(t, ID));
	}
	
	@Transactional
	public void executeVoidHQLQuery(String query) {
		Session session = sessionFactory.getCurrentSession();
        session.createQuery(query).executeUpdate();
	}

	@Transactional
	public <T extends IHasIntID> void updateGenericByID(
		Class<T> t, int ID, String propertyName, Object value){
		Session session = sessionFactory.getCurrentSession();		
    	T result = t.cast(session.get(t, ID));        	
    	//Cambiamos el valor de la variable usando Reflection
    	invokeSetter(result, propertyName, value);  
	}	


	//https://java2blog.com/invoke-getters-setters-using-reflection-java/
	private void invokeSetter(Object obj, String propertyName, Object variableValue)
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
	
	private void invokeGetter(Object obj, String variableName)
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
