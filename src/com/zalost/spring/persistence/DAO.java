package com.zalost.spring.persistence;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zalost.spring.mvc.IHasIntID;

public interface DAO {
	public void InsertAutoID(Object o);
	public <T extends IHasIntID> T selectGenericByAutoID(Class<T> t, int ID);	
	public <T> List<T> selectGenericFrom(Class<T> t, String criteria);
	public <T extends IHasIntID> void updateGenericByID(
			Class<T> t, int ID, String propertyName, Object value);
	public SessionFactory buildSessionFactory();
	public SessionFactory getSessionFactory();
	public void closeFactory();
	public void executeHQLQuery(String query);
}
