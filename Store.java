/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;
import java.util.ArrayList;
public class Store {
 private ArrayList<Item> itemStore = new ArrayList<Item>();
    private ArrayList<Customer> customerStore = new ArrayList<Customer>();
 
    public ArrayList<Item> getItemStore(){
        return itemStore;
    }
    
    public void setItemStore(ArrayList<Item> itemStore){
        this.itemStore = itemStore;
    }
    
    public ArrayList<Customer> getCustomerStore(){
        return customerStore;
    }
    
    public void setCustomerStore(ArrayList<Customer> customerStore){
        this.customerStore = customerStore;
    }
    
    public void showItemStore(){
        for(int i=0; i<itemStore.size();i++)
            System.out.println(">>>"+ (i+1)+"."+itemStore.get(i).showItemInfo());
    }
    
    public boolean isIdExist(int id ){
        //boolean a = false ;
        for(int i=0; i<customerStore.size();i++){
            if(customerStore.get(i).getId()== id){
                return true;
            }
        }
       return false ;
    }
    
    public boolean isCustomerExist(int id ){
        boolean a = false ;
        for(int i=0; i<customerStore.size();i++)
            if(customerStore.get(i).getId()== id){
        a=true;
        break;
    }
            return a ;
    }
          int i ;  
    public Customer getCustomer (int id){
        int index = 0;
        for(int i=0;i<customerStore.size();i++)
            if(customerStore.get(i).getId()==id);
                index = i ;
        return customerStore.get(index);
    } 
}