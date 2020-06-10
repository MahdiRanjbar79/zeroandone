package com.bl4cknull;


import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    private static String lastName , firstName , salaryS , street , city , state,zipCode , checking;
    private static Double salary;
    private static boolean check = false , recheck , whileturn ;
    public static void main(String[]args){

        do {

            getData();
            Employee emp1 = new Employee(lastName, firstName);
            emp1.setSalary(salary);
            emp1.address = new Address(street, city, state, zipCode);
            Employee emp2 = (Employee) emp1.clone();
            System.out.println("*** fadata employee 1 saved ***\n");
            printEmployee(emp1);
            // printEmployee(emp2);
            getData();
            emp2.setLastName(lastName);
            emp2.setFirstName(firstName);
            emp2.setSalary(salary);
            emp2.address = new Address(street, city, state, zipCode);
            System.out.println("*** data employee 1 changed ***\n");
            // printEmployee(emp1);
            printEmployee(emp2);
            //repeat();
            checking = JOptionPane.showInputDialog("do you want enter again ? (yes/no): ");
            do {
                if (checking.equalsIgnoreCase("yes")) {
                    recheck = true;
                } else if (checking.equalsIgnoreCase("no")) {
                    recheck = false;
                    JOptionPane.showMessageDialog(null,"thanks for using");
                } else {
                    whileturn = true;
                    JOptionPane.showMessageDialog(null, "your entire value is wrong , please enter again");
                }
            }while(whileturn);
        }while(recheck);
    }
    private static void printEmployee(Employee e){
        System.out.println(e.getFirstName()+" "+e.getLastName());
        System.out.println(e.address.getAddress());
        System.out.println("salary: "+ e.getSalary());
        System.out.println();
        JOptionPane.showMessageDialog(null,e.getFirstName()+" "+e.getLastName());
        JOptionPane.showMessageDialog(null ,e.address.getAddress());
        JOptionPane.showMessageDialog(null,"salary: "+ e.getSalary());
    }

    private static void getData(){
        lastName = JOptionPane.showInputDialog("please enter last name: ");
        firstName = JOptionPane.showInputDialog("please enter first name: ");
        do{
            try{
                check = false;
                salaryS = JOptionPane.showInputDialog("please enter salary : ");
                salary = Double.parseDouble(salaryS);
            }catch(Exception e){
                check = true;
                JOptionPane.showMessageDialog(null, "your entire value is wrong: ");
            }
        }while(check);
        street = JOptionPane.showInputDialog("please enter street: ");
        city = JOptionPane.showInputDialog("please enter city: ");
        state = JOptionPane.showInputDialog("please enter state: ");
        zipCode = JOptionPane.showInputDialog("please enter zipCode: ");


    }

}


class Employee implements Cloneable{
    private String lastName;
    private String firstName;
    private Double salary;
    public Address address;
    public Employee(String lastName , String firstName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = new Address();
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName = firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public Double getSalary(){
        return this.salary = salary;
    }
    public void setSalary(Double salary){
        this.salary = salary;
    }
    public Object clone(){
        Employee emp;
        try{
            emp = (Employee) super.clone();
            emp.address = (Address)address.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
        return emp;
    }
    public String toString(){
        return this.getClass().getName()+"["
                +this.firstName+" "
                +this.lastName+","
                +this.salary +"]";
    }
}

class Address implements Cloneable{
    private String street;
    private String city;
    private String state;
    private String zipCode;
    public Address(){
        this.street = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
    }
    public Address(String street,String city,String state,String zipCode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }
    public String getAddress(){
        return this.street + "\n"
                +this.city + ", "
                +this.state + " "
                +this.zipCode;
    }
}



