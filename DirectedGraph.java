/*
  Jaden Russell
  Project 4
  5/9/23
  This program creates a general directed graph database with methods to perform a depth first search, 
  add edges, and find unreachable classes*/
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
public class DirectedGraph {

    private int verNum;
    private Map<String, List<String>> adj;

    public DirectedGraph(int n) {
        verNum = n;
        adj = new LinkedHashMap<>();
    }

    public void addVertex(String s) {
        adj.putIfAbsent(s, new ArrayList<>());
    }

    public void addEdge(String l1, String l2) {
        if (!adj.containsKey(l1)) {
            addVertex(l1);
        }

        if (!adj.containsKey(l2)) {
            addVertex(l2);
        }

        adj.get(l1).add(l2);
    }

    public String getfirst() {
        return adj.keySet().iterator().next();
    }

    public List<String> getAdj(String s) {
        return adj.get(s);
    }

    public ArrayList<String> DFS(String r) {
        ArrayList<String> isVisited = new ArrayList<>();
        return DFS(r, isVisited);
    }

    public ArrayList DFS(String current, ArrayList<String> visited) {
        visited.add(current);
        for (int i = 0; i < adj.get(current).size(); i++) {
            if (!visited.contains(adj.get(current).get(i))) {
                DFS(adj.get(current).get(i), visited);
            }
        }
        return visited;
    }

    public String findUnreach() {
        String uVertex = "";
        List<String> aVert = DFS(adj.keySet().iterator().next());
        for (Map.Entry<String, List<String>> entry : adj.entrySet()) {
            if (!aVert.contains(entry.getKey())) {
                if (!uVertex.equals("")) {
                    uVertex += ", ";
                }
                uVertex += entry.getKey();
            }
        }
        if (!uVertex.equals("")) {
            return uVertex + " is unreachable.";
        }
        return "All classes are reachable.";
    }

}
