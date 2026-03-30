/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;

public class ShoppingCart {
private Item item ;
    private int quantityCart ;

    public ShoppingCart() {
    }
    

    public ShoppingCart(Item item, int quantityCart) {
        this.item = item;
        this.quantityCart = quantityCart;
    }
    
    public String itemInfoShoppingCart(){
        return "["+item.showItemInfo()+"["+quantityCart+"]]";
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }
     public double totalPrice(){
         return item.price*this.quantityCart;
     }
     
     
}
