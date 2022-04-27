package MyGame.Components;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Buttons {

    static ArrayList<CoupleButtons> btns;
    private static boolean State;
    static String[] images;

    public Buttons() {
        images= new String[]{"coffee.png", "house.png", "man.png", "mobile.png", "river.png", "snowman.png", "vehicle.png", "woman.png","pens.png","bird.png"};
        btns=new ArrayList<>();
        State=false;
        for (String image : images) {
            MyButton btn1 = new MyButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/" + image))));
            MyButton btn2 = new MyButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/" + image))));
            Buttons.btns.add(new CoupleButtons(btn1, btn2));
        }
    }

    public static boolean getState() {
        return Buttons.State;
    }

    public static void setState(boolean State) {
        Buttons.State = State;
    }

    public static void setState2(boolean state){
        for(CoupleButtons cpbtn:btns){
            cpbtn.setState2(false);
        }
    }

    public int size(){
        return Buttons.btns.size();
    }

    public void Show(){
        for (int i=0;i<images.length;i++){
            Buttons.btns.get(i).Show();
        }
    }
    public static void Hide(){
        for (int i=0;i<images.length;i++){
            Buttons.btns.get(i).Hide();
        }
    }
}
