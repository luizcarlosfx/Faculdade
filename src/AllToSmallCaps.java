import java.io.File;
import java.util.Arrays;


public class AllToSmallCaps
{
	public static void main(String[] args)
	{
		File directory = new File("C:/xampp/htdocs/images/stories/virtuemart/product");
		
		Arrays.asList(directory.listFiles()).forEach(AllToSmallCaps::renameFileToLowerCase);
		
	}
	
	public static void renameFileToLowerCase(File file)
	{
		file.renameTo(new File(file.getParentFile().getAbsolutePath() + "/" + file.getName().toLowerCase()));
	}
}
