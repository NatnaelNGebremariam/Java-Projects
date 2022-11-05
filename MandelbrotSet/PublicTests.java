import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 
				&& x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 
				&& z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 
				&& y.getImag().compareTo(b) == 0);
		
	}
	@Test
	public void testAdd() {
		MyDouble a = new MyDouble(15.0), b = new MyDouble(-13.7);
		MyDouble c = new MyDouble(-19.2), d = new MyDouble(16.0);
		
		ComplexNumber comp = new ComplexNumber(a, b); //15.0-13.7i
		ComplexNumber comp1 = new ComplexNumber(c, b); //-19.2-13.7i
		ComplexNumber comp2 = new ComplexNumber(c, d); //-19.2+16.0i
		ComplexNumber comp3 = new ComplexNumber(d, a); //16.0+15.0i
		
		ComplexNumber sum = comp.add(comp1); //-4.2-27.4i
		ComplexNumber sum1 = comp.add(comp2); //-4.2+2.3i
		ComplexNumber sum2 = comp.add(comp3); //31+1.3i 
		ComplexNumber sum3 = comp1.add(comp2); //-38.4+2.3i
		ComplexNumber sum4 = comp1.add(comp3); //-3.2+1.3i 
		ComplexNumber sum5 = comp2.add(comp3); //-3.2+31i
		
		ComplexNumber test_sum = new ComplexNumber (new MyDouble (-4.2),
				new MyDouble (-27.4));
		assertTrue(sum.compareTo(test_sum)==0);
		
		ComplexNumber test_sum1 = new ComplexNumber (new MyDouble (-4.2), 
				new MyDouble (2.3));
		assertTrue(sum1.compareTo(test_sum1)==0);
		
		ComplexNumber test_sum2 = new ComplexNumber (new MyDouble (31), 
				new MyDouble (1.3));
		assertTrue(sum2.compareTo(test_sum2)==0);
		
		ComplexNumber test_sum3 = new ComplexNumber (new MyDouble (-38.4), 
				new MyDouble (2.3));
		assertTrue(sum3.compareTo(test_sum3)==0);
		
		ComplexNumber test_sum4 = new ComplexNumber (new MyDouble (-3.2), 
				new MyDouble (1.3));
		assertTrue(sum4.compareTo(test_sum4)==0);
		
		ComplexNumber test_sum5 = new ComplexNumber (new MyDouble (-3.2),
				new MyDouble (31));
		assertTrue(sum5.compareTo(test_sum5)==0);
		
	}
	@Test
	public void testSubtract() {
		
		MyDouble a = new MyDouble(-5.0), b = new MyDouble(3.7);
		MyDouble c = new MyDouble(9.2), d = new MyDouble(-6.0);
		
		ComplexNumber comp = new ComplexNumber(a, b); //-5.0+3.7i
		ComplexNumber comp1 = new ComplexNumber(b, c); //3.7+9.2
		ComplexNumber comp2 = new ComplexNumber(c, d); //9.2-6.0i
		ComplexNumber comp3 = new ComplexNumber(d, a); //-6.0-5.0i
		
		ComplexNumber diff = comp.subtract(comp1); //-8.7-5.5i
		ComplexNumber diff1 = comp.subtract(comp2); //-14.2+9.7i
		ComplexNumber diff2 = comp.subtract(comp3); //1+8.7i
		ComplexNumber diff3 = comp1.subtract(comp2); //-5.5+15.2i
		ComplexNumber diff4 = comp1.subtract(comp3); //9.7+14.2
		ComplexNumber diff5 = comp2.subtract(comp3); //15.2-i
		
		ComplexNumber test_diff = new ComplexNumber (new MyDouble (-8.7),
				new MyDouble (-5.5));
		assertTrue(diff.compareTo(test_diff)==0);
		
		ComplexNumber test_diff1 = new ComplexNumber (new MyDouble (-14.2), 
				new MyDouble (9.7));
		assertTrue(diff1.compareTo(test_diff1)==0);
		
		ComplexNumber test_diff2 = new ComplexNumber (new MyDouble (1), 
				new MyDouble (8.7));
		assertTrue(diff2.compareTo(test_diff2)==0);
		
		ComplexNumber test_diff3 = new ComplexNumber (new MyDouble (-5.5), 
				new MyDouble (15.2));
		assertTrue(diff3.compareTo(test_diff3)==0);
		
		ComplexNumber test_diff4 = new ComplexNumber (new MyDouble (9.7),
				new MyDouble (14.2));
		assertTrue(diff4.compareTo(test_diff4)==0);
		
		ComplexNumber test_diff5 = new ComplexNumber (new MyDouble (15.2), 
				new MyDouble (1));
		assertTrue(diff5.compareTo(test_diff5)==0);
		
	
	}
	@Test
	public void testMulti() {
		
		MyDouble a = new MyDouble(-1.0), b = new MyDouble(2.0);
		MyDouble c = new MyDouble(3.0), d = new MyDouble(-4.0);
		
		ComplexNumber comp = new ComplexNumber(a, b); //-1.0+2.0i
		ComplexNumber comp1 = new ComplexNumber(b, c); //2.0+3.0i
		ComplexNumber comp2 = new ComplexNumber(c, d); //3.0-4.0i
		ComplexNumber comp3 = new ComplexNumber(d, a); //-4.0-1.0i
		
		ComplexNumber multi = comp.multiply(comp1); //-8+1i
		ComplexNumber multi1 = comp.multiply(comp2); //5+10i
		ComplexNumber multi2 = comp.multiply(comp3); //6-7i
		ComplexNumber multi3 = comp1.multiply(comp2); //18+i
		ComplexNumber multi4 = comp1.multiply(comp3); //-5-14i
		ComplexNumber multi5 = comp2.multiply(comp3); //-16+13i
		
		assertTrue(multi.compareTo(new ComplexNumber 
				(new MyDouble(-8.0),new MyDouble(1.0)))==0);
		
		assertTrue(multi1.compareTo(new ComplexNumber 
				(new MyDouble(5.0),new MyDouble(10.0)))==0);
		
		assertTrue(multi2.compareTo(new ComplexNumber 
				(new MyDouble(6.0),new MyDouble(-7.0)))==0);
		
		assertTrue(multi3.compareTo(new ComplexNumber 
				(new MyDouble(18.0),new MyDouble(1.0)))==0);
		
		assertTrue(multi4.compareTo(new ComplexNumber 
				(new MyDouble (-5.0),new MyDouble (-14.0) ))==0);
		
		assertTrue(multi5.compareTo(new ComplexNumber 
				(new MyDouble (-16.0),new MyDouble (-13.0) ))==0);
		
	}
	@Test
	public void testDiv() {
		//Test 1
		MyDouble a = new MyDouble(1.0), b = new MyDouble(2.0);
		MyDouble c = new MyDouble(3.0), d = new MyDouble(4.0);
		

		MyDouble dem= (c.multiply(c)).add(d.multiply(d));
		
		MyDouble num=(a.multiply(c)).add(b.multiply(d));
		
		MyDouble num2=(b.multiply(c)).subtract(a.multiply(d));
		
		//(1*3)+(2*4)/(3^2+4^2)
		MyDouble divcom = new  MyDouble(num.divide(dem));
		//(2*3)-(1*4)/(3^2+4^2)
		MyDouble divcom1 = new  MyDouble(num2.divide(dem));
		
		
		ComplexNumber compare= new ComplexNumber(divcom,divcom1);
		ComplexNumber comp = new ComplexNumber(a, b); //1.0+2.0i
		ComplexNumber comp1 = new ComplexNumber(c, d); //3.0+4.0i

		
		comp = comp.divide(comp1); 
		assertTrue(comp.compareTo(compare)==0);
		
		//Test 2
		MyDouble a1 = new MyDouble(2.0), b1 = new MyDouble(4.0);
		MyDouble c1 = new MyDouble(6.0), d1 = new MyDouble(8.0);
		

		MyDouble demo= (c1.multiply(c1)).add(d1.multiply(d1));
		
		MyDouble firstNum1=(a1.multiply(c1)).add(b1.multiply(d1));
		
		MyDouble secondNum1=(b1.multiply(c1)).subtract(a1.multiply(d1));
		
		//(2*6)+(4*8)/(6^2+8^2)
		MyDouble divNum1 = new  MyDouble(firstNum1.divide(demo));
		//(4*6)-(2*8)/(6^2+8^2)
		MyDouble divNum2 = new  MyDouble(secondNum1.divide(demo));
		
		
		ComplexNumber testCompare= new ComplexNumber(divNum1,divNum2);
		ComplexNumber test1 = new ComplexNumber(a1, b1); //2.0+4.0i
		ComplexNumber test2 = new ComplexNumber(c1, d1); //6.0+8.0i

		
		test1 = test1.divide(test2); 
		assertTrue(test1.compareTo(testCompare)==0);
		
		//Test 3
		MyDouble a2 = new MyDouble(3.0), b2 = new MyDouble(6.0);
		MyDouble c2 = new MyDouble(9.0), d2 = new MyDouble(12.0);
		

		MyDouble demo1= (c2.multiply(c2)).add(d2.multiply(d2));
		
		MyDouble firstNum2=(a2.multiply(c2)).add(b2.multiply(d2));
		
		MyDouble secondNum2=(b2.multiply(c2)).subtract(a2.multiply(d2));
		
		//(3*9)+(6*12)/(9^2+12^2)
		MyDouble div1 = new  MyDouble(firstNum2.divide(demo1));
		//(6*9)-(3*12)/(=9^2+12^2)
		MyDouble div2 = new  MyDouble(secondNum2.divide(demo1));
		
		
		ComplexNumber testCompare1= new ComplexNumber(div1,div2);
		ComplexNumber secondTest1 = new ComplexNumber(a2, b2); //3.0+6.0i
		ComplexNumber secondTest2 = new ComplexNumber(c2, d2); //8.0+12.0i

		
		secondTest1 = secondTest1.divide(secondTest2); 
		assertTrue(secondTest1.compareTo(testCompare1)==0);
		
	}
	
	
	//Test that works for equals() and compareTo()
	@Test
	public void testEqualsCompareTo() {
		MyDouble a = new MyDouble(-99.0), b = new MyDouble(00351.0);
		MyDouble c = new MyDouble(1232.0), d = new MyDouble(-34013.0);
		
		ComplexNumber comp= new ComplexNumber(a,b);
		
		ComplexNumber comp1= new ComplexNumber (a,b);
		ComplexNumber comp2= new ComplexNumber (c,d);
		ComplexNumber comp3= new ComplexNumber (c,d);
		ComplexNumber comp4= new ComplexNumber (b,d);
		ComplexNumber comp5= new ComplexNumber (b,d);
		ComplexNumber comp6= new ComplexNumber (a,c);
		ComplexNumber comp7= new ComplexNumber (a,c);
	
		assertTrue(comp.compareTo(comp1)==0);
		assertTrue(comp2.compareTo(comp3)==0);
		assertTrue(comp4.compareTo(comp5)==0);
		assertTrue(comp6.compareTo(comp7)==0); 
	}

	@Test
	public void testNorm() {
		MyDouble a = new MyDouble(19.0), b = new MyDouble(203.0);
		MyDouble c = new MyDouble(-93.0), d = new MyDouble(-74.0);
		
		ComplexNumber comp= new ComplexNumber(a,b);
		ComplexNumber comp1= new ComplexNumber(c,d);
		ComplexNumber comp2= new ComplexNumber(a,d);
		ComplexNumber comp3= new ComplexNumber(c,b);
		
		
		MyDouble test= ComplexNumber.norm(comp);
		ComplexNumber Test= new ComplexNumber(test);
		assertTrue(comp.compareTo(Test)==0);
		
		MyDouble test2= ComplexNumber.norm(comp1);
		ComplexNumber Test2= new ComplexNumber(test2);
		assertTrue(comp1.compareTo(Test2)==0);
		
		MyDouble test3= ComplexNumber.norm(comp2);
		ComplexNumber Test3= new ComplexNumber(test3);
		assertTrue(comp2.compareTo(Test3)==0);
		
		MyDouble test4= ComplexNumber.norm(comp3);
		ComplexNumber Test4= new ComplexNumber(test4);
		assertTrue(comp3.compareTo(Test4)==0);
		
		
	}
	@Test
	public void testParse() {
		String complexstring= "99+86i";
		ComplexNumber complex =ComplexNumber.parseComplexNumber(complexstring);
		ComplexNumber complexvalue= new ComplexNumber(new MyDouble (99.0), 
				new MyDouble (86.0));
		assertTrue(complex.compareTo(complexvalue)==0);
		
		String complexstring2= "-96+63i";
		ComplexNumber complex2 =ComplexNumber.
				parseComplexNumber(complexstring2);
		ComplexNumber complexvalue2= new ComplexNumber(new MyDouble (-96.0), 
				new MyDouble (63.0));
		assertTrue(complex2.compareTo(complexvalue2)==0);
		
		String complexstring3= "-1111-8987i";
		ComplexNumber complex3 =ComplexNumber.
				parseComplexNumber(complexstring3);
		ComplexNumber complexvalue3= new ComplexNumber(new MyDouble (-1111.0), 
				new MyDouble (-8987.0));
		assertTrue(complex3.compareTo(complexvalue3)==0);
		
		String complexstring4= "-1841240214124812+7024012412i";
		ComplexNumber complex4=ComplexNumber.parseComplexNumber(complexstring4);
		ComplexNumber complexvalue4= 
				new ComplexNumber(new MyDouble (-1841240214124812.0), 
				new MyDouble (7024012412.0));
		assertTrue(complex4.compareTo(complexvalue4)==0);
		
		
	}
	
	
	
	
}
