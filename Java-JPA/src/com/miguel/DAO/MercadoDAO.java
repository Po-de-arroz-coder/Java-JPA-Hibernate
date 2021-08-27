package com.miguel.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.miguel.ConnectionFactory.ConnectionFactory;
import com.miguel.model.bean.Mercado;
import com.miguel.model.bean.Mercado;

public class MercadoDAO {
	
	public Mercado save(Mercado mercado) {
		EntityManager em = new ConnectionFactory().getConnection();
		try{
			em.getTransaction().begin();
			if(mercado.getId() == null) {em.persist(mercado);}
			else {em.merge(mercado);}
			
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
			
		}
		return mercado;
	}
	
	public Mercado findById(int id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Mercado mercado = null;
		
		try {
			mercado = em.find(Mercado.class,id);
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return mercado;
	}
	
	public List<Mercado> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Mercado> list = null;
		
		try {
			list = em.createQuery("from Mercado m ").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return list;
	}
}
