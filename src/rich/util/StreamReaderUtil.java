/**
 * 
 */
package rich.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author rli
 *
 */
public class StreamReaderUtil {

	
	public static String readIntoOneLine(InputStream io) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(io));
		String line;
		StringBuffer sb = new StringBuffer();
		while((line = reader.readLine()) != null){
			sb.append(line);
		}
		return sb.toString();
	}
	
	/**
	 * read the bytes from an InputStream
	 * @param io
	 * @return
	 * @throws IOException
	 */
	public static byte[] readIntoOneArray(InputStream io) throws IOException{
		int readLength = 0;
		int bufferlength = 1000;
		byte[] buffer = new byte[bufferlength];
		byte[] result = new byte[10];
		
		for(int lastLength = 0;(readLength = io.read(buffer)) > 0;lastLength = lastLength + readLength){
			System.arraycopy(buffer, 0, result, lastLength, readLength);
			
		}
		
		return result;
		
	}
}
