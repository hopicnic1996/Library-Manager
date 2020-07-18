package Controller;

import Model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://127.0.0.1:1433;"
            + "database=BookManager;"
            + "integratedSecurity=false";
    //  Database credentials
    static final String USER = "trung";
    static final String PASS = "trung";

    public static Connection getMyConnection() {
        Connection conn = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) {
                System.out.println("Connected.");
            }
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeMyConnection(Connection conn) {
        try {
            //3. Close the connection
            conn.close();
            System.out.println("Connection is closed! Good bye!");
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        Connection con = getMyConnection();
//        closeMyConnection(con);
//    }

    public static ArrayList<Book> getAllBook() {
        //1.OPEN CONNECTION
        Connection con = getMyConnection();

        //2.DO STUFF WITH DATABASE
        ArrayList<Book> aList = new ArrayList<>();
        String query = "select * from tblBook";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookID = rs.getInt("bookID");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int publishYear = rs.getInt("publishYear");
                String bookImage = rs.getString("bookImage");
                int numberOfCopies = rs.getInt("nbOfCopies");

                Book aBook = new Book(bookID, title, author, publishYear, bookImage, numberOfCopies);
                aList.add(aBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //3. CLOSE CONNECTION
        finally {
            closeMyConnection(con);
        }
        return aList;
    }

    public static void main(String[] args) {
        Book aBook = new Book("Title", "Author", 1999, "LINK", 1);
        System.out.println(addBook_Version2(aBook));
    }

    public static int addBook(Book inputBook) {
        //1.OPEN CONNECTION
        Connection con = getMyConnection();
        //2.DO STUFF WITH DATABASE
        int result = 0;
        String query = "Insert into tblBook values\n"
                + "('" + inputBook.getTitle() + "'"
                + ",'" + inputBook.getAuthor() + "'"
                + "," + inputBook.getPublishYear() + ""
                + ",'" + inputBook.getBookImage() + "'"
                + "," + inputBook.getNumberOfCopies() + ");";
        try (Statement stmt = con.createStatement()) {
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } //3. CLOSE CONNECTION
        finally {
            closeMyConnection(con);
        }
        return result;
    }

    public static int addBook_Version2(Book inputBook) {
        //1.OPEN CONNECTION
        Connection con = getMyConnection();
        //2.DO STUFF WITH DATABASE
        int result = 0;
        String query = "Insert into tblBook values\n"
                + "(?,?,?,?,?);";
        //try (Statement stmt = con.createStatement()) {
        try (PreparedStatement ptmt = con.prepareStatement(query)) {
            ptmt.setString(1, inputBook.getTitle());
            ptmt.setString(2, inputBook.getAuthor());
            ptmt.setInt(3, inputBook.getPublishYear());
            ptmt.setString(4, inputBook.getBookImage());
            ptmt.setInt(5, inputBook.getNumberOfCopies());

            //result = stmt.executeUpdate(query);
            ptmt.executeUpdate();
            Statement stmt = con.createStatement();
            String query_2 = "SELECT @@IDENTITY";
            ResultSet rs = stmt.executeQuery(query_2);
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //3. CLOSE CONNECTION
        finally {
            closeMyConnection(con);
        }
        return result;
    }

    public static int updateBook(Book quyen_moi) {
        Connection con = getMyConnection();
        int result = 0;
        String query = "Update tblBook set\n"
                + "title = ?, author = ?, publishYear = ?, bookImage = ?, nbOfCopies = ? where bookID = ?";
        try (PreparedStatement ptmt = con.prepareStatement(query)) {
            ptmt.setString(1, quyen_moi.getTitle());
            ptmt.setString(2, quyen_moi.getAuthor());
            ptmt.setInt(3, quyen_moi.getPublishYear());
            ptmt.setString(4, quyen_moi.getBookImage());
            ptmt.setInt(5, quyen_moi.getNumberOfCopies());
            ptmt.setInt(6, quyen_moi.getBookID());
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeMyConnection(con);
        }
        return result;
    }

    public static int deleteBook(String bookID) {
        //1.Open connection 
        Connection con = getMyConnection();
        //2.Do stuff with database
        int result = 0;
        String query = "DELETE FROM tblBook WHERE bookID = ?";
        try (PreparedStatement ptmt = con.prepareStatement(query)) {
            ptmt.setString(1, bookID);
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }// 3. close connection
        finally {
            closeMyConnection(con);
        }
        return result;
    }

    public static ArrayList<Book> searchByName(String title) {
        //1.OPEN CONNECTION
        Connection con = getMyConnection();
        //2.DO STUFF WITH DATABASE
        ArrayList<Book> aList = new ArrayList<>();
        String query = "SELECT * FROM tblBook WHERE title LIKE ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            return createBookFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } //3. CLOSE CONNECTION
        finally {
            closeMyConnection(con);
        }
        return aList;
    }

    public static ArrayList<Book> createBookFromResultSet(ResultSet rs) throws SQLException {
        ArrayList<Book> book = new ArrayList<>();
        while (rs.next()) {
            int bookID = rs.getInt("bookID");
            String title = rs.getString("title");
            String author = rs.getString("author");
            int publishYear = rs.getInt("publishYear");
            String bookImage = rs.getString("bookImage");
            int numberOfCopies = rs.getInt("nbOfCopies");

            Book aBook = new Book(bookID, title, author, publishYear, bookImage, numberOfCopies);
            book.add(aBook);
        }
        return book;
    }
}
