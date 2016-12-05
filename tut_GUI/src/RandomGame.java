import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomGame extends JFrame {
    int randomNum, guess;
    private JButton button;
    private JTextField textField;
    private JLabel promptLabel;
    private JLabel resultLabel;
    private JLabel randomLabel;

    public RandomGame(){
        setLayout(new FlowLayout());

        promptLabel = new JLabel("Enter a random number 1-13");
        add(promptLabel);

        textField = new JTextField(5);
        add(textField);

        button = new JButton("Enter a guess...");
        add(button);

        resultLabel = new JLabel("");
        add(resultLabel);

        randomLabel = new JLabel("");
        add(randomLabel);

        event e = new event();
        button.addActionListener(e);
    }

    public class event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            randomNum = (int)(Math.random()*10 + 1);
            try {
                guess = (int)(Double.parseDouble(textField.getText()));
                if(guess==randomNum){
                    resultLabel.setText("You won!");
                }else{
                    resultLabel.setText("You lost!");
                }
                randomLabel.setText("The Random Number was:" + randomNum);

            }catch (Exception ex){
                randomLabel.setText("Please enter numbers only!");
            }
        }
    }

    public static void main(String[] args) {
        RandomGame gui = new RandomGame();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(300,150);
        gui.setTitle("The Random Game");
    }

}
