package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;

public class LeapYearGUI extends JFrame{
    private JPanel panel;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI(){
//        try{
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLeapYear();
            }
        });

        tfYear.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    checkLeapYear();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel);
        app.setSize(400, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Leap Year Checker");
    }

    public void checkLeapYear(){
        try{
            int year = Integer.parseInt(tfYear.getText());
            if(year < 0 ){
                throw new InputMismatchException("Input must not be a negative number");
            }else if (year == 0){
                throw new InputMismatchException("Input must be a nonzero");
            }
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        JOptionPane.showMessageDialog(panel, "Leap Year");
                    } else {
                        JOptionPane.showMessageDialog(panel, "Not a leap year");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Leap Year");
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Not a leap year");
            }
        }catch (InputMismatchException e){
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(panel, "Input must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}