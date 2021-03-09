package com.zalost.spring.persistence;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zalost.spring.mvc.IHasIntID;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AccesoDB implements DAO {	
	
	private SessionFactory sessionFactory;
	 
	public SessionFactory buildSessionFactory() 
	{
		try
		{
			if (sessionFactory == null) 
			{
				sessionFactory = 
        			new Configuration().configure().buildSessionFactory();
			}
			return sessionFactory;
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
   	}
	 
	public void closeFactory() {
		getSessionFactory().close();	
	}	   

	public void InsertAutoID(Object o) {
		Session session = getSessionFactory().openSession();
    	//Comenzamos Transacción
    	Transaction transaction =session.beginTransaction();		    	
    	try {
        	//Save
    		session.save(o);
        	//Commit
        	transaction.commit();
    	}
    	catch (HibernateException hibernateEx) {
            try {
            	transaction.rollback();
            } catch(RuntimeException runtimeEx){
                System.err.printf("Error en RollBack Transaction", runtimeEx);
            }
            hibernateEx.printStackTrace();
        }
    	finally {
    		session.close();
    	}    	
	}
	
	public <T extends IHasIntID> T selectGenericByAutoID(Class<T> t, int ID) {
		T result =  null;

    	Session session = getSessionFactory().openSession();
    	//Comenzamos Transacción
    	Transaction transaction =session.beginTransaction();		    	
    	try {
        	result =t.cast(session.get(t, ID));
        	//Commit
        	transaction.commit();
    	}
    	catch (HibernateException hibernateEx) {
            try {
            	transaction.rollback();
            } catch(RuntimeException runtimeEx){
                System.err.printf("Error en RollBack Transaction", runtimeEx);
            }
            hibernateEx.printStackTrace();
        }
    	finally {
    		session.close();
    	}    	

    	return result;
	}
	
	//Example criteria: "from Empleado e where e.IdEmpleado > 20"
	public <T> List<T> selectGenericFrom(Class<T> t, String criteria) {
		List<T> result = new ArrayList<T>();
    	
		Session session = getSessionFactory().openSession();
		//Comenzamos Transacción
    	Transaction transaction =session.beginTransaction();	
		try {			    	
	    	//Read
	    	result = (ArrayList<T>)session.createQuery(criteria).getResultList();
	    	//Commit
	    	transaction.commit();
		}
		catch (HibernateException hibernateEx) {
            try {
            	transaction.rollback();
            } catch(RuntimeException runtimeEx){
            	System.err.printf("Error en RollBack Transaction", runtimeEx);
            }
            hibernateEx.printStackTrace();
        }
    	finally {
    		session.close();
    	}    
    	
    	return result;	
	}
	
	
	public <T extends IHasIntID> void updateGenericByID(
		Class<T> t, int ID, String propertyName, Object value){

		Session session = getSessionFactory().openSession();		
    	T result =  null;
    	//Comenzamos Transacción
    	Transaction transaction =session.beginTransaction();    	
    	try {
        	//Obtenemos el objeto desde DB
        	result = t.cast(session.get(t, ID));        	
        	//Cambiamos el valor de la variable usando Reflection
        	invokeSetter(result, propertyName, value);        	
        	//Commit
        	transaction.commit();
    	}
    	catch (HibernateException hibernateEx) {
            try {
            	transaction.rollback();
            } catch(RuntimeException runtimeEx){
            	System.err.printf("Error en RollBack Transaction", runtimeEx);
            }
            hibernateEx.printStackTrace();
        }
    	finally {
    		session.close();
    	}   	
	}	


	public void executeHQLQuery(String query) {
	    	
    	Session session = getSessionFactory().openSession();
    	//Comenzamos Transacción
    	Transaction transaction =session.beginTransaction();
    	try {
        	//Read
        	session.createQuery(query).executeUpdate();
        	//Commit
        	transaction.commit();
    	}
    	catch (HibernateException hibernateEx) {
            try {
            	transaction.rollback();
            } catch(RuntimeException runtimeEx){
            	System.err.printf("Error en RollBack Transaction", runtimeEx);
            }
            hibernateEx.printStackTrace();
        }
    	finally {
    		session.close();
    	}
	}
	
	//Métodos de reflection
	//Información y ejemplos en https://java2blog.com/invoke-getters-setters-using-reflection-java/
	
	//Más información y explicación: 
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
