//Write a Java program to display sales details of Product (PID, PName, Qty, Rate,Amount) between two selected dates. (Assume Sales table is already created).

import java.sql.*;

public class slip11b {
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
        System.out.println("connected to DB");
        Statement st = c.createStatement();
        ResultSet rs1 = st.executeQuery("Select * from product");
        System.out.println("Product table");
        while (rs1.next()) {
            System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getInt(3) + " " + rs1.getInt(4) + " " + rs1.getInt(5) + " " + rs1.getDate(6));
        }
            
    
        
        String query = "Select * from product where dates between '2023/02/01' and '2023/04/01'";
        ResultSet rs = st.executeQuery(query);
        System.out.println("After Selecting dates between '2023/02/01' and '2023/04/01'  ");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getDate(6));
        }  
        c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
