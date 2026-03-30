/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;


public class Item {
    protected String name ;
    protected int number = count ;
    private static int count ;
    protected int quntityStore;
    protected double price ;
    protected char type ;
    
    public Item(){
        count+=1;
    }

    public Item(String name, int quntityStore, double price, char type) {
        this.name = name;
        this.quntityStore = quntityStore;
        this.price = price;
        this.type = type;
    }
    public String showItemInfo(){
        return number + " , " + name ;
    }
    
    public boolean isExist (int quantityCart){
        return quntityStore >= quantityCart ;
    }
    
    public void decreaseQuantityStore (int qun ){
        quntityStore -=qun;
    }
    
    public void increaseQuantityStore (int qun ){
        quntityStore +=qun ;
    }
    

}   

