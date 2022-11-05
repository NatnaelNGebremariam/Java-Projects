import java.awt.Color;

public class MandelbrotTools {
	
	/*  STUDENTS:  Put your "isBig" and "divergence" methods here. */
	
	/*Compares norm with Divergence
	 * The method takes a ComplexNumber parameter and return a boolean
	 */
	public static boolean isBig(ComplexNumber other) {
		//Square the values retrieved from getReal & getImag method
		MyDouble real=other.getReal().multiply(other.getReal()); 
		MyDouble imag=other.getImag().multiply(other.getImag());;
		MyDouble sum= real.add(imag);//Add both Imag and Real Nums 
		
		//Compares sum to Controller.DIVERGENCE_BOUNDARY, 1= True, 0 =False
		int finalValue= sum.compareTo(Controller.DIVERGENCE_BOUNDARY);
		return finalValue>0;
	
	/*Takes in a parameter of a complexNumber and return the integer from the 
	 * sequence of complex numbers that was calculated
	 * Example: z1 = z0(^2) + z0 ,z2 = z1(^2) + z0, and etc.       
	*/	
	}public static int divergence(ComplexNumber z0) {
		int counter=0;
		ComplexNumber complexNumber=z0.multiply(z0).add(z0); //z1= z0^2+z0
		if(isBig(z0)) {
			return 0;
			
		}while (counter<=Controller.LIMIT) {
			if(isBig(complexNumber)) {
				return counter;
			}else {
				complexNumber=complexNumber.multiply(complexNumber).add(z0);
				counter+=1; //z1= z0^2+z0, z2= z0^2+z0 ......
			}
			
		}return -1;
		
	}
	
	
	/* This method selects a non-black color for a point which DIVERGED when tested with the Mandelbrot
	 * recurrence, based on how many terms in the sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was first to be "too big".  
	 * This value could be anything from 0 to Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if clause below which says
	 * "modify this block to create your own color scheme".  When someone runs the program and selects 
	 * "Student Color Scheme", the code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;
		
		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}
		
		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}
		
		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			
			
			/***************************************************************
			 * Modify this block to create your own color scheme!          *
			 ***************************************************************/
			returnValue = Color.WHITE;  // take this out and return something useful
			
			
		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}
	
	

}
