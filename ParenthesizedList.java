/*
  Jaden Russell
  Project 4
  5/9/23
  This program creates a parenthesized list of a graph by implementing the DFSActions interface methods*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project4_jaden_russell;

import java.util.*;

/**
 *
 * @author jaden
 */
public class ParenthesizedList implements DFSActions {

    private DirectedGraph dGraph;

    public ParenthesizedList(DirectedGraph g) {
        dGraph = g;
    }

    private String buildP(String n, int level) {
        String list = "";
        if (level == 0) {
            list += "(";
        }
        list += " " + n + " ";

        List<String> adj = dGraph.getAdj(n);

        if (adj != null) {
            if (!adj.isEmpty()) {
                list += "(";
                for (String name : adj) {
                    if (cycleDetect(name)) {
                        list += buildP(name + "*", level + 1);
                    } else {
                        list += buildP(name, level + 1);
                    }

                }
                list += ")";
            }

        }
        return list;
    }

    @Override
    public Boolean cycleDetect(String current) {
        List<String> vAdj = dGraph.getAdj(current);
        for (int i = 0; i < vAdj.size(); i++) {
            List<String> inAdj = dGraph.getAdj(vAdj.get(i));
            for (int j = 0; j < inAdj.size(); j++) {
                if (inAdj.get(j).equals(current)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void processVer(String current, List<String> adj) {
        adj.add(current);
    }

    @Override
    public List<String> Ascend(String current) {
        return dGraph.getAdj(current);
    }

    @Override
    public String Descend(String current, List<String> found) {
        List<String> adj = Ascend(current);
        for (int i = 0; i < adj.size(); i++) {
            if (!found.contains(adj.get(i))) {
                return adj.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return buildP(dGraph.getfirst(), 0)+")";
    }
}
