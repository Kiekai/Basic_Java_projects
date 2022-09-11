package Basic;
import java.util.Scanner;

public class Nhap {
	Scanner in = new Scanner(System.in);
	
	String ten;
	char kitu;
	int a;
	float b;
	double c;
	short d;
	int v, x;
	
	Nhap()
	{
	    ten = in.nextLine();
	    kitu = (char) (in.next().charAt(0)+1);
		a = in.nextInt();
		b = in.nextFloat();
		c = in.nextDouble();
		d = in.nextShort();
		v = in.nextInt();
		x = in.nextInt();
	}
	
	public void Output()
	{
		System.out.println("Ten: " + ten);
		System.out.println("Ki tu lien sau: " + kitu);
		System.out.println("Diem: " + a);
		System.out.println("Diem: " + b);
		System.out.println("Diem: " + c);
		System.out.println("Diem: " + d);	
		System.out.println(v > x);
	}
	
}
