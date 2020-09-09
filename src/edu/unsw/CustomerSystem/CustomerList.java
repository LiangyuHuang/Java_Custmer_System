package edu.unsw.CustomerSystem;

public class CustomerList {

    private int total;
    private Customer[] customers;

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer){
        // check if the array is full or the obj is null
        if (customer == null || total >= customers.length)
            return false;
        // add customer
        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index, Customer cust){
        // check if the index is available and cust is null
        if (index >= customers.length || cust == null || index < 0)
            return false;
        // replace it
        customers[index] = cust;
        return true;
    }

    public boolean deleteCustomer(int index){
        // check if the index is available
        if (index >= customers.length || index < 0)
            return false;
        // delete
        customers[index] = null;
        for (int i = index; i < total-1; i++){
            if (customers[i] != null){
                customers[i] = customers[i+1];
            }else{
                customers[i-1] = null;
                break;
            }
        }
        total--;
        return true;
    }

    public Customer[] getAllCustomers(){
        Customer[] showCustomer = new Customer[total];
        int i = 0;
        for (Customer user: customers){
            if (user != null)
                showCustomer[i++] = user;
            else
                break;
        }
        return showCustomer;
    }

    public Customer getCustomer(int index){
        // check if the index is available
        if (index >= customers.length || index < 0)
            return null;
        return customers[index];
    }
}
