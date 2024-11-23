import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Gui {
    public Gui() {
        createFrame();
    }
    private static void createFrame() {
        JFrame mainFrame = new JFrame("String Search");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.getContentPane().setLayout(new BorderLayout());

        createInstructionsPanel(mainFrame);


        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private static void createInstructionsPanel(JFrame mainFrame) {
        JTextArea instructionsTextArea = new JTextArea();
        instructionsTextArea.setText("Use the buttons to display the provided text, search for text in the program, and exit the program");
        instructionsTextArea.setOpaque(true);
        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setPreferredSize(new Dimension(30, 50));

        mainFrame.getContentPane().add(instructionsTextArea, BorderLayout.PAGE_START);
    }
}
