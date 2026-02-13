
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author Ahmad
 */
public class Expenses {
    
    public void AddExpense(String eType, String eAmount, String eDate){
    try {
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
        String qry = "INSERT INTO expenses (expense_type, expense_amount, expense_date) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(qry);
        
        pst.setString(1, eType);
        pst.setBigDecimal(2, new BigDecimal(eAmount));
        pst.setDate(3, Date.valueOf(eDate));
        
        int rowsAffected = pst.executeUpdate();
        if(rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Data is Successfully Added");
        
        }
    }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void DeleteAllExpenses(){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true","admin","12345");
            Statement st = con.createStatement();
            String qry = "DELETE FROM expenses";
                st.executeUpdate(qry);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
