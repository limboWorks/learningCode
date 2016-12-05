import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class events extends JFrame{

    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    static Integer count1 = 0;
    static Integer count2 = 0;

    public events(){
        setLayout(new FlowLayout());

        button1 = new JButton("Count 1");
        add(button1);
        button2 = new JButton("Count 2");
        add(button2);

        label1 = new JLabel("");
        add(label1);
        label2 = new JLabel("");
        add(label2);

        event e = new event();
        button1.addActionListener(e);

        event2 ev = new event2();
        button2.addActionListener(ev);
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label1.setText(count1.toString());
            count1++;
        }
    }

    public class event2 implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            label2.setText(count2.toString());
            count2++;
        }
    }

        public static void main(String[] args) {
            events gui = new events();
            gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            gui.setTitle("The magnificend counter");
            gui.setSize(400,200);
            gui.setVisible(true);
        }
    }

