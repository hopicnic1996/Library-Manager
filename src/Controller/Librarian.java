/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import java.util.ArrayList;

/**
 *
 * @author QuanDH
 */
public class Librarian {
    private static ArrayList<Book> listOfBook;
    public static int addBook(Book inputBook) {
       //if valid
       
       int ID = DBconnection.addBook_Version2(inputBook);
       if(ID!=0){
           //Thanh cong
           inputBook.setBookID(ID);
           if(listOfBook.add(inputBook)){
               return ID;
           }
       }else{
           //That bai
           return 0;
       }
       //else
       return 0;
    }
    public static boolean updateBook(Book quyen_cu, Book quyen_moi) {
        //B1: Kết nối cơ sở dữ liệu và chạy update
        if (DBconnection.updateBook(quyen_moi) !=0) //B2: Nếu B1 thành công, Cập nhật list với thông tin sách mới
        {
            quyen_cu.setTitle(quyen_moi.getTitle());
            quyen_cu.setAuthor(quyen_moi.getAuthor());
            quyen_cu.setPublishYear(quyen_moi.getPublishYear());
            quyen_cu.setBookImage(quyen_moi.getBookImage());
            quyen_cu.setNumberOfCopies(quyen_moi.getNumberOfCopies());
            return true;
            //B3: Nếu B1, B2 thành công, trả về true
        }
        return false;
    }
//    public static boolean deleteBook(String bookID){
//        if(DBconnection.deleteBook(bookID) !=0){
//            
//        }
//        return true;
//    }
    

    public static ArrayList<Book> getAllBook() {
       listOfBook =  DBconnection.getAllBook();
       return listOfBook;
    }

}
