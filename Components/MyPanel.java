package MyGame.Components;
import java.util.Collections;
import javax.swing.*;
import java.util.ArrayList;

public class MyPanel extends  JPanel{
    private final Buttons buttons;
    public Buttons getButtons() {
        return buttons;
    }

    public MyPanel(){
        this.buttons=new Buttons();
        draw();
    }
    public void draw(){
        super.removeAll();
        super.updateUI();
        ArrayList<MyButton> btns=listbtns(this.buttons);
        for (MyButton btn : btns) {
            super.add(btn);
        }
    }
    public ArrayList<MyButton> listbtns(Buttons btns){
        ArrayList<MyButton> list=new ArrayList<>();
        for (int i=0;i<btns.size();i++) {
            list.add(Buttons.btns.get(i).btn1);
            list.add(Buttons.btns.get(i).btn2);
        }
        Collections.shuffle(list);
        return list;
    }
}

