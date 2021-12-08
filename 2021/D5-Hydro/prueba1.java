import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.BitSet;
import java.util.ArrayList;


class Prueba2 {

    public static int[] StringArrToIntArr(String[] s) 
    {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
           result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception 
    {
        // Open the file
        FileInputStream fstream = new FileInputStream("inputTest.txt");
        BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));
        ArrayList<Line> lines = new ArrayList<>();
        int x1,y1,x2,y2;
        int lenMatrix;
        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   
        {
            x1 = Integer.parseInt(strLine.split("->")[0].trim().split(",")[0]);
            y1 = Integer.parseInt(strLine.split("->")[0].trim().split(",")[1]);
            x2 = Integer.parseInt(strLine.split("->")[1].trim().split(",")[0]);
            y2 = Integer.parseInt(strLine.split("->")[1].trim().split(",")[1]);
            lines.add(new Line(new Point(x1,y1),new Point(x2,y2)));
        }

        //Close the input stream
        fstream.close();

        lenMatrix = Line.getMaxXY(lines) + 1;

        int[][] board = new int[lenMatrix][lenMatrix];

        for (int i = 0 ; i < lines.size() ; i++)
        {
            Line.draw(board, lines.get(i));
        }

        int greaterThan1 = 0;
        for (int i = 0 ; i < lenMatrix ; i++)
        {
            for (int j = 0 ; j < lenMatrix ; j++)
            {
                if (board[i][j] > 1)
                    greaterThan1++;
            }
    
        }

        System.out.printf("Resultado: %d\n",greaterThan1);
        

    }
}
