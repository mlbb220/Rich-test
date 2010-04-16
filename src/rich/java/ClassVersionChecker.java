package rich.java;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassVersionChecker {
	
	
	/*
	 * major  minor Java platform version
45       3           1.0
45       3           1.1
46       0           1.2
47       0           1.3
48       0           1.4
49       0           1.5
50       0           1.6 

	 */
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++)
            checkClassVersion(args[i]);
        String filename = "d:\\TestingMerchantScanner.class";
        checkClassVersion(filename);
    }

    private static void checkClassVersion(String filename)
        throws IOException
    {
        DataInputStream in = new DataInputStream
         (new FileInputStream(filename));

        int magic = in.readInt();
        if(magic != 0xcafebabe) {
          System.out.println(filename + " is not a valid class!");;
        }
        int minor = in.readUnsignedShort();
        int major = in.readUnsignedShort();
        System.out.println(filename + ": " + major + " . " + minor);
        in.close();
    }
} 