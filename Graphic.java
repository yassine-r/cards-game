package MyGame;

import MyGame.Components.Buttons;
import MyGame.Components.CoupleButtons;
import MyGame.Components.MyPanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Graphic implements ActionListener {

    JButton button_start;
    JButton button_quit;
    MyPanel panel_center;
    public static JLabel scoreLabel;
    public JLabel durationLabel;
    public static JLabel winnnerlabel;
    public static int score;
    public static Clip clip;
    ActionListener timerListener;
    public static Timer timer;
    Date date_start;

    public Graphic() {
        score = 0;
        JFrame frame = new JFrame("Game");

        JPanel panel_north = new JPanel();
        panel_center = new MyPanel();
        JPanel panel_south = new JPanel();

        button_start = new JButton("Start Game");
        button_start.setBackground(new Color(4, 122, 178));
        button_start.setForeground(Color.WHITE);
        button_start.setBorderPainted(false);
        button_start.setFocusPainted(false);


        button_quit = new JButton("Quit");
        button_quit.setBackground(new Color(206, 17, 17));
        button_quit.setForeground(Color.WHITE);
        button_quit.setBorderPainted(false);
        button_quit.setFocusPainted(false);

        scoreLabel = new JLabel("Score: " + Graphic.score);
        durationLabel = new JLabel("duration: 00:00:00");
        winnnerlabel=new JLabel("                                                     ");
        button_start.addActionListener(this);
        button_quit.addActionListener(this);

        panel_north.add(button_start);
        panel_north.add(button_quit);
        panel_south.add(Graphic.scoreLabel);
        panel_south.add(winnnerlabel);
        panel_south.add(durationLabel);
        frame.add(panel_north, BorderLayout.NORTH);
        frame.add(panel_center, BorderLayout.CENTER);
        frame.add(panel_south, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(445, 445);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_start) {
            panel_center.draw();
            Buttons.setState(false);
            Buttons.setState2(false);
            panel_center.getButtons().Show();
            this.button_start.setText("Restart");
            CoupleButtons.lock(4000);
            Graphic.score=0;
            Graphic.scoreLabel.setText("Score: " + Graphic.score);
            Graphic.winnnerlabel.setText("                                                     ");

            date_start = new Date();
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            timerListener = s -> {
                Date date = new Date();
                long sum = date.getTime() -date_start.getTime();
                Date sumDate = new Date(sum);
                String time = timeFormat.format(sumDate);
                durationLabel.setText("duration: "+time);
            };
            timer = new Timer(1000, timerListener);
            timer.setInitialDelay(0);
            timer.start();
        }
        if (e.getSource() == button_quit) {
            System.exit(0);
        }
    }

    public static Clip playSong(String name){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/MyGame/songs/"+name).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

}
