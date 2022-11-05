/*A class that deals with Imaginary and Real Numbers 
 * The class provides features like adding, subtracting, dividing and 
 * multiplying
*/
public class ComplexNumber {
	
	private final MyDouble real;  // To be initialized in constructors
	private final MyDouble imag;  // To be initialized in constructors
	
	
	//Constructor takes in two parameters to set the instance variables a value
	public ComplexNumber(MyDouble real, MyDouble imag) {
		this.real=real;
		this.imag=imag;
		
	/*Constructor takes in a parameters for real and set it to the value
	 * imag is set to 0	
	 */
	}public ComplexNumber(MyDouble real){
		this.real=real;
		this.imag= new MyDouble(0); //Set this to Zero
		
	//Copy Constructor of ComplexNumber
	}public ComplexNumber(ComplexNumber other){
		real=other.real;
		imag=other.imag;
	
	//A method that returns the real number	
	}public MyDouble getReal(){
		return this.real;
		
	//A method that gets the value of the imaginary number	
	}public MyDouble getImag() {
		return this.imag;
		
	/*A method that returns the sum of the current object 
	 * and the ComplexNumber parameter
	 */
	}public ComplexNumber add(ComplexNumber addNums){
		MyDouble realNums=addNums.getReal().add(this.real);//Add's the Real Num
		MyDouble imagNums= addNums.getImag().add(this.imag);//Add the Imag Num
		//Combines Real and Imag Values
		ComplexNumber complexNumber= new ComplexNumber(realNums,imagNums); 
		
		return complexNumber;
		
	/*A method that returns the difference of the current object 
	* and the ComplexNumber parameter
	 */	
	}public ComplexNumber subtract(ComplexNumber subNums) {
		//Subtract's values of Imag and Real Values
		MyDouble realNums=this.real.subtract(subNums.getReal());
		MyDouble imagNums= this.imag.subtract(subNums.getImag());
		//Combines Real and Imag Values
		ComplexNumber complexNumber= new ComplexNumber(realNums,imagNums); 
		
		return complexNumber;

		
	/*A method that returns the product of the current object 
	* and the ComplexNumber parameter
	*/		
	}public ComplexNumber multiply(ComplexNumber multiNums) {
		//Assigns the Values for Real 
		MyDouble valueReal=	multiNums.getReal();
		MyDouble real=this.real;
		
		//Assigns the Values for Imaginary Number
		MyDouble valueImag=multiNums.getImag();
		MyDouble imag=this.imag;
								
		//Command that replace i^2 with -1
		MyDouble iSquared = new MyDouble(-1);
				
		//Multiply's Imaginary Object
		MyDouble imagNums=(valueReal.multiply(imag).add(valueImag.
				multiply(real)));
						
		//Multiply's Real Object
		MyDouble realNums= (valueReal.multiply(real).add(valueImag.
				multiply(imag).multiply(iSquared)));
				
		//Return both Imaginary and Real Number as a Complex Number		
		ComplexNumber complexNumber= new ComplexNumber(realNums,imagNums);
		return complexNumber;
		
	/*A method that returns the difference of the current object 
	* and the ComplexNumber parameter
	*/	
	}public ComplexNumber divide(ComplexNumber divNums) {
		//Assigns the Values for Real 
		MyDouble valueReal=	divNums.getReal();
		MyDouble valueImag=divNums.getImag();
			
		//Creates a Double that equals to i= -1
		MyDouble i= new MyDouble(-1);
		MyDouble imag=valueImag.multiply(i);
				
		//New ComplexNumber is created
		ComplexNumber value= new ComplexNumber (valueReal,imag);
				
		ComplexNumber numerator=this.multiply(value);
		ComplexNumber denominator=divNums.multiply(value);
				
				
		MyDouble numReal=numerator.getReal(); //Real Number for Top Values
		MyDouble numImag=numerator.getImag(); //Imag  Number for Top Values
		MyDouble denomReal=denominator.getReal();//Real Number for Bottom Value
		//Divides	
		numReal=numReal.divide(denomReal);
		numImag=numImag.divide(denomReal);
				
		//Return both Imaginary and Real Number as a Complex Number		
		ComplexNumber complexnumber= new ComplexNumber (numReal,numImag);

		return complexnumber;
	/*A method that returns true if the current object 
	* is equal to the ComplexNumber parameter
	*/	
	}public boolean equals(ComplexNumber other) {
		return other.getReal().equals(this.real) && 
			   other.getImag().equals(this.imag);
	
	/*A method that returns 0 (True) if the norm of the current object 
	* is equal to norm of the ComplexNumber parameter. Return -1 if False
	*/	
	}public int compareTo(ComplexNumber compNums){
		int digit=norm(this).compareTo(norm(compNums));
		
		if(digit >0) {
			return 1;
			
		}else if(digit <0) {
			return -1;
			
		}else { 
			return 0;
		}
		
	/*Takes in account for four different cases of signs that real and
	 * imaginary components may have in the current object.
	 * Returns a string that has no spaces in between them
	*/
	}public String toString(){
		MyDouble realNums=this.real;
		MyDouble imagNums=this.imag;
		MyDouble zero= new MyDouble(0);
		
		int realValue= realNums.compareTo(zero); //Checks if Real is equal to 0
		int imagValue= imagNums.compareTo(zero);//Checks if Imag is equal to 0
		String output= null;
		
		if(realValue >0 && imagValue >=0) {
			 return output = realNums.toString()+ "+" +imagNums.toString()+"i";
		}else if(realValue >0 && imagValue <0 ) {
			 return output= realNums.toString()+imagNums.toString()+"i";
		}else if(realValue <0 && imagValue >0) {
			return output= realNums.toString()+ "+" +imagNums.toString()+"i";
			
		}else if(realValue <0 && imagValue <0) {
			return  output= realNums.toString()+imagNums.toString()+"i";
		}
		return output;
		
		
	
	/* Takes in a ComplexNumber parameter and returns a
	 * MyDouble object representing the norm of the complex
	 * number
	 */
	}public static MyDouble norm(ComplexNumber norm){
		MyDouble normReal=norm.real.multiply(norm.real); //Squares the RealNum
		MyDouble normImag=norm.imag.multiply(norm.imag);;//Squares the ImagNum
		MyDouble sumNorm= normReal.add(normImag);//Add both Imag and Real Nums 
		MyDouble finalNorm=sumNorm.sqrt();//Square roots the sum of Imag & Real
		return finalNorm;
	
		
	/*Takes a String parameter  and return a complexNumber of Imaginary 
	 * and Real Number
	 * The function removes any whitespace located in the string and search for
	 * any "-" or "+" signs in the string in order to adjust them into a 
	 * ComplexNumber
	 */
	
	}public static ComplexNumber parseComplexNumber(String word) {
		String whiteSpace = word.replaceAll("\\s","");//Removes any white space
		int iFinder=whiteSpace.indexOf("i"); //Find the I from the whitespace 
		Double real;
		Double imag;
		
		boolean positiveChecker=whiteSpace.contains("+");// True if "+" exists
		
		if (positiveChecker == true) { //If String has "+"
			int positiveFinder=whiteSpace.indexOf("+"); //Locates the "+" 
			//Creates a new strings from the whitespace and "+" gathered
			String realString=whiteSpace.substring(0,positiveFinder);
			String imagString=whiteSpace.substring(positiveFinder,iFinder);
			
			//Converts Strings into MyDouble 
			real=Double.parseDouble(realString);
			imag=Double.parseDouble(imagString);
			
		}else {// If string has "-"
			int negativeFinder=whiteSpace.lastIndexOf("-"); //Locates the "-" 
			//Creates a new strings from the whitespace and "-" gathered
			String realString=whiteSpace.substring(0,negativeFinder);
			String imagString=whiteSpace.substring(negativeFinder,iFinder);
			
			//Converts Strings into MyDouble 
			real=Double.parseDouble(realString);
			imag=Double.parseDouble(imagString);
			
		}
		//Converts Double value into MyDouble value
		MyDouble realFinal= new MyDouble(real);
		MyDouble imagFinal= new MyDouble(imag);
		
		//Final Values of ComplexNumbers is returned
		ComplexNumber complexNumber= new ComplexNumber(realFinal,imagFinal);
		return complexNumber;
		
	}
	
	
	
}
