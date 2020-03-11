/*=============================================================================  
|   Source code:  BRectTester.java
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
| 		javac BRectTester.java BetterRectangle.java
|		java BRectTester
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  The program tests the implementation of the BetterRectangle class.
|				 It creates four BetterRectangle objects, using one of each
|			 	 constructor, and then tests the overloaded toString() and equals()
|				 methods, along with additional accessor, utility, and mutator
|				 methods. The output of each method is displayed alongside an
|				 expected value to ensure that each method is handling the
|				 hard-coded test cases properly and accurately.
|  
|        Input:  N/A
|  
|       Output:  The program will validate that all new features in the
|				 BetterRectangle sub-class are functioning. Output is clearly labeled,
|				 readable, and attractive. All method output is displayed alongside
|				 expected values for the hard-coded test cases for easy comparison.
|  
|      Process:  The program's steps are as follows:  
|  
|                1.  The program constructs the four BetterRectangle test cases.  
|                2.  The toString() method is printed for all four BetterRectangles.
|                3.  The accessor methods are tested on bRectA and printed.
|                4.  The utility methods are tested on bRectB & bRectC and printed.
|                5.  The mutator method is tested on bRectD and printed.
|  
|   Required Features Not Included:  All required features are included.  
|  
|   Known Bugs:  None; the program operates correctly. 
|
|  *===========================================================================*/

public class BRectTester
{
	public static void main(String[] args)
	{
		//input values for the test cases are hard-coded from the specifications
		//expected values are calculated using the documented formulas
		BetterRectangle bRectA = new BetterRectangle(3,4);
		System.out.println("A: " + bRectA.toString());
		
		BetterRectangle bRectB = new BetterRectangle(bRectA);
		System.out.println("B: " + bRectB.toString());

		BetterRectangle bRectC = new BetterRectangle(1,1,4,3);
		System.out.println("C: " + bRectC.toString());

		BetterRectangle bRectD = new BetterRectangle();
		System.out.println("D: " + bRectD.toString());

		System.out.printf("%nAccessor methods being executed for Rectangle A...%n");
		System.out.println("A: " + bRectA.toString());
		System.out.printf("%8s%10s", "Area:", bRectA.getArea());
		System.out.printf("%28s%n", "Expected: 12");
		System.out.printf("%13s%5s", "Perimeter:", bRectA.getPerimeter());
		System.out.printf("%28s%n", "Expected: 14");
		System.out.printf("%9s%11.2f", "Slope:", bRectA.getSlope());
		System.out.printf("%28s%n", "Expected: 1.33");
		System.out.printf("%12s%5s%d,%d)", "MidPoint:", "("
						  , (int)bRectA.getMidPoint().getX()
						  , (int)bRectA.getMidPoint().getY());
		System.out.printf("%28s%n", "Expected: (2,2)");

		System.out.printf("%nUtility methods being executed for Rectangle B and C...%n");
		System.out.println("B: " + bRectB.toString());
		System.out.println("C: " + bRectC.toString());
		System.out.printf("%10s%11s", "Equals?", bRectB.equals(bRectC));
		System.out.printf("%28s%n", "Expected: false");
		System.out.printf("%13s%8s", "Congruent?", bRectB.congruent(bRectC));
		System.out.printf("%28s%n", "Expected: false");
		System.out.printf("%14s%6s", "Equivalent?", bRectB.equivalent(bRectC));
		System.out.printf("%28s%n", "Expected: true");
		System.out.printf("%11s%9s", "Similar?", bRectB.similar(bRectC));
		System.out.printf("%28s%n", "Expected: true");
		System.out.printf("%14s%7s", "Concentric?", bRectB.concentric(bRectC));
		System.out.printf("%28s%n", "Expected: false");

		System.out.printf("%nMutator methods being executed for Rectangle D...%n");
		System.out.println("D: " + bRectD.toString());
		System.out.printf("%15s%6s", "Scale by  4?", bRectD.scaleBy(4));
		System.out.printf("%27s%n", "Expected: true");
		System.out.printf("%15s%7s", "Scale by -4?", bRectD.scaleBy(-4));
		System.out.printf("%27s%n", "Expected: false");
		System.out.println("D: " + bRectD.toString());
	}
}