import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class events extends JFrame{

    private JLabel label;
    private JButton button;
    private int count = 0;

    public events(){
        setLayout(new FlowLayout());

        button = new JButton("Click for text");
        add(button);

        label = new JLabel("");
        add(label);

        event e = new event();
        button.addActionListener(e);
    }

    public class event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            label.setText(toString(count));


        }
    }
}
