package com.ggm.spring.persistence;

import java.util.List;

import com.ggm.spring.entity.IHasIntID;
import com.ggm.spring.entity.User;

public interface DAO {
	public void Insert(Object o);	
	public <T> T selectFirstGenericFromCriteria(Class<T> t, String criteria);	
	public <T> List<T> selectGenericFromCriteria(Class<T> t, String criteria);
	public <T extends IHasIntID> T selectGenericByID(Class<T> t, int ID);
	public <T extends IHasIntID> void updateGenericByID(
			Class<T> t, int ID, String propertyName, Object value);
	public void executeVoidHQLQuery(String query);
}
