package com.css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import student.mange.Student;
import student.mange.StudentDao;

public class StudentManagementApp {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		System.out.println("Wellcome to Student");
		InputStreamReader a=new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(a);
		while(true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to display student");
			System.out.println("PRESS 4 to exit student");
			int c=Integer.parseInt(br.readLine());
			
			if (c==1) {
				//add student..
				System.out.println("Enter user name :");
				String name=br.readLine();
				
				System.out.println("Enter user phone : ");
				String phone=br.readLine();
				
				System.out.println("Enter user City :");
				String City=br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, City);
				boolean answer=StudentDao.insertStudentToDB(st);
				if (answer) {
					System.out.println("Student is addeded successfully....");
				}else {
					System.out.println("something went wrong try again....");
				}
				System.out.println(st);
				
			}else if (c==2) {
				//delete student..
				System.out.println("Enter student id to delete...");
				int userId = Integer.parseInt(br.readLine());
				boolean f= StudentDao.deleteStudent(userId);
				if (f) {
					System.out.println("Deleted....");
				}else {
					System.out.println("something went wrong.....");
				}
				
			}else if (c==3) {
				//display student..
				StudentDao.showAllStudent();
			}else if (c==4) {
				//exit student..
				break;
			}else {
				
			}
		}
			System.out.println("Thankyou for using my application....");
			System.out.println("see you soon...bye bye");
	}

}
	