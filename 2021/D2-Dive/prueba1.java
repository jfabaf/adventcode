import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Prueba1 {
    public static void main(String[] args) throws IOException {
    int x=0,deep=0;
    String instruction;
    int number;

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
        number = Integer.parseInt(strLine.substring(spaceIndex+1));
        switch(instruction)
        {
            case "forward":
                x+= number;
                break;

            case "up":
                deep -= number;
                break;
            
            case "down":
                deep += number;
                break;
        }
    }

    //Close the input stream
    fstream.close();

    System.out.printf("Solución: %d\n", x*deep);
        
        
    }
}
