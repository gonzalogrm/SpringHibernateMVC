package com.zalost.spring.persistence;

public class DAOManager {
	private DAO acceso;
	private static DAOManager instance;

	private DAOManager() {
		acceso = new AccesoDB();
	}

	public static DAOManager getInstance() {
		if(instance == null) instance = new DAOManager();
		return instance;
	}
	
	public DAO getAcceso() {		
		return acceso;
	}

	public void setAcceso(DAO acceso) {
		this.acceso = acceso;
	}
}
