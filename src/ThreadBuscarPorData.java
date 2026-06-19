import java.awt.EventQueue;

import javax.swing.JLabel;

public class ThreadBuscarPorData extends Thread {

	
	private Persistencia P1;
	private JLabel ativCriadas;
	private JLabel ativNaoFinalizada;
	private JLabel MaisTarefas;
	private JLabel nomeMaisTrabalhoso;
	private String dataInicial;
	private String dataFinal;
	
	public ThreadBuscarPorData (Persistencia P1,JLabel ativCriadas,JLabel ativNaoFinalizada,JLabel MaisTarefas,String dataInicial,String dataFinal ) {
		this.P1 = P1;
		this.ativCriadas = ativCriadas;
		this.ativNaoFinalizada = ativNaoFinalizada;
		this.MaisTarefas = MaisTarefas;
		this.dataInicial= dataInicial;
		this.dataFinal= dataFinal;
	}
	
	@Override
	public void run() {
		intervalorData data = P1.BuscarPorData(dataFinal,dataInicial);
		
		 EventQueue.invokeLater(() -> {
			ativCriadas.setText(data.getTarefa().getAtribuidas());
			ativNaoFinalizada.setText(data.getTarefa().getPendente());
			MaisTarefas.setText("foram feita "+data.getQuantasAtividadeFunc()+"pelo(a) "+ data.getFuncionario().getNome() );
		 });
	}
}
