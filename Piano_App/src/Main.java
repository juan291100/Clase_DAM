import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame{
    private JPanel MainPanel;
    private JButton Button_Do;
    private JButton Button_Re;
    private JButton Button_Mi;
    private JButton Button_Fa;
    private JButton Button_Sol;
    private JButton Button_La;
    private JButton Button_Si;
    private JButton Button_Mib;
    private JButton Button_Solb;
    private JButton Button_Lab;
    private JButton Button_Sib;
    private JButton Button_Reb;

    public  Main() throws LineUnavailableException, IOException {

        String soundName_do = "do.wav";
        AudioInputStream DO;
        try {
            DO = AudioSystem.getAudioInputStream(new File(soundName_do).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_do = AudioSystem.getClip();
        clip_do.open(DO);

        Button_Do.addActionListener(e -> {

            clip_do.setMicrosecondPosition(0);
            clip_do.start();

        });

        String soundName_re = "re.wav";
        AudioInputStream RE;
        try {
            RE = AudioSystem.getAudioInputStream(new File(soundName_re).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_re = AudioSystem.getClip();
        clip_re.open(RE);

        Button_Re.addActionListener(e -> {

            clip_re.setMicrosecondPosition(0);
            clip_re.start();

        });

        String soundName_mi = "mi.wav";
        AudioInputStream MI;
        try {
            MI = AudioSystem.getAudioInputStream(new File(soundName_mi).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_mi = AudioSystem.getClip();
        clip_mi.open(MI);

        Button_Mi.addActionListener(e -> {

            clip_mi.setMicrosecondPosition(0);
            clip_mi.start();

        });

        String soundName_fa = "fa.wav";
        AudioInputStream FA;
        try {
            FA = AudioSystem.getAudioInputStream(new File(soundName_fa).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_fa = AudioSystem.getClip();
        clip_fa.open(FA);

        Button_Fa.addActionListener(e -> {

            clip_fa.setMicrosecondPosition(0);
            clip_fa.start();

        });

        String soundName_sol = "sol.wav";
        AudioInputStream SOL;
        try {
            SOL = AudioSystem.getAudioInputStream(new File(soundName_sol).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_sol = AudioSystem.getClip();
        clip_sol.open(SOL);

        Button_Sol.addActionListener(e -> {

            clip_sol.setMicrosecondPosition(0);
            clip_sol.start();

        });

        String soundName_la = "la.wav";
        AudioInputStream LA;
        try {
            LA = AudioSystem.getAudioInputStream(new File(soundName_la).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_la = AudioSystem.getClip();
        clip_la.open(LA);

        Button_La.addActionListener(e -> {

            clip_la.setMicrosecondPosition(0);
            clip_la.start();

        });

        String soundName_si = "si.wav";
        AudioInputStream SI;
        try {
            SI = AudioSystem.getAudioInputStream(new File(soundName_si).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
        Clip clip_si = AudioSystem.getClip();
        clip_si.open(SI);

        Button_Si.addActionListener(e -> {

            clip_si.setMicrosecondPosition(0);
            clip_si.start();

        });

    }

    public static void main(String[] args) throws LineUnavailableException, IOException {

        //Determinamos las características del JPanel.
        Main panel = new Main();
        panel.setContentPane(panel.MainPanel);

        panel.setTitle("Piano");
        panel.setResizable(false);
        panel.setSize(600, 250);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon("piano.png");
        panel.setIconImage(imagen.getImage());

    }

}
