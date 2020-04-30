package Starfield;

import javax.microedition.lcdui.Graphics;
import java.util.Random;

public class Starfield
{
	private final int myNumberOfStars = 40;

	private int myDepthOfSpace = 100000;

	private int myDistanceBetween = 5000;

	private int myWidth;

	private int myHeight;

	private Star myStars[];

	public Starfield(int width, int height)
	{
		myWidth = width;
		myHeight = height;

		// allocate Stars array
		myStars = new Star[myNumberOfStars];

		// Init random number generator
		Random rand = new Random(System.currentTimeMillis());

		// initialize Stars with random coordinates and depths between 60000 and
		// 100000
		for (int i = 0; i < myNumberOfStars; i++)
		{
			myStars[i] = new Star(rand.nextInt(myWidth),
					rand.nextInt(myHeight), rand.nextInt(myDepthOfSpace),
					1000 + rand.nextInt(100));
		}
	}

	public void animate()
	{
		Random rand = new Random(System.currentTimeMillis());

		// move stars
		for (int i = 0; i < myNumberOfStars; i++)
		{
			myStars[i].setDepth(myStars[i].getDepth() - myStars[i].getSpeed());
			if (myStars[i].getDepth() <= 0)
			{
				myStars[i] = null;
				myStars[i] = new Star(rand.nextInt(myWidth), rand.nextInt(myHeight), 
						rand.nextInt(myDepthOfSpace), 1000 + rand.nextInt(100));
			}
		}
	}

	// todo
	// tunneleffekt verstärken
	// sterne müsssen alle aus dem bildschirm fliegen
	public void draw(Graphics g)
	{
		// draw empty space
		g.setColor(0, 0, 0);
		g.fillRect(0, 0, myWidth, myHeight);

		// calculate center of starfield
		int centerx = myWidth / 2;
		int centery = myHeight / 2;

		// draw each star
		for (int i = 0; i < myNumberOfStars; i++)
		{
			int dx = myStars[i].getX() - centerx;
			int dy = myStars[i].getY() - centery;
			double quotient = ((double) myStars[i].getDepth() / myDepthOfSpace);
			int realx = 0;
			int realy = 0;

			 if (myStars[i].getDepth() <= myDistanceBetween)
			 {
				 // let star run out of screen
			 }
			 else
			 {
				// since J2ME does not suppot the asin funtion we have to
				// calculate the slope of the
				// line from center to dx/dy and scale that value
				realx = (int) (centerx + (dx * (1.0 - quotient)));
				realy = (int) (centery + (dy * (1.0 - quotient)));
			}

			// the size of a star is between 1 and 6x6 pixels so calculate the
			// size and color and draw
			// the star with the center of realx/realy
			int starsize = (int) (6 * (1.0 - quotient));
			int colorvalue = (int) (255 * (1.0 - quotient));
			g.setColor(colorvalue, colorvalue, colorvalue);
			g.fillRect(realx, realy, starsize, starsize);
		}
	}
}
