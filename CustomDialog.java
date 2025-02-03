import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CustomDialog extends JDialog {
    public CustomDialog(JFrame parent, String title, String message) {
        super(parent, title, true);

        //create a panel
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(message);
        label.setForeground(Color.white);
        panel.add(label, BorderLayout.CENTER);
        
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //add panel to the dialog
        panel.add(okButton, BorderLayout.SOUTH);
        panel.setBackground(Color.darkGray);
        getContentPane().add(panel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
    }
}
