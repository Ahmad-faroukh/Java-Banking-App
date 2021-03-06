package accountingsystem;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E15
 */


public class UserLoginWindow extends javax.swing.JFrame {

    /**
     * Creates new form UserLoginWindow
     */
    private static String userID;
    
    public static String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public UserLoginWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        user_id_tf = new javax.swing.JTextField();
        user_password_tf = new javax.swing.JPasswordField();
        user_login_btn = new javax.swing.JButton();
        user_back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");

        jLabel2.setText("Account ID :");

        jLabel3.setText("Password :");

        user_id_tf.setBackground(new java.awt.Color(241, 241, 241));
        user_id_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_id_tfActionPerformed(evt);
            }
        });

        user_password_tf.setBackground(new java.awt.Color(241, 241, 241));

        user_login_btn.setBackground(new java.awt.Color(153, 153, 153));
        user_login_btn.setText("Login");
        user_login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_login_btnActionPerformed(evt);
            }
        });

        user_back_btn.setBackground(new java.awt.Color(153, 153, 153));
        user_back_btn.setText("Back");
        user_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(user_login_btn)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user_back_btn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(user_id_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addComponent(user_password_tf)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(user_id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(user_password_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_back_btn)
                    .addComponent(user_login_btn))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_id_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_id_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_id_tfActionPerformed

    private void user_login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_login_btnActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/accountingsystem", "root", "");
            Statement sql = con.createStatement();
            ResultSet rs = sql.executeQuery("select account_id , password from users");
            String userInput = user_password_tf.getText();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(userInput.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashedText = number.toString(16);

            boolean loggedin = false;
            while (rs.next()) {
                if (user_id_tf.getText().equals(rs.getString("account_id")) && hashedText.equals(rs.getString("password"))) {
                    loggedin = true;
                    this.setUserID(user_id_tf.getText());
                    break;
                }
            }
            if (loggedin) {
                UserPannel userpannel = new UserPannel();
                this.setVisible(false);
                userpannel.setVisible(true);
                
                
                File logs = new File("E:\\Java\\AccountingSystem\\src\\accountingsystem\\logs.txt");
                if(!logs.exists()){
                    logs.createNewFile();
                }
                
                String newLine = System.getProperty("line.separator");
                FileOutputStream fos = new FileOutputStream(logs, true);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                PrintWriter pw = new PrintWriter(osw);
                
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss").format(Calendar.getInstance().getTime());
                pw.append("Query : select account_id , password from users"+newLine);
                pw.append("USER ID : " +user_id_tf.getText() + " Logged In @ "+timeStamp+newLine);
                pw.close();
               
            } else {
                JOptionPane.showMessageDialog(
                        this, "Worng Username Or Passowrd",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(
                    this, "Cant Connect To Data Base",
                    "Backend Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserLoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserLoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_login_btnActionPerformed

    private void user_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_back_btnActionPerformed
        this.setVisible(false);
        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);
    }//GEN-LAST:event_user_back_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLoginWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton user_back_btn;
    private javax.swing.JTextField user_id_tf;
    private javax.swing.JButton user_login_btn;
    private javax.swing.JPasswordField user_password_tf;
    // End of variables declaration//GEN-END:variables
}
