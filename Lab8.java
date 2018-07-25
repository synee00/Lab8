import java.util.Scanner;

/*Jasmine S. Allen
 * July 24, 2018
 * Program: Provide information about students in a class. Prompt the user
 * 			to ask about a particular student. GIve proper responses according 
 * 			to user-submitted information. ASk if user would like to learn about 
 * 			another student.
 * 			
 * Build Specs: 1. Account for invalid user input with exceptions
 * 				2. Try to incorporate ArrayIndexOutOfBounds and IllegalArgumentException
 * 					 
 * 					
 * 	
 *  ***With extended challenges? NO
 */
public class Lab8 {

	public static void main(String[] args) {
		
		String [] students =  {"Jasmine", "Amna", "Andrew", "Stan", "Kris", "Eddie", "Cameron", "Anesha", "Sasi", "Rose"};
		String [] hometown = {"Detroit, Michigan", "Ann Arbor, Michigan", "Dexter, Michigan", "Detroit, Michigan", "Austin, Texas",
								"Kalamazoo, Michigan", "Detroit, Michigan", "Flint, Michigan", "Detroit, Michigan", "Fort Lauderdale, Florida"};
		String [] food = {"CHEESECAKE", "Fried Chicken", "Cheesecake", "Mac & Cheese", "Pizza WITH pineapples",
				"Jollof", "Nabeyaki Udon w/ Shrimp Tempura", "Cereal", "Pound cake!!", "Spaghetti"};
		
		System.out.println("Welcome to our Java class!");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		printInfo(scan, "Which student would you like to learn more about? (enter a number 1-10)  ", students, hometown, food);

		
		
		
	}
	public static void printInfo(Scanner scan, String prompt, String [] student, String [] hometown, String [] food)
	{
		String choice = "y";
		String junk = "";
		boolean isValid = false;
		 
		int input;
		
		while (choice.matches("[yY.]*"))
		{
			printStudents(prompt, student);		
			input = scan.nextInt();
			
			if (input >= 1 && input <= 10) 
			{
				//isValid = true;
				//System.out.println(input + " is valid");
				System.out.println();
				try {
					printData("Would you like to know " + student[input] + "'s hometown or favorite food? ", scan, hometown, food, input);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("That student does not exist in this world. Please try again.");
					System.out.println();
					//isValid = false;
					continue;
				}
			}
			else 
			{
				System.out.println("That student does not exist in this world. Please try again.");
				System.out.println();
				//isValid = false;
				continue;
			}
			
			
			
			System.out.print("Would you like to know more? (y/n)?  ");
			//adding a getline to be able to read the next iteration of the translator
			junk = scan.nextLine();
			choice = scan.next();
			
			
			System.out.println();
		}

	}
	public static void printStudents(String prompt, String [] student)
	{
		System.out.println(prompt);
		System.out.println();
		
		for(int i = 0; i < student.length; i++)
		{
			System.out.println((i + 1) + ".   " + student[i]);
		}
		
		System.out.println();
	}
	public static void printData(String prompt, Scanner scan,  String [] hometown, String [] food, int student)
	{
		System.out.println(prompt);
		System.out.print(" (enter \"hometown\" or \"food\"): ");
		
		String choice = scan.next();
		boolean isValid = false;
		
		do
		{
			if(choice.equalsIgnoreCase("hometown"))
			{
				System.out.println(hometown[student]);
				isValid = true;
			}
			else if(choice.equalsIgnoreCase("food"))
			{
				System.out.println(food[student]);
				isValid = true;

			}
			else
			{
				System.out.println("That data does not exist here. Please try again");
				isValid = false;
			}
		}while(!isValid);
			
		
	}


	

}
