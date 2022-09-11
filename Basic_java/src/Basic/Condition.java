package Basic;
import java.util.*;
public class Condition {
	Scanner in = new Scanner(System.in);
	String a, b;
	int so1, so2, so3;
	
	Condition()
	{
		a = in.nextLine();
		b = in.nextLine();
		so1 = in.nextInt();
		so2 = in.nextInt();
		so3 = in.nextInt();
	}
	
	public void Output()
	{
		if(a.equals(b))
		{
			System.out.println("two people have the same name");
		}
		else
		{
			System.out.println("two people don't have the same name");
		}
		
		if(so1<=so2 && so2<=so3)
		{
			System.out.println("Increase");
		}
		else if(so1 >= so2 && so2 >= so3)
		{
			System.out.println("Decrease");
		}
		else 
		{
			System.out.println("Normal");
		}
	}
	
}
