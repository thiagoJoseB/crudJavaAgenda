package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.model.Contato;
import br.com.br.agenda.factory.ConnectionFactory;

/// 06 CRUD 
public class ContatoDAO {
	
	///CRUD
	//// INSERT                 /// import  Contato
	public void save(Contato contato) {
		/// insert 
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";
		
		//// conexao com o banco 
		Connection conn = null;
		
		///executar  /// com mysql
		PreparedStatement pstm = null;
		
		/// tentar se conectar com o banco 
		try {
			/// criar uma conexao com o banco de dados   /// classe e metodo que faz conexao com o banco de dados 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			///executar classe sql
			/// criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			/// passar os parametros  //// posicao , nome class e valor
			/// adicionar os valores que sao esperados pela query  
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			///Executar a query  /// boolean deu certo ou errado 
			pstm.execute();
			
			/// 08 veio pra mostrar uma mensagem de salvo com sucesso la do arquivo main
			System.out.println("Contato salvo com sucesso!");
			
			/// prepara o try pra se tiver uma execesao 
		}catch(Exception e) {
			e.printStackTrace();  /// printar a exeception a exececao  //// printar o erro 
			
			/// se deu certo finaliza 
		}finally {
			
			/// fechar as conexoes caso esteja aberto 
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				/// fechar a conexao   /// ver se a conexao esta ativa 
				if(conn!=null) {
					conn.close();
				}
			
				
				/// se tiver algum erro /// lancar uma exececao 
			}catch(Exception e) {
				e.printStackTrace();
				
		}
		
		
			
	}
		
	}
	
	
	
	//// 11 UPTADE
	
	public void update (Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? "+
	  "WHERE id = ?";
		
		Connection  conn = null;
		PreparedStatement pstm = null;
		
		try {
			/// criar conexao com o banco de dados 
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			////criar a classe para executar a query 
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			///adicionar os valores para atualizar 
			pstm.setString(1, contato.getNome());
			
			pstm.setInt(2, contato.getIdade());
			
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//QUAL é o  id do registro que deseja atualizar ?
			pstm.setInt(4, contato.getId());
			
			
			/// executar a query 
			pstm.execute();
			
			
		    	
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

	
	// 13 DELETE 
	          //// trazer pelo id
	public void deleteByID(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		
 		java.sql.PreparedStatement pstm = null;
 		
 		
 		try {
 			conn = ConnectionFactory.createConnectionToMySQL();
 			
 			pstm = (PreparedStatement) conn.prepareStatement(sql);
 			
 			        
 			pstm.setInt(1, id);
 			
 			pstm.execute();
 			
 		}catch (Exception e) {
 			e.printStackTrace();
 			
		}finally {
			
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
 		
 		
	} 
	
	////09 SELECT 
	/// o conteudo vai ser em forma de list
	public List<Contato> getContatos(){
	   
		/// variavel que tem oescript do banco 
		String sql = "SELECT * FROM contatos";
		
		//// instanciando 
		List<Contato> contatos = new ArrayList<Contato>();
		
		/// conexao com o banco 
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		/// fonte de dados /// recebe do banco 
		/// classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		
		try {
			/// tentar fazer conexao com o banco 
			conn =  ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)  conn.prepareStatement(sql);
			
			/// receber o que retornou do banco  /// executar
			rset = pstm.executeQuery();
			
			/// percorrre o array , enquanto tiver dado continua a percorrer 
			while (rset.next()) {
				Contato contato = new  Contato();
				
	/// recuperar id  /// contato onde tem os dados  /// o setId é id  /// rset é o que tem os registros e getInt tipo é a coluna 
				contato.setId(rset.getInt("id"));
				
				/// recuperar o nome
				contato.setNome(rset.getString("nome"));
				
				/// recupera  idade
				contato.setIdade(rset.getInt("idade"));
				
				// recupera a data
				contato.setDataCadastro(rset.getDate("datacadastro"));
				
				/// pegar as informacoes desmenbrada e lancar no list
				contatos.add(contato);
			
			
			
		   }
	    }catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				  }
				
				 if(pstm!=null) {
					 rset.close();
				 }
				 
				 if(conn!=null) {
					 conn.close();
				 }
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			 
			 
			} /// fim finaly
		
		    return contatos;
		    
		
		
		
	} /// fim list
	
}
