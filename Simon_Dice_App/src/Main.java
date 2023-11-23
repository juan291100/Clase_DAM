//Nos permite usar aquello relacionado con Swing.
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    private JPanel MainPanel;
    private JButton Button_Verde;
    private JButton Button_Rojo;
    private JButton Button_Amarillo;
    private JButton Button_Azul;
    private JButton Button_Negro;

    public Main() {

        Button_Verde.setEnabled(false);
        Button_Rojo.setEnabled(false);
        Button_Amarillo.setEnabled(false);
        Button_Azul.setEnabled(false);

        final int[] contador = new int[1];
        final int[] color = new int[1];
        final int[] limite = new int[1];
        final int[] timer = new int[1];
        final int[] i = new int[1];
        final int[] j = new int[1];
        final int[] patron = new int[8];
        limite[0] = 8;

        //Nos permite usar bucles en swing ya que los bucles for no son muy útiles según que casos.
        Timer timer_light = new Timer(500, e -> {

            Button_Negro.setEnabled(false);
            Button_Verde.setEnabled(false);
            Button_Rojo.setEnabled(false);
            Button_Amarillo.setEnabled(false);
            Button_Azul.setEnabled(false);

            j[0] = 0;

            if (contador[0] % 2 == 0) {
                color[0] = (int) (Math.random() * 4);
                patron[i[0]] = color[0];
                i[0]++;
            }

            //System.out.println("Contador: "+contador[0]+" Color: "+color);

            if (color[0] == 0){
                if (contador[0] % 2 == 0) {
                    Button_Verde.setBackground(Color.GREEN);
                }else{
                    Button_Verde.setBackground(new Color(12,155,19));
                }
            } else if (color[0] == 1) {
                if (contador[0] % 2 == 0) {
                    Button_Rojo.setBackground(Color.RED);
                }else{
                    Button_Rojo.setBackground(new Color(155,9,8));
                }
            } else if (color[0] == 2) {
                if (contador[0] % 2 == 0) {
                    Button_Amarillo.setBackground(Color.YELLOW);
                }else{
                    Button_Amarillo.setBackground(new Color(146,155,2));
                }
            }else {
                if (contador[0] % 2 == 0) {
                    Button_Azul.setBackground(Color.BLUE);
                }else{
                    Button_Azul.setBackground(new Color(8,18,155));
                }
            }

            contador[0]++;

            if (contador[0] == limite[0]) {
                ((Timer)e.getSource()).stop();
                System.out.println(" ");
                Button_Negro.setEnabled(false);
                Button_Verde.setEnabled(true);
                Button_Rojo.setEnabled(true);
                Button_Amarillo.setEnabled(true);
                Button_Azul.setEnabled(true);
                contador[0] = 0;
                limite[0] += 2;
                timer[0]++;

            }

        });

        Button_Negro.addActionListener(e -> {

            if (timer[0] == 1){
                timer_light.setDelay(400);
            } else if (timer[0] == 2) {
                timer_light.setDelay(300);
            } else if (timer[0] == 3) {
                timer_light.setDelay(200);
            } else if (timer[0] == 4) {
                timer_light.setDelay(100);
            }

            timer_light.start();

        });

        Button_Verde.addActionListener(e -> {

            if (j[0] == (i[0]-1)){
                if (timer[0] == 4) {
                    JOptionPane.showMessageDialog(null, "Has ganado!!");
                    System.exit(0);
                }
                Timer timer_dark = new Timer(1000, ex -> {

                    if (contador[0] % 2 == 0) {
                        Button_Verde.setBackground(Color.GREEN);
                        Button_Rojo.setBackground(Color.RED);
                        Button_Amarillo.setBackground(Color.YELLOW);
                        Button_Azul.setBackground(Color.BLUE);
                    }else {
                        Button_Verde.setBackground(new Color(12,155,19));
                        Button_Rojo.setBackground(new Color(155,9,8));
                        Button_Amarillo.setBackground(new Color(146,155,2));
                        Button_Azul.setBackground(new Color(8,18,155));
                    }

                    contador[0]++;
                    if (contador[0] == 2){
                        ((Timer)ex.getSource()).stop();
                        contador[0] = 0;
                        Button_Negro.setEnabled(true);
                        Button_Verde.setEnabled(false);
                        Button_Rojo.setEnabled(false);
                        Button_Amarillo.setEnabled(false);
                        Button_Azul.setEnabled(false);
                        i[0] = 0;
                    }

                });

                timer_dark.start();

            }

            if (patron[j[0]] != 0){
                JOptionPane.showMessageDialog(null,"Has fallado.");
                System.exit(0);
            }

            j[0]++;

        });

        Button_Rojo.addActionListener(e -> {

            if (j[0] == (i[0]-1)){
                if (timer[0] == 5) {
                    JOptionPane.showMessageDialog(null, "Has ganado!!");
                    System.exit(0);
                }

                Timer timer_dark = new Timer(1000, ex -> {

                    if (contador[0] % 2 == 0) {
                        Button_Verde.setBackground(Color.GREEN);
                        Button_Rojo.setBackground(Color.RED);
                        Button_Amarillo.setBackground(Color.YELLOW);
                        Button_Azul.setBackground(Color.BLUE);
                    }else {
                        Button_Verde.setBackground(new Color(12,155,19));
                        Button_Rojo.setBackground(new Color(155,9,8));
                        Button_Amarillo.setBackground(new Color(146,155,2));
                        Button_Azul.setBackground(new Color(8,18,155));
                    }

                    contador[0]++;
                    if (contador[0] == 2){
                        ((Timer)ex.getSource()).stop();
                        contador[0] = 0;
                        Button_Negro.setEnabled(true);
                        Button_Verde.setEnabled(false);
                        Button_Rojo.setEnabled(false);
                        Button_Amarillo.setEnabled(false);
                        Button_Azul.setEnabled(false);
                        i[0] = 0;
                    }

                });

                timer_dark.start();

            }

            if (patron[j[0]] != 1){
                JOptionPane.showMessageDialog(null,"Has fallado.");
                System.exit(0);
            }

            j[0]++;

        });

        Button_Amarillo.addActionListener(e -> {

            if (j[0] == (i[0]-1)){
                if (timer[0] == 5) {
                    JOptionPane.showMessageDialog(null, "Has ganado!!");
                    System.exit(0);
                }

                Timer timer_dark = new Timer(1000, ex -> {

                    if (contador[0] % 2 == 0) {
                        Button_Verde.setBackground(Color.GREEN);
                        Button_Rojo.setBackground(Color.RED);
                        Button_Amarillo.setBackground(Color.YELLOW);
                        Button_Azul.setBackground(Color.BLUE);
                    }else {
                        Button_Verde.setBackground(new Color(12,155,19));
                        Button_Rojo.setBackground(new Color(155,9,8));
                        Button_Amarillo.setBackground(new Color(146,155,2));
                        Button_Azul.setBackground(new Color(8,18,155));
                    }

                    contador[0]++;
                    if (contador[0] == 2){
                        ((Timer)ex.getSource()).stop();
                        contador[0] = 0;
                        Button_Negro.setEnabled(true);
                        Button_Verde.setEnabled(false);
                        Button_Rojo.setEnabled(false);
                        Button_Amarillo.setEnabled(false);
                        Button_Azul.setEnabled(false);
                        i[0] = 0;
                    }

                });

                timer_dark.start();

            }

            if (patron[j[0]] != 2){
                JOptionPane.showMessageDialog(null,"Has fallado.");
                System.exit(0);
            }

            j[0]++;

        });

        Button_Azul.addActionListener(e -> {

            if (j[0] == (i[0]-1)){
                if (timer[0] == 5) {
                    JOptionPane.showMessageDialog(null, "Has ganado!!");
                    System.exit(0);
                }

                Timer timer_dark = new Timer(1000, ex -> {

                    if (contador[0] % 2 == 0) {
                        Button_Verde.setBackground(Color.GREEN);
                        Button_Rojo.setBackground(Color.RED);
                        Button_Amarillo.setBackground(Color.YELLOW);
                        Button_Azul.setBackground(Color.BLUE);
                    }else {
                        Button_Verde.setBackground(new Color(12,155,19));
                        Button_Rojo.setBackground(new Color(155,9,8));
                        Button_Amarillo.setBackground(new Color(146,155,2));
                        Button_Azul.setBackground(new Color(8,18,155));
                    }

                    contador[0]++;
                    if (contador[0] == 2){
                        ((Timer)ex.getSource()).stop();
                        contador[0] = 0;
                        Button_Negro.setEnabled(true);
                        Button_Verde.setEnabled(false);
                        Button_Rojo.setEnabled(false);
                        Button_Amarillo.setEnabled(false);
                        Button_Azul.setEnabled(false);
                        i[0] = 0;
                    }

                });

                timer_dark.start();

            }

            if (patron[j[0]] != 3){
                JOptionPane.showMessageDialog(null,"Has fallado.");
                System.exit(0);
            }

            j[0]++;

        });

    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);
        panel.setTitle("Simón Dice");
        panel.setResizable(false);
        panel.setSize(500, 500);
        panel.getContentPane().setBackground(Color.GRAY);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("simon.png");
        panel.setIconImage(imagen.getImage());

    }

}
