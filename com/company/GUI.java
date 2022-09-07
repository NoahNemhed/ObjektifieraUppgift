package com.company;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GUI implements ActionListener {
    private ArrayList<details> detailsList;
    jParser jParser;
    CSVparser CSVparser;
    XMLParser XMLparser;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JFrame frame;
    private JPanel panel;
    private JTextArea jTextArea;
    private JScrollPane scroll;

    public GUI() {
        this.detailsList = new ArrayList<details>();
        this.frame = new JFrame();
        this.button1 = new JButton("CSV");
        this.button2 = new JButton("XML");
        this.button3 = new JButton("JSON");
        this.panel = new JPanel();
        this.CSVparser = new CSVparser();
        this.jParser = new jParser();
        this.XMLparser = new XMLParser();
        this.jTextArea = new JTextArea(60,8);
        scroll = new JScrollPane(jTextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret = (DefaultCaret) jTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);



        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);


        panel.setBorder(BorderFactory.createEmptyBorder(400,400,200,200));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(scroll);
        panel.setLayout(new GridLayout(2,3));


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == button1){
           try {
               readCSVoutput();
           } catch (FileNotFoundException ex) {
               ex.printStackTrace();
           }
           jTextArea.setText(detailsListToString(this.detailsList));
       }
       if(e.getSource() == button2){
           try {
               readXMLoutput();
           } catch (FileNotFoundException ex) {
               ex.printStackTrace();
           } catch (IOException ex) {
               ex.printStackTrace();
           } catch (ParserConfigurationException ex) {
               ex.printStackTrace();
           } catch (SAXException ex) {
               ex.printStackTrace();
           }
           jTextArea.setText(detailsListToString(this.detailsList));
       }
       if(e.getSource() == button3){
           readJSONoutput();
           String temp = detailsListToString(this.detailsList);
           jTextArea.setText(temp);
       }

    }
    //Reads CSV file and creates Objects from file.
    public void readCSVoutput() throws FileNotFoundException {
        if(this.detailsList.size() > 0 ){
            this.detailsList.clear();
        }
        ArrayList<String> x = CSVparser.readFile("src/sample.csv");
        for(int i = 1; i<x.size(); i++){
            String[] temp = x.get(i).split(",");
            details d = new details(temp[0], temp[1],temp[2], temp[3],temp[4], temp[5],temp[6], temp[7]);
            detailsList.add(d);
        }
        //Sorts data by fname alphabetically.
        Collections.sort(detailsList, Comparator.comparing(details::getFname));
        x.clear();
        System.out.println(detailsList.size());
    }
    //Reads XML file and creates Objects from file.
    public void readXMLoutput() throws IOException, ParserConfigurationException, SAXException {
        if(this.detailsList.size() > 0 ){
            this.detailsList.clear();
        }
        ArrayList<String> x = XMLparser.readFile("src/sample.xml");

        for(int i = 1; i<x.size(); i++){
            String[] temp = x.get(i).split(",");
            details d = new details(temp[0], temp[1],temp[2], temp[3],temp[4], temp[5],temp[6], temp[7]);
            detailsList.add(d);
        }
        //Sorts data by fname alphabetically.
        Collections.sort(detailsList, Comparator.comparing(details::getFname));
        x.clear();
        System.out.println(detailsList.size());
    }
    //Reads JSON file and creates Objects from file.
    public void readJSONoutput(){
        if(this.detailsList.size() > 0 ){
            this.detailsList.clear();
        }
        ArrayList<String> x = jParser.readFile("src/sample.json");
        for(int i = 1; i<x.size(); i++){
            String[] temp = x.get(i).split(",");
            details d = new details(temp[0], temp[1],temp[2], temp[3],temp[4], temp[5],temp[6], temp[7]);
            detailsList.add(d);
        }
        //Sorts data by fname alphabetically.
        Collections.sort(detailsList, Comparator.comparing(details::getFname));
        x.clear();

    }


    //Reads Object List and returns data as String.
    public String detailsListToString(ArrayList<details> d){
        String temp = "";
        for(details a : detailsList){
            temp += a + "\n";
        }
        return temp;
    }


}
