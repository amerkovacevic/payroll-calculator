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
public class Hourly extends Employee
{
    @Override
    
    public void computeGross()
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount of hours: ");
        hours = sc.nextInt();

        System.out.print("Enter your rate per hour: ");
        rate = sc.nextInt();

        if(hours > 40)
        {
            overtime = hours - 40;
            overtime = (float) (overtime * rate * 1.5);
            gross = overtime + (rate * hours);
        }
        else
        {
            overtime = 0;
            gross = rate * hours + overtime;
        }
    }
}
