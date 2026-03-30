/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;

public class ShoesItem extends Item {
 @Override
    public String showItemInfo(){
        return super.showItemInfo()+"["+quntityStore+"]";
        
    }
    public ShoesItem() {
    }
    public ShoesItem( String name, int quntityStore, double price, char type) {
        super(name, quntityStore, price, type);
        
    }

}    

