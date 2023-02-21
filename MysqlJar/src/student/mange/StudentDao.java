package student.mange;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student st) {
		
		boolean f =false;
		//jdbc code.....
		try {
			 Connection con = ConnectionProvider.createc();
			 String q="insert into students(sname,sphone,scity) values(?,?,?)";
			 
			 //PreparedStatement
			 PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(q);
			 //set the value of parameter
			 pstmt.setString(1,st.getStudentName());
			 pstmt.setString(2,st.getStudentPhone());
			 pstmt.setString(3,st.getStudentCity());
			 
			 //execute...
			 pstmt.executeUpdate();
			 f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
		public static boolean deleteStudent(int userId) {
			boolean f =false;
			//jdbc code.....
			try {
				 Connection con = ConnectionProvider.createc();
				 String q="delete from student where sid=?";
				 
				 //PreparedStatement
				 PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(q);
				 //set the value of parameter
				 pstmt.setInt(1,userId);
				 				 
				 //execute...
				 pstmt.executeUpdate();
				 f=true;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return f;
		}
		public static void showAllStudent() {
			// TODO Auto-generated method stub
			try {
				Connection con =ConnectionProvider.createc();
				String q ="slect *from students()";
				Statement stmt = (Statement) con.createStatement();
				ResultSet set=stmt.executeQuery(q);
				while(set.next()) {
					int id=set.getInt(1);
					String name =set.getString(2);
					String phone =set.getString(3);
					String city =set.getString(4);
					
					System.out.println("ID :"+id);
					System.out.println("name :"+name);
					System.out.println("phone :"+phone);
					System.out.println("city :"+city);
					System.out.println("---------------------------");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
	}

