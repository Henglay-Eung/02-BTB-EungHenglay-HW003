
public class SalariedEmployee extends StaffMember {
	private double salary;
	private double bonus;
	public SalariedEmployee(int id,String name,String address,double salary,double bonus)
	{
		super(id,name,address);
		this.salary=Math.abs(salary);
		this.bonus=Math.abs(bonus);
	}
	public String toString() {
		return " ID : " + id + ", Name : " + name + ", Address : " + address 
				+", Salary : "+salary+", Bonus : "+bonus+", Payment : "+pay();
	}
	public double pay() {
		return salary+bonus;
	}
}
