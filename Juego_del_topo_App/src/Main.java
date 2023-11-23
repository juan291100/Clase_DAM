//Nos permite usar lo relacionado con Swing.
import javax.swing.*;
import java.awt.*;
//Nos permite emplear los listeners y eventos.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Nos permite usar lo relacionado con el ratón.
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//Nos permite usar Objects.
import java.util.Objects;


public class Main extends JFrame{

    private JPanel MainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttontime;
    private JButton buttonscore;
    private JTextField timeTextField;
    private JTextField puntuacionTextField;

    static class funciones {

        //Nos permitirá cambiar el delay conforme avanza nuestra puntuación.
        public static void reducir_delay(int[] contador_score, Timer topo){

            if (contador_score[0] == 5){
                topo.setDelay(850);
            } else if (contador_score[0] == 10) {
                topo.setDelay(700);
            } else if (contador_score[0] == 15) {
                topo.setDelay(550);
            } else if (contador_score[0] == 20) {
                topo.setDelay(400);
            } else if (contador_score[0] == 25) {
                topo.setDelay(250);
            }

        }

    }

    public Main() {

        //Cambia la fuente de los showMessage.
        UIManager.put("OptionPane.messageFont", new Font("Calibri", Font.PLAIN, 36));


        //Declaramos nuestras variables e inicializamos las que nos convengan.
        final int[] contador_score = new int[1];
        final int[] contador_tiempo = new int[1];

        contador_tiempo[0] = 60;

        //Creamos un timer que nos muestre el tiempo restante durante el juego.
        Timer tiempo = new Timer(950, e -> {

            buttontime.setText((String.format("%02d", contador_tiempo[0])));
            contador_tiempo[0]--;
            if (contador_tiempo[0] < 0){
                ((Timer)e.getSource()).stop();
                JOptionPane.showMessageDialog(null,"El tiempo ha terminado. Has obtenido un total de " + contador_score[0] + " puntos.");
                System.exit(0);
            }

        });

        tiempo.start();

        //Creamos un timer que nos actualice el contador de puntuación conforme este aumenta.
        Timer score = new Timer(200, e -> buttonscore.setText((String.format("%02d", contador_score[0]))));

        score.start();

        //Creamos un timer que se encargue de lo relacionado con los topos y sus salidas.
        Timer topo = new Timer(1000, new ActionListener() {

            int aleatorio;
            int contador = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                aleatorio = (int)(Math.random()*9);

                if (contador % 2 == 0) {

                    if (aleatorio == 0) {
                        button1.setText("X");
                    } else if (aleatorio == 1) {
                        button2.setText("X");
                    } else if (aleatorio == 2) {
                        button3.setText("X");
                    } else if (aleatorio == 3) {
                        button4.setText("X");
                    } else if (aleatorio == 4) {
                        button5.setText("X");
                    } else if (aleatorio == 5) {
                        button6.setText("X");
                    } else if (aleatorio == 6) {
                        button7.setText("X");
                    } else if (aleatorio == 7) {
                        button8.setText("X");
                    } else {
                        button9.setText("X");
                    }

                }else {
                    button1.setText("_");
                    button2.setText("_");
                    button3.setText("_");
                    button4.setText("_");
                    button5.setText("_");
                    button6.setText("_");
                    button7.setText("_");
                    button8.setText("_");
                    button9.setText("_");
                }

                contador++;

                if (contador_tiempo[0] < 0){
                    ((Timer)e.getSource()).stop();
                }

            }
        });

        topo.start();

        //Programamos el obtener puntos al darle a los topos.
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button1.getText(), "X")){
                    button1.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button2.getText(), "X")){
                    button2.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button3.getText(), "X")){
                    button3.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button4.getText(), "X")){
                    button4.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button5.getText(), "X")){
                    button5.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button6.getText(), "X")){
                    button6.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button7.getText(), "X")){
                    button7.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button8.getText(), "X")){
                    button8.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if (Objects.equals(button9.getText(), "X")){
                    button9.setText("_");
                    contador_score[0]++;
                }
                funciones.reducir_delay(contador_score, topo);

            }
        });

    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);
        panel.setTitle("El juego del topo");
        panel.setResizable(false);
        panel.setSize(600, 600);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("topo.png");
        panel.setIconImage(imagen.getImage());


    }
}
