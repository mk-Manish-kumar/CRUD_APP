package in.hirbernet.Mymainclass;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.hirbernet.model.Studentdata;
import in.hirbernet.utill.Utill;

public class CallAllfunction {

	private static Session session;
	private static Transaction transaction;
	private static boolean flag=false;
	private static Session session2;
	private static Studentdata studentdata;
	private static Session session3;
	private static Studentdata studentdata2;
	private static Transaction transaction2;
	private static Session session4;
	private static Transaction transaction3;
	private static Studentdata studentdata3;

	 
	public static void insertopration() {
		Scanner scanner=new Scanner(System.in);
		try {
		session = Utill.getsession();
		if(session!=null) {
			transaction = session.beginTransaction();
		}
		 
		System.out.println("Enter the id ");
		int id=scanner.nextInt();
		System.out.println("Enter the name");
		String nameString=scanner.next();
		System.out.println("Enter the address");
		String addressString=scanner.next();
		System.out.println("Enter the age");
		String ageString=scanner.next();
		if(transaction!=null) {
			Studentdata studentdata=new Studentdata();
			 studentdata.setId(id);
			 studentdata.setNameString(nameString);
			 studentdata.setAddressString(addressString);
			 studentdata.setAge(Integer.parseInt(ageString));
			 
			 session.persist(studentdata);
			 flag=true;
		}else {
			System.exit(0);
		}
		}catch ( HibernateException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			 e.printStackTrace();
		}finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("save the record in database..");
			}else {
				transaction.rollback();
				System.out.println("faild...");
			}
			 
		}
		
	}
	public static void display(int id) {
		try {
			session2 = Utill.getsession();
			if(session2!=null) {
				studentdata = session2.get(Studentdata.class, id);
				if(studentdata!=null) {
					System.out.println(studentdata);
					 
				}else {
					System.out.println("record not found");
				}
			}
		}catch ( HibernateException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			 e.printStackTrace();
		} 
	}
	public static void delete(int id) {
		try {
			session3 = Utill.getsession();
			if(session3!=null) {
				    transaction2 = session3.beginTransaction();
			}if(transaction2!=null) {
				studentdata2 = session3.get(Studentdata.class, id);
				  if(studentdata2!=null) {
					  session3.remove(studentdata2);
					  transaction2.commit();
					  System.out.println("delete is sucess");
				  }else {
					  transaction2.rollback();
					System.out.println("record is not found");
				}
			}
		}catch ( HibernateException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public static void update(int id) {
		try {
			Scanner scanner=new Scanner(System.in);
			session4 = Utill.getsession();
			if(session4!=null) {
				transaction3 = session4.beginTransaction();
			}
			if(transaction3!=null) {
				studentdata3 = session4.get(Studentdata.class, id);
			}
			if(studentdata3!=null) {
				System.out.println("old data is  "+ studentdata3);
				System.out.println("Enter the name");
				String nameString=scanner.next();
				System.out.println("Enter the address");
				String addtessString=scanner.next();
				System.out.println("Enter the age");
				String ageString=scanner.next();
				
				studentdata3.setNameString( nameString);
				studentdata3.setAddressString(addtessString);
				 
				studentdata3.setAge( Integer.parseInt(ageString));
			
				session4.merge(studentdata3);
				transaction3.commit();
				System.out.println("sucessfull update");
			}else {
				System.out.println("not record found  update");
			}
		}catch ( HibernateException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
