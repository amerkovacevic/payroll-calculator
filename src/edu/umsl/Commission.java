/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.util.Scanner;

/**
 *
 * @author akxpm
 */
public class Commission extends Employee
{   
    @Override
    
    public void computeGross()
    {
        int items;
        float unitPrice;
                
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many items did you sell?");
        items = sc.nextInt();
        System.out.println("What was the unit price?");
        unitPrice = sc.nextInt();
        
        gross = (float) (unitPrice * items * .5);
        
    }
}
