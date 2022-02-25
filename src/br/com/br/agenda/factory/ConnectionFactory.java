package br.com.br.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	/// 03 nome do usuario do mysql    /// nome do banco 
	private static final String USERNAME = "root"; 

	/// senha do banco 
	private static final String PASSWORD = "bcd127";
	
	
	///caminho do banco de dados  , porta nome do banco de dados 
	private static final String DATABASE_URL = "jdbc:mysql:/localhost:3306/agenda";
	
	
	
	///04 conexao com o banco de dados /// importa a classe Connection 
	
	public static Connection createConnectionToMySQL() throws Exception {
		///faz com que a classe seja carregada com a JVM
		Class.forName("com.mysql.Driver");
		
		 /// cria a conexao com o banco de dados  //// (DATABASE_URL, USERNAME, PASSWORD)
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	///05 fecha se tiver uma conexao ativa
	
	public static void main(String[] args) throws Exception {
		
		/// recuperar uma conexao com o banco de dados 
		Connection con = createConnectionToMySQL();
		
		/// testar se a conexao é nula 
		if(con!=null) {
			System.out.println("Conexao obetida com sucesso");
			con.close();
		}
		
	}
	
}
