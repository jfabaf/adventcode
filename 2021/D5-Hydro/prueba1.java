import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.BitSet;
import java.util.ArrayList;


class Prueba2 {

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
           result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
    // Open the file
    FileInputStream fstream = new FileInputStream("inputTest.txt");
    BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));


    String strLine;

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   
    {
    }

    //Close the input stream
    fstream.close();
    }
}
