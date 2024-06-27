/*
  Jaden Russell
  Project 4
  5/9/23
  This program creates a GUI for the user to choose a file of classes, then creates a graph,
  hierarchy list, and parenthesized list of the graph's contents*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project4_jaden_russell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.util.*;

/**
 *
 * @author jaden
 */
public class Project4_Jaden_Russell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        JFileChooser c = new JFileChooser("C:\\Users\\jaden\\OneDrive\\Documents\\NetBeansProjects\\Project4_Jaden_Russell\\src\\project4_jaden_russell");
        int result = c.showOpenDialog(c);

        DirectedGraph graph = new DirectedGraph(11);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("The file could not be opened.");
            System.exit(0);
        }

        File selectedFile = c.getSelectedFile();
        BufferedReader read = new BufferedReader(new FileReader(selectedFile));
        String fileLine = read.readLine();
        
        while (fileLine != null) {
            String[] classes = fileLine.split(" ");
            for (int i = 1; i < classes.length; i++) {
                graph.addEdge(classes[0], classes[i]);
            }
            fileLine = read.readLine();
        }

        System.out.println(graph.findUnreach());
        
        Hierarchy h1 = new Hierarchy(graph);
        System.out.println("\nHierarchy:");
        System.out.println(h1.toString());
        
        ParenthesizedList p1 = new ParenthesizedList(graph);
        System.out.println("\nParenthesized List:");
        System.out.println(p1.toString());
    }

}
