/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author akxpm
 */
public class Payroll 
{
    Employee[] myEmployee = new Employee[3];
    
    public static void main(String[] args)
        {
            Payroll pr = new Payroll();
            pr.menu();
        }
    
    public void menu()
    {
        Scanner sc = new Scanner(System.in);
        int input;
        do
        {
            System.out.println("1) Populate Employee");
            System.out.println("2) Select Employee");
            System.out.println("3) Save Employee");
            System.out.println("4) Load Employee");
            System.out.println("5) Write Payroll");
            System.out.println("6) Read Payroll");
            System.out.println("7) Exit");
            input = Integer.parseInt(sc.next());
            if(input == 1)
            {
                populateEmployee();
            }
            else if(input == 2)
            {
                selectEmployee();
            }
            else if(input == 3)
            {
                saveEmployee();
            }
            else if(input == 4)
            {
                loadEmployee();
            }
            else if(input == 5)
            {
                writePayroll();
            }
            else if(input == 6)
            {
                readPayroll();
            }
        }
        while(input !=7);
    }
    
    public void populateEmployee()
    {
//        String id_holdinput;
		
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<myEmployee.length; i++)
        {

            System.out.println("Please enter if you are a Commission[C], Salary[S], or Hourly[H]");

            String input = sc.next();

            if(input.equalsIgnoreCase("C"))
            {
                myEmployee[i] = new Commission();
                System.out.println("Please enter your name: ");
                String local_id = sc.next();
                myEmployee[i].setName(local_id);
            }
            if(input.equalsIgnoreCase("H"))
            {
                myEmployee[i] = new Hourly();  
                System.out.println("Please enter your name: ");
                String local_id = sc.next();
                myEmployee[i].setName(local_id);
            } 
            if(input.equalsIgnoreCase("S"))
            {            
                myEmployee[i] = new Salary();
                System.out.println("Please enter your name: ");
                String local_id = sc.next();
                myEmployee[i].setName(local_id);
            }
        }
    }
    
    public void selectEmployee()
    {
        String tempName;
        int index = -99;
        for(int i = 0; i < myEmployee.length; i++)
        {
            System.out.println("Enter name to find:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try
            {
                tempName = br.readLine();
            }
            catch(IOException ioe)
            {
                System.out.println("Something went wrong with your input name try again");
                i=-1;
                continue;
            }
            
            if(myEmployee[i].getName().equalsIgnoreCase(tempName))
            {
                index = i;
                break;
            }          
        }
        if(index != -99)
        {
            myEmployee[index].menu();
        }
        else
        {
            System.out.println("Employee not found, please try again.");
        }
    }
    
    public void saveEmployee()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("SetEmployee.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
			
            oos.writeObject(myEmployee);
            oos.flush();
            fos.close();
        }
        catch (IOException e)
        {
                System.err.println(e);
        }
    }
    
    public void loadEmployee()
    {
        try
        {
                FileInputStream fis = new FileInputStream("SetEmployee.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployee = (Employee[])ois.readObject();
                fis.close();
        }
        catch (Throwable e)
        {
                System.err.println(e);
        }
    }
    
    public void showPayroll()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(myEmployee[i].getName() + " " + myEmployee[i].getRate());
        }

    }

    public void populatePayroll()
    {
        for(int i =0; i<3; i++)
        {
            myEmployee[i] = new Employee("Jane Doe", 40, 10);
            String s = Integer.toString(i);
            myEmployee[i].setName(s);
        }
    }

    public void readPayroll()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("employeeINFO.txt"));
            int counter = 0;

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) 
            {
                System.out.println(sCurrentLine);
                StringTokenizer st = new StringTokenizer(sCurrentLine, "|");

                while(st.hasMoreTokens())
                {
                    for(int i = 0; i < 2; i++)
                    {
                        if(i == 0)
                        {
                            String tempName = st.nextToken();
                            myEmployee[counter].setName(tempName);
                        }
                        else
                        {
                            myEmployee[counter].setRate((float) Double.parseDouble(st.nextToken()));
                        }
                    }
                }
                counter++;
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void writePayroll()
    {
        try{
                File file = new File("employeeINFO.txt");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                        file.createNewFile();
                }


                FileWriter fw = new FileWriter(file, false); //change to true to append to the file
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0; i < myEmployee.length; i++)
                {
                                      
                    String tempString = myEmployee[i].getName();
                    double tempNumber = myEmployee[i].getGross();
                    String tempStringNum = Double.toString(tempNumber);
                    bw.write(tempString);
                    bw.write("|");
                    bw.write(tempStringNum);
                    bw.newLine();
                    
                }
                    
                System.out.println("Done");
                bw.close();
          } 
          catch (IOException e)
          {
                e.printStackTrace();
          }
    
    }
}

//String tempname;
//        int temphr;
//        int temprt;
//        
//        Scanner sc = new Scanner(System.in);
//        
//        for(int i = 0; i < myEmployee.length; i++)
//        {
//            if(myEmployee[i] == null)
//            {
//                System.out.println("Please enter your name: ");
//                tempname = sc.next();
//                System.out.println("Please enter your hours for last period: ");
//                temphr = Integer.parseInt(sc.next());
//                System.out.println("Please enter your hourly rate: ");
//                temprt = Integer.parseInt(sc.next());
//            
//                myEmployee[i] = new Employee(tempname,temphr, temprt);
//                break;
//            }
//        }
