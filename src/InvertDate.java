import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class InvertDate
{
	public static void main(String[] args)
	{
		File folder = new File("C:/Users/LuizCarlos/Google Drive/FACULDADE/6º SEMESTRE/Banco de Dados Avançados/TEORIA");
		
		
		for (File file : folder.listFiles())
		{
			Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
			
			Matcher matcher = pattern.matcher(file.getName());
			
			while (matcher.find())
			{
				String newName = file.getName().replaceAll("(\\d{2})-(\\d{2})-(\\d{4})", "$3-$2-$1");
				
				file.renameTo(new File(file.getParent() + "/" + newName));
			}
		}
	}
	
	public static String invertDate(String date)
	{
		String [] array = date.split("-");
		
		String newDate = "";
		
		for (int i = array.length - 1; i >= 0; i--)
		{
			if(i != array.length - 1)
			{
				newDate += "-";
			}
			newDate += array[i];
		}
		
		return newDate;
	}
}
