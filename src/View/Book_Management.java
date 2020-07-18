/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DBconnection;
import Controller.Librarian;
import Model.Book;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus F555L
 */
public class Book_Management extends javax.swing.JFrame {

    ArrayList<Book> listOfBook;
    private ImageIcon iconBook;
    private final int IMG_WIDTH = 164;
    private final int IMG_HEIGHT = 150;
    private Book quyen_cu;
    private int role = 0;

    /**
     * Creates new form Book_Management
     */
    public Book_Management() {
        loadAllBook();
        initComponents();
        Book_ViewDetail.setVisible(false);
        try {
            jLabel8.setText(listOfBook.size() + "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void loadAllBook() {
        String[] title = {"Book ID", "Title", "Author", "Publisher", "Stock"};
        myTableModel = new DefaultTableModel(title, 0);
        listOfBook = Librarian.getAllBook();

        //Hien thi danh sach vao bang
        for (Book eachBook : listOfBook) {
            Object[] aRow = {eachBook.getBookID(), eachBook.getTitle(),
                eachBook.getAuthor(), eachBook.getPublishYear(),
                eachBook.getNumberOfCopies()};
            myTableModel.addRow(aRow);
        }

    }

    public void setRole(String inputRole) {
        if (inputRole.equalsIgnoreCase("Add")) {
            role = 0;
            Book_ViewDetail.setVisible(true);
            clearAllField();
            enableAllField();
            btnApply.setText("Add");
            btnApply.setVisible(true);
            lblTieuDe.setText("Add new book");
        } else if (inputRole.equalsIgnoreCase("Edit")) {
            role = 1;
            lblTieuDe.setText("Edit Book");
            selectedRowIndexForEdit = tblBookList.getSelectedRow();
            if (selectedRowIndexForEdit == -1) {
                JOptionPane.showMessageDialog(this, "Please choose a row to process this function",
                        "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Book_ViewDetail.setVisible(true);
                enableAllField();
                setValues(listOfBook.get(selectedRowIndexForEdit));
            }
            btnApply.setText("Update");
            btnApply.setVisible(true);//Hien thi nut
        }
    }

    private void disableAllField() {
        txtBookId.setEnabled(false);
        txtTittle.setEnabled(false);
        txtAuthor.setEnabled(false);
        txtPublishYear.setEnabled(false);
        txtNumberOfCopies.setEnabled(false);
        lableImage.setEnabled(false);
        txtBookImage.setEnabled(false);
        txtBookImage.setVisible(false);
        lableImage.setVisible(false);
        btnApply.setVisible(false);
        btnUpload.setVisible(false);
    }

    private void enableAllField() {
        txtBookId.setEnabled(true);
        txtTittle.setEnabled(true);
        txtAuthor.setEnabled(true);
        txtPublishYear.setEnabled(true);
        txtNumberOfCopies.setEnabled(true);
        lblBookImage.setVisible(true);
        lableImage.setEnabled(true);
        lableImage.setVisible(true);
        txtBookImage.setVisible(true);
        btnApply.setVisible(true);
        btnUpload.setVisible(true);
    }

    private void clearAllField() {
        txtBookId.setText("");
        txtTittle.setText("");
        txtAuthor.setText("");
        txtPublishYear.setText("");
        txtNumberOfCopies.setText("");
        lableImage.setText("");
        lblBookImage.setVisible(false);
        txtBookImage.setText("");
        btnApply.setVisible(true);
        btnUpload.setVisible(true);
    }

    public void setValues(Book passedBook) {
        quyen_cu = passedBook;
        txtBookId.setText(passedBook.getBookID() + "");
        txtTittle.setText(passedBook.getTitle());
        txtAuthor.setText(passedBook.getAuthor());
        txtPublishYear.setText(passedBook.getPublishYear() + "");
        txtNumberOfCopies.setText(passedBook.getNumberOfCopies() + "");
        txtBookImage.setText(passedBook.getBookImage());

        try {
            File sourceimage = new File(passedBook.getBookImage());
            Image image = ImageIO.read(sourceimage);
            //iconBook = new ImageIcon(getClass().getResource("/IMG/C.jpg"), "No image for this book...");
            //Image image = iconBook.getImage(); // transform it 
            Image newimg = image.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            iconBook = new ImageIcon(newimg);  // transform it back
            lblBookImage.setIcon(iconBook);
        } catch (Exception ex) {
            lblBookImage.setText("No image found for this book");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Book_ViewDetail = new javax.swing.JPanel();
        txtTittle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtPublishYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumberOfCopies = new javax.swing.JTextField();
        lblBookImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBookId = new javax.swing.JTextField();
        lblTieuDe = new javax.swing.JLabel();
        lableImage = new javax.swing.JLabel();
        txtBookImage = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookList = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Number of Book:");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Book Management");

        jLabel3.setText("Book ID:");

        jLabel4.setText("Tittle: ");

        jLabel5.setText("Author:");

        jLabel6.setText("Publish year:");

        jLabel7.setText("Number of copies:");

        txtBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIdActionPerformed(evt);
            }
        });

        lblTieuDe.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblTieuDe.setText("Book Detail");

        lableImage.setText("Book image:");

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Book_ViewDetailLayout = new javax.swing.GroupLayout(Book_ViewDetail);
        Book_ViewDetail.setLayout(Book_ViewDetailLayout);
        Book_ViewDetailLayout.setHorizontalGroup(
            Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Book_ViewDetailLayout.createSequentialGroup()
                        .addGap(0, 78, Short.MAX_VALUE)
                        .addComponent(btnApply)
                        .addGap(337, 337, 337))
                    .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                        .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(lableImage))
                        .addGap(8, 8, 8)
                        .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                                    .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtBookId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtPublishYear, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumberOfCopies, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(2, 2, 2))
                                .addComponent(txtTittle))
                            .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                                .addComponent(txtBookImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpload)))
                        .addContainerGap())))
            .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblTieuDe))
                    .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(lblBookImage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Book_ViewDetailLayout.setVerticalGroup(
            Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Book_ViewDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBookImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumberOfCopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Book_ViewDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lableImage)
                    .addComponent(txtBookImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApply))
        );

        tblBookList.setModel(myTableModel);
        tblBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBookList);

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("jLabel8");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(141, 141, 141)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Book_ViewDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(400, 400, 400))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Book_ViewDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add)
                            .addComponent(Edit)
                            .addComponent(Delete)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIdActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        setRole("Add");
    }//GEN-LAST:event_AddActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
        setRole("Edit");
    }//GEN-LAST:event_EditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
        if (role == 1) { //Edit
            String title = txtTittle.getText();
            String author = txtAuthor.getText();
            String publishYear = txtPublishYear.getText();
            String nbOfCopies = txtNumberOfCopies.getText();
            String bookImage = txtBookImage.getText();
            Book quyen_moi = new Book(quyen_cu.getBookID(), title, author, Integer.parseInt(publishYear), bookImage, Integer.parseInt(nbOfCopies));
            if (Librarian.updateBook(quyen_cu, quyen_moi)) {
                updateJTable_Edit(quyen_moi);
                JOptionPane.showMessageDialog(this, "Update successfull");
                Book_ViewDetail.setVisible(false);
                disableAllField();
            } else {
                JOptionPane.showMessageDialog(this, "Edit fail");
            }
        } else if (role == 0) { //Add
            String tittle = txtTittle.getText();
            String author = txtAuthor.getText();
            String publishYear = txtPublishYear.getText();
            String nbOfCopies = txtNumberOfCopies.getText();
            String bookImage = txtBookImage.getText();
            Book inputBook = new Book(tittle, author,
                    Integer.parseInt(publishYear),
                    bookImage,
                    Integer.parseInt(nbOfCopies));
            int ID_MOI_SINH = Librarian.addBook(inputBook);

            if (ID_MOI_SINH != 0) {
                JOptionPane.showMessageDialog(this, "Adding successfully!");
                //Cap nhat gia tri moi vao JTable
                inputBook.setBookID(ID_MOI_SINH);
                try {
                    updateJTable(inputBook);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                Book_ViewDetail.setVisible(false);
                disableAllField();
            } else {
                JOptionPane.showMessageDialog(this, "An error appears. "
                        + "Adding unsuccessfully!");
            }
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblBookList.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please choose a row to process this function",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Book_ViewDetail.setVisible(true);
            disableAllField();
            setValues(listOfBook.get(selectedRowIndex));
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to delete "
                    + selectedRowIndex + " ?");
            if (choice == JOptionPane.YES_OPTION) {
                String bookID = txtBookId.getText();
                if (DBconnection.deleteBook(bookID) != 0) {
                    myTableModel.removeRow(selectedRowIndex);
                    JOptionPane.showMessageDialog(this, "Delete successfull");
                    //Cập nhật lại bảng:
                } else {
                    JOptionPane.showMessageDialog(this, "Delete fail");
                }
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void tblBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookListMouseClicked
        // TODO add your handling code here:
        lblTieuDe.setText("Book Detail");
        int selectedRowIndex = tblBookList.getSelectedRow();
        Book_ViewDetail.setVisible(true);
        disableAllField();
        lblBookImage.setVisible(true);
        setValues(listOfBook.get(selectedRowIndex));
    }//GEN-LAST:event_tblBookListMouseClicked

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                //System.out.println(selectedFile.getAbsolutePath());
                txtBookImage.setText(selectedFile.getAbsolutePath());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String key = txtSearch.getText();
        listOfBook = DBconnection.searchByName(key);
        String[] title = {"BookID", "Title", "Publisher", "Author", "Stock"};
        DefaultTableModel model = new DefaultTableModel(title, 0);
        //display into table
        for (Book e : listOfBook) {
            Object[] row = {e.getBookID(), e.getTitle(), e.getPublishYear(), e.getAuthor(), e.getNumberOfCopies()};
            model.addRow(row);
        }
        tblBookList.setModel(model);
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JPanel Book_ViewDetail;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lableImage;
    private javax.swing.JLabel lblBookImage;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JTable tblBookList;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookId;
    private javax.swing.JTextField txtBookImage;
    private javax.swing.JTextField txtNumberOfCopies;
    private javax.swing.JTextField txtPublishYear;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTittle;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel myTableModel;
    private int selectedRowIndexForEdit;

    void updateJTable(Book eachBook) {
        Object[] aRow = {eachBook.getBookID(), eachBook.getTitle(),
            eachBook.getAuthor(), eachBook.getPublishYear(),
            eachBook.getNumberOfCopies()};
        myTableModel.addRow(aRow);
    }

    void updateJTable_Edit(Book quyen_moi) {
        myTableModel.setValueAt(quyen_moi.getTitle(), selectedRowIndexForEdit, 1);//Tittle
        myTableModel.setValueAt(quyen_moi.getAuthor(), selectedRowIndexForEdit, 2);//Author
        myTableModel.setValueAt(quyen_moi.getPublishYear(), selectedRowIndexForEdit, 3);//PublishYear
        myTableModel.setValueAt(quyen_moi.getNumberOfCopies(), selectedRowIndexForEdit, 4);//NumberOfCopies

    }
}
