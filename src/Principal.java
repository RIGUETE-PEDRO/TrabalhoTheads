import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Persistencia P1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CARGO");
		lblNewLabel.setBounds(12, 27, 60, 28);
		contentPane.add(lblNewLabel);
		
		JComboBox cbxCargos = new JComboBox();
		cbxCargos.setBounds(12, 67, 387, 26);
		contentPane.add(cbxCargos);

		
		
		JLabel lblResultadoCargo = new JLabel("");
		lblResultadoCargo.setBounds(614, 67, 321, 22);
		contentPane.add(lblResultadoCargo);

		this.P1 = new Persistencia();
		this.P1.Conecta("localhost", "3306", "prog4_ativ3", "root", "root");	
		
		ThreadCargos t = new ThreadCargos(P1, cbxCargos);
		
		JButton btnCargo = new JButton("Buscar Atividades");
		btnCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxCargos.getSelectedItem() != null) {
					Cargo cargo = (Cargo) cbxCargos.getSelectedItem();
					String filtro= cargo.getDescricao();
					ThreadBuscarAtividades bAtiv = new ThreadBuscarAtividades(P1, lblResultadoCargo,filtro);
					bAtiv.start();
				    return;
				}
			}
		});
		btnCargo.setBounds(423, 67, 160, 27);
		contentPane.add(btnCargo);
		
		JComboBox cbxFuncionario = new JComboBox();
		cbxFuncionario.setBounds(12, 146, 387, 26);
		contentPane.add(cbxFuncionario);
		
		JLabel lblFuncionario = new JLabel("FUNCIONARIO");
		lblFuncionario.setBounds(12, 117, 102, 28);
		contentPane.add(lblFuncionario);
		
		JLabel lblTarefasPendente = new JLabel("");
		lblTarefasPendente.setBounds(12, 187, 221, 17);
		contentPane.add(lblTarefasPendente);
		
		JLabel lbltarefasAtribuidas = new JLabel("");
		lbltarefasAtribuidas.setBounds(245, 187, 206, 17);
		contentPane.add(lbltarefasAtribuidas);
		
		JButton btnBuscarAtividadesPor = new JButton("Buscar Atividades Por Funcionario");
		btnBuscarAtividadesPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxFuncionario.getSelectedItem() != null) {
					Funcionario funcionario = (Funcionario) cbxFuncionario.getSelectedItem();
					int filtro = funcionario.getIdFuncionario();
					ThreadBuscarPorFunc buscFunc = new ThreadBuscarPorFunc(P1,lblTarefasPendente,lbltarefasAtribuidas,filtro);
					buscFunc.start();
					return;
				}
			}
		});
		btnBuscarAtividadesPor.setBounds(423, 146, 254, 27);
		contentPane.add(btnBuscarAtividadesPor);
		ThreadBuscaFuncionario f = new ThreadBuscaFuncionario(P1, cbxFuncionario);
		
		
		f.start();
		t.start();
	}
}
