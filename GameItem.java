/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;

public class GameItem extends Item {
private String manufacturingCountry;

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public GameItem() {
    }

    public GameItem(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public GameItem(String manufacturingCountry, String name, int quntityStore, double price, char type) {
        super(name, quntityStore, price, type);
        this.manufacturingCountry = manufacturingCountry;
    }
    
    @Override
     public String showItemInfo(){
         return super.showItemInfo()+ "made by "+manufacturingCountry+"["+quntityStore+"]";
     }

}    

