import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private Connection Con;
	private String Servidor;
	private String Porta;
	private String Database;
	private String Usuario;
	private String Senha;
	
	public Connector(){
		// Instanciar driver do banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Con = null;
	}
	
	public Connection Conecta(
			String Servidor,
			String Porta,
			String Database,
			String Usuario,
			String Senha){

		this.Servidor = Servidor;
		this.Porta = Porta;
		this.Database = Database;
		this.Usuario = Usuario;
		this.Senha = Senha;
		
		String URL = "jdbc:mysql://" + this.Servidor +
					 ":" + this.Porta + "/" +
					 this.Database;
		try {
			this.Con = DriverManager.getConnection(URL,
					this.Usuario, this.Senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.Con;
	}
	
	public void Executa(String SQL){
		try {
			
			Statement Comando = this.Con.createStatement();
			Comando.execute(SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet ExecutaConsulta(String SQL){
		ResultSet Resultado = null;
		try {
			Statement Comando = this.Con.createStatement();
			Resultado = Comando.executeQuery(SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Resultado;
	}
	
}
