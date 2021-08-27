package com.miguel.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.miguel.ConnectionFactory.ConnectionFactory;
import com.miguel.model.bean.Produto;

public class ProdutoDAO {
	
	public Produto save(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			
			if(produto.getId() == null) {
				//Create
				em.persist(produto);
			}else {
				//Update
				em.merge(produto);
			}
			em.getTransaction().begin();
			
			em.getTransaction().commit();
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		
		
		return produto;
	}
	
	public Produto findById(int id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;
		
		try {
			produto = em.find(Produto.class,id);
		}catch(Exception e ) {
			System.err.println(e);
		}finally{
			em.close();
		}
		
		return produto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Produto> produtos = null;
		
		try {
			produtos = em.createQuery("from Produto p").getResultList();
		}catch(Exception e ) {
			System.err.println(e);
		}finally{
			em.close();
		}
		
		return produtos;
	}
	
	public Produto remove(int id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;
		
		
		
		try {
			
			produto = em.find(Produto.class,id);
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
			
		}catch(Exception e ) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		
		return produto;
	}
	
	
}
