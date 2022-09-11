package Basic;

import java.util.Scanner;

public class Main {
	
	public static long fac(int n)
	{
		if(n == 1)
			return 1;
		return n * fac(n-1);
	}
	
	public static long sum(int n)
	{
		if(n == 0)
			return 0;
		return n + sum(n-1);
	}

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		System.out.print("Nhap lua chon: ");
		choice = in.nextInt();
		in.nextLine();
		switch(choice)
		{
		  case 1:
		  {
			  Nhap nhap = new Nhap();
			  nhap.Output();
		  }
		  case 2:
		  {
			  Condition condition = new Condition();
			  condition.Output();
		  }
		  case 3:
		  {
			  Loop loop = new Loop();
			  loop.Output();
		  }
		  case 4:
		  {
			  Array_String a = new Array_String();
			  a.Output();
		  }
		  case 5:
		  {
			  Array_String_2 b = new Array_String_2();
			  //b.Input();
			  b.Output();
		  }
		  case 6:
		  {
			  int k = in.nextInt();
			  System.out.println(fac(k));
			  System.out.print(sum(k));
			  
		  }
		}
	}

}
