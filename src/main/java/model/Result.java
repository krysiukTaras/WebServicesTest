/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Taras_Krysiuk
 */
public class Result {

    public Result(double value) {
        this.value = value;
    }
        
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();      
        str.append("\n\t\t[value=").append(value).append("]");        
        return str.toString();
    }
}
