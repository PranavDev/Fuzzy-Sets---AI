import java.io.*;
import java.util.*;

public class FuzzySet
{
	public static void Calculate_Membership_Values(float Members[], int n, float H_Member, int G)
	{
		float Membership_Values[] = new float[10];
		float x, d, M_val = 0;
		
		for(int i=0;i<n;i++)
		{
			x = Members[i];
			d = Math.abs(x - H_Member);
			M_val = G*d;
			
			if(M_val==0)
			{
				Membership_Values[i] = 1;
			}
			else if(M_val>0 && M_val<=1)
			{
				Membership_Values[i] = 1 - (G*d);
			}
			else if(M_val>1)
			{
				Membership_Values[i] = 0;
			}
		}
		display_Members_Values(Members, Membership_Values);
	}
	
	
	
	
	
	public static void display_Members_Values(float Members[], float Membership_Values[])
	{
		System.out.print("\n---------------------------------\n");
		System.out.print("\nMEMBERS\t | \tMEMBERSHIP_VALUES\n");
		System.out.print("\n---------------------------------\n");
		for(int i=0;i<Members.length;i++)
		{
			System.out.println(Members[i]+"\t | \t"+Membership_Values[i]);
		}
	}
	
	
	
	
	
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		float H_Member = 0;
		int num = 0, G = 0;
		float Members[] = new float[10];
		
		System.out.println("--------------------FUZZY-LOGIC--------------------\n\n");
		
		System.out.print("> Enter the Member with the Highest Membership : ");
		H_Member = sc.nextFloat();
		
		System.out.print("\n> Enter the No. of Members : ");
		num = sc.nextInt();
		
		System.out.print("\n> Enter the Members : \n");
		for(int i=0;i<num;i++)
		{
			System.out.print("- Enter Member "+(i+1)+" : ");
			Members[i] = sc.nextFloat();
		}
		
		System.out.print("\n> Enter the Value of Gamma : ");
		G = sc.nextInt();
		
		Calculate_Membership_Values(Members, num, H_Member, G);
	}
}
