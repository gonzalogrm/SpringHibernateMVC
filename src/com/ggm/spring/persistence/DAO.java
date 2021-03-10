package com.ggm.spring.persistence;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ggm.spring.entity.IHasIntID;
import com.ggm.spring.entity.User;

public interface DAO {
	//public void InsertAutoID(Object o);
	//public <T extends IHasIntID> T selectGenericByAutoID(Class<T> t, int ID);
	public List<User> selectUsers();
	public <T> List<T> selectGenericFromCriteria(Class<T> t, String criteria);
	//public <T extends IHasIntID> void updateGenericByID(
	//		Class<T> t, int ID, String propertyName, Object value);
	//public void executeHQLQuery(String query);
}
