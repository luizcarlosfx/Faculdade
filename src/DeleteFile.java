import java.io.File;

import javax.swing.JOptionPane;

public class DeleteFile
{
	public static void main(String[] args)
	{
		String filePath = JOptionPane.showInputDialog("TypeFilePath");
		File file = new File(filePath);

		if (!file.exists())
		{
			JOptionPane.showMessageDialog(null, "This file does not exist");
		}
		else
		{
			file.delete();
		}
		
		JOptionPane.showMessageDialog(null, "File deleted successful");
	}
}
