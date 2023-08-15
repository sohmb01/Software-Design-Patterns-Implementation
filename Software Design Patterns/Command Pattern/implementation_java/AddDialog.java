import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JDialog implements ActionListener {

    private JTextField idField;
    private JTextField contentField;
    private JButton okButton;
    private JButton cancelButton;
    private boolean isOK;

    public AddDialog(Frame parent) {
        super(parent, "Add Item", true);
        setLayout(new GridLayout(3, 2));
        setSize(300, 120);

        // Set up the ID field
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        add(idLabel);
        add(idField);

        // Set up the content field
        JLabel contentLabel = new JLabel("Content:");
        contentField = new JTextField();
        add(contentLabel);
        add(contentField);

        // Set up the OK and Cancel buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel);

        setLocationRelativeTo(parent);
    }

    public String getID() {
        return idField.getText();
    }

    public String getContent() {
        return contentField.getText();
    }

    public boolean isOK() {
        return isOK;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            isOK = true;
            setVisible(false);
        } else if (e.getSource() == cancelButton) {
            isOK = false;
            setVisible(false);
        }
    }
}
