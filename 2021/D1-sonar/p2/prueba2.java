import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Your First Program

class Prueba2 {
    public static void main(String[] args) throws IOException {
    ArrayList<Window> windows = new ArrayList<>();
    int increases = 0;
    // Open the file
    
    FileInputStream fstream = new FileInputStream("inputTest.txt");
    BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));
    int             numLine = 0;
    int             currentNumber;
    Window          newWindow;

    String strLine;

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   
    {
        numLine++;
        currentNumber = Integer.parseInt(strLine);
        newWindow = new Window(3);
        newWindow.add(currentNumber);
        windows.add(newWindow);
        
        for (int i = windows.size()-2 ; i >= 0 ; i--)
        {
            Window aux;
            aux = windows.get(i);
            if (!aux.complete())
            {
                aux.add(currentNumber);
            }
            else
                break;
        }
    }

    //Close the input stream
    fstream.close();
    //int[] windows = new int[4];

    //remove not completed windows
    Window currentWindow=null,lastWindow=null;
    for (int i = 0 ; i < windows.size()  ; i++)
    {
        currentWindow = windows.get(i);
        if (!currentWindow.complete())
            break;

        if (lastWindow != null && currentWindow.getSum() > lastWindow.getSum() )
        {
            increases++;
        }
        lastWindow = currentWindow;
    }

    System.out.printf("Increases: %d\n", increases);
        
        
    }
}
