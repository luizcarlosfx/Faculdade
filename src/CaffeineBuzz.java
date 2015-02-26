public class CaffeineBuzz {
  public static String caffeineBuzz(int n)
  {
    String result = "";
    
    if(n % 3 == 0)
    {
      if(n % 4 == 0)
      {
        result = "Coffee";
      }
      else 
      {
        result = "Java";
      }
      
      if(n % 2 == 0)
      {
        result += "Script";
      }
      
      return result;
    }
    else 
    {
      return "mocha_missing!";
    }
  }
}