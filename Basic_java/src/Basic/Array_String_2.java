package Basic;
import java.util.*;
public class Array_String_2 {
	Scanner in = new Scanner(System.in);
	String s;
	String s1;
	String s4, answer = "";
	int k;
	char c;
	int count;
	Array_String_2()
	{
		s1 = in.nextLine();		
		for(int i = 0; i < s1.length(); i++)
		{
			if(i == 0)
			{
				String s2 = s1.substring(i, i+1);
				String remain = s1.substring(i+1, s1.length());
				s2 = s2.toUpperCase();
				s1 = s2 + remain;
			}
			else if(i % 2 == 0 && i != 0)
			{
				String s2 = s1.substring(0, i);
				String s3 = s1.substring(i, i+1);
				String remain = s1.substring(i+1, s1.length());
				s3 = s3.toUpperCase();
				s1 = s2 + s3 + remain;
			}
		}
		
		s4 = in.nextLine();
		for(int i = s4.length() - 1; i >= 0; i--)
		{
			answer += s4.charAt(i);
		}
		
		s = in.nextLine();
		c = in.next().charAt(0);
		k = in.nextInt();
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == c)
				count++;
		}
		System.out.println(s.charAt(k-1));
	}
	
	public void Output()
	{
		System.out.println("So luong ki tu giong ki tu dau: " + count);
		System.out.println("Chuoi xen ke hoa va thuong: " + s1);
		System.out.println("Chuoi dao nguoc: " + answer);
	}
}
