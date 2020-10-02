import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
//import java.util.*; //makes the executable file really big (not the biggest deal but ya know) 


public class Driver
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/data.dat"));
		Driver.fillFileWithRandomNums(20);
		
		ArrayList<String> myNumbers = new ArrayList<String>();
		while(input.hasNext())
		{
			myNumbers.add(input.nextLine());
		}
		input.close();
		
		for(int i = 0; i < myNumbers.size(); i++)
		{
			System.out.println(myNumbers.get(i));
		}
	}
	
	static void fillFileWithRandomNums(int howMany)
	{
		//this overwrites the file, it does not append the file
		Random r = new Random();
		try
		{
			File f = new File(System.getProperty("user.dir") + "/src/data.dat");
			//If you change the false to true, then it will just append the file
			FileWriter writer = new FileWriter(f, false);
			for( int i = 0; i < howMany ; i++)
			{
				//writing this to memory, not your hard drive
				writer.write(r.nextInt(10000) +"\n");
			}
			//this is when any changes that you wrote gets written to your hard drive
			//So once you are done using the file, close the file
			writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
