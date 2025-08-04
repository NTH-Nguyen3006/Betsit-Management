
package ui.controller;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.ChangePasswordJDialog;
import ui.LoginJDialog;
import ui.WelcomeJDialog;
import ui.manager.ContractManagerJDialog;
import ui.manager.PaymentManagerJDialog;
import ui.manager.RolesManagerJDialog;
import ui.manager.RoomManagerJDialog;
import ui.manager.ServiceManagerJDialog;
import ui.manager.TenantsManagerJDialog;
import ui.manager.UserManagerJDailog;
import utils.XDialog;

public interface BedsitController {
    void init();

    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new LoginJDialog(frame, true));
    }

    default void showUserManagerJDialog(JFrame frame) {
         this.showJDialog(new UserManagerJDailog(frame, true));
    }

    default void showTenantsManagerJDialog(JFrame frame) {
         this.showJDialog(new TenantsManagerJDialog(frame, true));
    }

    default void showContractsManagerJDialog(JFrame frame) {
         this.showJDialog(new ContractManagerJDialog(frame, true));
    }

    default void showInvoicesManagerJDialog(JFrame frame) {

    }

    default void showPaymentsManagerJDialog(JFrame frame) {
         this.showJDialog(new PaymentManagerJDialog(frame, true));
    }

    default void showServicesManagerJDialog(JFrame frame) {
         this.showJDialog(new ServiceManagerJDialog(frame, true));
    }

    default void showRoomManagerJDialog(JFrame frame) {
         this.showJDialog(new RoomManagerJDialog(frame, true));
    }

    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }

    default void showRoleJDialog(JFrame frame) {
        this.showJDialog(new RolesManagerJDialog(frame, true));
    }
}
