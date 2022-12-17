package SimpleCalc;

import LeapYear.LeapYearGUI;

import javax.swing.*;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel;
    private JTextField  tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public static void main(String[] args) {
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.panel);
        app.setSize(550, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Simple Calculator");
    }
}
