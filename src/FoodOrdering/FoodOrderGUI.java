package FoodOrdering;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame {
    private JPanel panel;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    private List <JCheckBox> coFoods;
    private List <JRadioButton> coDiscount;

    public FoodOrderGUI(){
        coFoods = new ArrayList<>();
        coFoods.add(cPizza);
        coFoods.add(cBurger);
        coFoods.add(cFries);
        coFoods.add(cSoftDrinks);
        coFoods.add(cTea);
        coFoods.add(cSundae);
        coDiscount = new ArrayList<>();
        coDiscount.add(rbNone);
        coDiscount.add(rb5);
        coDiscount.add(rb10);
        coDiscount.add(rb15);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computerOrder();
            }
        });
    }
    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.panel);
        app.setSize(550, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Food Ordering System");
    }

    public void computerOrder(){
       try{
            double total = 0;
            boolean flagFood = false;
            boolean flagDiscount = false;
            for (JCheckBox cb : coFoods) {
                if (cb.isSelected()) {
                    flagFood = true;
                    if (cb == cPizza) {
                        total += 100;
                    } else if (cb == cBurger) {
                        total += 80;
                    } else if (cb == cFries) {
                        total += 65;
                    } else if (cb == cSoftDrinks) {
                        total += 55;
                    } else if (cb == cTea) {
                        total += 50;
                    } else if (cb == cSundae) {
                        total += 40;
                    }
                }
            }
            if(!flagFood) {
                throw new Exception("You must select at least one food option");
            }
            for (JRadioButton cb : coDiscount) {
                if (cb.isSelected()) {
                    flagDiscount = true;
                    if (cb == rbNone) {
                        //None
                    } else if (cb == rb5) {
                        total -= (total * .05);
                    } else if (cb == rb10) {
                        total -= (total * .1);
                    } else if (cb == rb15) {
                        total -= (total * .15);
                    }
                }
            }
            if(!flagDiscount){
                throw new Exception("You must provide a discount option");
            }
            JOptionPane.showMessageDialog(panel, String.format("The total price is Php %.2f", total));
        }catch (Exception e){
           JOptionPane.showMessageDialog(panel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
    }


}
