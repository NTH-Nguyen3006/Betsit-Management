package utils;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
public class XOther {
    public static boolean hasTextFieldEmpty(JTextComponent... fields) {
        for (JTextComponent field : fields) {
            if (field.getText().isEmpty())
                return true;
        }
        return false;
    }
    public static boolean hasJRadioButtonEmty(JToggleButton ... buttons){
        for (JToggleButton btn : buttons) {
            if (btn.isSelected()) {
                return true;
            }
        }
        return false;
    }
    public static void setEmptyField(JTextComponent... fields) {
        for (JTextComponent field : fields)
            field.setText("");
    }
}
