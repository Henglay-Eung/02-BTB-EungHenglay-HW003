import java.util.*;
public class Main {

	public static void main(String[] args) {
		TreeSet<StaffMember> members=new TreeSet<StaffMember>();
		String menuRegex="^[1-4]$";
		String menuChoice;
		boolean menuResult;
		Scanner input=new Scanner(System.in);
		StaffMember volunteer=new Volunteer(1,"B","Phnom Penh");
		StaffMember hourlyEmployee=new HourlyEmployee(2,"Az","Phnom Penh",20,10); 
		StaffMember salariedEmployee=new SalariedEmployee(3,"C","Phnom Penh",20,10);
		members.add(volunteer);
		members.add(hourlyEmployee);
		members.add(salariedEmployee);
		while(true)
		{
			FunctionsForMain.display(members);
			System.out.println("\n1/. Add Employee  2/. Edit  3/. Remove  4/. Exit\n");
			System.out.print("==> Choose option(1-4) : ");
			menuChoice=input.nextLine();
			menuResult=menuChoice.matches(menuRegex);
			if(menuResult)
			{
				if(menuChoice.equals("1"))
					FunctionsForMain.addStaff(members);
				else if(menuChoice.equals("2"))
					FunctionsForMain.editStaff(members);
				else if(menuChoice.equals("3"))
					FunctionsForMain.removeStaff(members);
				else if(menuChoice.equals("4"))
				{
					System.out.println("Good Bye!");
					System.exit(0);
				}
					
			}
			else
				System.out.println("Please Input number between 1 and 4!");
		}
		
	}

}
