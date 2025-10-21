package in.hirbernet.Mymainclass;

import java.util.Scanner;

public class MyclassApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean z=true;
		 while(z) {
			 System.out.println("inset opration press 1");
			 System.out.println("display opration press 2");
			 System.out.println("delete opration press 3");
			 System.out.println("update opration prsee 4");
			 System.out.println("Exit press 5");
			 int value=scanner.nextInt();
			 switch (value) {
			case 1: CallAllfunction.insertopration();
				break;
				
			case 2: System.out.println("Enter the id display a record");
			       int id=scanner.nextInt();
			       CallAllfunction.display(id);
			       break;
			       
			 case 3:  System.out.println("Enter the id delete the record");
			        int idd=scanner.nextInt();
				    CallAllfunction.delete(idd);
			 		break;
			 		
			 case 4: 
				   System.out.println("Enter the id update the record");
				    int idu=scanner.nextInt();
				    CallAllfunction.update(idu);
			 		break;
			 		
			 case 5 : System.out.println("exit");
			 			z=false;
			 			break;
			 			 
			default: System.out.println("invaild option try again");
				break;
			}
			 
		 }
		 System.out.println("all the resourse is clear");
		 scanner.close();
	}

}
