package com.sliwinski;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<Branch>();
    private String name;

    public Bank(String name) {
        this.branches = new ArrayList<Branch>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNewBranch(String name){
        if (findExistingBrach(name)>=0){
            System.out.println("Branch named: " + name + " already exists!");
        }else {
            Branch branch = new Branch(name);
            branches.add(branch);
            System.out.println("Branch named: " + name + " was added successfully");
        }
    }

    public int findExistingBrach(String name){
        for (int i=0;i<branches.size();i++){
            if(branches.get(i).getName().equals(name)){
                return i;
            }
        }return -1;
    }

    public void addNewCustomerToExistingBranch(String customerName,double amount,String branchName){
        int branchPosition = findExistingBrach(branchName);
        if(branchPosition>=0){
            branches.get(branchPosition).addNewCustomer(customerName,amount);
        }else {
            System.out.println("Branch named: " + branchName + " do not exist!");
        }
    }

    public void addTransactionForExistingCustomer(String customerName,double amount, String branchName){
        int branchPosition = findExistingBrach(branchName);
        if(branchPosition>=0){
            branches.get(branchPosition).addTransactionsToExistingCustomer(customerName,amount);
            System.out.println("Customer named: " + customerName + " in branch " + branchName + " deposited: "+ amount);
        }else {
            System.out.println("Branch named: " + branchName + " do not exist!");
        }
    }

    public boolean showListOfBranches(){
        System.out.println("Branch list: ");
        for (int i=0;i<branches.size();i++){
            System.out.println("Branch no." + i + " named: "+branches.get(i).getName());
        } if(branches.size()<=0){
            System.out.println("There are no branches created!");
            return false;
        }return true;
    }

    public boolean showListOfCustomersForBranch(String branchName){
        if (findExistingBrach(branchName)>=0){
            System.out.println("List of customers in branch named: " + branchName + ":");
            if(branches.get(findExistingBrach(branchName)).showListOfCustomers()){
                return true;
            }
        }else {
            System.out.println("Branch named " + branchName + " does not exist!");
            return false;
        }
        return false;
    }
    public boolean customerAlreadyExists(String branchName,String customerName){
        if (branches.get(findExistingBrach(branchName)).customerAlreadyExists(customerName)){
            return true;
        }
        return false;
    }


}

