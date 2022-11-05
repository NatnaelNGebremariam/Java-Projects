import java.util.Scanner;

public class Polygons {

	public static void main(String[] args) {
		//Creates a new scanner called input
		Scanner input= new Scanner(System.in);
		
		//FINAL NUMERICAL CONSTANT for Shapes
		final int TRIANGLE_SIDES= 3;
		final int SQUARE_SIDES= 4;
		final int PENTAGON_SIDES=5;
		final int HEXAGON_SIDES=6;
		
		//FINAL STRING CONSTANT for Shapes
		final String TRIANGLE= "triangle";
		final String SQUARE= "square";
		final String PENTAGON= "pentagon";
		final String HEXAGON= "hexagon";
		
		/* Dictates which mode users is prompted (Mode 1 or 2), 
		 * is later given a value based on user input
		 */
		final int MODE;
		
		System.out.println
		("Type 1 to enter the number of sides or 2 to enter a shape:");
		MODE= input.nextInt(); // The MODE users prefers is stored
		
		//Command for Guessing Shape with Number of Sides
		if(MODE==1) {
			//Asks the user number of sides
			System.out.println("Enter number of sides:");
			int sides= input.nextInt();
			
			
			input.nextLine(); //Resolves Scanner Issue
		
			/* Checks if the value for sides is 3-6, else "Invalid Choice." 
			 * Checks if side and shape is "Correct!", else "Incorrect!"
			*/
			if(sides==TRIANGLE_SIDES
					|| sides==SQUARE_SIDES
					|| sides==PENTAGON_SIDES
					|| sides==HEXAGON_SIDES) {
				System.out.println("Which shape has "+sides+" sides?");
				String shape=input.nextLine();
				
				if(sides==TRIANGLE_SIDES && shape.equals(TRIANGLE) ||
				   sides==SQUARE_SIDES && shape.equals(SQUARE) ||
				   sides==PENTAGON_SIDES && shape.equals(PENTAGON) ||
				   sides==HEXAGON_SIDES && shape.equals(HEXAGON)) {
					   System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}
				
			}else {
				System.out.println("Invalid choice.");
			}
			
		//Command for Guessing Number of Sides with Shape
		}else if(MODE==2) {
	
			System.out.println("Choose a shape:");
			input.nextLine(); //Resolves Scanner Issue
			String shape=input.nextLine();
			
	
			//Checks if user check available shape
			if(shape.equals(TRIANGLE)||
					shape.equals(SQUARE) ||
					shape.equals(PENTAGON) ||
					shape.equals(HEXAGON)) {
				System.out.println("How many sides does a "+shape+" have?");
				int sides=input.nextInt();
				
				/* Checks if the value for sides is 3-6, else "Invalid Choice." 
				 * Checks if sides and shape is "Correct!", else "Incorrect!"
				 */
				
				if(sides==TRIANGLE_SIDES || sides==SQUARE_SIDES || 
						sides==PENTAGON_SIDES || sides==HEXAGON_SIDES) {
					
					if(sides==TRIANGLE_SIDES && shape.equals(TRIANGLE) ||
					   sides==SQUARE_SIDES && shape.equals(SQUARE)||
					   sides==PENTAGON_SIDES && shape.equals(PENTAGON) ||
					   sides==HEXAGON_SIDES && shape.equals(HEXAGON) ){
						System.out.println("Correct!");
						
					}else {
						System.out.println("Incorrect!");
					}
					
				}else {
					System.out.println("Incorrect!");
				}
				
				
			}else {
				System.out.println("Invalid choice.");
			}
			
		}
		input.close(); // Close Scanner
	}
}
