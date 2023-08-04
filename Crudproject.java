package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Crudproject {

	public static void main(String[] args) {
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.insert");
			System.out.println("2.select");
			System.out.println("3.update");
			System.out.println("4.delete");
			System.out.println("5.exit");
			   int a=sc.nextInt();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/javademodb";
		    String user="root";
		    String pass="";
		    Connection con=DriverManager.getConnection(url,user,pass);
		    switch(a)
		    {
		    case 1:
		    System.out.println("enter the employee id");
			int id=sc.nextInt();
			System.out.println("enter the employeee name");
			String name=sc.next();
			System.out.println("enter the employee department");
			String dept=sc.next();
			System.out.println("enter the employeee salary");
			float sal=sc.nextFloat();
			System.out.println("enter the emplyee exprience");
			String exp=sc.next();		     
		    String q="Insert into employee values(?,?,?,?,?)";
		    PreparedStatement  ps=con.prepareStatement(q);
            ps.setInt(1, id);
            ps.setString(2,name);
            ps.setString(3,dept);
            ps.setFloat(4, sal);
            ps.setString(5,exp);
            int a1=ps.executeUpdate();
            if(a1!=0)
                 {
            	  System.out.println("-------------employee details inserted------------");
                 }
                else
                 {
            	  System.out.println("----------not inserted--------");
                 }
              break;
              case 2:
              String q1="select * from employee";
 		      Statement st=con.createStatement();
 		      ResultSet rs=st.executeQuery(q1);
 		      System.out.println("employeeid---");
 		      while(rs.next())
 		        {
 		    	System.out.println(rs.getInt("employeeid"));
 		    	System.out.println(rs.getString("employeename"));
 		    	System.out.println(rs.getString("employeedepartment"));
 		    	System.out.println(rs.getFloat("employeesalary"));    
 		    	System.out.println(rs.getString("employeeexperience"));
 		        }
              case 3:
		      System.out.println("enter the employeename");
		         String employeename=sc.next();
		      System.out.println("enter the employeexperience");
		         String employeeexperience=sc.next();
		      System.out.println("enter the employeedapartment");
		         String employeedepartment=sc.next();
		      System.out.println("enter the employee salary");
		         float employeesalary=sc.nextFloat();
		      System.out.println("enter the employee id");
		          int empid=sc.nextInt();
		      String q2="update employee set employeename=?,employeeexperience=?,employeedepartment=?,employeesalary=? where employeeid=?";
			  PreparedStatement ps1=con.prepareStatement(q2); 
			    ps1.setString(1,employeename);
			    ps1.setString(2, employeeexperience);
				ps1.setString(3, employeedepartment);
				ps1.setFloat(4,employeesalary);
				ps1.setInt(5,empid);				
				int update=ps1.executeUpdate();
				  if(update!=0)
				{
					System.out.println("updated");
				}
				else
				  {
					System.out.println("not updated");
				  }
             break;
              case 4:
            	 System.out.println("enter the employee id");
            	  int employeeid=sc.nextInt();
                 String q3="delete from employee where id=?";
		         PreparedStatement ps2=con.prepareStatement(q3);
		         ps2.setInt(1, employeeid);
   	             int delete=ps2.executeUpdate();
   	             if(delete!=0)
   	              {
   		        System.out.println("deleted");
   	              }
   	              else
   	              {
   		        System.out.println("not deleted:");
   	             }
   	          break;
   	          default :
   	           {
   		      System.out.println("exit-----the program");
   	          }
		     }
		     sc.close();
		     con.close();
		}
       catch(ClassNotFoundException |SQLException e)
		{
	     System.out.println(e);
		}
		finally
		{
			System.out.println("than you------welcome again-----");
		}
		
	}   
}
