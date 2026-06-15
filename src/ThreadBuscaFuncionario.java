import java.awt.EventQueue;
import java.util.List;

import javax.swing.JComboBox;

public class ThreadBuscaFuncionario extends Thread {

	private Persistencia P1;
	private JComboBox<Funcionario> combo;
	
	public ThreadBuscaFuncionario(Persistencia P1,JComboBox<Funcionario> combo) {

		this.P1 = P1;
		this.combo = combo;
		
	}
	 
	 @Override
	    public void run() {

	        List<Funcionario> Funcionarios = P1.listFuncionario();

	        EventQueue.invokeLater(() -> {

	            combo.removeAllItems();

	            for (Funcionario f : Funcionarios) {
	                combo.addItem(f);
	            }

	            combo.setSelectedIndex(-1);
	        });
	    }
	
}
