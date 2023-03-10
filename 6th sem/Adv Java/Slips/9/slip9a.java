//Write a Java Program to create a Emp (ENo, EName, Sal) table and insert record into it. (Use PreparedStatement Interface)

import java.sql.*;
import java.util.*;

class slip9a {
    public static void main( String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
            String query = "create table emp1 (eno int, ename varchar(34), sal int)";
            Statement sc = con.createStatement();
            sc.executeUpdate(query);
            sc.close() ;
        
            PreparedStatement ps = con.prepareStatement("insert into emp1 values(?,?,?)");

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter eno : ");
            int eno = scan.nextInt();
            System.out.println("Enter ename : ");
            String ename = scan.next();
            System.out.println("Enter sal : ");
            int sal = scan.nextInt();

            ps.setInt(1,eno);
            ps.setString(2, ename);
            ps.setInt(3,sal);

            ps.executeUpdate();




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}