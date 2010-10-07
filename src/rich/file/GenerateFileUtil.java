package rich.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateFileUtil {

	public List<String> readFileContent(File file){
		List<String> result = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line != null){
				result.add(line);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	
	public void generateFile(List<String> fileContents,String prefix,String suffix,String destFileName){
		File destFile = new File(destFileName);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(destFile));
			for (String fileContent : fileContents) {
				writer.write(prefix + fileContent.trim() + suffix +"\r\n");	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		String filePath = GenerateFileUtil.class.getClass().getResource("/").getPath() + "/rich/file/terminolege.txt";
		File file = new File(filePath);
		GenerateFileUtil util = new GenerateFileUtil();
//		util.generateFile(util.readFileContent(file), "INSERT INTO FIN_INSTITUTION_TERMINAL ( FIN_INSTITUTION_ID, TERMINAL_ID, PROGRAM_GROUP_ID ) VALUES ( 1, '", "', 1);", "test.sql");
		util.generateFile(util.readFileContent(file), "prefix=", "", "terminolege.properties");
		System.out.println("generate successfully~");
	}
}
