import java.awt.BorderLayout;
import javax.swing.*;

public class Shop {
    private JFrame parentFrame;

    public Shop(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    //visit the shop
    public void visitShop(Player player) {
        String[] options = {"Buy Healing Potion (10 Gold)", "Buy Strength Potion (15 Gold)", "Buy Prayer Bead (20 Gold)", "Leave Shop"};
        int choice = JOptionPane.showOptionDialog(parentFrame, "Welcome to the shop! What would you like to buy?",
            "Shop", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            //buy items
            switch (choice) {
                case 0 -> {
                    if (player.getMoney() >= 10) {
                        player.addPotion(1);
                        player.setMoney(player.getMoney() - 10);
                        showMessage("You bought a Healing Potion.");
                    } else {
                        showMessage("Not enough gold!");
                    }
                }
                case 1 -> {
                    if (player.getMoney() >= 15) {
                        player.addStrengthPotion(1);
                        player.setMoney(player.getMoney() - 15);
                        showMessage("You bought a Strength Potion.");
                    } else {
                        showMessage("Not enough gold!");
                    }
                }
                case 2 -> {
                    if (player.getMoney() >= 20) {
                        player.addPrayerBeads(2);
                        player.setMoney(player.getMoney() - 20);
                        showMessage("You bought 2 Prayer Beads.");
                    } else {
                        showMessage("Not enough gold!");
                    }
                }
                case 3 -> showMessage("Thank you for visiting the shop!");
            }
    }

    //show message dialog
    private void showMessage(String message) {
        JDialog dialog = new JDialog(parentFrame, "Message", true);
        dialog.getContentPane().add(new JLabel(message), BorderLayout.CENTER);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }
}
