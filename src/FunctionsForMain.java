import java.util.*;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class FunctionsForMain {
	public static void display(TreeSet<StaffMember> members)
	{
		Table table=new Table(1, BorderStyle.CLASSIC,ShownBorders.ALL);
		Iterator<StaffMember> iterator=members.iterator();
		while(iterator.hasNext())
			table.addCell(iterator.next().toString());
		
		System.out.println(table.render());
	}

	public static void addStaff(TreeSet<StaffMember> members)
	{
		String menuRegex="^[1-4]$";
		String menuChoice;
		boolean menuResult;
		Scanner input=new Scanner(System.in);
		System.out.println("\n1/. Volunteer  2/. Hourly Emp  3/. Salaried Emp  4/. Back\n");
		System.out.print("==> Choose option(1-4) : ");
		menuChoice=input.nextLine();
		menuResult=menuChoice.matches(menuRegex);
		if(menuResult)
		{
			if(!menuChoice.equals("4"))
			{
				StaffMember member=null;
				ArrayList data=insert();
				int id=(int) data.get(0);
				String name=(String)data.get(1);
				String address=(String)data.get(2);
				
				if(menuChoice.equals("1"))
				{
					member=new Volunteer(id,name,address);
				}
				else if(menuChoice.equals("2"))
				{
					int hoursWorked=0;
					double rate=0;
					System.out.print("==>Enter Hours Worked : ");
					hoursWorked=input.nextInt();
					System.out.print("==>Enter Rate : ");
					rate=input.nextDouble();
					member=new HourlyEmployee(id,name,address,hoursWorked,rate);
				}
				else
				{
					double salary=0;
					double bonus=0;
					System.out.print("==>Enter Staff's Salary : ");
					salary=input.nextDouble();
					System.out.print("==>Enter Staff's Bonus : ");
					bonus=input.nextDouble();
					member=new SalariedEmployee(id,name,address,salary,bonus);
				}
				members.add(member);
			}
			else
				return;
		}
		else
			System.out.println("Please input number between 1 and 4!");
	}
	public static ArrayList insert()
	{
		int id;
		String name,address;
		ArrayList data=new ArrayList();
		Scanner input=new Scanner(System.in);
		System.out.print("=========== Insert Info =========\n");
		System.out.print("==>Enter Staff Member's ID : ");
		id=input.nextInt();
		input=new Scanner(System.in);
		System.out.print("==>Enter Staff Member's Name : ");
		name=input.nextLine();
		System.out.print("==>Enter Staff Member's Address : ");
		address=input.nextLine();
		name=name.toUpperCase().charAt(0)+name.substring(1);
		data.add(id);
		data.add(name);
		data.add(address);
		return data;
	}
	public static void editStaff(TreeSet<StaffMember> members) {
		int id;
		Scanner input=new Scanner(System.in);
		System.out.print("=========== Edit Info =========\n");
		System.out.print("==> Enter Employee's ID to update : ");
		id=input.nextInt();
		for(StaffMember member : members)
		{
			if(member.id==id)
			{
				System.out.println(member.toString());
				System.out.print("\n=========== NEW INFORMATION OF STAFF MEMBER =========\n\n");
				System.out.print("==>Enter Staff Member's Name : ");
				input=new Scanner(System.in);
				String name=input.nextLine();
				System.out.print("==>Enter Staff Member's Address : ");
				String address=input.nextLine();
				members.remove(member);
				if(member.getClass().getName()=="Volunteer")
					members.add(new Volunteer(id,name,address));
				else if(member.getClass().getName()=="HourlyEmployee")
				{
					int hour=-1;
					double rate=-1;
					while(hour<0||rate<0)
					{
						System.out.print("==>Enter New Hour : ");
						hour=input.nextInt();
						System.out.print("==>Enter New Rate : ");
						rate=input.nextDouble();
					}
					members.add(new HourlyEmployee(id,name,address,hour,rate));
				}
				else
				{
					double salary=-1;
					double bonus=-1;
					while(salary<0||bonus<0)
					{
						System.out.print("==>Enter New Salary : ");
						salary=input.nextInt();
						System.out.print("==>Enter New Bonus : ");
						bonus=input.nextDouble();
					}
					members.add(new SalariedEmployee(id,name,address,salary,bonus));
				}
				return;
			}
		}
		System.out.println("Cannot find the member\n");
	}
	
	public static void removeStaff(TreeSet<StaffMember> members) {
		int id;
		Scanner input=new Scanner(System.in);
		System.out.print("=========== Delete =========\n\n");
		System.out.print("==> Enter Emplyee's ID to remove : ");
		id=input.nextInt();
		for(StaffMember member : members)
		{
			if(member.id==id)
			{
				System.out.println(member.toString());
				members.remove(member);
				System.out.println("Removed successfully!");
				return;
			}
		}
		System.out.println("Cannot find the member\n");
	}
}
