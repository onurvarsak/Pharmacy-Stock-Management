//import statements
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author user
 * This class will compare two String double array come from Prices class and Receipt class
 * then it look same field and take action accordingly
 */
public class Compare 
{
	// We identified one object from SimpleDateFormat for convert from String to Date
	SimpleDateFormat convertDate = new SimpleDateFormat("dd.MM.yyyy");
	// new object of Strings that converted by SimpleDateFormat 
	Date dateOfReceipt, startOfDate, endOfDate;
	
	
	/** be same name of medicines is the lowest value*/
	private double minimumPrice = 0.00;
	/** sum total that will write in screen */
	private double total = 0.00;
	/** Output of Screen */
	private String output="";
	
	
	/**
	 * 
	 * @param p is object created from Prices class
	 * @param r is object created from Receipt class
	 * 
	 */
	public Compare(Prices p, Receipt r) 
	{
		// control price and calculate price 
		for (int i = 0; i < r.getListOfMedicine().length; i++) 
		{
			for (int j = 0; j < p.getListOfPrices().length; j++) 
			{
				if(r.getListOfMedicine()[i][0].equals(p.getListOfPrices()[j][0]) && r.getSocialSecurity().equals(p.getListOfPrices()[j][1]))
				{
					// I used this block because convert from String to Date 
					// then compare with getTime() method  
					try {
						dateOfReceipt = convertDate.parse(r.getDateOfReceipt());
						startOfDate = convertDate.parse(p.getListOfPrices()[j][2]);
						endOfDate = convertDate.parse(p.getListOfPrices()[j][3]);
						
						// this block will run date of receipt between start of date medicine and end of medicine date
						if(dateOfReceipt.getTime()>startOfDate.getTime() && dateOfReceipt.getTime()<endOfDate.getTime()){
							if(minimumPrice == 0.0){
								minimumPrice = Double.parseDouble(p.getListOfPrices()[j][4]);
							}else if (Double.parseDouble(p.getListOfPrices()[j][4])<minimumPrice){
								minimumPrice = Double.parseDouble(p.getListOfPrices()[j][4]);
							}
						}
					}
					catch (ParseException e){
						e.printStackTrace();
					}
				}
				
			}
			output +=r.getListOfMedicine()[i][0]+"\t"+String.format("%.2f",minimumPrice)+"\t"+r.getListOfMedicine()[i][1]+"\t"+String.format("%.2f",(minimumPrice * Double.parseDouble(r.getListOfMedicine()[i][1])))+"\n";
			total += (minimumPrice * Double.parseDouble(r.getListOfMedicine()[i][1]));
			minimumPrice = 0.00;
		}
		output+="Total\t" + String.format("%.2f",total);
	}
	@Override
	public String toString() {
		return output;
	}
}
