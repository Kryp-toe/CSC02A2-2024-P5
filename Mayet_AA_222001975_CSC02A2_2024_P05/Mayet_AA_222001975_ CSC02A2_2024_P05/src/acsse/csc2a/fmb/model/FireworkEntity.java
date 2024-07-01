package acsse.csc2a.fmb.model;

public class FireworkEntity extends Entity
{
	private Firework firework;
	
	public FireworkEntity(int xLocation, double angle, Firework firework)
	{
		// TODO Auto-generated constructor stub
		super(xLocation, angle);
		this.firework = firework;
		
	}
	
	public final Firework getFirework()
	{
		return this.firework;
	}
	 
	public String toString()
	{
		String output = super.toString() + "\n"
				+ this.firework.toString() + "\n";
		return output;
	}
}
