import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ThreadBuscarAtividades extends Thread{
	private Persistencia P1;
	private JLabel label;
	private String filtro;
	
	public ThreadBuscarAtividades(Persistencia P1,JLabel label,String filtro) {
		this.P1 = P1;
		this.label = label;
		this.filtro = filtro;
	}
	
	@Override
	public void run() {
		String Quantidade = P1.BuscarAtividadesAtribuidas(filtro);
		
		EventQueue.invokeLater(() -> {
            label.setText(Quantidade);
        });
		
	}
}
