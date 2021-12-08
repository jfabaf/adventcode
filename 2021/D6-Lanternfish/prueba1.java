import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.BitSet;
import java.util.ArrayList;


class Prueba1 {

    public static ArrayList<Integer> StringArrToIntArrayList(String[] s) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
           result.add(Integer.parseInt(s[i]));
        }
        return result;
    }

    public static void main(String[] args) throws Exception 
    {
        // Open the file
        FileInputStream fstream = new FileInputStream("inputTest.txt");
        BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));
        ArrayList<Integer> fishes = new ArrayList<>();
        int days = 80; //80
        int newFishes;

        String strLine = br.readLine();
        if (strLine != null)
        {
            fishes = Prueba1.StringArrToIntArrayList(strLine.trim().split(","));
            
            while (days > 0)
            {
                newFishes = 0;
                for (int i = 0 ; i < fishes.size() ; i++)
                {
                    int currentValue = fishes.get(i).intValue();
                    if (currentValue == 0)
                    {
                        fishes.set(i, Integer.valueOf(6));
                        newFishes++;
                    }
                    else
                    {
                        fishes.set(i,currentValue-1);
                    }

                }
                for (int i = 0 ; i < newFishes ; i++)
                    fishes.add(Integer.valueOf(8));
                
                days--;
            }

            System.out.printf("Resultado: %d\n",fishes.size());
        }

        //Close the input stream
        fstream.close();

    }
}
