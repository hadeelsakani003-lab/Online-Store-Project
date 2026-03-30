
package onlinestore;
import java.util.ArrayList;
import java.util.Scanner;

public class OnLineStore {

 static char e ;
   static Store store = new Store() ;
   static ArrayList<Item> itemStore = store.getItemStore();
   static ArrayList<Customer> customerStore = store.getCustomerStore();
   static Scanner scan = new Scanner (System.in ) ;
    
    public static void main(String[] args) {
        chooseFromTheMenu ();
    } 
    
    public static void chooseFromTheMenu (){
        menu();
        System.out.println("Enter a number to choose from the menu");
        int num = scan.nextInt();
        switch (num){
            case 1 : {
                do{
                    itemStore.add(addItemsToStore());
                    System.out.println("Item added successfuly");
                    System.out.println("The current items in the store :");
                    store.showItemStore();
                    System.out.println("Do you want to add another item (y/n)");
                    e = enterChar();
                } while(isYes(e));
                goBackToTheMenu(e);
                
            }break;
            case 2: {
                System.out.println("Add a new customer operation :");
                char ch = 'y';
                do{
                    customerStore.add(addCustomer());
                    System.out.println("Customer added with empty shopping cart successfully");
                    System.out.println("Do you want to add  another customer (y/n)?");
                    ch=enterChar();
                }while(isYes(ch)) ; 
                  goBackToTheMenu(ch);          
            }break;
            case 3 :{
                do{
                    addItemShoppingCart();
                    System.out.println("Do you want to add another item (y/n)??");
                    e = enterChar();
                }while(isYes(e));
                 goBackToTheMenu(e); 
            }break;
            case 4 : {
                System.out.println("Remove item from customer shopping cart operation:");
                do{
                    removeItemFromCart();
                    System.out.println("Do you want remove another item (y/n)");
                    e = enterChar();
                }while(isYes(e));
                goBackToTheMenu(e);
            }break;
            case 5 :{
                System.out.println("View items in customer shopping cart operation : ");
                do{
                    viewCustomerItems();
                    System.out.println("Do you want view items of another customer? (y/n)" );
                            
                           
                    e = enterChar();
                }while(isYes(e));
                goBackToTheMenu(e);
            }break;
            case 6 :{
                System.out.println("modify customer data operation :");
                do{
                    modifyCustomerInfo();
                    System.out.println("DO you want modify customer datd ?or press n to back to the main menu");
                    e = enterChar();
                }while(isYes(e));
                goBackToTheMenu(e);
            }break;
            case 7 :{
                System.out.println("empty customer shopping cart operaton :");
                do{
                    emptyCustomerShoppingCart();
                    System.out.println("Do you want empty another customer cart ?or press n to back to the main menu");
                    e = enterChar();
                }while(isYes(e));
                goBackToTheMenu(e);
            }break;
            case 8 :{
                System.out.println("End shopping cart and checkout :");
                do{
                    endShopping();
                    System.out.println("Do you want to end shopping ? or press N to go to the menu");
                    e = enterChar();
                }while(isYes(e));
                goBackToTheMenu(e);
            }break;
            case 9 :{
                System.exit(0);
            }break;
            default : {
                System.out.println("invalid choice \nPlease Enter a number from 1 to 9 ");
                 goBackToTheMenu(enterChar());
            }break;
    }
        
    }
        
  public static char enterChar() {
      char ch ;
      do{
          System.out.println("Enter n to return to the menu or y to continue :");
          ch = scan.next().charAt(0);
      }while(!(ch == 'n'||ch =='N'||ch == 'y'||ch=='Y'));
      return ch ;
  } 
  
  public static void menu(){
    System.out.println(" \nStore System Menu");
    System.out.println("1. Add a new Item to Store");
    System.out.println("2. Add a new Customer to Store");
    System.out.println("3. Add an item to Customer shopping cart");
    System.out.println("4. Remove an item from Customer shopping cart" );
    System.out.println("5. View the items in Customer shopping cart");
    System.out.println("6. Modify customer data");
    System.out.println("7. Empty Customer shopping cart");
    System.out.println("8. End shopping and go to checkout");
    System.out.println( "9. Exit the program");
  }
     
  public static boolean isYes (char e){
      return e == 'y'||e == 'Y';
  }
  
  public static void goBackToTheMenu(char e ){
      if(e== 'n'||e=='N')
          chooseFromTheMenu ();
  }
  
  public static int enterCustomerNumber(){
      System.out.println("Please enter the customer number :");
      return scan.nextInt();
  }
  
  public static Customer getCustomer(){
     
      System.out.println("Please enter the customer number :");
      int number = scan.nextInt();
    
      if(store.isCustomerExist(number)== false)
          return null;
      else return store.getCustomer(number);
  }
   public static boolean ItemIDExist(int ID){
      for (int i = 0; i < itemStore.size(); i++) {
          if(ID == itemStore.get(i).number){
              return true;
          }
      }
      return false;
  }
  public static Item addItemsToStore(){
      Item item = new Item();
      System.out.println("Add item operation :");
      System.out.println("Please enter the item number");
      int number = scan.nextInt();
      scan.nextLine();
      if(ItemIDExist(number)){
          System.out.println("Item id exist, try again.");
          return addItemsToStore();
      }else{
      System.out.println("Please enter the item name :");
      String name = scan.nextLine();
      System.out.println("Please enter the item quantity :");
      int quantity = scan.nextInt();
      System.out.println("Please enter the item price :");
      double price = scan.nextDouble();
      scan.nextLine();
      System.out.println("Enter the type of item (B)Book,(s)shoes,(G)Game ??");
      char type = scan.next().charAt(0);
      
      switch(type){
          case 'B':{
              System.out.println("Please enter the book title :");
              String title = scan.next();
              System.out.println("Please enter the book author :");
              String author = scan.next();
              item = new BookItem(author,title, name, quantity, price, type );
              break;
          }
          case 'G':{
              System.out.println("Please enter the item manufacturing Country ");
              String manufacturingCountry = scan.next();
              item = new GameItem(manufacturingCountry,name,quantity,price,type);
              break;
              
          }
          case'S':{
              System.out.println("Please enter the item manufacturing Country ");
              String manufacturingCountry = scan.next();
              item = new ShoesItem(name,quantity,price,type);
              break;
          }
          default : item = null;
      }
      }
      return item ;
  }
  
  public static Customer addCustomer(){
      String name = " ";
      int number = enterCustomerNumber();
      while(store.isIdExist(number) == true){
        System.out.println("The customer ID already exists, please try another one:");
        number = enterCustomerNumber(); // يطلب الرقم مجدداً في كل مرة يخطئ فيها المستخدم
    } {
          System.out.println("please enter the customer name :");
          name = scan.next();
      }
      return new Customer(name,number);
  }
  
  public static void addItemShoppingCart(){
      System.out.println("Add item to customer shopping cart operation :");
      Customer customer = getCustomer();
      if(customer==null){
          System.out.println("The customer is not exist,Do you want try again(y/n)??");
          e = enterChar();
          if(isYes(e)) addItemShoppingCart();
          else goBackToTheMenu(e);
      }
      else{
          setItemToCart(customer);
      }
  }
  
  public static void setItemToCart(Customer customer){
      System.out.println(customer.showCustomerInfo());
      System.out.println("Items in the store");
      store.showItemStore();
      System.out.println("Enter your choice item :");
      int choice = scan.nextInt();
      if(choice <= itemStore.size()){
        Item choiceItem = itemStore.get(choice-1);
        System.out.println("The item is"+"["+choiceItem.showItemInfo()+"]");
        System.out.println("Enter the quantity you need :");
        int quantityCart =scan.nextInt();
        if(choiceItem.isExist(quantityCart)){
            customer.addItemToCart(choiceItem, quantityCart);
            ShoppingCart car =customer.qetItemCart(choiceItem.number);
            System.out.println("The item is "+car.itemInfoShoppingCart()+"adding successfully to shopping cart");
        }
        else{
            System.out.println("sorry the required quantity is not available , try again");
            System.out.println("Do you want to add another item to shopping cart (y/n)??");
            e = enterChar();
            if(isYes(e))
                setItemToCart(customer);
            else 
                goBackToTheMenu(e);
        }
      }else{
          System.out.println("item index is not true");
          setItemToCart(customer);
      }
  }
      
      public static char choiceMR(){
          System.out.println("What do you want to modify ??");
          System.out.println("R. remove item from the shopping cart");
          System.out.println("M.return to the main menu ");
          System.out.println("Enter your choice M to menu or R to remove item ");
          return scan.next().charAt(0);
      }
          
      
      public static void removeItemFromCart(){
          Customer customer = getCustomer();
          if (customer == null){
              System.out.println("The customer is not exists, Do you want try again(y/n)??");
              e = enterChar();
              if(isYes(e))removeItemFromCart(); 
              else  goBackToTheMenu(e);
          }
          else{
               System.out.println(customer.showCustomerInfo());
              char mr = choiceMR();
             
              if(mr == 'R'|| mr == 'r'){
                  customer.showItemsCart();
                  System.out.println("Enter your item option number :");
                  int choice = scan.nextInt();
                  if(choice <= customer.getItemsCart().size()){
                  ShoppingCart choiceShCart= customer.getItemsCart().get(choice-1);
                  customer.removeItemsCart(choiceShCart);
                  System.out.println("The item is"+choiceShCart.itemInfoShoppingCart()+"removing from shopping cart successfully");
                  
              
                  }else{
                      System.out.println("item id is wrong, try again");
                      removeItemFromCart();
              }}
              else if (mr== 'M'||mr=='m')
              chooseFromTheMenu ();
          
          }
      }
      
      public static Customer viewCustomerItems(){
          Customer customer = getCustomer();
          if(customer == null){
              System.out.println("The customer is not exist , Do you want try again (y/n)");
              e = enterChar();
              if(isYes(e))viewCustomerItems();
              else  goBackToTheMenu(e);
          }
          else{customer.viewItemsCart();
      }
          return customer ;
  }
      
      public static void modifyCustomerInfo(){
          Customer customer = getCustomer();
          
          if(customer == null){
              System.out.println("The customer is  not exist , Do you want to try again (y/n)");
              e = enterChar();
              if(isYes(e))modifyCustomerInfo();
              else goBackToTheMenu(e);
          }
          else{
              customer.showCustomerInfo();

              System.out.println("please enter the new customer id:"); 
              int id = scan.nextInt();
              if(!store.isCustomerExist(id)){
                customer.setId(customer.getId());
              }else{
                  System.out.println("ID exists, try again");
                  modifyCustomerInfo();
              }
              System.out.println("please enter the new customer name:");
              customer.setName(scan.next());
              System.out.println("customer modified successfully");
              System.out.println("Do you want to modify another customer (y/n)??");
              e = enterChar();
              if(isYes(e))modifyCustomerInfo();
              else{
                  System.out.println("return to main menu");
                  goBackToTheMenu(e);
              }
          }
          
              
          }
      public static void emptyCustomerShoppingCart(){
          Customer customer = getCustomer();
          if(customer == null){
              System.out.println("The customer is not exist,Do you want try again (y/n)");
              e = enterChar();
              if(isYes(e))emptyCustomerShoppingCart();
              else goBackToTheMenu(e);
          }
          else{
              for (int i = 0; i<customer.getItemsCart().size();i++){
                  customer.removeItemsCart(customer.getItemsCart().get(i));
              }
              customer.setItemsCart(new ArrayList<>());
          }
      }
      
      public static void endShopping() {
      Customer customer = viewCustomerItems();

    if (customer != null) {
        System.out.println("---------------------------------");
        System.out.println("Final Invoice for: " + customer.getName());
        
        double totalAmount = 0;
        
        for (ShoppingCart cartEntry : customer.getItemsCart()) {
            Item item = cartEntry.getItem();
            int qty = cartEntry.getQuantityCart();
            
            double subTotal = item.price * qty;
            totalAmount += subTotal;
            
            System.out.println("- " + item.showItemInfo() + " | Price: " + item.price + " | Qty: " + qty + " | Sub: " + subTotal);
        }

        System.out.println("---------------------------------");
        System.out.println("Total Amount to Pay: $" + totalAmount);
        System.out.println("Thank you for shopping!");
    
        store.getCustomerStore().remove(customer);
        System.out.println("Transaction complete. Customer session closed.");
    } else {
        System.out.println("Operation cancelled: Customer not found.");
    }
}
}   
      
