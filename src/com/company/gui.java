package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class gui {

    private JComboBox comboBox1, comboBox2;
    private JPanel pan1;
    private JPanel maps;
    private JPanel Library1, Library2, Library3, Library4, Library5;
    private JPanel oneW1, oneW2, oneW3;
    private JButton button1;
    private JPanel Theparade;
    private JPanel first, second, third;
    private JButton confirmRoomButton;
    private JLabel library1Label, library2Label, library3Label, library4Label, library5Label;
    private JLabel oneW11, oneW22, oneW33;
    private JLabel ParadeLabel;
    private JButton confirmLocationButton;
    private JScrollPane scroll;
    private JPanel imagePanel;
    private int x = 0, y = 0;
    private Maps current, finalmap;
    private BufferedImage bImage, bImage1, bImage2, bImage3, bImagef;
    private Maps destination1, destination2, destination3;
    private String imgPath1, imgPath2, imgPath3, imgPath4, imgPath5;


    public gui() {


        $$$setupUI$$$();
        button1.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = "" + comboBox1.getSelectedItem();
                String route = "";
                String start = "";
                maps.removeAll();

                switch (choice) {
                    case "Library 1" -> {
                        choice = "Maps/Library/L1/Library1.txt";
                        route = "Maps/Library/L1/L1Route.txt";
                        start = "L1";
                        imgPath1 = "images/Library 1.png";
                        maps.add(Library1);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 2" -> {
                        choice = "Maps/Library/L2/Library2.txt";
                        route = "Maps/Library/L2/L2Route.txt";
                        start = "L2";
                        imgPath1 = "images/Library 2.png";
                        maps.add(Library2);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 3" -> {
                        choice = "Maps/Library/L3/Library3.txt";
                        route = "Maps/Library/L3/L3Route.txt";
                        start = "L3";
                        imgPath1 = "images/Library 3.png";
                        maps.add(Library3);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 4" -> {
                        choice = "Maps/Library/L4/Library4.txt";
                        route = "Maps/Library/L4/L4Route.txt";
                        start = "L4";
                        imgPath1 = "images/Library 4.png";
                        maps.add(Library4);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "Library 5" -> {
                        choice = "Maps/Library/L5/Library5.txt";
                        route = "Maps/Library/L5/L5Route.txt";
                        start = "L5";
                        imgPath2 = "images/Library 5.png";
                        maps.add(Library5);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "The Parade" -> {
                        choice = "Maps/TP/TheParade.txt";
                        route = "Maps/TP/TPRoute.txt";
                        start = "TP";
                        imgPath1 = "images/The parade.png";
                        maps.add(Theparade);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }
                    case "1W.1" -> {
                        choice = "Maps/1W/1W.1/1W.1.txt";
                        route = "Maps/1W/1W.1/1W.1Route.txt";
                        imgPath2 = "images/1W.png";
                        start = "1W.1";
                        maps.add(oneW1);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);

                    }
                    case "1W.2" -> {
                        choice = "Maps/1W/1W.2/1W.2.txt";
                        route = "Maps/1W/1W.2/1W.2Route.txt";
                        imgPath1 = "images/1W.png";
                        start = "1W.2";
                        maps.add(oneW2);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);

                    }
                    case "1W.3" -> {
                        choice = "Maps/1W/1W.3/1W.3.txt";
                        route = "Maps/1W/1W.3/1W.3Route.txt";
                        start = "1W.3";
                        imgPath1 = "images/1W.png";
                        maps.add(oneW3);
                        maps.repaint();
                        maps.revalidate();
                        maps.setVisible(true);
                    }

                    case "" -> System.out.println("no selection");
                }
                if (!choice.equals("")) {
                    current = new Maps(choice, route, "");
                    current.setStart(start);
                    choice = choice.replace("Maps/", "");
                    current.setBuilding(choice.substring(0, choice.indexOf("/")));
                    if(!current.getBuilding().equals("TP")){
                        current.setFloor(choice.replace(current.getBuilding(), "").substring(0, choice.indexOf("/")));
                    }
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
            }
        });
        library3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
            }
        });
        library4Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
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
                String cur = "";
                String building = "";


                switch (sub) {
                    case "L1" -> {
                        route = "Maps/Library/L1/L1Route.txt";
                        cur = "Maps/Library/L1/Library1.txt";
                        building = "Library";
                        imgPath1 = "images/Library 1.png";
                    }
                    case "L2" -> {
                        route = "Maps/Library/L2/L2Route.txt";
                        cur = "Maps/Library/L2/Library2.txt";
                        building = "Library";
                        imgPath1 = "images/Library 2.png";
                    }
                    case "L3" -> {
                        route = "Maps/Library/L3/L3Route.txt";
                        building = "Library";
                        cur = "Maps/Library/L3/Library3.txt";
                        imgPath1 = "images/Library 3.png";
                    }
                    case "L4" -> {
                        route = "Maps/Library/L4/L4Route.txt";
                        cur = "Maps/Library/L4/Library4.txt";
                        building = "Library";
                        imgPath1 = "images/Library 4.png";
                    }
                    case "L5" -> {
                        route = "Maps/Library/L5/L5Route.txt";
                        cur = "Maps/Library/L5/Library5.txt";
                        building = "Library";
                        imgPath1 = "images/Library 5.png";
                    }
                    case "1W" -> {
                        sub = "1W." +choice.charAt(3);
                        cur = "Maps/1W/1W." +choice.charAt(3) + "/1W." + choice.charAt(3) + ".txt";
                        route = "Maps/1W/1W." + choice.charAt(3) + "/1W." + choice.charAt(3) + "Route.txt";
                        imgPath1 = "images/1W.png";
                        building = "1W";
                    }

                }




                JPanel Imagepanel = new JPanel();
                JLabel l1 = null,l2,l3,l4,l5;
                Imagepanel.setLayout(new FlowLayout());
                Graphics2D g2;


                if (sub.equals(current.getFloor())) {
                    //find route on map current else find route on both maps current and destination
                    current.setDestination(choice);
                    try {
                        bImage1 = ImageIO.read(new File(imgPath1));
                        l1 = new JLabel(new ImageIcon(bImage1));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    g2 = bImage.createGraphics();
                    try {
                        current.join();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    //draw method

                    g2.setColor(Color.red);
                    BasicStroke stroke = new BasicStroke(30);
                    g2.setStroke(stroke);
                    g2.drawLine(10, 10, 100, 100);

                    Imagepanel.add(l1);
                    scroll = new JScrollPane(Imagepanel);
                    third.add(scroll);
                    third.repaint();
                    maps.removeAll();
                    maps.setVisible(false);


                } else {
                    finalmap = new Maps(cur, route, choice);
                    finalmap.setBuilding(building);
                    finalmap.setST();

                    if (building.equals(current.getBuilding())) {
                        //SAME BUILDING
                        current.setDestination("stairs");
                        current.setST();
                        try {
                            current.join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        finalmap.findstart(current.getEnd());
                        finalmap.start();

                        //draw current
                        //then wait join dest1 and draw dest 1


                    } else {
                        if (current.getBuilding().equals("TheParade")) {
                            if (!sub.equals("L2") && !sub.equals("1W.1")) {
                                if (building.equals("Library")) {
                                    destination1 = new Maps("Maps/Library/L2/Library2.txt", "Maps/Library/L2/L2Route.txt", "stairs");
                                }
                                if (building.equals("1W")) {
                                    destination1 = new Maps("Maps/1W/1W.1/1W.1.txt", "Maps/1W/1W.1/1W.1Route.txt", "stairs");
                                }
                                destination1.findstart("Entrance");
                                destination1.setST();
                                destination1.start();
                                try {
                                    destination1.join();
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                                finalmap.setStart(destination1.getEnd());
                                finalmap.start();
                            }
                        } else {
                            boolean y = false;
                            for (String room : current.rooms) {
                                if (room.contains("Entrance")) {
                                    y = true;
                                    break;
                                }
                            }
                            boolean g = false;
                            for (String room : finalmap.rooms) {
                                if (room.contains("Entrance")) {
                                    g = true;
                                    break;
                                }
                            }
                            if (!y) {
                                current.setDestination("stairs");
                                current.setST();
                                if (current.getBuilding().equals("Library")) {
                                    destination1 = new Maps("Maps/Library/L2/Library2.txt", "Maps/Library/L2/L2Route.txt", "Exit");
                                } else {
                                    if (current.getBuilding().equals("1W")) {
                                        destination1 = new Maps("Maps/1W/1W.1/1W.1.txt", "Maps/1W/1W.1/1W.1Route.txt", "Exit");
                                    }
                                }
                                try {
                                    current.join();
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                                destination1.setST();
                                destination1.findstart(current.getEnd());
                                destination1.start();
                                destination2 = new Maps("Maps/TP/TheParade.txt.txt", "Maps/TP/TPRoute.txt.txt", building);
                                destination2.setST();
                                destination2.findstart(current.getBuilding());
                                destination2.start();

                                if (!g) {
                                    if (building.equals("Library")) {
                                        destination3 = new Maps("Maps/Library/L2/Library2.txt", "Maps/Library/L2/L2Route.txt" , "stairs");
                                    }
                                    if(building.equals("1W")){
                                        destination3 = new Maps("Maps/1W/1W.1/1W.1.txt", "Maps/1W/1W.1/1W.1Route.txt", "stairs");
                                    }
                                    destination3.setST();
                                    destination3.findstart("Entrance");
                                    destination3.start();
                                    try {
                                        destination3.join();
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                    finalmap.findstart(destination3.getEnd());
                                    finalmap.start();


                                }else{
                                    finalmap.findstart("Entrance");
                                    finalmap.start();
                                }


                            } else {
                                current.setDestination("Exit");
                                current.setST();
                                destination1 = new Maps("Maps/TP/TheParade.txt", "Maps/TP/TPRoute.txt", building);
                                destination1.setST();
                                destination1.findstart(current.getBuilding());
                                destination1.start();

                                if (!g) {
                                    if (building.equals("Library")) {
                                        destination2 = new Maps("Maps/Library/L2/Library2.txt", "Maps/Library/L2/L2Route.txt", "stairs");
                                    }
                                    if (building.equals("1W")) {
                                        destination2 = new Maps("Maps/1W/1W.1/1W.1.txt", "Maps/1W/1W.1/1W.1Route.txt", "stairs");
                                    }
                                    destination2.setST();
                                    destination2.findstart("Entrance");
                                    destination2.start();
                                    try {
                                        destination2.join();
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                    finalmap.findstart(destination2.getEnd());
                                }else{
                                    finalmap.findstart("Entrance");
                                    finalmap.start();
                                }



                            }
                        }
                    }
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setContentPane(new gui().pan1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
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
        oneW11 = new JLabel();
        oneW22 = new JLabel();
        oneW33 = new JLabel();
        ImageIcon oneW = new ImageIcon(new ImageIcon("images/1W.png").getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        oneW11.setIcon(oneW);

        oneW22.setIcon(oneW);
        oneW33.setIcon(oneW);
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
        oneW1 = new JPanel();
        oneW1.setLayout(new CardLayout(0, 0));
        maps.add(oneW1, "Card7");
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        oneW1.add(panel7, "Card1");
        oneW11.setText("");
        panel7.add(oneW11, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        oneW2 = new JPanel();
        oneW2.setLayout(new CardLayout(0, 0));
        maps.add(oneW2, "Card8");
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        oneW2.add(panel8, "Card1");
        oneW22.setText("");
        panel8.add(oneW22, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        oneW3 = new JPanel();
        oneW3.setLayout(new CardLayout(0, 0));
        maps.add(oneW3, "Card9");
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        oneW3.add(panel9, "Card1");
        oneW33.setText("");
        panel9.add(oneW33, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        first = new JPanel();
        first.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1));
        pan1.add(first, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(10, 10), null, 0, true));
        final JLabel label1 = new JLabel();
        label1.setText("UNIVERSITY ROUTE PLANNER");
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
        third.setLayout(new CardLayout(0, 0));
        pan1.add(third, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pan1;
    }

}
