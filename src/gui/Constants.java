package gui;

import java.awt.*;

public final class Constants {

    // The width of the application window.
    public static final int WINDOW_WIDTH = 700;

    // The height of the application window.
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH * 2 / 3;

    public static final Font SCREEN_FONT = new Font("Serif", Font.BOLD, 40);
    public static final Font BUTTON_FONT = new Font("Serif", Font.BOLD, 20);

    // Number button constants
    public static final String DECIMAL_POINT = ".";
    public static final String LEADING_DECIMAL = "0.";
    public static final String DOUBLE_ZERO = "00";

    // The initial value on the screen / the value when the screen is cleared.
    public static final String START_SCREEN = LEADING_DECIMAL + DOUBLE_ZERO;

    // Button string constants
    public static final String RECORD_PURCHASE = "Record Purchase";
    public static final String ENTER_PAYMENT = "Enter Payment";
    public static final String ADD_MONEY = "Add Money";
    public static final String REGISTER_TOTAL = "Register Total";
    public static final String CLEAR = "Clear";
    public static final String ENTER = "= / Enter";
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "x";
    public static final String DIVIDE = "/";
}
