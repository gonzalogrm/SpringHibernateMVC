package com.ggm.spring.persistence;
import com.ggm.util.*;

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
    	UtilityMethods.invokeSetter(result, propertyName, value);  
	}	
}
