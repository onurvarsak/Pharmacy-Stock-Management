
public class Prices 
{
	/**is keeping list of prices String[][] arrays, each of line of file*/
	private String listOfPrices[][];
	
	/**
	 * construct, of ListOfPrices class
	 * @param nameOfFile 
	 * that will be reading name of file 
	 * 
	 * is String that name of file
	 */
	public Prices(String nameOfFile) 
	{
		ConvertFromFileToArray fileOfPrices = new ConvertFromFileToArray(nameOfFile);
		listOfPrices = new String[fileOfPrices.getLength()][5];
		
		for (int i = 0; i < fileOfPrices.getArray().length; i++) 
		{
			for (int j = 0; j < 5; j++) 
			{
				listOfPrices[i][j] = fileOfPrices.getArray()[i].split("\t")[j];
			}
		}
	}

	/**
	 * 
	 * @return listofPrices is double String that hold List of Medicine and property
	 */
	public String[][] getListOfPrices() {
		return listOfPrices;
	}
}
