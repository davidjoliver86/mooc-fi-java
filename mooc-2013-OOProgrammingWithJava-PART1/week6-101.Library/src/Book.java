/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class Book {

    private String title;
    private int year;
    private String publisher;

    public String title() {
        return title;
    }
    
    public int year() {
        return year;
    }

    public String publisher() {
        return publisher;
    }

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }
    
    public String toString() {
        return String.format("%s, %s, %d", this.title, this.publisher, this.year);
    }
}
