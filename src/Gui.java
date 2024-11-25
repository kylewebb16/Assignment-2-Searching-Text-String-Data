import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class Gui {
    public Gui() {
        JFrame mainFrame = new JFrame("String Search");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.getContentPane().setLayout(new GridBagLayout());

        createInstructionsPanel(mainFrame);
        createButtons(mainFrame);
    
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    
    private static void createInstructionsPanel(JFrame mainFrame) {
        JLabel instructionsLabel = new JLabel();
        instructionsLabel.setText("<html><h2>Use the buttons to display the provided text, search for text in the program, and exit the program<h2></html>");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.ipadx = 10;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        mainFrame.getContentPane().add(instructionsLabel, gbc);
    }

    private static class MyButton extends JButton{
        public MyButton(ImageIcon icon, String buttonText){
            this.setText(buttonText);
            this.setIcon(icon);
            this.setPreferredSize(new Dimension(200, 70));
            this.setIconTextGap(20);
            this.setHorizontalAlignment(SwingConstants.LEFT);
            this.setFocusPainted(false);
        }
    }
    
    private static void createButtons(JFrame mainFrame) {
        
        MyButton printButton1 = new MyButton(new ImageIcon("../images/keyboard (1).png"), "<html><h2>Print Text</h2></html>");
        GridBagConstraints b1Constraints = new GridBagConstraints();
        b1Constraints.gridx = 2;
        b1Constraints.gridy = 1;
        b1Constraints.insets = new Insets(2, 0, 2, 0);
        mainFrame.getContentPane().add(printButton1, b1Constraints);
        
        
        MyButton searchButton2 = new MyButton(new ImageIcon("../images/keyboard (2).png"), "<html><h2>Search Text</h2></html>");
        GridBagConstraints b2Constraints = new GridBagConstraints();
        b2Constraints.gridx = 2;
        b2Constraints.gridy = 2;
        b2Constraints.insets = new Insets(2, 0, 2, 0);
        mainFrame.getContentPane().add(searchButton2, b2Constraints);
        
        
        MyButton exitButton3 = new MyButton(new ImageIcon("../images/keyboard (3).png"), "<html><h2>Exit Program</h3></html>");
        GridBagConstraints b3Constraints = new GridBagConstraints();
        b3Constraints.gridx = 2;
        b3Constraints.gridy = 3;
        b3Constraints.insets = new Insets(2, 0, 2, 0);
        mainFrame.getContentPane().add(exitButton3, b3Constraints);

        Action printAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createOutputText(mainFrame);
            }
        };
        printButton1.addActionListener(printAction);
        printButton1.getInputMap().put(KeyStroke.getKeyStroke("1"), "printText");
        printButton1.getActionMap().put("printText", printAction);
    }

    private static void createOutputText(JFrame mainFrame) {
        Font outputFont = new Font("Arial Bold", Font.BOLD, 15);

        JTextArea outputEditorPane = new JTextArea();
        outputEditorPane.setText("String Contents:\n" + getStatesString());
        outputEditorPane.setFont(outputFont);
        outputEditorPane.setOpaque(false);
        outputEditorPane.setLineWrap(true);
        outputEditorPane.setWrapStyleWord(true);
        outputEditorPane.setEditable(false);
        outputEditorPane.setPreferredSize(new Dimension(400, 120));

        // Positioning row 2, column 0, fill horizontal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.ipadx = 10;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;

        mainFrame.getContentPane().add(outputEditorPane, gbc);
        mainFrame.pack();
    }

    
    public static String getStatesString() {
        // Add 50 states to a string
        return "Alabama, " + "Alaska, " + "Arizona, " +
                "Arkansas, " + "California, " + "Colorado, " +
                "Connecticut, " + "Delaware, " + "Florida, " +
                "Georgia, " + "Hawaii, " + "Idaho, " +
                "Illinois, " + "Indiana, " + "Iowa, " +
                "Kansas, " + "Kentucky, " + "Louisiana, " +
                "Maine, " + "Maryland, " + "Massachusetts, " +
                "Michigan, " + "Minnesota, " + "Mississippi, " +
                "Missouri, " + "Montana, " + "Nebraska, " +
                "Nevada, " + "New Hampshire, " + "New Jersey, " +
                "New Mexico, " + "New York, " + "North Carolina, " +
                "North Dakota, " + "Ohio, " + "Oklahoma, " +
                "Oregon, " + "Pennsylvania, " + "Rhode Island, " +
                "South Carolina, " + "South Dakota, " + "Tennessee, " +
                "Texas, " + "Utah, " + "Vermont, " +
                "Virginia, " + "Washington, " + "West Virginia, " +
                "Wisconsin, " + "Wyoming";
    }
}
