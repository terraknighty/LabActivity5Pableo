package SimpleCalc;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        try{
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
        }catch (ArithmeticException e){
            JOptionPane.showMessageDialog(panel, "You cannot divide with 0 as your second number...", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(panel, "Invalid input...", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
