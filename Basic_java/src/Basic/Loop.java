package Basic;

public class Loop {
	public void Output()
	{
		for(int i = 0; i <5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				System.out.print(i*5 + j + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int n = 1;
		while(n <= 100)
		{
			if(n % 2 == 0)
				System.out.print(n + " ");
			n++;
		}
	}
}
