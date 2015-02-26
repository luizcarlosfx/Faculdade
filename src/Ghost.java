public class Ghost
{
	private String color;

	private static String[] colors =
		{ "white", "yellow", "purple", "red" };

	public Ghost()
	{
		int colorIndex = (int) (Math.random() * colors.length);

		this.color = colors[colorIndex];
	}

	public String getColor()
	{
		return this.color;
	}

	public static void main(String[] args)
	{
		Ghost ghost = new Ghost();

		System.out.println(ghost.getColor());

		System.out.println(addSquaresOfDigits(9119));
	}

	static long addSquaresOfDigits(int number)
	{
		String result = "";
		
		while (number > 0)
		{
			int temp = number % 10;
			
			System.out.println(number + " : " + temp);

			int square = (temp * temp);
			
			result += square;

			number /= 10;
		}
		
		return Integer.parseInt(result);
	}
}