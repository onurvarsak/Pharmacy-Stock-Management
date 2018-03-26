// Main class of program 
public class Main 
{
	/**
	 * 
	 * @param args is names of files
	 */
	public static void main(String[] args) 
	{
		// it is creating object from Receipt and send first argument to p object
		Receipt r = new Receipt(args[0]);
		// it is creating object from Prices and send second argument to r object
		Prices p = new Prices(args[1]);
		// it is creating object from Compare then it compares r object and p object
		Compare c = new Compare(p, r);
		
		// it is write in screen output 
		System.out.println(c.toString());
	}
}

