package studio2;

public class Pi {

	public static void main(String[] args) {
		
		double r = 1;
		double circle=0;
		double dx = r/10000000.0;
		double idx = 0;
		for(int i = 0; i<10000000;i++)
		{
			idx = idx+dx;
			double height = Math.sqrt(r*r-idx*idx);
			circle = circle+height;
		}
		System.out.println(circle/10000000);
		double pi = circle/10000000*4;
		System.out.println(pi);
		
		// TODO Auto-generated method stub

	}

}
