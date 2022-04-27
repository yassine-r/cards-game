package MyGame.Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MyGame.Graphic;

import javax.swing.*;

public class CoupleButtons implements ActionListener {
    MyButton btn1;
    MyButton btn2;
    int score;

    public CoupleButtons(MyButton btn1, MyButton btn2) {
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.score = 0;
    }

    public void Show() {
        btn1.Show();
        btn2.Show();
    }

    public void Show(MyButton btn) {
        btn.Show();
    }

    public void Hide() {
        if (this.score == 0) {
            btn1.Hide();
            btn2.Hide();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn1) {
            process(this.btn1,this.btn2);
        }
        if (e.getSource() == this.btn2) {
            process(this.btn2,this.btn1);
        }
    }
    public void process(MyButton btn1,MyButton btn2){
        if (Buttons.getState()) {
            this.Show(btn1);
            if (btn2.getState()) {
                if (score==0){
                    score = 5;
                    if(Graphic.score<Buttons.images.length*5){
                        Graphic.score += score;
                    }
                    if(Graphic.score==Buttons.images.length*5){
                        Graphic.timer.stop();
                        Graphic.winnnerlabel.setText("                      You win!                      ");
                        Graphic.clip=Graphic.playSong("Success.wav");
                    }
                    Graphic.scoreLabel.setText("Score: " + Graphic.score);
                    Buttons.setState(false);
                }

            } else {
                Buttons.setState(false);
                lock(500);
            }
        } else {
            this.Show(btn1);
            Buttons.setState(true);
        }
    }
    public static void lock(int mil) {
        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(mil);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Buttons.Hide();
        });
    }
    public void setState2(boolean b) {
        this.score=0;
        this.btn1.setState(b);
        this.btn2.setState(b);
    }
}
