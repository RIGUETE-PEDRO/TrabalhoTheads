import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
	private Connector C1;
	
	public Persistencia(){
		this.C1 = new Connector();
	}
	
	public void Conecta(
			String Servidor,
			String Porta,
			String Database,
			String Usuario,
			String Senha){

		this.C1.Conecta(Servidor, Porta,
				Database, Usuario, Senha);
	}
	
	public List<Cargo> listCargos(){
		List<Cargo> cargos = new ArrayList<>();
		String sql = "SELECT * FROM Cargo ";
		ResultSet resultado = C1.ExecutaConsulta(sql);
		
		try {
			while(resultado.next()) {
				Cargo cargo = new Cargo();
				cargo.setIdCargo(resultado.getInt("idCargo"));
				cargo.setDescricao(resultado.getString("Descricao"));
				
				cargos.add(cargo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return cargos;
	};
	
	
	

	public String BuscarAtividadesAtribuidas(String cargo) {
		String atividadesAtribuida = null ; 
		atividadesAtribuida = "Atividades Atribuida= ";
		String sql = "SELECT COUNT(*) AS total FROM Cargo c " +
	             "JOIN Funcionario f ON c.idCargo = f.idCargo " +
	             "JOIN Atividade a ON f.idFuncionario = a.idExecutor " +
	             "WHERE c.Descricao = '" + cargo + "'";
		ResultSet resultado = C1.ExecutaConsulta(sql); 
		
		try {

		    if (resultado.next()) {

		        int total = resultado.getInt("total");

		        atividadesAtribuida += total;
		       

		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		return atividadesAtribuida;
	}

	public List<Funcionario> listFuncionario() {
		List<Funcionario> listfuncionario = new ArrayList<>();
		String sql = "SELECT * FROM Funcionario;";
		ResultSet resultado = C1.ExecutaConsulta(sql);
		
		try {
			while(resultado.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(resultado.getInt("idFuncionario"));
				funcionario.setNome(resultado.getString("Nome"));
				funcionario.setCpf(resultado.getString("CPF"));
				funcionario.setEmail(resultado.getString("Email"));
				funcionario.setIdCargo(resultado.getInt("idCargo"));
				listfuncionario.add(funcionario);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return listfuncionario;
		
	
	}

	public Tarefas buscarAtividadeFunc(int idExecutor) {
		Tarefas tarefas = new Tarefas();
		String quantidadeAtribuidas = "SELECT COUNT(*) as total FROM Atividade where idExecutor = "+idExecutor+" ;";
		String quantidadePendente = "SELECT COUNT(*) as total FROM Atividade where idExecutor = "+idExecutor+" and DataExecucao IS NULL  ;";
		
		ResultSet Atribuida = C1.ExecutaConsulta(quantidadeAtribuidas);
		ResultSet Pendente = C1.ExecutaConsulta(quantidadePendente);

		try {
			if (Atribuida.next()) {
	            tarefas.setAtribuidas(
	            		Atribuida.getString("total"));
	        }

	        if (Pendente.next()) {
	            tarefas.setPendente(
	                    Pendente.getString("total"));
	        }
				
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		return tarefas;
	}
	
	
	
	
}
