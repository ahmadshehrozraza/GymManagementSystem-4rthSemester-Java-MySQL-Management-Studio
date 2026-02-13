import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ahmad
 */
public class Staff_Data {
    
     public void AddStaffDetails(String sCNIC,String sType, String sName, String sAge, String sGender, String sAddress, String sDate, String sGymTime, String sMobileNo, String sEmail, String sAmount  ){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "INSERT INTO staff_data (CNIC,s_type,Name,Age,Gender,Address,Date,Gym_Time,Mobile_No,Email,Amount) VALUES ('"+sCNIC+"','"+sType+"','"+sName+"','"+sAge+"','"+sGender+"','"+sAddress+"','"+sDate+"','"+sGymTime+"','"+sMobileNo+"','"+sEmail+"','"+sAmount+"')";
                st.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Data is Successfully Added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
      public void DisplayListStaffData(DefaultTableModel tablemodel){
    // String listOfCustomers[];
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "SELECT * FROM staff_data";
            
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
               
               String sCNIC = rs.getString(1);
               String sType = rs.getString(2);
               String sName = rs.getString(3);
               String sAge = rs.getString(4);
               String sGender = rs.getString(5);
               String sAddress = rs.getString(6);
               String sDate = rs.getString(7);
               String sGymTime = rs.getString(8);
               String sMobileNo = rs.getString(9);
               String sEmail = rs.getString(10);
               String sAmount = rs.getString(11);
               
           String  listOfCustomers[] = {sType,sCNIC, sName, sAge, sGender, sAddress, sDate, sGymTime, sMobileNo, sEmail, sAmount};
                
           tablemodel.addRow(listOfCustomers);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
      
      public void UpdateStaffDetails(String cCNIC,String sType, String cName, String cAge, String cGender, String cAddress, String cDate, String cGymTime, String cMobileNo, String cEmail, String cAmount ){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "UPDATE staff_data SET Name = '"+cName+"',s_type = '"+sType+"',Age = '"+cAge+"',Gender = '"+cGender+"',Address = '"+cAddress+"',Date = '"+cDate+"',Gym_Time = '"+cGymTime+"',Mobile_No = '"+cMobileNo+"',Email = '"+cEmail+"',Amount = '"+cAmount+"' WHERE CNIC = '"+cCNIC+"'";
                st.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Data is Successfully Updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
      
      public void DeleteStaffDetails(String cCNIC){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "DELETE FROM staff_data WHERE CNIC = '"+cCNIC+"'";
                st.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Data is Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      
      public void DisplayListOfPayments(DefaultTableModel tablemodel){
    // S tring listOfCustomers[];
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "SELECT * FROM staff_data ";
            
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
                String sCNIC = rs.getString(1);
                String sType = rs.getString(2);
               String sName = rs.getString(3);
               String sAddress = rs.getString(6);
               String sMobileNo = rs.getString(9);
               String sEmail = rs.getString(10);
               String sAmount = rs.getString(11);
               String sSalaryStatus = rs.getString(12);
               
           String  listOfCustomers[] = {sType,sCNIC, sName, sAddress,  sMobileNo, sEmail, sAmount,sSalaryStatus};
                
           tablemodel.addRow(listOfCustomers);
            }
            
        } catch (Exception e) {
            Logger.getLogger(Customer_Data.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
      
       public void DisplayListOfPaymentsSearchingCNIC(DefaultTableModel tablemodel, String CNIC){
    // S tring listOfCustomers[];
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "SELECT * FROM customers_data  WHERE CNIC = '"+CNIC+"'" ;
            
            ResultSet rs = st.executeQuery(qry);
                 while(rs.next()){
                    String cCNIC = rs.getString(1);
                    String sType = rs.getString(2);
                    String cName = rs.getString(3);
                    String cAddress = rs.getString(6);
                    String cMobileNo = rs.getString(9);
                    String cEmail = rs.getString(10);
                    String cAmount = rs.getString(11);
                    String cFeeStatus = rs.getString(12);
                    
                    String  listOfCustomers[] = {sType, cCNIC, cName, cAddress,  cMobileNo, cEmail, cAmount, cFeeStatus};
                    
                    tablemodel.addRow(listOfCustomers);
                }
           
        }catch (Exception e) {
            Logger.getLogger(Customer_Data.class.getName()).log(Level.SEVERE, null, e);
        }
    }
      
       public void PaidAmount(String cCNIC){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "UPDATE staff_data SET Salary_Status = 'Paid' WHERE CNIC = '"+cCNIC+"'";
            st.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
       public void paymentSent(String sCNIC, String sName,String Payment, String pDate){
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
        String user = "admin";
        String password = "12345";
        
        String query = "INSERT INTO staff_payment (CNIC, [Name], Payment, [P_Date]) VALUES (?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, sCNIC);
            pst.setString(2, sName);
            pst.setBigDecimal(3, new BigDecimal(Payment));
            pst.setDate(4, Date.valueOf(pDate));
            
            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       
       public void DeleteStaffData(){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "DELETE FROM staff_data";
                st.executeUpdate(qry);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
       
       public void DeleteStaffPaymentData(){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "DELETE FROM staff_payment";
                st.executeUpdate(qry);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
