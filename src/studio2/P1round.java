package studio2;

public class P1round {

	public static void main(String[] args) {
		double r = 1;
		int total = 0;
		for(double x =0.0; x<=1;x+=0.00001)
		{
			double yy = Math.sqrt(r*r-x*x);
			double y = Math.random();
			if(y<=yy)
			{
				total+=1;
			}
		}
		double chance = total/(1/0.00001);
		double pi = chance*4;
		System.out.println(pi);
		
		
		
		
		// TODO Auto-generated method stub

	}

}
