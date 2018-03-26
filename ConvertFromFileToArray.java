//import statements
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
	
public class ConvertFromFileToArray 
{
	/**is number's line of file*/
	private int length;  
	/**is String[] array, each of line of file*/
	private String[] array;
	

	/**
	 * Constructed,
	 * keep is string that name of file ,
	 * is reading  file and convert String[] array 
	 * @param nameOfFile
	 * is String that name of file
	 */
	public ConvertFromFileToArray(String nameOfFile)
	{
		try {
			int i = 0;
			length = Files.readAllLines(Paths.get(nameOfFile)).size();
			array = new String[length];
			for(String line: Files.readAllLines(Paths.get(nameOfFile))){
				array[i++] = line;
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	

	public int getLength() {
		return length;
	}
	public String[] getArray() {
		return array;
	}
}
