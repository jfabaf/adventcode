import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Prueba2 {

    public static int[] StringArrToIntArr(String[] s) 
    {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
           result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public static int getFuel(int steps)
    {
        return (steps*(steps + 1)) / 2;
    }


    public static void main(String[] args) throws Exception 
    {
        // Open the file
        FileInputStream fstream = new FileInputStream("input.txt");
        BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = br.readLine();
        int[] nums;
        List<Integer> numList;
        int max,min;
        int fuel = 0, minFuel = Integer.MAX_VALUE;

        //Close the input stream
        fstream.close();

        if (strLine != null)
        {
            nums = Prueba2.StringArrToIntArr(strLine.trim().split(","));
            numList = Arrays.asList(Arrays.stream(nums).boxed().toArray( Integer[]::new ));
            min = Collections.min(numList);
            max = Collections.max(numList);
            for (int destiny = min ; destiny <= max ; destiny++)
            {
                fuel = 0;
                for (int i = 0 ; i < nums.length ; i++)
                {
                    fuel += Prueba2.getFuel(Math.abs(destiny - nums[i]));
                }
                if (fuel < minFuel)
                    minFuel = fuel;
            }

            System.out.printf("Resultado: %d\n",minFuel);
    
        }



        
        

    }
}
