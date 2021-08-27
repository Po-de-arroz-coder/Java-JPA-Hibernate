package com.miguel.tests;

import com.miguel.DAO.ProdutoDAO;
import com.miguel.model.bean.Produto;
public class Produtotest {        

	public static void main(String[] args) {
		/*
		 * Produto p = new Produto(); ProdutoDAO dao = new ProdutoDAO(); p.setId(1);
		 * p.setDescricao("Melão"); p = dao.save(p);
		 */
		ProdutoDAO dao = new ProdutoDAO();
		//dao.remove(4);
		for(Produto p : dao.findAll()) {
			System.out.println("Id: "+p.getId()+"\n Descricao: "+p.getDescricao());
		}
		
		
	}

}
