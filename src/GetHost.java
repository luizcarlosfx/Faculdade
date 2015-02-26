import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;


public class GetHost
{
	public static void main(String[] args) throws UnknownHostException, MalformedURLException
	{
		String urlString = "http://santaritasjc.org.br";
		InetAddress address = InetAddress.getByName(new URL(urlString).getHost());
		

		String ip = address.getHostAddress();
		
		System.out.println(ip + " this is the host");
	}
}
