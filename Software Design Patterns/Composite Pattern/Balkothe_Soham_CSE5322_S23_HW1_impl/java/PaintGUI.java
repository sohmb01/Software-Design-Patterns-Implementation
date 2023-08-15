
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class PaintGUI extends JFrame {
   private GUIController controller;
   Canvas canvas = new Canvas();
   JPanel panel;
   JPanel sidePanel = new JPanel();
   BorderLayout borderLayout = new BorderLayout();
   JButton boxButton = new JButton(" Box ");
   JButton circleButton = new JButton(" Circle ");
   JButton triangleButton = new JButton(" Triangle ");

   public PaintGUI() {
      super();
      try {
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         jbInit();
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }

   public GUIController getController() {
      return controller;
   }

   private void jbInit() throws Exception {
      canvas.setBackground(Color.white);
      canvas.setVisible(true);
      setSize(new Dimension(800, 600));
      setTitle("Paint GUI");
      panel = (JPanel) getContentPane();
      panel.setLayout(borderLayout);
      sidePanel.setPreferredSize(new Dimension(100, 200));
      panel.add(canvas, java.awt.BorderLayout.CENTER);
      panel.add(sidePanel, java.awt.BorderLayout.WEST);
      
      sidePanel.add(circleButton);
      sidePanel.add(triangleButton);
      sidePanel.add(boxButton);
      
      controller = new GUIController();

      /* Button configuration */
      canvas.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            Graphics g = canvas.getGraphics();

            controller.mouseClicked((int) e.getPoint().getX(),
                  (int) e.getPoint().getY(), g);
         }
      });

      
      circleButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            controller.selectCircle();
         }
      });

      boxButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            controller.selectBox();
         }
      });

      triangleButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            controller.selectTriangle();
         }
      });

   }

   public static void main(String args[]) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               PaintGUI window = new PaintGUI();
               window.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}
