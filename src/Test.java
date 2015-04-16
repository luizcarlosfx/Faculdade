public class Test
{
	public static void main(String[] args)
	{
		System.out.println(vectorAngle(-1, 0));
	}

	static double vectorAngle(double x, double y)
	{
		return Math.toDegrees(Math.atan2(y, x));
	}
}
