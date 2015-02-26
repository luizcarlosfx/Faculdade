import java.util.Arrays;

public class GreetingsMyFriends
{

	public static String[] greetingForAllFriends(String... friends)
	{
		if (friends == null || friends.length == 0)
		{
			return null;
		}

		String[] greetings = new String[friends.length];

		for (int i = 0; i < greetings.length; i++)
		{
			greetings[i] = String.format("Hello, %s!", friends[i]);
		}

		return greetings;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(greetingForAllFriends("Luiz", "Carlos", "Outro")));
	}
}