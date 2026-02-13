
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.sql.Date;

/**
 *
 * @author Ahmad
 */
public class GnrtReports {
    
    Calendar current = Calendar.getInstance();
    //int currentYear = current.get(Calendar.YEAR);
    private static int currentYear = Year.now().getValue();
    
    
   public Date[] getStartAndEndDateOfMonth(int month) {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    
    cal.clear(); 
    cal.set(year, month, 1);
    Date startDate = new Date(cal.getTimeInMillis()); 
    

    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date endDate = new Date(cal.getTimeInMillis()); 
    
    return new Date[]{startDate, endDate};
}
   
   
   public Date[] getStartAndEndDatesOfYear(int year) {
    Calendar cal = Calendar.getInstance();
    

    cal.clear(); 
    cal.set(year, Calendar.JANUARY, 1);
    Date startDate = new Date(cal.getTimeInMillis()); 
    
    cal.clear(); 
    cal.set(year, Calendar.DECEMBER, 31);
    Date endDate = new Date(cal.getTimeInMillis());
    
    return new Date[]{startDate, endDate};
}

     
    public String AmountCollectMonthly(int month){
       BigDecimal totalPayment = BigDecimal.ZERO;
    Date[] dates = getStartAndEndDateOfMonth(month);
    Date startDate = dates[0];
    Date endDate = dates[1];
    
    String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    String user = "admin";
    String password = "12345";
    String query = "SELECT SUM(Payment) AS TotalPayment FROM customer_payment WHERE P_Date BETWEEN ? AND ?";
    
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setDate(1, startDate);
        pst.setDate(2, endDate);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalPayment = rs.getBigDecimal("TotalPayment");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return String.valueOf(totalPayment);
}
    
     public String SalariesPaidMonthly(int month){
            BigDecimal totalPayment = BigDecimal.ZERO;
    Date[] dates = getStartAndEndDateOfMonth(month);
    Date startDate = dates[0];
    Date endDate = dates[1];
    
    String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    String user = "admin";
    String password = "12345";
    String query = "SELECT SUM(Payment) AS TotalPayment FROM staff_payment WHERE P_Date BETWEEN ? AND ?";
    
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setDate(1, startDate);
        pst.setDate(2, endDate);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalPayment = rs.getBigDecimal("TotalPayment");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return String.valueOf(totalPayment);
}
    
      public String TotalExpensesMonthly(int month){
             BigDecimal totalPayment = BigDecimal.ZERO;
    Date[] dates = getStartAndEndDateOfMonth(month);
    Date startDate = dates[0];
    Date endDate = dates[1];
    
    String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    String user = "admin";
    String password = "12345";
    String query = "SELECT SUM(expense_amount) AS TotalPayment FROM expenses WHERE expense_date BETWEEN ? AND ?";
    
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setDate(1, startDate);
        pst.setDate(2, endDate);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalPayment = rs.getBigDecimal("TotalPayment");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return String.valueOf(totalPayment);
}
      
      public Double NetResultMonthly(int month){
    Double totalAmount = 0.0;
    Double totalKharcha = 0.0;
    
    String amountCollected = AmountCollectMonthly(month);
    if(amountCollected != null && !amountCollected.equals("null") && !amountCollected.isEmpty()){
        totalAmount = Double.valueOf(amountCollected);
    }
    
    String salariesPaid = SalariesPaidMonthly(month);
    String totalExpenses = TotalExpensesMonthly(month);
    if(salariesPaid != null && !salariesPaid.equals("null") && !salariesPaid.isEmpty()){
        totalKharcha += Double.valueOf(salariesPaid);
    }
    if(totalExpenses != null && !totalExpenses.equals("null") && !totalExpenses.isEmpty()){
        totalKharcha += Double.valueOf(totalExpenses);
    }
    
    Double result = totalAmount - totalKharcha;
    
    return result;
}
      
      
      
      
      
      
      
      public String AmountCollectYearly(int year){
       BigDecimal totalPayment = BigDecimal.ZERO;
    Date[] dates = getStartAndEndDatesOfYear(year);
    Date startDate = dates[0];
    Date endDate = dates[1];
    
    String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    String user = "admin";
    String password = "12345";
    String query = "SELECT SUM(Payment) AS TotalPayment FROM customer_payment WHERE P_Date BETWEEN ? AND ?";
    
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setDate(1, startDate);
        pst.setDate(2, endDate);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalPayment = rs.getBigDecimal("TotalPayment");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return String.valueOf(totalPayment);
}
    
     public String SalariesPaidYearly(int year){
            BigDecimal totalPayment = BigDecimal.ZERO;
    Date[] dates = getStartAndEndDatesOfYear(year);
    Date startDate = dates[0];
    Date endDate = dates[1];
    
    String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    String user = "admin";
    String password = "12345";
    String query = "SELECT SUM(Payment) AS TotalPayment FROM staff_payment WHERE P_Date BETWEEN ? AND ?";
    
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setDate(1, startDate);
        pst.setDate(2, endDate);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalPayment = rs.getBigDecimal("TotalPayment");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return String.valueOf(totalPayment);
}
    
      public String TotalExpensesYearly(int year){
             BigDecimal totalPayment = BigDecimal.ZERO;
    Date[] dates = getStartAndEndDatesOfYear(year);
    Date startDate = dates[0];
    Date endDate = dates[1];
    
    String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    String user = "admin";
    String password = "12345";
    String query = "SELECT SUM(expense_amount) AS TotalPayment FROM expenses WHERE expense_date BETWEEN ? AND ?";
    
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setDate(1, startDate);
        pst.setDate(2, endDate);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            totalPayment = rs.getBigDecimal("TotalPayment");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return String.valueOf(totalPayment);
}
      


public Double NetResultYearly(int year){
    Double totalAmount = 0.0;
    Double totalKharcha = 0.0;
    
    String amountCollected = AmountCollectYearly(year);
    if(amountCollected != null && !amountCollected.equals("null") && !amountCollected.isEmpty()){
        totalAmount = Double.valueOf(amountCollected);
    }
    
    String salariesPaid = SalariesPaidYearly(year);
    String totalExpenses = TotalExpensesYearly(year);
    if(salariesPaid != null && !salariesPaid.equals("null") && !salariesPaid.isEmpty()){
        totalKharcha += Double.valueOf(salariesPaid);
    }
    if(totalExpenses != null && !totalExpenses.equals("null") && !totalExpenses.isEmpty()){
        totalKharcha += Double.valueOf(totalExpenses);
    }
    
    Double result = totalAmount - totalKharcha;
    
    return result;
}


}
