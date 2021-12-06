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
    int[] draw = null;
    int n = 5;
    int[][] boardNumers = new int[n][n];
    int currentLine;
    Board lastWinner = null;
    int nwiners=0;


    // Open the file
    FileInputStream fstream = new FileInputStream("inputTest.txt");
    BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));

    ArrayList<Board> boards = new ArrayList<>();

    String strLine;

    //Read File Line By Line
    currentLine = 0;
    while ((strLine = br.readLine()) != null)   
    {
        //System.out.printf("Voy por '%s'\n",strLine);
        if (draw == null) //firstline
        {
            draw = Prueba2.StringArrToIntArr(strLine.split(","));
        }
        else 
        {
            if (strLine.trim().length() > 0)
            {
                if (currentLine == 0)
                {
                    boardNumers = new int[n][n];
                }

                boardNumers[currentLine] = Prueba2.StringArrToIntArr(strLine.trim().replaceAll("   ", "  ").replaceAll("  ", " ").split(" "));
                if (currentLine == 4)
                {
                    boards.add(new Board(boardNumers));
                    currentLine = 0;
                }
                else
                    currentLine++;
            }
        }
    }

    //Close the input stream
    fstream.close();

    //Bingo begins
    for (int i = 0 ; i < draw.length && lastWinner == null ; i++)
    {
        for (int nboard = 0 ; nboard < boards.size() && lastWinner == null ; nboard++)
        {
            boards.get(nboard).draw(draw[i]);
            if (boards.get(nboard).isWinner())
            {
                
                nwiners++;
                if (nwiners == boards.size())
                {
                    lastWinner = boards.get(nboard);
                }
                    
            }

        }
    }

    if (lastWinner != null)
        System.out.printf("Resultado: %d\n",lastWinner.score());
    
    }
}
