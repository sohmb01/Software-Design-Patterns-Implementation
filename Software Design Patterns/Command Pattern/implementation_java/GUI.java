import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class GUI extends JFrame implements ActionListener {

    private JButton addButton;
    private JButton deleteButton;
    private JButton undoButton;
    private JButton redoButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private Controller controller;
    

    public GUI() {
        super("Item Manager");

        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Content");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        undoButton.addActionListener(this);
        redoButton.addActionListener(this);

        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        controller = new Controller();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void display(ArrayList<Item> itemsList){
        tableModel.setRowCount(0);
        for (Item item : itemsList){
            Object[] row = {item.getID(), item.getContent()};
            tableModel.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            
            AddDialog dialog = new AddDialog(this);
            dialog.setVisible(true);
            if (dialog.isOK()) {
                
                String id = dialog.getID();
                String content = dialog.getContent();
                Item item = new Item(id, content);
                ArrayList<Item> itemsList = controller.addItem(item);
                display(itemsList);

            }
        } else if (e.getSource() == deleteButton) {
           
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                Item item = new Item((String)tableModel.getValueAt(selectedRow, 0), (String)tableModel.getValueAt(selectedRow, 1));
                ArrayList<Item> itemsList = controller.deleteItem(item);
                display(itemsList);
                
            }
        } else if (e.getSource() == undoButton) {
            
            ArrayList<Item> itemsList = controller.undoOperation();
            display(itemsList);
            
        } else if (e.getSource() == redoButton) {

            ArrayList<Item> itemsList = controller.redoOperation();
            display(itemsList);
            
        }
    }
    public static void main(String args[]) {
            EventQueue.invokeLater(new Runnable() {
               public void run() {
                  try {
                     GUI window = new GUI();
                     window.setVisible(true);
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            });
         }
}