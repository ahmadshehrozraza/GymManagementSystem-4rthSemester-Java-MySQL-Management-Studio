
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class User_Info {
    
    Customer_Data cData = new Customer_Data();
    Staff_Data sData = new Staff_Data();
    Expenses eData = new Expenses();
    
    public void UserSignUp (String userName,String passWord, String eMail)
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement statement = con.createStatement();
            String qry = "INSERT INTO admin_account (User_name, User_Password, User_Email) VALUES ('"+userName+"','"+passWord+"','"+eMail+"')";
            statement.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
  

    public boolean checkForAccount() {
        boolean isUserNameNull = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement statement = con.createStatement();
            String qry = "SELECT * FROM admin_account";
            ResultSet resultSet = statement.executeQuery(qry);
            
            if(!(resultSet.next()))
            isUserNameNull = true;



        } catch (SQLException e) {
            // Handle any database related errors
            e.printStackTrace();
        }

        return isUserNameNull;
    }
     public void UpdateUserInfo (String userName,String passWord, String eMail)
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement statement = con.createStatement();
            String qry = "UPDATE admin_account SET User_name = '"+userName+"', User_Password = '"+passWord+"', User_Email = '"+eMail+"'";
            statement.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Account Updated Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      public void DeleteUserInfo ()
    {
         cData.DeleteAllData();
         cData.DeleteCustomersPaymentData();
         sData.DeleteStaffData();
         sData.DeleteStaffPaymentData();
         eData.DeleteAllExpenses();
         
            Connection con;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
              Statement statement = con.createStatement();
            String qry = "DELETE FROM admin_account";
            statement.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "All Data Deleted Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(User_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }
         public static String userName(){
             String getUserName = null;
             try {
                 Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
                 Statement st = con.createStatement();
                 String qry = "SELECT  User_name FROM admin_account";
                 ResultSet rs = st.executeQuery(qry);
                 while(rs.next()){
                     getUserName = rs.getString("User_name");
                 }
             } catch (Exception e) {
                  System.out.println(e);
             }
         return getUserName;
}

         public String userPassword(){
             String getUserPassword = null;
             try {
                 Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
                 Statement st = con.createStatement();
                 String qry = "SELECT  User_Password FROM admin_account";
                 ResultSet rs = st.executeQuery(qry);
                 while(rs.next()){
                     getUserPassword = rs.getString("User_Password");
                 }
             } catch (Exception e) {
                  System.out.println(e);
             }
         return getUserPassword;
}
         public String userEmail(){
             String getUserEmail = null;
             try {
                 Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
                 Statement st = con.createStatement();
                 String qry = "SELECT  User_Email FROM admin_account";
                 ResultSet rs = st.executeQuery(qry);
                 while(rs.next()){
                     getUserEmail = rs.getString("User_Email");
                 }
             } catch (Exception e) {
                  System.out.println(e);
             }
         return getUserEmail;
}
         public static String mail;
         
         public void ForgotPassword(String uPassword){
              try {
                 Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
                 Statement st = con.createStatement();
                 String qry = "UPDATE  admin_account SET User_Password = '"+uPassword+"'";
                 st.executeUpdate(qry);
                  JOptionPane.showMessageDialog(null, "Password Successfully Changed");
             } catch (Exception e) {
                  System.out.println(e);
             }
         }
}    