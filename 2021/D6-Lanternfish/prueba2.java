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


    public static void main(String[] args) throws Exception 
    {
        // Open the file
        FileInputStream fstream = new FileInputStream("inputTest.txt");
        BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));
        int[] initial;
        long[] fishes = new long[9]; //0 to 8 days left and value represent number of fishes
        long numerOfFishes = 0;
        long[] newDay;
        int days = 256; //80

        String strLine = br.readLine();
        if (strLine != null)
        {
            initial = Prueba2.StringArrToIntArr(strLine.trim().split(","));
            for (int i = 0 ; i < initial.length ; i++)
                fishes[initial[i]]++;
            
            while (days > 0)
            {
                newDay = new long[9];
                for (int i = fishes.length - 1 ; i > 0 ; i--)
                {
                    newDay[i-1] += fishes[i];
                }
                newDay[6] += fishes[0];
                newDay[8] += fishes[0];
                fishes = newDay;
                days--;
            }

            for (int i = 0 ; i < fishes.length ; i++)
                numerOfFishes += fishes[i];

            System.out.printf("Resultado: %d\n",numerOfFishes);
        }

        //Close the input stream
        fstream.close();

    }
}
