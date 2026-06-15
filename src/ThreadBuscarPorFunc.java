import java.awt.EventQueue;

import javax.swing.JLabel;

public class ThreadBuscarPorFunc extends Thread{

    private Persistencia P1;
	private JLabel pendente;
	private JLabel atribuidas;
	private int filtro;
	
	public ThreadBuscarPorFunc (Persistencia P1,JLabel pendente,JLabel atribuidas,int filtro ) {
		this.P1 = P1;
		this.pendente = pendente;
		this.atribuidas = atribuidas;
		this.filtro = filtro;
	}
	
	@Override
	public void run() {
		Tarefas tarefas = P1.buscarAtividadeFunc(filtro);
		
		EventQueue.invokeLater(() -> {
            atribuidas.setText("Tarefas atribuídas = " + tarefas.getAtribuidas());
            pendente.setText("Tarefas pendentes = " + tarefas.getPendente());
        });
	}
}
