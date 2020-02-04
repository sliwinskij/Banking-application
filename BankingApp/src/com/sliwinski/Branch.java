package com.sliwinski;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addNewCustomer(String name, double amount){
        if (findCustomer(name)>=0){
            System.out.println("Customer named " + name + " already exists!");
        }else {
            Customer customer = new Customer(name,amount);
            customers.add(customer);
            System.out.println("Customer named: " + name + ", with initial amount: " + amount + " was added to the system!");
        }

    }
    public void addTransactionsToExistingCustomer(String name,double amount){

        if (findCustomer(name)>=0){
            customers.get(findCustomer(name)).getTransactions().add(amount);
            System.out.println("Amount: " + amount + " was added to customer: " + name);
        } else {
            System.out.println("No customer named: " + name + " found!");
        }

    }
    public int findCustomer(String name){
        for (int i = 0; i< customers.size(); i++){
            if(customers.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }
    public boolean showListOfCustomers(){
        for (int i=0;i<customers.size();i++){
            System.out.println("Customer no." + i + " name: "+customers.get(i).getName() + " have ammount of: " + customers.get(i).getTransactions());
        }if(customers.size()<=0){
            System.out.println("There are no customers! Add one!");
            return false;
        }return true;
    }

    public boolean customerAlreadyExists(String customerName){
        for (int i=0;i<customers.size();i++){
            if(customers.get(i).getName().equals(customerName)){
                System.out.println("Customer named: " + customerName + " already exists!");
                return true;
            }
        }return false;
    }

}

