package myProg;

import java.io.*;

public class SplitFile {

//    Split a file according to the following criteria:
//    The first half of bytes written in file2, the second half of bytes written in the file3.
//    If file1 number of bytes is odd, then file2 contain more than half.

    public static void main(String[] args) throws IOException{
        try ( BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));) {

            String file1 = rd.readLine();
            String file2 = rd.readLine();
            String file3 = rd.readLine();


            FileInputStream file1Input = new FileInputStream(file1);
            FileOutputStream file2Output = new FileOutputStream(file2);
            FileOutputStream file3Output = new FileOutputStream(file3);

            byte[] bufferFile2 = new byte[file1Input.available()/2 + file1Input.available()%2];
            byte[] bufferFile3 = new byte[file1Input.available()/2];

            file2Output.write(bufferFile2, 0, file1Input.read(bufferFile2));
            file3Output.write(bufferFile3, 0, file1Input.read(bufferFile3));
        }
    }
}
