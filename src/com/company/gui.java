package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class gui {

    private JComboBox comboBox1, comboBox2;
    private JPanel pan1;
    private JPanel maps;
    private JPanel Library1, Library2, Library3, Library4, Library5;
    private JButton button1;
    private JPanel Theparade;
    private JPanel first, second, third;
    private JButton confirmRoomButton;
    private JLabel library1Label, library2Label, library3Label, library4Label, library5Label;
    private JLabel ParadeLabel;
    private JButton confirmLocationButton;
    private JScrollPane scroll;
    private JPanel imagePanel;
    private int x = 0, y = 0;
    private Maps current;
    private BufferedImage bImage;
    private ArrayList<Maps> destination;


    public gui() {


        $$$setupUI$$$();
        button1.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = "" + comboBox1.getSelectedItem();
                String route = "";
                maps.removeAll();

                switch (choice) {
                    case "Library 1" -> {
                        choice = "L1/Library1.txt";
                        route = "L1/L1Route.txt";
                        maps.add(Library1);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 2" -> {
                        choice = "L2/Library2.txt";
                        route = "L2/L2Route.txt";
                        maps.add(Library2);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 3" -> {
                        choice = "L3/Library3.txt";
                        route = "L3/L3Route.txt";
                        maps.add(Library3);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 4" -> {
                        choice = "L4/Library4.txt";
                        route = "L4/L4Route.txt";
                        maps.add(Library4);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 5" -> {
                        choice = "L5/Library5.txt";
                        route = "L5/L5Route.txt";
                        maps.add(Library5);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "The Parade" -> {
                        choice = "TP/TheParade.txt";
                        route = "TP/TPRoute.txt";
                        maps.add(Theparade);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "" -> System.out.println("no selection");
                }
                if (!choice.equals("")) {
                    current = new Maps(choice, route, "");
                }

            }
        });

        maps.setVisible(false);
        library1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();


            }
        });
        library2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                System.out.println(x / 10 + "," + y / 10);

            }
        });
        library3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                System.out.println(x / 10 + "," + y / 10);

            }
        });
        library4Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                System.out.println(x / 10 + "," + y / 10);

            }
        });
        library5Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();


            }
        });
        ParadeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                System.out.println(x / 10 + "," + y / 10);

            }
        });

        confirmLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = x / 10;
                y = y / 10;
                if (!current.validate(x, y)) {
                    System.out.println("Invalid (wall), please press new location in map " + x + " " + y);
                } else {
                    current.setXY(x, y);
                    current.start();
                }
            }
        });
        confirmRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = "" + comboBox2.getSelectedItem();
                String sub = choice.substring(0, 2);
                String route = "";
                switch (sub) {
                    case "L1" -> route = "L1/L1Route.txt";
                    case "L2" -> route = "L2/L2Route.txt";
                    case "L3" -> route = "L3/L3Route.txt";
                    case "L4" -> route = "L4/L4Route.txt";
                    case "L5" -> route = "L5/L5Route.txt";
                    case "TP" -> route = "TP/TPRoute.txt";
                }
                if (sub.equals(current.start)) {
                    //find route on map current else find route on both maps current and destination
                    current.setDestination(choice);

                    imagePanel = new JPanel();

                    imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.PAGE_AXIS));
                    scroll = new JScrollPane(imagePanel);
                    Image image = null;
                    try {
                        bImage = ImageIO.read(new File(current.CurrLoc));
                        JLabel label = new JLabel(new ImageIcon(bImage));
                        imagePanel.add(label);
                        Graphics2D g2 = bImage.createGraphics();
                        g2.setColor(Color.red);
                        BasicStroke stroke = new BasicStroke(30);
                        g2.setStroke(stroke);
                        g2.drawLine(10, 10, 100, 100);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    third.add(scroll);
                    third.repaint();

                } else {
                    current.setDestination("stairs");
                    current.start();
                    destination.add(new Maps(choice, route, choice));


                }


            }
        });
        library2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                System.out.println("sw");
            }
        });
        library2Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                System.out.println(e.getX() + "," + e.getY());
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setContentPane(new gui().pan1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        library1Label = new JLabel();
        ImageIcon l1 = new ImageIcon(new ImageIcon("images/Library 1.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        library1Label.setIcon(l1);
        library2Label = new JLabel();
        ImageIcon l2 = new ImageIcon(new ImageIcon("images/Library 2.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        library2Label.setIcon(l2);
        library3Label = new JLabel();
        ImageIcon l3 = new ImageIcon(new ImageIcon("images/Library 3.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        library3Label.setIcon(l3);
        library4Label = new JLabel();
        ImageIcon l4 = new ImageIcon(new ImageIcon("images/Library 4.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        library4Label.setIcon(l4);
        library5Label = new JLabel();
        ImageIcon l5 = new ImageIcon(new ImageIcon("images/Library 5.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        library5Label.setIcon(l5);
        ParadeLabel = new JLabel();
        ImageIcon p = new ImageIcon(new ImageIcon("images/The parade.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        ParadeLabel.setIcon(p);
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        pan1 = new JPanel();
        pan1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        maps = new JPanel();
        maps.setLayout(new CardLayout(0, 0));
        pan1.add(maps, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        Library1 = new JPanel();
        Library1.setLayout(new CardLayout(0, 0));
        maps.add(Library1, "Card1");
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Library1.add(panel1, "Card1");
        library1Label.setHorizontalAlignment(0);
        library1Label.setHorizontalTextPosition(0);
        library1Label.setText("");
        panel1.add(library1Label, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        Library2 = new JPanel();
        Library2.setLayout(new CardLayout(0, 0));
        maps.add(Library2, "Card2");
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Library2.add(panel2, "Card1");
        library2Label.setText("");
        panel2.add(library2Label, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Library3 = new JPanel();
        Library3.setLayout(new CardLayout(0, 0));
        maps.add(Library3, "Card3");
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Library3.add(panel3, "Card1");
        library3Label.setHorizontalAlignment(0);
        library3Label.setText("");
        panel3.add(library3Label, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Library4 = new JPanel();
        Library4.setLayout(new CardLayout(0, 0));
        maps.add(Library4, "Card4");
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Library4.add(panel4, "Card1");
        library4Label.setText("");
        panel4.add(library4Label, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Library5 = new JPanel();
        Library5.setLayout(new CardLayout(0, 0));
        maps.add(Library5, "Card5");
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Library5.add(panel5, "Card1");
        library5Label.setText("");
        panel5.add(library5Label, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Theparade = new JPanel();
        Theparade.setLayout(new CardLayout(0, 0));
        maps.add(Theparade, "Card6");
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Theparade.add(panel6, "Card1");
        ParadeLabel.setText("");
        panel6.add(ParadeLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        first = new JPanel();
        first.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1));
        pan1.add(first, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(10, 10), null, 0, true));
        final JLabel label1 = new JLabel();
        label1.setText("Label");
        first.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        first.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Please choose starting map");
        first.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("");
        defaultComboBoxModel1.addElement("The Parade");
        defaultComboBoxModel1.addElement("Library 1");
        defaultComboBoxModel1.addElement("Library 2");
        defaultComboBoxModel1.addElement("Library 3");
        defaultComboBoxModel1.addElement("Library 4");
        defaultComboBoxModel1.addElement("Library 5");
        defaultComboBoxModel1.addElement("1W.1");
        defaultComboBoxModel1.addElement("1W.2");
        defaultComboBoxModel1.addElement("1W.3");
        comboBox1.setModel(defaultComboBoxModel1);
        first.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button1 = new JButton();
        button1.setText("confim map");
        first.add(button1, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        confirmLocationButton = new JButton();
        confirmLocationButton.setText("Confirm location");
        first.add(confirmLocationButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        second = new JPanel();
        second.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        pan1.add(second, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Please choose desired room:");
        second.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("");
        defaultComboBoxModel2.addElement("L1.17");
        defaultComboBoxModel2.addElement("L1.7");
        defaultComboBoxModel2.addElement("L1.3");
        defaultComboBoxModel2.addElement("L3.10");
        defaultComboBoxModel2.addElement("L3.13");
        defaultComboBoxModel2.addElement("L3.13a");
        defaultComboBoxModel2.addElement("L3.14");
        defaultComboBoxModel2.addElement("L3.19");
        defaultComboBoxModel2.addElement("L3.20");
        defaultComboBoxModel2.addElement("L4.01");
        defaultComboBoxModel2.addElement("L4.02");
        defaultComboBoxModel2.addElement("L4.03a");
        defaultComboBoxModel2.addElement("L4.04");
        defaultComboBoxModel2.addElement("L4.05");
        defaultComboBoxModel2.addElement("L4.06");
        defaultComboBoxModel2.addElement("L4.07");
        defaultComboBoxModel2.addElement("L4.08");
        defaultComboBoxModel2.addElement("L4.17");
        defaultComboBoxModel2.addElement("L4.18");
        defaultComboBoxModel2.addElement("L4.3a");
        defaultComboBoxModel2.addElement("L4.30b");
        comboBox2.setModel(defaultComboBoxModel2);
        second.add(comboBox2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        confirmRoomButton = new JButton();
        confirmRoomButton.setText("Confirm room");
        second.add(confirmRoomButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        third = new JPanel();
        third.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pan1.add(third, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pan1;
    }

}
