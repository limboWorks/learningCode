/**
 * Created by star on 04.12.2016.
 */
import javax.swing.*;
import java.awt.*;
public class FirstGui extends JFrame {

    private JLabel label;
    private JButton button;
    private JTextField textField;

    public FirstGui(){
        setLayout(new FlowLayout());

        label = new JLabel("Suck my clit");
        add(label);

        textField = new JTextField(15);
        add(textField);

        button = new JButton("Click ma nipps");
        add(button);
    }

    public static void main(String[] args) {
        FirstGui gui = new FirstGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 200);
        gui.setVisible(true);
        gui.setTitle("LimboWorks");

    }

}
