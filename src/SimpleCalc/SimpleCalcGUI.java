package SimpleCalc;

import LeapYear.LeapYearGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel;
    private JTextField  tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;


    public SimpleCalcGUI(){

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

    }

    public static void main(String[] args) {
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.panel);
        app.setSize(550, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Simple Calculator");
    }

    public void calculate(){
        int firstNum = Integer.parseInt(tfNumber1.getText());
        int secondNum = Integer.parseInt(tfNumber2.getText());
        int operation = cbOperations.getSelectedIndex();
        int result = 0;
        switch (operation) {
            case 0:
                result = firstNum + secondNum;
                break;
            case 1:
                result = firstNum - secondNum;
                break;
            case 2:
                result = firstNum * secondNum;
                break;
            case 3:
                result = firstNum / secondNum;
                break;
        }
        lblResult.setText(Integer.toString(result));
    }
}
