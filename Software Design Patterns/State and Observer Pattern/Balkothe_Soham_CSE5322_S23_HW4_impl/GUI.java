import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener {
    private static final int ROWS = 15;  // Number of rows in the lawn
    private static final int COLS = 15;  // Number of columns in the lawn
    private static final int CELL_SIZE = 40;  // Size of each cell in pixels
    private static final int DELAY = 500;  // Delay between painting cells in milliseconds
    
    private boolean painting = false;  // Whether the lawn is being painted
    private boolean[][] painted = new boolean[ROWS][COLS];  // Whether each cell has been painted
    private int row = 0;  // Current row being painted
    private int col = 0;  // Current column being painted
    private int dir = 1;  // Direction of painting (1 = right, -1 = left)
    
    private JButton startButton;  // Button to start painting
    private JButton stopButton;  // Button to stop painting
    private Controller controller;
    private int[] cellPosition = new int[2];

    public GUI() {
        // Set the preferred size of the panel to fit the entire lawn
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        
        // Create the start button
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        setBackground(Color.GREEN);
        // Create the stop button
        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        
        // Add the buttons to the panel
        add(startButton);
        add(stopButton);
        controller = new Controller();
    }
    
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Start painting
            controller.setMoverOn(true);
            controller.mowLawn();
            int [] cellPosition = controller.getPosition();
            repaint();
        } else if (e.getSource() == stopButton) {
            // Stop painting
            controller.setMoverOn(false);
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Paint the cells that have been painted so far
        g.setColor(Color.GREEN.darker());
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (painted[i][j]) {
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        
        // If painting is in progress, paint the next cell
        if (painting) {
            row = cellPosition[0];
            col = cellPosition[1];
            painted[row][col] = true;
            g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            
            
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
            }
            
            // Repaint the panel to show the newly painted cell
            repaint();
        }
    }
    
    public static void main(String[] args) {
        // Create the window and set the content pane to the lawn painter panel
        JFrame frame = new JFrame("Lawn Painter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI());
        frame.pack();
        frame.setVisible(true);
    }
}
