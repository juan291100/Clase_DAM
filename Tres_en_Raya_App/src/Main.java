//Nos permite emplear aquello relacionado con el Swing.
import javax.swing.*;
import java.awt.*;

class funciones {

    public static void boton (boolean[] jugador, JButton button) {

        if (jugador[0]) {
            button.setText("X");
            jugador[0] = false;
        }else {
            button.setText("O");
            jugador[0] = true;
        }
        button.setEnabled(false);

    }
    public  static  void acabar_juego(int [][] contador) {

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 2; j++) {
                if (contador[i][j] == 3){
                    if (j == 0){
                        JOptionPane.showMessageDialog(null, "El ganador es el jugador 1");
                        System.exit(0);
                    }else {
                        JOptionPane.showMessageDialog(null, "El ganador es el jugador 2");
                        System.exit(0);
                    }
                }
            }
        }

    }

}

public class Main extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel MainPanel;

    public Main() {

        //Cambia la fuente de lo showMessage.
        UIManager.put("OptionPane.messageFont", new Font("Calibri", Font.PLAIN, 16));

        //Declaramos nuestras variables.
        final boolean[] jugador = new boolean[1];
        final int[][] contador = new int[8][2];
        String menu;

        //Inicializamos el contador.
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 2; j++) {
                contador[i][j] = 0;
            }
        }

        //Le pedimos al usuario que elija que símbolo quiere emplear.
        do {
            menu = JOptionPane.showInputDialog(null, """
                    Elige que jugador empezará la partida.
                    1.- Jugador 1 (X)
                    2.- Jugador 2 (O)""");

            if (!menu.equals("1") && !menu.equals("2")){
                JOptionPane.showMessageDialog(null, "Valor introducido no válido");
            }

            jugador[0] = menu.equals("1");

        }while(!menu.equals("1") && !menu.equals("2"));

        //Dependiendo del jugador se pondra "X" o "O" y si se hace linea el programa terminará.
        button1.addActionListener(e -> {

            if (jugador[0]) {
                contador[0][0]++;
                contador[3][0]++;
                contador[6][0]++;
            }else {
                contador[0][1]++;
                contador[3][1]++;
                contador[6][1]++;
            }

            funciones.boton(jugador, button1);

            funciones.acabar_juego(contador);

        });

        button2.addActionListener(e -> {

            if (jugador[0]) {
                contador[1][0]++;
                contador[3][0]++;
            }else {
                contador[1][1]++;
                contador[3][1]++;
            }

            funciones.boton(jugador, button2);

            funciones.acabar_juego(contador);

        });

        button3.addActionListener(e -> {

            if (jugador[0]) {
                contador[2][0]++;
                contador[3][0]++;
                contador[7][0]++;

            }else {
                contador[1][1]++;
                contador[3][1]++;
                contador[7][1]++;
            }

            funciones.boton(jugador, button3);

            funciones.acabar_juego(contador);

        });

        button4.addActionListener(e -> {

            if (jugador[0]) {
                contador[0][0]++;
                contador[4][0]++;
            }else {
                contador[0][1]++;
                contador[4][1]++;
            }

            funciones.boton(jugador, button4);

            funciones.acabar_juego(contador);

        });

        button5.addActionListener(e -> {

            if (jugador[0]) {
                contador[1][0]++;
                contador[4][0]++;
                contador[6][0]++;
                contador[7][0]++;
            }else {
                contador[1][1]++;
                contador[4][1]++;
                contador[6][1]++;
                contador[7][1]++;
            }

            funciones.boton(jugador, button5);

            funciones.acabar_juego(contador);

        });

        button6.addActionListener(e -> {

            if (jugador[0]) {
                contador[2][0]++;
                contador[4][0]++;
            }else {
                contador[2][1]++;
                contador[4][1]++;
            }

            funciones.boton(jugador, button6);

            funciones.acabar_juego(contador);

        });

        button7.addActionListener(e -> {

            if (jugador[0]) {
                contador[0][0]++;
                contador[5][0]++;
                contador[7][0]++;

            }else {
                contador[0][1]++;
                contador[5][1]++;
                contador[7][1]++;
            }

            funciones.boton(jugador, button7);

            funciones.acabar_juego(contador);

        });

        button8.addActionListener(e -> {

            if (jugador[0]) {
                contador[1][0]++;
                contador[5][0]++;
            }else {
                contador[1][1]++;
                contador[5][1]++;
            }

            funciones.boton(jugador, button8);

            funciones.acabar_juego(contador);

        });

        button9.addActionListener(e -> {

            if (jugador[0]) {
                contador[2][0]++;
                contador[5][0]++;
                contador[6][0]++;

            }else {
                contador[2][1]++;
                contador[5][1]++;
                contador[6][1]++;
            }

            funciones.boton(jugador, button9);

            funciones.acabar_juego(contador);

        });

    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);
        panel.setTitle("Tres en raya");
        panel.setResizable(false);
        panel.setSize(400, 400);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Asignamos una imagen como icono del programa.
        ImageIcon imagen = new ImageIcon("tresenraya.png");
        panel.setIconImage(imagen.getImage());

    }

}
