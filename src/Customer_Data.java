
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

public class Customer_Data {
//    UpdateAndDelete updatAndDelete = new UpdateAndDelete();
    public void AddCustomerDetails(String cCNIC,String cName, String cAge, String cGender, String cAddress, String cDate, String cGymTime, String cMobileNo, String cEmail, String cAmount ){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "INSERT INTO customers_data (CNIC,Name,Age,Gender,Address,Date,Gym_Time,Mobile_No,Email,Amount) VALUES ('"+cCNIC+"','"+cName+"','"+cAge+"','"+cGender+"','"+cAddress+"','"+cDate+"','"+cGymTime+"','"+cMobileNo+"','"+cEmail+"','"+cAmount+"')";
                st.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Data is Successfully Added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void DisplayListCustomerData(DefaultTableModel tablemodel){
    // String listOfCustomers[];
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "SELECT * FROM customers_data";
            
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
               
               String cCNIC = rs.getString(1);
               String cName = rs.getString(2);
               String cAge = rs.getString(3);
               String cGender = rs.getString(4);
               String cAddress = rs.getString(5);
               String cDate = rs.getString(6);
               String cGymTime = rs.getString(7);
               String cMobileNo = rs.getString(8);
               String cEmail = rs.getString(9);
               String cAmount = rs.getString(10);
               
           String  listOfCustomers[] = {cCNIC, cName, cAge, cGender, cAddress, cDate, cGymTime, cMobileNo, cEmail, cAmount};
                
           tablemodel.addRow(listOfCustomers);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void UpdateCustomerDetails(String cCNIC,String cName, String cAge, String cGender, String cAddress, String cDate, String cGymTime, String cMobileNo, String cEmail, String cAmount ){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "UPDATE customers_data SET Name = '"+cName+"',Age = '"+cAge+"',Gender = '"+cGender+"',Address = '"+cAddress+"',Date = '"+cDate+"',Gym_Time = '"+cGymTime+"',Mobile_No = '"+cMobileNo+"',Email = '"+cEmail+"',Amount = '"+cAmount+"' WHERE CNIC = '"+cCNIC+"'";
                st.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Data is Successfully Updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void SearchCustomer(String cCNIC){
      //  String listOfCustomers[];
              try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "SELECT * FROM customers_data WHERE CNIC = '"+cCNIC+"'";
                 ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
               String cName = rs.getString(2);
               String cAge = rs.getString(3);
               String cGender = rs.getString(4);
               String cAddress = rs.getString(5);
               String cDate = rs.getString(6);
               String cGymTime = rs.getString(7);
               String cMobileNo = rs.getString(8);
               String cEmail = rs.getString(9);
               String cAmount = rs.getString(10);
               
         String   listOfCustomers[] = {cName, cAge, cGender, cAddress, cDate, cGymTime, cMobileNo, cEmail, cAmount};
            //updatAndDelete.getData(listOfCustomers);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
              
}
         
     public void DeleteCustomerDetails(String cCNIC){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "DELETE FROM customers_data WHERE CNIC = '"+cCNIC+"'";
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
            String qry = "SELECT * FROM customers_data ";
            
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){
                String cCNIC = rs.getString(1);
               String cName = rs.getString(2);
               String cAddress = rs.getString(5);
               String cMobileNo = rs.getString(8);
               String cEmail = rs.getString(9);
               String cAmount = rs.getString(10);
               String cFeeStatus = rs.getString(11);
               
           String  listOfCustomers[] = {cCNIC, cName, cAddress,  cMobileNo, cEmail, cAmount,cFeeStatus};
                
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
                    String cName = rs.getString(2);
                    String cAddress = rs.getString(5);
                    String cMobileNo = rs.getString(8);
                    String cEmail = rs.getString(9);
                    String cAmount = rs.getString(10);
                    String cFeeStatus = rs.getString(11);
                    //String cRAmountDate = rs.getString(12)
                    
                    String  listOfCustomers[] = {cCNIC, cName, cAddress,  cMobileNo, cEmail, cAmount, cFeeStatus};
                    
                    tablemodel.addRow(listOfCustomers);
                }
           
        }catch (Exception e) {
            Logger.getLogger(Customer_Data.class.getName()).log(Level.SEVERE, null, e);
        }
        
    
    }
    public void ReceivedAmount(String cCNIC){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "UPDATE customers_data SET Fee_Status = 'Paid' WHERE CNIC = '"+cCNIC+"'";
            st.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void paymentRecieved(String cCNIC, String cName,String Payment, String pDate){
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
        String user = "admin";
        String password = "12345";
        
        String query = "INSERT INTO customer_payment (CNIC, [Name], Payment, [P_Date]) VALUES (?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, cCNIC);
            pst.setString(2, cName);
            pst.setBigDecimal(3, new BigDecimal(Payment));
            pst.setDate(4, Date.valueOf(pDate));
            
            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void DeleteAllData(){
          
            Connection con;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
              Statement statement = con.createStatement();
            String qry = "DELETE FROM customers_data";
            statement.executeUpdate(qry);
        } catch (SQLException ex) {
            Logger.getLogger(User_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    public void ChangeFeeStatus(){
         LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);


        if (currentDate.equals(firstDayOfMonth)) {
             try {
           Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
              Statement statement = con.createStatement();
            String qry = "UPDATE customers_data SET Fee_Status = 'Not Paid' WHERE Fee_Status = 'Paid'";
            statement.executeUpdate(qry);
        } catch (SQLException ex) {
            Logger.getLogger(User_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public void DeleteCustomersPaymentData(){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "DELETE FROM customer_payment";
                st.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
