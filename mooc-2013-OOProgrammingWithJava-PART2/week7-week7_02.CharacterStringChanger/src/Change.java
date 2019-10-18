/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Change {
    
    private char from;
    private char to;
    
    public Change(char from, char to) {
        this.from = from;
        this.to = to;
    }
    
    public String change(String s) {
        return s.replace(from, to);
    }
    
}
