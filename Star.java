package Starfield;

public class Star
{
	private int myX;

	private int myY;

	private int myDepth;

	private int mySpeed;

	public Star(int x, int y, int depth, int speed)
	{
		myX = x;
		myY = y;
		myDepth = depth;
		mySpeed = speed;
	}

	public void setDepth(int depth)
	{
		myDepth = depth;
	}

	public int getDepth()
	{
		return myDepth;
	}

	public int getX()
	{
		return myX;
	}

	public int getY()
	{
		return myY;
	}

	public int getSpeed()
	{
		return mySpeed;
	}
}
