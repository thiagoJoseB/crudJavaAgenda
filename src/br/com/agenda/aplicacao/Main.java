package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

  ////import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/// 07   /// INSERT
		
		/// instancio o ojeto contato Com a classe Contato
		Contato contato = new Contato();
		
		contato.setNome("messi");
		
		contato.setIdade(30);
		
		contato.setDataCadastro(new Date());
		
		/// instancio o ojeto contatoDao Com a classe ContatoDAO
		ContatoDAO  contatoDao = new ContatoDAO();
		
		/// save é a funcao do arquivo ContatoDAO 
		
		contatoDao.save(contato);     ///  grifa esse comando pra atuzalizar
		
		
		
		
		/// 12 atualizar ocontato 
		Contato c1 = new Contato();
		c1.setNome("messi lionel");
		c1.setIdade(31);
		c1.setDataCadastro(new Date());
		c1.setId(1); /// é o id numero  que esta no banco de dados na pk
		
		contatoDao.update(c1);      ///  grifa esse comando pra delete
		
		
		
		
		///14 DELETE O contato pelo seu numero de id
		
		contatoDao.deleteByID(1);
		
		
		///10 vizualizacao dos registros do banco de dados
		
		for(Contato c : contatoDao.getContatos()) {
			/// apresentar os dados
			System.out.println("contato: " +c.getNome());
		}
		
		

	}

}
