
public class HourlyEmployee extends StaffMember{
	private int hoursWorked;
	private double rate;
	public HourlyEmployee(int id,String name,String address,int hoursWorked,double rate) {
		super(id,name,address);
		this.hoursWorked=Math.abs(hoursWorked);
		this.rate=Math.abs(rate);
	}
	public String toString() {
		return " ID : " + id + ", Name : " + name + ", Address : " + address 
				+", HoursWorked : "+hoursWorked+", Rate : "+rate
				+ ", Payment : "+pay()+" ";
	}
	public double pay() {
		return hoursWorked*rate;
	}
}
