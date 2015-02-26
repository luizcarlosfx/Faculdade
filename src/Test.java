import javax.swing.JOptionPane;


public class Test
{
	public static void main(String[] args)
	{
		int x = 5;
		
		if (JOptionPane.showInputDialog(null, "teste").equals("a"))
			return;
		else{
			int y = 2;
			int j = x / y;
			System.out.println(5 / 2);
		}
		
	}
}
