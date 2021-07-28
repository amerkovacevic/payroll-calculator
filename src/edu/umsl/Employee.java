/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author akxpm
 */

public class Employee implements Serializable
{
    public String name;
    public float rate;
    public float taxrate = 0.23f;
    public int hours;
    public float gross;
    public float tax;
    public float net;
    public float net_percent;
    public float overtime = 0;
    
    public Employee()
    {
        
    }
    
    public Employee(String name, int hours, int rate)
    {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getHour()
    {
        return hours;
    }
    
    public void setHour(int Hour)
    {
        this.hours = Hour;
    }
    
    public float getRate()
    {
        return rate;
    }
    
    public void setRate(float Rate)
    {
        this.rate = Rate;
    }
    
    public float getGross()
    {
        return gross;
    }
    
    public void setGross(float Gross)
    {
        this.gross = Gross;
    }    

    public void menu()
    {
        Scanner sc = new Scanner(System.in);
        int input;
        do
        {
            System.out.println("1) Calculate Gross Pay");
            System.out.println("2) Calculate Tax");
            System.out.println("3) Calculate Net Pay");
            System.out.println("4) Calculate Net Percent");
            System.out.println("5) Display All");
            System.out.println("6) Exit");
            input = Integer.parseInt(sc.next());
            
            if(input == 1)
            {
                computeGross();
            }
            else if(input == 2)
            {
                computeTax();
            }
            else if(input == 3)
            {
                computeNet();
            }
            else if(input == 4)
            {
                computeNetperc();
            }
            else if(input == 5)
            {
                displayEmployee();
            }
        }
        while(input !=6);
    }


    public void computeGross()
    {
        gross = rate * hours;
    }

    protected void computeTax()
    {
        tax = gross * taxrate;
    }

    protected void computeNet()
    {
        net = gross - tax;
    }

    protected void computeNetperc()
    {
        net_percent = (net/gross) * 100;
    }

    protected void displayEmployee()
    {
//        computeGross();
        computeTax();
        computeNet();
        computeNetperc();

        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
        System.out.println("Gross: " + gross);
        System.out.println("Net: " + net);
        System.out.println("Net%: " + net_percent + "%");

    }
}
