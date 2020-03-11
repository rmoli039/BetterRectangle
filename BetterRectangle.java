/*=======================================================================
|   Source code:  BetterRectangle.java
|
|         Class:  BetterRectangle 
|
|        Author:  Richard Molina
|    Student ID:  6140544
|    Assignment:  Program #4 - Better Rectangle
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U08
|        Instructor:  William Feild  
|          Due Date:  18 October 2018, at the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|     Language:  Java 
|  Compile/Run:   
| 		javac BetterRectangle.java
| 
|        Purpose:  This class serves as a subclass of the default Rectangle 
|				   class, extending it to provide further implementation.
|				   BetterRectangle allows the construction of BetterRectangle
|				   in 4 different ways, provides accessor methods for
|				   various rectangle features, provides various utility methods
|				   to compare BetterRectangle objects, and provides a mutator
|				   method to scale BetterRectangle objects. It also overrides
|				   the equals() and toString() methods from the default class
|				   so that they better serve BetterRectangle objects.
|
|  Inherits From:  Rectangle
|
|     Interfaces:  None
|
|  +-----------------------------------------------------------------------
|
|      Constants:  DEFAULT_POINT is a point object initialized to (0,0).
|				   This is the default anchor point for constructed
|				   rectangles when the constructor does not specify an
|				   anchor point to assign.
|
|				   DEFAULT_WIDTH is initialized to 1. This is the default
|				   width for constructed rectangles when the constructor
|				   does not specify a width to assign.
|
|				   DEFAULT_HEIGHT is initialized to 1. This is the default
|				   height for constructed rectangles when the constructor
|				   does not specify a height to assign.
|
|				   DECIMAL_PLACES is initialized to 2, the desire number of
|				   accurate decimal places to be used for rounding of
|				   floating point numbers.
|
| +-----------------------------------------------------------------------
|
|     Constructors:  BetterRectangle
|                     - Constructs a BetterRectangle
|					  - Sets the anchor point to DEFAULT_POINT
|					  - Sets the width to DEFAULT_WIDTH
|					  - Sets the height to DEFAULT_HEIGHT
|					 BetterRectangle
|                     - Constructs a BetterRectangle
|					  - Sets the anchor point to DEFAULT_POINT
|					  - Takes input for and sets the width
|					  - Takes input for and sets the height
|					 BetterRectangle
|                     - Constructs a BetterRectangle
|					  - Takes input for an x-coordinate
|					  - Takes input for a y-coordinate
|					  - Sets the anchor point to (x,y)
|					  - Takes input for and sets the width
|					  - Takes input for and sets the height
|					 BetterRectangle
|                     - Constructs a BetterRectangle
|					  - Takes a BetterRectangle object as input
|					  - Copies/sets the width from the input BetterRectangle
|					  - Copies/sets the height from the input BetterRectangle
|					  - Copies/sets the anchor from the input BetterRectangle
|
|    Class Methods:  None
|
| Instance Methods:  equals(Object otherRectangle)
|					  - Returns true/false whether the two rectangles are identical
|					 toString()
|					  - Returns a string of all data/calculations for the rectangle
|					 getArea()
|					  - Returns the area of the rectangle
|					 getPerimeter()
|					  - Returns the perimeter of the rectangle
|					 getSlope()
|					  - Returns the rounded slope of the rectangle
|					 getMidPoint()
|					  - Returns the rounded mid-point of the rectangle
|					 congruent(BetterRectangle otherRectangle)
|					  - Returns true/false whether the two rectangles are congruent
|					 equivalent(BetterRectangle otherRectangle)
|					  - Returns true/false whether the two rectangles are equivalent
|					 similar(BetterRectangle otherRectangle)
|					  - Returns true/false whether the two rectangles are similar
|					 concentric(BetterRectangle otherRectangle)
|					  - Returns true/false whether the two rectangles are concentric
|					 scaleBy(int scale)
|					  - Returns true/false whether scaling by the input is possible
|					  - Scales the rectangle's width & height by the input
|
|  *===========================================================================*/

import java.awt.Rectangle;   //Allows the use the default rectangle class
import java.awt.Point;   //Allows the creation/use of point objects
import java.math.*;   //Allows the use of the pow, ceil, and round functions

public class BetterRectangle extends Rectangle
{
	private static final Point DEFAULT_POINT = new Point(0,0);
	private static final int DEFAULT_WIDTH = 1;
	private static final int DEFAULT_HEIGHT = 1;
	private static final int DECIMAL_PLACES = 2;
	
	public BetterRectangle()
	{
		super.setLocation(DEFAULT_POINT);
		super.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public BetterRectangle(int rectangleWidth, int rectangleHeight)
	{
		super.setLocation(DEFAULT_POINT);
		super.setSize(rectangleWidth,rectangleHeight);
	}
	
	public BetterRectangle(int xPoint, int yPoint, int rectangleWidth, int rectangleHeight)
	{
		super.setLocation(xPoint,yPoint);
		super.setSize(rectangleWidth,rectangleHeight);
	}
	
	public BetterRectangle(BetterRectangle originalRectangle)
	{
		super.setLocation(originalRectangle.getLocation());
		super.setSize(originalRectangle.getSize());
	}
	
	/*---------------------------- equals ----------------------------
    |  Method equals (otherRectangle)
    |
    |  Purpose:  To return true/false whether or not the two
    |			 BetterRectangle objects are identical to one another.
    |			 Includes a check to ensure that the object input is a
    |			 BetterRectangle object, returning false if not.
    |
    |  @param	 otherRectangle the BetterRectangle you are comparing with
    |
    |  @return  true/false whether the two rectangles are identical
    *-------------------------------------------------------------------*/
	@Override
	public boolean equals(Object otherRectangle)
	{
		if (!(otherRectangle instanceof BetterRectangle))
		{
			return false;
		}	//close if
		else if (!super.equals(otherRectangle))
		{
			return false;
		}	//close else if
		else
		{
			return true;
		}	//close else
	}	//close equals method
	
	/*---------------------------- toString ----------------------------
    |  Method toString ()
    |
    |  Purpose:  To return a string displaying the features and calculations
    |			 for the BetterRectangle object, including its anchor point,
    |			 width, height, area, perimeter, slope, and mid-point. 
    |
    |  @param	  
    |
    |  @return  a string of all data/calculations for the rectangle
    *-------------------------------------------------------------------*/
	@Override
	public String toString()
	{
		return getClass().getName() + "[x=" + getX() + ",y=" + getY() 
			   + " width=" + getWidth() + ", height=" + getHeight()
			   + ", area=" + getArea() + ", perimeter=" + getPerimeter()
			   + ", slope=" + getSlope() + ", mid-point=" + getMidPoint() + "]";
	}	//close toString method
	
	/*---------------------------- getArea ----------------------------
    |  Method getArea ()
    |
    |  Purpose:  Calculate and return the area of the BetterRectangle.
    |  			 The formula for the area is: width * height.
    |
    |			 Source: COP 3337 Assignment 4 specifications
    |
    |  @param	 
    |
    |  @return  the rectangle's area as an integer
    *-------------------------------------------------------------------*/
	public int getArea()
	{
		return (int)(getWidth() * getHeight());
	}	//close getArea method
	
	/*---------------------------- getPerimeter ----------------------------
    |  Method getPerimeter ()
    |
    |  Purpose:  Calculate and return the perimeter of the BetterRectangle.
    |  			 The formula for the perimeter is: 2 * (width + height).
    |
    |			 Source: COP 3337 Assignment 4 specifications
    |
    |  @param	 
    |
    |  @return  the rectangle's perimeter as an integer
    *-------------------------------------------------------------------*/
	public int getPerimeter()
	{
		return 2 * (int)(getWidth() + getHeight());
	}	//close getPerimeter method
	
	/*---------------------------- getSlope ----------------------------
    |  Method getSlope ()
    |
    |  Purpose:  Calculate and return the slope of the BetterRectangle.
    |  			 The formula for the slope is: height / width.
    |
    |			 The output is rounded to be accurate to DECIMAL_PLACES
    |			 number of decimal places. The formula to round to a
    |			 certain number of decimal places is: multiply the input
    |			 by 10^DECIMAL_PLACES, round to the nearest whole number,
    |			 and then divide by 10^DECIMAL_PLACES.
    |
    |			 Source: COP 3337 Assignment 4 specifications
    |            Source: mkyong.com/java/how-to-round-double-float-value-
    |					 to-2-decimal-points-in-java/
    |
    |  @param	 
    |
    |  @return  the rectangle's slope, accurate to DECIMAL_PLACES
    *-------------------------------------------------------------------*/
	public double getSlope()
	{
		double slope = getHeight() / getWidth();
		double decimalScale = Math.pow(10, DECIMAL_PLACES);
		return Math.round(slope * decimalScale) / decimalScale; 
	}	//close getSlope method
	
	/*---------------------------- getMidPoint ----------------------------
    |  Method getMidPoint ()
    |
    |  Purpose:  Calculate and return the mid-point of the BetterRectangle.
    |  			 The coordinates of the mid-point are obtained using 
    |			 the inherited getCenterX() and getCenterY() methods.
    |
    |			 The mid-point coordinates are rounded up to the nearest
    |			 integer using the Math.ceil function.
    |
    |  @param	 
    |
    |  @return  the rectangle's mid-point, with each coordinate rounded up
    *-------------------------------------------------------------------*/
	public Point getMidPoint()
	{
		int xCoordinate = (int)Math.ceil(getCenterX());
		int yCoordinate = (int)Math.ceil(getCenterY());
		Point midPoint = new Point(xCoordinate,yCoordinate);
		return midPoint; 
	}	//close getMidPoint method
	
	/*---------------------------- congruent ----------------------------
    |  Method congruent (otherRectangle)
    |
    |  Purpose:  To return true/false whether or not the two
    |			 BetterRectangle objects are congruent to one another.
    |			 Two rectangles are congruent when they have the same
    |			 widths and heights.
    |			 
    |			 Source: COP 3337 Assignment 4 specifications
	|
    |  @param	 otherRectangle the BetterRectangle you are comparing with
    |
    |  @return  true/false whether the two rectangles are congruent
    *-------------------------------------------------------------------*/
	public boolean congruent(BetterRectangle otherRectangle)
	{
		if (getWidth() == otherRectangle.getWidth()
				&& getHeight() == otherRectangle.getHeight())
		{
			return true;
		}	//close if
		else
		{
			return false;
		}	//close else
	}	//close congruent method
	
	/*---------------------------- equivalent ----------------------------
    |  Method equivalent (otherRectangle)
    |
    |  Purpose:  To return true/false whether or not the two
    |			 BetterRectangle objects are equivalent to one another.
    |			 Two rectangles are equivalent when they have the same
    |			 perimeter.
    |			 
    |			 Source: COP 3337 Assignment 4 specifications
	|
    |  @param	 otherRectangle the BetterRectangle you are comparing with
    |
    |  @return  true/false whether the two rectangles are equivalent
    *-------------------------------------------------------------------*/
	public boolean equivalent(BetterRectangle otherRectangle)
	{
		if (getPerimeter() == otherRectangle.getPerimeter())
		{
			return true;
		}	//close if
		else
		{
			return false;
		}	//close else
	}	//close equivalent method
	
	/*---------------------------- similar ----------------------------
    |  Method similar (otherRectangle)
    |
    |  Purpose:  To return true/false whether or not the two
    |			 BetterRectangle objects are similar to one another.
    |			 Two rectangles are similar when they have the same
    |			 area.
    |			 
    |			 Source: COP 3337 Assignment 4 specifications
	|
    |  @param	 otherRectangle the BetterRectangle you are comparing with
    |
    |  @return  true/false whether the two rectangles are similar
    *-------------------------------------------------------------------*/
	public boolean similar(BetterRectangle otherRectangle)
	{
		if (getArea() == otherRectangle.getArea())
		{
			return true;
		}	//close if
		else
		{
			return false;
		}	//close else
	}	//close similar method
	
	/*---------------------------- concentric ----------------------------
    |  Method concentric (otherRectangle)
    |
    |  Purpose:  To return true/false whether or not the two
    |			 BetterRectangle objects are concentric to one another.
    |			 Two rectangles are concentric when they have the same
    |			 mid-point.
    |			 
    |			 Source: COP 3337 Assignment 4 specifications
	|
    |  @param	 otherRectangle the BetterRectangle you are comparing with
    |
    |  @return  true/false whether the two rectangles are concentric
    *-------------------------------------------------------------------*/
	public boolean concentric(BetterRectangle otherRectangle)
	{
		if (getMidPoint().equals(otherRectangle.getMidPoint()))
		{
			return true;
		}	//close if
		else
		{
			return false;
		}	//close else
	}	//close concentric method
	
	/*---------------------------- scaleBy ----------------------------
    |  Method scaleBy (scale)
    |
    |  Purpose:  To scale the rectangle's width & height by the input.
    |			 This is done by multiplying the rectangle's width and
    |			 height by the scale value.
    |
    |			 The scale value must be a fixed positive integer.
    |			 An input scale value <= 0 is not valid and returns
    |			 false without mutating the rectangle.
    |
    |			 Source: COP 3337 Assignment 4 specifications
	|
    |  @param	 scale the scale value to scale the rectangle by
    |
    |  @return  true/false whether scaling by the input is possible
    *-------------------------------------------------------------------*/
	public boolean scaleBy(int scale)
	{
		if (scale <= 0)
		{
			return false;
		}	//close if
		else
		{
			int newWidth = (int)(getWidth() * scale);
			int newHeight = (int)(getHeight() * scale);
			setSize(newWidth, newHeight);
			return true;
		}	//close else
	}	//close scaleBy method
}