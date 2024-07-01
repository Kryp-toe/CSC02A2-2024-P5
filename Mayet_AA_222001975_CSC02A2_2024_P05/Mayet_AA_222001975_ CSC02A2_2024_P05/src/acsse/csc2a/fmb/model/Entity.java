package acsse.csc2a.fmb.model;

public abstract class Entity
{
	private int xLocation;
	private double angle;
	
	public Entity(int xLocation, double angle)
	{
		this.angle = angle;
		this.xLocation = xLocation;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double getAngle()
	{
		return this.angle;
	}
	 
	public int	getXLocation()
	{
		return this.xLocation;
	}
	
	@Override
	public String toString()
	{
		String output = "########################################################################################\n"
					  + "**************************************READING ENTITY************************************\n"
					  + "########################################################################################";
		return output;
	}
}