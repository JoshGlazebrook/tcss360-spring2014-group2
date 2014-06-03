package group2;
import com.google.gson.*;

import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Josh
 *
 */
public class JSONHelper {
	
	/**
	 * Serializes an object into a JSON data file.
	 * @param filename The target file location to save data to.
	 * @param obj The object to serialize to JSON.
	 * @return True if the process completed, false if it failed.
	 */
	public static boolean serializeToFile(String filename, Object obj)  {
		Gson serializer = new Gson();
		String result = serializer.toJson(obj);
		try {
			FileWriter writer = new FileWriter(new File(filename));
			writer.write(result);
			writer.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}
	
	/**
	 * Deserializes a JSON data file into an object of type T.
	 * @param filename The file location to read data from.
	 * @param objectType The type of the object to serialize to. 
	 * 				 	  Example: HashMap<String, String> result = deserializeFromFile("test.json", new HashMap<String, String>());
	 * @return 
	 * @return The object. null if the process failed.
	 */
	public static <T> T deserializeFromFile(String filename, Class<T> objectType) {
		Gson serializer = new Gson();
		try {
			Scanner reader = new Scanner(new File(filename));
			String data = reader.useDelimiter("\\Z").next();
			reader.close();
			T result = (T)serializer.fromJson(data, objectType);
			objectType = null;
			return result;
		} catch (IOException ex) {
			return null;
		} 
	}
}
