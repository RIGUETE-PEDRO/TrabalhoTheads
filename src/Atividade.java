import java.time.LocalDateTime;

public class Atividade {
	private int idAtividade;
	private String titulo;
	private String codigo;
	private String descricao;
	private int idCoodenador;
	private int idExecutor;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataExecucao;
	
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdCoodenador() {
		return idCoodenador;
	}
	public void setIdCoodenador(int idCoodenador) {
		this.idCoodenador = idCoodenador;
	}
	public int getIdExecutor() {
		return idExecutor;
	}
	public void setIdExecutor(int idExecutor) {
		this.idExecutor = idExecutor;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDateTime getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(LocalDateTime dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	
}
