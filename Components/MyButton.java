package MyGame.Components;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class MyButton extends JButton {
    private final Icon content;
    private boolean state;

    public MyButton(ImageIcon content) {
        this.content = content;
        this.state = false;
        super.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/unknown.png"))));
        super.setEnabled(false);
        super.setForeground(Color.WHITE);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setPreferredSize(new Dimension(80, 80));
        super.setHorizontalAlignment(SwingConstants.CENTER);
        super.setHorizontalTextPosition(SwingConstants.CENTER);
        super.setFont(new Font("Arial", Font.BOLD, 18));
    }
    public void Show(){
        super.setIcon(content);
        super.setEnabled(true);
        this.state=true;
    }

    public void Hide(){
        super.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/unknown.png"))));
        this.state=false;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean b) {
        this.state=b;
    }
}
