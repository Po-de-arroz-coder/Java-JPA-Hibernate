package com.miguel.tests;

import com.miguel.DAO.MercadoDAO;
import com.miguel.DAO.ProdutoDAO;
import com.miguel.model.bean.Mercado;
import com.miguel.model.bean.Produto;

public class Mercadotest {


	public static void main(String[] args) {

		Mercado mercado = new Mercado();
		MercadoDAO mercadoDAO = new MercadoDAO();
/*
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		mercado.setQtdFuncionarios(90);
		mercado.setNome("Mercado Panamericano");
		mercadoDAO.save(mercado);
	
		produto.setId(3);
		produto.setDescricao("Laranja");
		produto.setMercado(mercado);
		

		produtoDAO.save(produto);
		
		mercado = mercadoDAO.findById(2);
		
		System.out.println(mercado.getNome());
*/
		
		
		for(Mercado merc : mercadoDAO.findAll()) {
			System.out.println("Id: "+merc.getId());
			System.out.println("Nome: "+merc.getNome());
			System.out.println("Quantidade de Funcionarios: "+merc.getQtdFuncionarios());
			System.out.println("");
			
		}
	}

}
