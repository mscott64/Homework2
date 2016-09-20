package gui;

import app.CashRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashBox extends JFrame {

    /* Feel free to add more instance variables. */
    private boolean isScreenCleared = true;
    private JLabel screen;
    private CashRegister cr = new CashRegister();

    /**
     * Sets up the Cash Register GUI. I can't call it CashRegister
     * because that's already the name of the CashRegister class.
     */
    public CashBox() {
        setTitle("Cash Register");
        Container c = this.getContentPane();
        c.add(createScreen(), BorderLayout.PAGE_START);
        c.add(getKeys(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setVisible(true);//making the frame visible

    }

    /**
     * Creates the JLabel that represents the screen of the CashBox.
     * The screen is where the numbers are displayed.
     * You shouldn't need to make any changes to this method.
     */
    private JLabel createScreen() {
        screen = new JLabel();
        screen.setOpaque(true);
        screen.setBackground(Color.WHITE);
        screen.setFont(Constants.SCREEN_FONT);
        screen.setText(Constants.START_SCREEN);
        return screen;
    }

    /**
     * Returns the panel containing all of the keys available to this cash box.
     * You shouldn't need to make any changes to this method.
     */
    private JPanel getKeys() {
        JPanel keys = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        keys.add(getNumberButtons());
        keys.add(getOtherKeys());
        return keys;
    }

    /**
     * This creates the grid with the numbers 9 down to 00 and the decimal point.
     * You shouldn't need to make any changes to this method.
     */
    private JPanel getNumberButtons() {
        JPanel numbers = new JPanel(new GridLayout(4, 3, 10, 10));
        for (int i = 9; i >= 0; i--) {
            numbers.add(createNumberButton(Integer.toString(i)));
        }
        numbers.add(createNumberButton("00"));
        numbers.add(createNumberButton("."));
        return numbers;
    }

    /**
     * Creates a number button that appends it's value to the screen
     * when pressed.
     * You shouldn't need to make any changes to this method.
     */
    private JButton createNumberButton(final String text) {
        JButton button = createButtonWithFont(text);
        button.setBackground(Color.CYAN);
        button.setPreferredSize(new Dimension(55, 55));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isScreenCleared) {
                    // If the screen is clear, decimal point and double zero behave differently.
                    switch(text) {
                        case Constants.DOUBLE_ZERO: // do nothing
                            return;
                        case Constants.DECIMAL_POINT: // Create decimal point with leading zero.
                            screen.setText(Constants.LEADING_DECIMAL);
                            break;
                        default: // Set this new value as the screen value.
                            screen.setText(text);
                            break;
                    }
                    isScreenCleared = false;
                } else {
                    // Append this text to the existing screen text.
                    String screenText = screen.getText();
                    switch(text) {
                        case Constants.DECIMAL_POINT:
                            // Don't add another decimal point if there's already one.
                            if (!screenText.contains(Constants.DECIMAL_POINT)) {
                                screen.setText(screenText.concat(Constants.DECIMAL_POINT));
                            }
                            break;
                        default:
                            screen.setText(screenText.concat(text));
                            break;
                    }
                }
            }
        });
        return button;
    }

    /**
     * Each of these buttons needs to be implemented correctly.
     *
     * The names that match methods in the cash register should call
     * that method in the cash register with whatever value is on the screen.
     * *** TODO: You need to add a button "Give change" that calls the give change method in CashRegister. ***
     * If that method returns some value, then that returned value should be displayed on the screen.
     *
     * The operators (+, -, *, /, =/Enter) should operate just like the calculator.
     * A value is entered. Then an operator is pressed. Then the second value is typed in.
     * No matter what the next button pressed is, the result of the first operation should be displayed
     * on the screen and should be the input for the method called or
     * the first operand of the next operator pressed.
     *
     * I've already started the createOtherButton helper method that you should add the ENTER functionality to.
     * Also you should implement the createCalculatorButton and createCashRegisterButton methods.
     */
    public JPanel getOtherKeys() {
        JPanel keys = new JPanel(new GridLayout(6, 2, 3, 3));
        // Add each of the required keys to the panel.
        keys.add(createCashRegisterButton(Constants.RECORD_PURCHASE));
        keys.add(createCashRegisterButton(Constants.ENTER_PAYMENT));
        /*** TODO: Add Give Change button here ***/
        keys.add(createCashRegisterButton(Constants.ADD_MONEY));
        keys.add(createCashRegisterButton(Constants.REGISTER_TOTAL));
        keys.add(createCalculatorButton(Constants.CLEAR));
        keys.add(createCalculatorButton(Constants.ADD));
        keys.add(createCalculatorButton(Constants.SUBTRACT));
        keys.add(createCalculatorButton(Constants.MULTIPLY));
        keys.add(createCalculatorButton(Constants.DIVIDE));
        keys.add(createCalculatorButton(Constants.ENTER));

        // Sets all of the keys to the same size and gives them a red outline.
        for (Component key : keys.getComponents()) {
            key.setPreferredSize(new Dimension(175, 50));
            key.setBackground(Color.RED);
        }
        return keys;
    }

    /**
     * This is where you will implement the calculator buttons (+, -, *, /, =/Enter)
     * I've already implemented the CLEAR button.
     */
    private JButton createCalculatorButton(final String text) {
        JButton button = createButtonWithFont(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(text) {
                    case Constants.CLEAR: // Clear the screen to its original value
                        isScreenCleared = true;
                        screen.setText(Constants.START_SCREEN);
                        break;
                    case Constants.ADD:
                        break;
                    default: // do nothing
                        break;
                }
            }
        });
        return button;
    }

    /**
     * This is where you will implement the buttons that call CashRegister methods.
     * Record purchase, Enter payment, Add money, Register total
     *
     * The returned values should never use more than two decimal places.
     * So if a user calls Register total, the total should read 13.85 (hint: String.format())
     */
    private JButton createCashRegisterButton(final String text) {
        /* Implement this */
        return createButtonWithFont(text);
    }

    /**
     * This method creates a button with the preferred font and sets the opacity
     * to true to allow the color of the button to show.
     * You shouldn't need to make any changes to this method.
     */
    private JButton createButtonWithFont(String text) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setFont(Constants.BUTTON_FONT);
        return button;
    }

    // Use this to start up the GUI.
    public static void main(String[] argv) {
        CashBox cb = new CashBox();
    }
}
