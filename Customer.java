/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;
import java.util.ArrayList;
public class Customer {
    
private String name ;
    private int id ;
    private ArrayList<ShoppingCart>itemsCart=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<ShoppingCart> getItemsCart() {
      return itemsCart ;  
    }
    public void setItemsCart(ArrayList<ShoppingCart>itemsCart){
        this.itemsCart = itemsCart ;
    }

    public Customer() {
    }

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String showCustomerInfo(){
        return "The customer number is : " + id + ", The customer name is : " +name ;   
    }
    public void addItemToCart(Item item , int quantity){
        item.decreaseQuantityStore(quantity);
        itemsCart.add(new ShoppingCart(item,quantity));
    }
    
    public ShoppingCart qetItemCart(int itemId){
        int index = 0;
        for (int i =0; i<itemsCart.size();i++)
            if(itemsCart.get(i).getItem().number==itemId)
                index=i;
        return itemsCart.get(index);
    }
    
    public void showItemsCart(){
        System.out.println("The current items in shopping cart : ");
        for(int i=0;i<itemsCart.size();i++)
            System.out.println(">>>"+(i+1)+"."+itemsCart.get(i).itemInfoShoppingCart());
        
    }
    public double getTotalPriceCart(){
        double price = 0;
        for(int i=0; i<itemsCart.size();i++)
            price+=this.itemsCart.get(i).totalPrice();
        return price ;
    }
    
    public void removeItemsCart(ShoppingCart shoppingCart){
        shoppingCart.getItem().increaseQuantityStore(shoppingCart.getQuantityCart());
        this.itemsCart.remove(shoppingCart);
    }
    
    public void viewItemsCart(){
        System.out.println("view items in customer shopping cart operation : ");
        System.out.println("Item number \t Item name \t Quantity \t Unit price \t Total price ");
        for(int i  = 0;i<this.getItemsCart().size();i++){
            ShoppingCart temp = this.itemsCart.get(i);
            Item item = temp.getItem();
            System.out.println(item.number + "\t\t"+item.name+"\t\t\t"+temp.getQuantityCart()+"\t\t\t"+item.price+"\t\t"+temp.totalPrice());
        }
        System.out.println("\t\t\t\t\tTotal price :"+ getTotalPriceCart());
    }
}
