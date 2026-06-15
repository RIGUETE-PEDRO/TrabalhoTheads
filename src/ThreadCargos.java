import java.awt.EventQueue;
import java.util.List;
import javax.swing.JComboBox;

public class ThreadCargos extends Thread {

    private Persistencia p1;
    private JComboBox<Cargo> combo;

    public ThreadCargos(Persistencia p1,
                        JComboBox<Cargo> combo) {

        this.p1 = p1;
        this.combo = combo;
    }

    @Override
    public void run() {

        List<Cargo> cargos = p1.listCargos();

        EventQueue.invokeLater(() -> {

            combo.removeAllItems();

            for (Cargo c : cargos) {
                combo.addItem(c);
            }

            combo.setSelectedIndex(-1);
        });
    }
}