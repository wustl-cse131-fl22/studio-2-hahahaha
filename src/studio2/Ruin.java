package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {		
				
		//输入
		Scanner scan = new Scanner(System.in); 
		System.out.println("Total simulations: ");
		int days = scan.nextInt();
		Scanner li = new Scanner(System.in); 
		System.out.println("The win limit: ");
		int limit = li.nextInt();
		Scanner ch = new Scanner(System.in); 
		System.out.println("The win chance: ");
		double chance = li.nextDouble();
		Scanner am = new Scanner(System.in); 
		System.out.println("The startamount: ");
		int startAmount = am.nextInt();	
		//
		int totalgain =0;
		int wintimes = 0;
		int ruintime = 0;
		int result;
		int stamount;
		int tttime = 0;
		for(int daystart = 1; daystart<=days; daystart++)
		{
			// 循环出一天输掉或者赢的可能		
			stamount = startAmount;
			int x =startAmount;
			int timegetresult = 0;
			while (x<limit &&x>0)
			{	
				//使得gamble 按照比例划分概率
				double gambledouble = Math.random();
				if (gambledouble<chance)
				{
					result = 1;
				}
				else
				{
					result = -1;
				}					
				//输赢记录为 1 或者-1
				x=x+result;
				timegetresult++;
				if (x==limit) 
				{
					wintimes+=1;
					tttime+=1;
					System.out.println("simulation"+tttime+":"+timegetresult+ " win ");
					totalgain = totalgain+x;
					System.out.println(totalgain);
					break;
				}
				else if(x==0)
				{
					ruintime+=1;
					tttime+=1;
					System.out.println("simulation"+tttime+":"+timegetresult+" lose ");
					totalgain = totalgain+x;
					System.out.println(totalgain);
					break;
				}
			}
					
		}
		int origanhave;
		origanhave = startAmount*days;
		if ((totalgain-origanhave)<0)
		{
			System.out.println("losses: "+totalgain+" simulations: "+ days);
		}
		else if ((totalgain-origanhave)>0)
		{
			System.out.println("Win: "+totalgain+" simulations: "+ days);
		}
		else
		{
			System.out.println("No loss No gain: "+totalgain+" simulations: "+ days);
		}
		double ruinrate = (Math.round(((1-((double)(wintimes)/days))*100)))/100.0;
		System.out.println("Ruin rate from simulation "+ruinrate);
		if(chance == 0.5)
		{
			double expectedruin = (1-((double)(startAmount))/limit);
			System.out.println("Expected Ruin Rate: "+expectedruin);
		}
		else
		{
			double alpha = (1-chance)/chance;
			double expruin = (Math.pow(alpha,startAmount)-Math.pow(alpha,limit))/(1-Math.pow(alpha,limit));
			System.out.println("Expected Ruin Rate: "+expruin);
		}
		
		// TODO Auto-generated method stub
	}

}
