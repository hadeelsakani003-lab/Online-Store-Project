/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestore;

public class BookItem extends Item {
private String author;
    private String title;

    public BookItem(String author, String title, String name, int quntityStore, double price, char type) {
        super(name, quntityStore, price, type);
        this.author = author;
        this.title = title;
    }

    @Override
    public String showItemInfo() {
        return super.showItemInfo() + " | Title: " + title + " | Written by: " + author + " | Stock: [" + quntityStore + "]";
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}    

