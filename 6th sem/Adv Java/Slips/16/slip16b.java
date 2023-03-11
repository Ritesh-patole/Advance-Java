

//Write a Java program to accept the details of students (rno, sname, per) at least 5 Records, store it into database and display the details of student having highest percentage. (Use PreparedStatement Interface) 

import java.sql.*;
import java.util.*;

public class slip16b {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
            PreparedStatement pst = c.prepareStatement("insert into students values (?,?,?)");
            Scanner sc = new Scanner(System.in);

            int i = 0;
            while (i<5) {
                System.out.println("Enter rno: ");
                int rno = sc.nextInt();
                System.out.println("Enter student name : ");
                String sname = sc.next();
                System.out.println("Enter persentage : : ");
                int per = sc.nextInt();

                pst.setInt(1, rno);
                pst.setString(2, sname);
                pst.setInt(3, per);

                pst.executeUpdate();
                i++;
            }

            Statement st = c.createStatement();
            ResultSet rs1 = st.executeQuery("Select * from students where per = (select max(per) from students)");
            System.out.println("Student with highest percentage: ");
            while(rs1.next()){
                System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + 
                "\t" + rs1.getInt(3));
            }
            sc.close();


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}
