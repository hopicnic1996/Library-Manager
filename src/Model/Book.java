/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Asus F555L
 */
public class Book {

    private int bookID;
    private String title;
    private String author;
    private int publishYear;
    private String bookImage;
    private int numberOfCopies;

    public Book(String title, String author, int publishYear, String bookImage, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.bookImage = bookImage;
        this.numberOfCopies = numberOfCopies;
    }

    public Book(int bookID, String title, String author, int publishYear, String bookImage, int numberOfCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.bookImage = bookImage;
        this.numberOfCopies = numberOfCopies;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    
}
