
public class StartAndStopProcess
{
	public static void main(String[] args)
	{
		ProcessBuilder processBuilder = new ProcessBuilder("\\\\luizcarlos-pc/Users/LuizCarlos/Desktop/Client2D.exe", "-batchmode");

		try
		{
			System.out.println("$2a$10$7E8vkqyHjIJdJrIqnx9W.OuUNjaEgJTKBJe/vh0CwW4TXM6w8INr.".length());
			// Start a process
			Process proccess = processBuilder.start();
			
			// Waits for 5 seconds
			Thread.sleep(50000);
			
			// Ends the process
			proccess.destroy();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		processBuilder.*/
	}
}
