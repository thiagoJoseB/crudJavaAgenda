package br.com.agenda.model;

import java.util.Date;

public class Contato {
 
///01	
  private int id;
  private String nome;
  private int idade;
  private Date dataCadastro;
  
  
  ///02
  /// metodos do id
  public void setId(int id) {
	  this.id = id;
  }
  
  public int getId(){
	  return id;
	  
  }
  
  
  /// metodos do nome 
  
  public void setNome(String nome) {
	  this.nome = nome;
  }
  
  
  public String getNome() {
	  return nome;
  }
  
  
  
  /// metodos da idade
  
  public void setIdade(int idade) {
	  this.idade = idade;
	 
	  
  }
  
  
  public int getIdade() {
	  return idade;
  }
  
  
/// metodos da data
  
  public void setDataCadastro(Date dataCadastro) {
	  this.dataCadastro = dataCadastro;
	  
  }
  
  public Date getDataCadastro() {
	  return dataCadastro;
  }
  
  
  

}
