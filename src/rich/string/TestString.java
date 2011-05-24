
package rich.string;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class TestString {

	@Test
	public void testEncoding() throws UnsupportedEncodingException{
		 String chars = "ni我\uff0c\u8bf4\u201c\u6765\uff0c\u770b\u4e00\u4f1a\u80fd\u4e0d\u80fd\u751f\u51fa\u4e2a\u5c0f\u7684\u6765\u2026\u751f";
		 
		 System.out.println(chars);
		 String chars_enGB2312 = new String(chars.getBytes("GB2312"), "GB2312");
		 System.out.println( chars.equals(chars_enGB2312));//true!
		 String chars_enUTF8 = new String(chars.getBytes("UTF-8"), "UTF-8");
		 System.out.println( chars.equals(chars_enUTF8));//true!
		 String chars_enSJIS = new String(chars.getBytes("SJIS"), "SJIS");
	}
	
	@Test
	/*
	 * for twitter. Parse the tweet
	 */
	public void testIndexof(){
		String text = "I love this url at: http://www.163.com.  He is the best!";
		System.out.println("test text is : "+ text);
		int httpIndex = text.indexOf("http://");
		System.out.println("index of http:// is : " + httpIndex);
		int spaceIndex = text.indexOf(" ",httpIndex);
		System.out.println("index of \' \' is : " + spaceIndex);
		
		System.out.println("url result is : " + text.substring(httpIndex,spaceIndex));
	}
	
	
	@Test
	public void testEmpty(){
		String test = " ";
		
		System.out.println("string is \""+ test +"\" and is empty?" + test.isEmpty());
		System.out.println("string is \""+ test +"\" and trim() is empty?" + test.trim().isEmpty());
	}
}
