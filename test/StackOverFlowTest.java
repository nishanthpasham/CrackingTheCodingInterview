import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class StackOverFlowTest {
	
	@Test
	public void testUserDir(){
		System.out.println(System.getProperty("user.dir"));
	}
	
	public boolean checkIfIntegerAlreadyPresent(int[] array, int inputInteger) {
		for(int a:array) {
			if(a==inputInteger)
				return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		System.out.println(getKey("Account Name"));
	}

	// Call this method for a required target
	public static String getKey(String target) {
		Map<String, String> keyValueMap = loadKeyValueMap();
		return keyValueMap.get(target);
	}
	
	//load the keys and value only once.
	public static Map<String, String> loadKeyValueMap()
	{
	    File file = new File("data.txt");
	    Scanner reader = null;
	    try
	    {
	        reader = new Scanner(file);
	    } catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    
	    Map<String, String> map = new HashMap<>();

	    while (reader.hasNextLine())
	    {
	    	String nextLine = reader.nextLine();
	    	String[] split = nextLine.split(":");
	    	map.put(split[0].trim(), split[1].trim());
	    }

	    return map;
	}

}
