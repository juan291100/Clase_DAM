//Nos permite usar aquello relacionado con JPanel.
import javax.swing.*;
import java.awt.*;

class funciones {

    public static void digito(boolean[] neg, StringBuilder datos, String valor, String[] texto, JTextField txtArea) {

        neg[0] = true;
        datos.append(valor);
        texto[0] = datos.toString();
        txtArea.setText(texto[0]);

    }
    public static void operator(boolean[] del, boolean[] neg, StringBuilder datos, String valor, String[] texto, JTextField txtArea) {

        del[0] = true;
        neg[0] = false;
        datos.append(" ").append(valor).append(" ");
        texto[0] = datos.toString();
        txtArea.setText(texto[0]);

    }
    public static void result(double i, String[] texto, JTextField txtArea ) {

        if (i % 1 != 0) {
            //Nos muestra las números unicamente con dos decimales.
            texto[0] = String.valueOf(((double)((int)(i *100.0)))/100.0);
        }else {
            //Nos convierte los doubles en enteros.
            texto[0] = String.valueOf((int)(i));
        }
        txtArea.setText(texto[0]);

    }

}

public class Main extends JFrame {
    private JPanel MainPanel;
    private JTextField txtArea;
    private JButton Button_CE;
    private JButton Button_Del;
    private JButton button_exp;
    private JButton button_division;
    private JButton Button_7;
    private JButton Button_8;
    private JButton Button_9;
    private JButton Button_multiplicacion;
    private JButton Button_4;
    private JButton Button_5;
    private JButton Button_6;
    private JButton Button_resta;
    private JButton Button_1;
    private JButton Button_2;
    private JButton Button_3;
    private JButton Button_0;
    private JButton Button_punto;
    private JButton Button_igual;
    private JButton Button_suma;
    private JButton Button_negativos;

    public Main() {

        //Cambia la fuente de lo showMessage.
        UIManager.put("OptionPane.messageFont", new Font("Calibri", Font.PLAIN, 16));

        //Declaramos las variables a usar y les añadimos final para poder ser empleadas dentro de los botones.
        final StringBuilder datos = new StringBuilder();
        final String[] texto = new String[1];
        final String[] operation = new String[1];
        final boolean[] del = new boolean[1];
        final boolean[] neg = new boolean[1];

        del[0] = true;
        operation[0] = "";

        //Programamos las funciones de los botones.

        //Button_CE nos limpia la pantalla de números y operaciones.
        Button_CE.addActionListener(e -> {

            del[0] = true;
            datos.setLength(0);
            texto[0] = datos.toString();
            txtArea.setText(texto[0]);

        });

        //Button_Del nos borra el ultimo índice de la cadena que se muestra en pantalla.
        Button_Del.addActionListener(e -> {

            neg[0] = false;
            if (!datos.isEmpty()) {
                if (del[0]) {
                    datos.deleteCharAt(datos.length() - 1);
                    texto[0] = datos.toString();
                    txtArea.setText(texto[0]);
                }
            }

        });

        //Button_exp se encarga de las operaciones de exponentes.
        button_exp.addActionListener(e -> {

            if (!datos.isEmpty()) {
                operation[0] = "\\^";
                funciones.operator(del, neg, datos, "^", texto, txtArea);
            }

        });

        //Button_exp se encarga de las operaciones de divisiones.
        button_division.addActionListener(e -> {

            if (!datos.isEmpty()) {
                operation[0] = "/";
                funciones.operator(del, neg, datos, "/", texto, txtArea);
            }

        });

        //Button_exp se encarga de las operaciones de multiplicaciones.
        Button_multiplicacion.addActionListener(e -> {

            if (!datos.isEmpty()) {
                //Ciertos carácteres especiales requieren de \\ para ser utilizables.
                operation[0] = "\\*";
                funciones.operator(del, neg, datos, "*", texto, txtArea);
            }

        });

        //Button_exp se encarga de las operaciones de restas.
        Button_resta.addActionListener(e -> {

            if (!datos.isEmpty()) {
                operation[0] = "-";
                funciones.operator(del, neg, datos, "-", texto, txtArea);
            }

        });

        //Button_exp se encarga de las operaciones de sumas.
        Button_suma.addActionListener(e -> {

            if (!datos.isEmpty()) {
                operation[0] = "\\+";
                funciones.operator(del, neg, datos, "+", texto, txtArea);
            }

        });

        //Button_igual realiza las operaciones que hemos elegido dependiendo del operador.
        Button_igual.addActionListener(e -> {

            if (!datos.isEmpty()) {
                if (operation[0].isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Operación no válida");
                } else {

                    String[] num = texto[0].split(operation[0]);

                    if (num.length != 2) {
                        JOptionPane.showMessageDialog(null, "Operación no válida");
                    } else {

                        double num_1 = Double.parseDouble(num[0]);
                        double num_2 = Double.parseDouble(num[1]);

                        switch (operation[0]) {

                            case "\\^": {

                                funciones.result(Math.pow(num_1, num_2), texto, txtArea);
                                break;

                            }
                            case "/": {

                                funciones.result((num_1 / num_2), texto, txtArea);
                                break;

                            }
                            case "\\*": {

                                funciones.result((num_1 * num_2), texto, txtArea);
                                break;

                            }
                            case "-": {

                                funciones.result((num_1 - num_2), texto, txtArea);
                                break;

                            }
                            case "\\+": {

                                funciones.result((num_1 + num_2), texto, txtArea);
                                break;

                            }

                        }

                        del[0] = false;
                        datos.setLength(0);
                        datos.append(texto[0]);
                        operation[0] = "";

                    }
                }
            }
        });

        //Los siguientes botones se emplean como las entradas de los números.
        Button_0.addActionListener(e -> {

            if (!datos.isEmpty() && del[0]) {
                funciones.digito(neg, datos, "0", texto, txtArea);
            }

        });

        Button_1.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "1", texto, txtArea);
            }
        });

        Button_2.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "2", texto, txtArea);
            }

        });

        Button_3.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "3", texto, txtArea);
            }

        });

        Button_4.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "4", texto, txtArea);
            }

        });
        Button_5.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "5", texto, txtArea);
            }

        });

        Button_6.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "6", texto, txtArea);
            }

        });

        Button_7.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "7", texto, txtArea);
            }

        });

        Button_8.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "8", texto, txtArea);
            }

        });

        Button_9.addActionListener(e -> {

            if (del[0]) {
                funciones.digito(neg, datos, "9", texto, txtArea);
            }

        });

        Button_punto.addActionListener(e -> {

            if (!datos.isEmpty()) {
                if (del[0]) {
                    funciones.digito(neg, datos, ".", texto, txtArea);
                }
            }

        });

        //Button_negativos se encarga de poder emplear números negativos.
        Button_negativos.addActionListener(e -> {

            if (datos.isEmpty() || !operation[0].isEmpty()) {
                if (!neg[0]) {
                    datos.append("-");
                    texto[0] = datos.toString();
                    txtArea.setText(texto[0]);
                }
                if(!operation[0].isEmpty()){
                    neg[0] = true;
                }
            }

        });
    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.txtArea.setEditable(false);
        panel.setContentPane(panel.MainPanel);
        panel.setTitle("Calculadora");
        panel.setResizable(false);
        panel.setSize(330, 330);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("calculadora.png");
        panel.setIconImage(imagen.getImage());

    }

}
