
public class Receipt 
{
	/** Name of patient that writing name in receipt*/
	private String nameOfPatient;
	/** Social Security of patient that writing name in receipt*/
	private String socialSecurity;  
	/** Patient that writing name in receipt take List of Medicines, String[][] array*/
	private String listOfMedicine[][];   
	/** Date of receipt patient that writing name in receipt*/
	private String dateOfReceipt;
	

	/**
	 * Constructed,
	 * keep is string that name of file ,
	 * @param fileName
	 * is String that name of file
	 * */
	public Receipt(String fileName) 
	{
		ConvertFromFileToArray fileOfReceipt = new ConvertFromFileToArray(fileName);
		
		nameOfPatient  = fileOfReceipt.getArray()[0].split("\t")[0];
		socialSecurity = fileOfReceipt.getArray()[0].split("\t")[1];
		dateOfReceipt  = fileOfReceipt.getArray()[0].split("\t")[2];
		
		listOfMedicine = new String[fileOfReceipt.getArray().length-1][2];
		
		for (int i = 0; i < fileOfReceipt.getArray().length-1; i++) {
			for (int j = 0; j < 2; j++) {
				listOfMedicine[i][j] = fileOfReceipt.getArray()[i+1].split("\t")[j];
			}
		}
	}
	
	public String getNameOfPatient() {
		return nameOfPatient;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	public String[][] getListOfMedicine() {
		return listOfMedicine;
	}
	public String getDateOfReceipt() {
		return dateOfReceipt;
	}
}
