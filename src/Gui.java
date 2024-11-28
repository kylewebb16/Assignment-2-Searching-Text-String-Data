import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Gui extends JFrame{
    public Gui() {
        JFrame mainFrame = new JFrame("String Search");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.getContentPane().setLayout(new GridBagLayout());

        createInstructionsPanel(mainFrame);
        createButtons(mainFrame);


        mainFrame.setSize(1024, 576);
        mainFrame.setVisible(true);
    }

    
    private static void createInstructionsPanel(JFrame mainFrame) {
        JLabel instructionsLabel = new JLabel();
        instructionsLabel.setText("<html><h1>Use the buttons to:</h1></html>");
        instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionsLabel.setBorder(BorderFactory.createLineBorder(Color.blue));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.PAGE_START;
        mainFrame.getContentPane().add(instructionsLabel, gbc);
    }

    private static class MyButton extends JButton{
        public MyButton(ImageIcon icon, String buttonText){
            this.setText("<html><h2>" + buttonText + "</h2></html>");
            this.setPreferredSize(new Dimension(200, 50));
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.setFocusPainted(false);
        }
    }
    
    private static void createButtons(JFrame mainFrame) {

        // Create print button at grid (x,y) = (0,1)
        MyButton printButton1 = new MyButton(new ImageIcon("../images/keyboard (1).png"), "1: Print Text");
        GridBagConstraints b1Constraints = new GridBagConstraints();
        b1Constraints.gridx = 0;
        b1Constraints.gridy = 1;
        b1Constraints.insets = new Insets(16, 32, 16, 32);
        mainFrame.getContentPane().add(printButton1, b1Constraints);


        // Create search button at grid (x,y) = (1,1)
        MyButton searchButton2 = new MyButton(new ImageIcon("../images/keyboard (2).png"), "2: Search Text");
        GridBagConstraints b2Constraints = new GridBagConstraints();
        b2Constraints.gridx = 1;
        b2Constraints.gridy = 1;
        b2Constraints.insets = new Insets(16, 32, 16, 32);
        mainFrame.getContentPane().add(searchButton2, b2Constraints);


        // Create exit button at grid (x,y) = (2,1)
        MyButton exitButton3 = new MyButton(new ImageIcon("../images/keyboard (3).png"), "3: Exit Program");
        GridBagConstraints b3Constraints = new GridBagConstraints();
        b3Constraints.gridx = 2;
        b3Constraints.gridy = 1;
        b3Constraints.insets = new Insets(16, 32, 16, 32);
        mainFrame.getContentPane().add(exitButton3, b3Constraints);

        // Create actions

        // Create and map action for print button
        Action printAction = new AbstractAction() {
            // Shows the searchable text and disables the print button
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                printButton1.setEnabled(false);
                createOutputText(mainFrame);
            }
        };
        // Map action to keybinding and button
        printButton1.addActionListener(printAction);
        printButton1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "printText");
        printButton1.getActionMap().put("printText", printAction);

        // Create and map action for searchButton
        Action searchAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = JOptionPane.showInputDialog(mainFrame, "Enter a search term");
                if (searchTerm != null) {
                    ArrayList<Integer> results = StringSearch.BMAlgorithm(getStatesString(), searchTerm);
                    if (results.isEmpty()) JOptionPane.showMessageDialog(mainFrame, "No occurances of '" + searchTerm + "' found.");
                    else JOptionPane.showMessageDialog(mainFrame, "Found '" + searchTerm + "' at index\n" + results);
                }
            }
        };
        searchButton2.addActionListener(searchAction);
        searchButton2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "searchText");
        searchButton2.getActionMap().put("searchText", searchAction);

        Action exitAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(mainFrame, "Do you want to exit the program?", "Exit Program?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) System.exit(0);
            }
        };
        exitButton3.addActionListener(exitAction);
        exitButton3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"), "exit");
        exitButton3.getActionMap().put("exit", exitAction);
    }

    private static void createOutputText(JFrame mainFrame) {
        Font outputFont = new Font("Arial Bold", Font.BOLD, 15);

        JTextPane outputEditorPane = new JTextPane();
        outputEditorPane.setText("String Contents:\n" + getStatesString());
        outputEditorPane.setFont(outputFont);
        outputEditorPane.setOpaque(false);
//        outputEditorPane.setLineWrap(true);
//        outputEditorPane.setWrapStyleWord(true);
        outputEditorPane.setEditable(false);
        outputEditorPane.setPreferredSize(new Dimension(400, 155));
        outputEditorPane.setBorder(BorderFactory.createLineBorder(Color.red));

        // Positioning row 2, column 0, fill horizontal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.ipadx = 10;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_END;

        mainFrame.getContentPane().add(outputEditorPane, gbc);
//        mainFrame.pack();
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
