//Nos permite usar aquello relacionado con JPanel.
import javax.swing.*;
import java.awt.*;

//Nos permite usar aquello relacionado con ficheros.
import java.io.*;

//Nos permite usar aquello relacionado con fecha.
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

//Nos permite usar aquello relacionado con Scanner.
import java.util.Scanner;

class catalogo {
    public int id;
    public String nombre;
    public double precio;
}

class fecha {
    public int year;
    public int mes;
    public int dia;
}

class funciones {

    public static void fichero_lectura(int i, catalogo[] productos) {

        try (InputStream in = funciones.class.getResourceAsStream("Productos.txt");
             BufferedReader r = new BufferedReader(new InputStreamReader(in))) {

            Scanner sr = new Scanner(r);

            String precio;
            String nombre;

            //Extrae y guarda los datos del archivo de texto en variables más cómodas de uso.
            while (sr.hasNextLine()) {

                //Guarda en la variable data una línea entera del archivo de texto.
                String data = sr.nextLine();
                //Divide la línea guardada en los distintos datos (id, nombre y precio) que nos interesan.
                String[] columns = data.split("\\s+");
                //Declaramos los objetos individuales.
                productos[i] = new catalogo();
                //Guardamos los datos separados en el objeto.
                productos[i].id = Integer.parseInt(columns[0]);
                nombre = columns[1];
                productos[i].nombre = nombre.replace("_", " ");
                //Extrae los números de la variable precio.
                precio = columns[2].replaceAll("[^\\d.]", "");
                productos[i].precio = Double.parseDouble(precio);
                i++;

            }

            //En caso de error a la hora de leer el archivo se mostrará lo siguiente.
        }catch(IOException ex){
            System.out.println("No se pudo encontrar el archivo");
        }

    }
    public static void obtener_fecha(fecha fecha_actual, String[] fecha_string_division) {

        fecha_actual.year = Integer.parseInt(fecha_string_division[0]);
        fecha_actual.mes = Integer.parseInt(fecha_string_division[1]);
        fecha_actual.dia = Integer.parseInt(fecha_string_division[2]);

    }
    public static void mostrar_catalogo(fecha fecha_actual, catalogo[] productos) {

        StringBuilder catalogo_completo = new StringBuilder();
        catalogo_completo.append("""
                <html><font color='red'>ID</font>        ||        <html><font color='blue'>Nombre</font>        ||        <html><font color='green'>Precio ($)</font>
                --------------------------------------------------------
                """);

        if (fecha_actual.mes == 11) {
            if (fecha_actual.dia == 24) {
                for (catalogo mostrar : productos) {
                    catalogo_completo.append("<html><font color='red'>").append(mostrar.id).append("<html><font color='black'>").append(" || ").append("<html><font color='blue'>").append(mostrar.nombre).append("<html><font color='black'>").append(" || ").append("<html><font color='green'>").append((double) Math.round((mostrar.precio * 0.78) * 100) / 100).append(" $"+"<html><font color='black'>").append("\n");
                }
                String catalogo = catalogo_completo.toString();
                JOptionPane.showMessageDialog(null, catalogo);
            }else {
                for (catalogo mostrar : productos) {
                    catalogo_completo.append("<html><font color='red'>").append(mostrar.id).append("<html><font color='black'>").append(" || ").append("<html><font color='blue'>").append(mostrar.nombre).append("<html><font color='black'>").append(" || ").append("<html><font color='green'>").append((double) Math.round((mostrar.precio * 1.3) * 100) / 100).append(" $"+"<html><font color='black'>").append("\n");
                }
                String catalogo = catalogo_completo.toString();
                JOptionPane.showMessageDialog(null, catalogo);
            }
        }else{
            for (catalogo mostrar : productos) {
                catalogo_completo.append("<html><font color='red'>").append(mostrar.id).append("<html><font color='black'>").append(" || ").append("<html><font color='blue'>").append(mostrar.nombre).append("<html><font color='black'>").append(" || ").append("<html><font color='green'>").append(mostrar.precio).append(" $"+"<html><font color='black'>").append("\n");
            }
            String catalogo = catalogo_completo.toString();
            JOptionPane.showMessageDialog(null, catalogo);
        }

    }
    public  static void ordenar_ascendente(catalogo[] productos) {

        for (int j = 0; j < (productos.length)-1; j++){
            for (int x = j+1; x < (productos.length); x++){
                if(productos[j].precio > productos[x].precio) {
                    catalogo cambio = productos[j];
                    productos[j] = productos[x];
                    productos[x] = cambio;
                }
            }
        }

    }
    public  static void ordenar_descendente(catalogo[] productos) {

        for (int j = 0; j < (productos.length)-1; j++){
            for (int x = j+1; x < (productos.length); x++){
                if(productos[j].precio < productos[x].precio) {
                    catalogo cambio = productos[j];
                    productos[j] = productos[x];
                    productos[x] = cambio;
                }
            }
        }

    }
    public static void mostrar_fecha(fecha fecha_actual) {

        JOptionPane.showMessageDialog(null,"<html><font color='purple'>La fecha actual es</font> " + fecha_actual.dia + "/" + fecha_actual.mes + "/" + fecha_actual.year + ".");

    }

}

public class Main extends JFrame {
    private JPanel MainPanel;
    private JTextField text_menu;
    private JButton Button;

    public Main() {

        //Cambia la fuente de los showMessage.
        UIManager.put("OptionPane.messageFont", new Font("Calibri", Font.PLAIN, 16));

        //Declaramos las variables.
        int i = 0;

        //Declaramos los objetos
        catalogo[] productos = new catalogo[20];
        fecha fecha_actual = new fecha();

        //Leemos el archivo de texto con los datos de los productos y realizamos varias operaciones.
        funciones.fichero_lectura(i, productos);

        //Obtenemos la fecha actual y dividimos sus componente para su posterior uso.
        String fecha_string = Instant.now().atZone(ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE);
        String[] fecha_string_division = fecha_string.split("-");
        funciones.obtener_fecha(fecha_actual, fecha_string_division);

        //Indicamos las acciones que se realizaran cuando pulsemos el botón.
        Button.addActionListener(e -> {

            switch (text_menu.getText()) {

                case "1": {

                    funciones.mostrar_catalogo(fecha_actual, productos);
                    break;

                }
                case "2": {

                    //Insertamos un input con texto para obtener el menu.
                    String menu = JOptionPane.showInputDialog("""
                            <html><font color='red'>1.- Ascendente.
                            <html><font color='red'>2.- Descendente.
                            <html><font color='red'>Operación a realizar:\s""");

                    switch (menu){

                        //Ordenamos mediante el método de la burbuja.
                        case "1": {

                            JOptionPane.showMessageDialog(null, "Se ha ordenado el catálogo de forma ascendente");
                            funciones.ordenar_ascendente(productos);
                            break;

                        }
                        case "2": {

                            JOptionPane.showMessageDialog(null, "Se ha ordenado el catálogo de forma descendente");
                            funciones.ordenar_descendente(productos);
                            break;

                        }
                        default: {

                            JOptionPane.showMessageDialog(null, "Operación no válida");

                        }

                    }
                    break;

                }
                case "3": {

                    JOptionPane.showMessageDialog(null, """
                            <html><font color='orange'>- Dia normal: Precio estandar.
                            <html><font color='orange'>- Pre-BlackFriday: Encarecimiento del 30%.
                            <html><font color='orange'>- Black-Friday: Rebaja del 40%.""");
                    break;

                }
                case "4": {

                    funciones.mostrar_fecha(fecha_actual);
                    break;

                }
                default: {

                    JOptionPane.showMessageDialog(null,"Operación no válida.");

                }

            }

        });

    }

    public static void main(String[] args) {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);
        panel.setTitle("Catálogo");
        panel.setResizable(false);
        panel.setSize(350, 300);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("catalogo.png");
        panel.setIconImage(imagen.getImage());

    }

}
