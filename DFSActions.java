/*
  Jaden Russell
  Project 4
  5/9/23
  This program creates an interface with methods that are used in a depth first search
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project4_jaden_russell;
import java.util.*;
/**
 *
 * @author jaden
 */
public interface DFSActions {
    
    public Boolean cycleDetect(String current);
    public void processVer(String current, List<String> found);
    public List<String> Ascend(String current);
    public String Descend(String current, List<String> found);
}
