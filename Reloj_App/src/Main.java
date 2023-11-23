//Nos permite usar lo relacionado con los Swing.
import javax.swing.*;

//Nos permite obtener la fecha actual.
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

class fecha {
    public int year;
    public int mes;
    public int dia;
}

public class Main extends  JFrame{
    private JTextField textHoras;
    private JTextField textField1;
    private JTextField textMinutos;
    private JPanel MainPanel;
    private JTextField textFecha;
    private JTextField textSegundos;
    private JTextField textField2;

    public Main() {

        fecha fecha_actual = new fecha();

        String fecha_string = Instant.now().atZone(ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE);
        String[] fecha_string_division = fecha_string.split("-");
        fecha_actual.year = Integer.parseInt(fecha_string_division[0]);
        fecha_actual.mes = Integer.parseInt(fecha_string_division[1]);
        fecha_actual.dia = Integer.parseInt(fecha_string_division[2]);

        Timer timer = new Timer(200, e -> {

            textHoras.setText(String.format("%02d",LocalDateTime.now().getHour()));
            textMinutos.setText(String.format("%02d",LocalDateTime.now().getMinute()));
            textSegundos.setText(String.format("%02d",LocalDateTime.now().getSecond()));
            textFecha.setText(fecha_actual.dia + " / " + fecha_actual.mes + " / " + fecha_actual.year);

        });

        timer.start();

    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);
        panel.textHoras.setEditable(false);
        panel.textHoras.setHorizontalAlignment(JTextField.CENTER);
        panel.textField1.setEditable(false);
        panel.textField1.setHorizontalAlignment(JTextField.CENTER);
        panel.textMinutos.setEditable(false);
        panel.textMinutos.setHorizontalAlignment(JTextField.CENTER);
        panel.textField2.setEditable(false);
        panel.textField2.setHorizontalAlignment(JTextField.CENTER);
        panel.textSegundos.setEditable(false);
        panel.textSegundos.setHorizontalAlignment(JTextField.CENTER);
        panel.textFecha.setEditable(false);
        panel.textFecha.setHorizontalAlignment(JTextField.CENTER);
        panel.setTitle("Reloj");
        panel.setResizable(false);
        panel.setSize(650, 300);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("reloj.png");
        panel.setIconImage(imagen.getImage());

    }

}
