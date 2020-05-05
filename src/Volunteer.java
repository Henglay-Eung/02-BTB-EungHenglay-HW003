
public class Volunteer extends StaffMember{
	public Volunteer(int id,String name,String address)
	{
		super(id,name,address);
	}
	
	public String toString() {
		return " ID : " + id + ", Name : " + name + ", Address : " + address +", Thank!";
	}

	public double pay() {
		return 0;
	}
}
