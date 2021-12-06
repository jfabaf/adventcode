import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.BitSet;


class Prueba1 {

    /*private static BitSet fromString(String binary) {
        BitSet bitset = new BitSet(binary.length());
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }*/
    
    public static void main(String[] args) throws IOException {
    //int numLine = 0;
    int[][] bits = null;
    int     length = 0;

    // Open the file
    FileInputStream fstream = new FileInputStream("inputTest.txt");
    BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   
    {
        if (bits == null)
        {
            bits = new int[strLine.length()][2];
            length = strLine.length();
        }
        
        for (int i = 0 ; i < strLine.length() ; i++)
        {
            if (strLine.charAt(i) == '0') //0
                bits[i][0] += 1;
            else
                bits[i][1] += 1;
        }

    }

    //Close the input stream
    fstream.close();
    String gamma = "",epsilon = "";

    for (int i = 0 ; i < length ; i++)
    {
        if (bits[i][1] > bits[i][0])
        {
            gamma += "1";
            epsilon += "0";
        }
        else
        {
            gamma += "0";
            epsilon += "1";
        }

    }

    System.out.printf("Solución: %d\n", Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon,2));
        
        
    }
}
