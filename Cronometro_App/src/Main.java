//Nos permkte emplear aquello relacionado con el JPanel.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JPanel MainPanel;
    private JTextField txtHoras;
    private JTextField textField1;
    private JTextField txtMinutos;
    private JTextField textField2;
    private JTextField txtSegundos;
    private JButton Button_Start;

    public Main() {

        //Declaramos nuestras variables.
        final boolean[] contar = new boolean[1];
        contar[0] = true;

        //Nos permite usar bucles en swing ya que los bucles for no son muy utiles según que casos.
        Timer timer = new Timer(950, new ActionListener() {
            int count_s = 1;
            int count_m = 1;
            int count_h = 1;

            public void actionPerformed(ActionEvent e) {

                if (count_s != 60) {
                    txtSegundos.setText((String.format("%02d", count_s)));
                    count_s++;
                }else {
                    txtSegundos.setText((String.format("%02d", 0)));
                    count_s = 1;
                    txtMinutos.setText((String.format("%02d", count_m)));
                    count_m++;
                    if (count_m == 60) {
                        txtHoras.setText((String.format("%02d", count_h)));
                        count_h++;
                    }
                }

            }

        });

        //Button_Start se encarga de comenzar y parar el cronómetro.
        Button_Start.addActionListener(e -> {
            if (contar[0]) {
                timer.start();
                contar[0] = false;
            }else {
                timer.stop();
                contar[0] = true;
            }
        });

    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);
        panel.txtHoras.setEditable(false);
        panel.txtHoras.setHorizontalAlignment(JTextField.CENTER);
        panel.textField1.setEditable(false);
        panel.textField1.setHorizontalAlignment(JTextField.CENTER);
        panel.txtMinutos.setEditable(false);
        panel.txtMinutos.setHorizontalAlignment(JTextField.CENTER);
        panel.textField2.setEditable(false);
        panel.textField2.setHorizontalAlignment(JTextField.CENTER);
        panel.txtSegundos.setEditable(false);
        panel.txtSegundos.setHorizontalAlignment(JTextField.CENTER);
        panel.setTitle("Cronómetro");
        panel.setResizable(false);
        panel.setSize(500, 300);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("cronometro.png");
        panel.setIconImage(imagen.getImage());

    }

}
