import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Prueba2 {
    public static void main(String[] args) throws IOException {
    int horizontal=0,deep=0,aim=0;
    String instruction;
    int x;

    // Open the file
    FileInputStream fstream = new FileInputStream("inputTest.txt");
    BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   
    {
        int spaceIndex;
        spaceIndex = strLine.indexOf(" ");
        instruction = strLine.substring(0, spaceIndex);
        x = Integer.parseInt(strLine.substring(spaceIndex+1));
        switch(instruction)
        {
            case "forward":
                horizontal+= x;
                deep += x*aim;
                break;

            case "up":
                aim -= x;
                break;
            
            case "down":
                aim += x;
                break;
        }
    }

    //Close the input stream
    fstream.close();

    System.out.printf("Solución: %d\n", horizontal*deep);
        
        
    }
}
