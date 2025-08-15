
package ui.manager;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import utils.XDate;

public class test {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(XDate.format(new Date().getTime()));
    }
}
