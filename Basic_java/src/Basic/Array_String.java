package Basic;
import java.util.*;
public class Array_String {
	Scanner in = new Scanner(System.in);
	int n;
	int[] a;
	int hang, cot;
	int [][]b;
	Array_String()
	{
		n = in.nextInt();
		a = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
		}
		
		for(int i = 0; i < n-1; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				if(a[i] > a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		hang = in.nextInt();
		cot = in.nextInt();
		b = new int[hang][cot];
		for(int i =0; i < hang; i++)
		{
			for(int j = 0; j < cot; j++)
			{
				b[i][j] = in.nextInt();
			}
		}
	}
	
	public void Output()
	{
		for(int i = 0; i < n; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < hang; i++)
		{
			for(int j = 0; j < cot; j++)
			{
				System.out.print(b[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
