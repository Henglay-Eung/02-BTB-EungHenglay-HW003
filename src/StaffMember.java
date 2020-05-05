public abstract class StaffMember implements Comparable<StaffMember>{
	protected int id;
	protected String name;
	protected String address;
	public StaffMember(int id,String name,String address)
	{
		this.id=id;
		this.name=name;
		this.address=address;
	}
	public String toString() {
		return "\n ID : " + id + "\n Name : " + name + "\n Address : " + address;
	}
	public abstract double pay();
	
	public int compareTo(StaffMember member)
	{	
		return name.compareTo(member.name);
	}
}
