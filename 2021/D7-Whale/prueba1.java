import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


class Prueba1 {

    public static int[] StringArrToIntArr(String[] s) 
    {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
           result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public static int getMedian(int[] numArray)
    {
        Arrays.sort(numArray);
        int median;
        if (numArray.length % 2 == 0)
            median = ((int)numArray[numArray.length/2] + (int)numArray[numArray.length/2 - 1])/2;
        else
            median = (int) numArray[numArray.length/2];

        return median;
    }

    public static void main(String[] args) throws Exception 
    {
        // Open the file
        FileInputStream fstream = new FileInputStream("input.txt");
        BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = br.readLine();
        int[] nums;
        int median;
        int fuel = 0;

        //Close the input stream
        fstream.close();

        if (strLine != null)
        {
            nums = Prueba1.StringArrToIntArr(strLine.trim().split(","));
            median = Prueba1.getMedian(nums);
            for (int i = 0 ; i < nums.length ; i++)
            {
                fuel += Math.abs(nums[i] - median);
            }

            System.out.printf("Resultado: %d\n",fuel);
    
        }



        
        

    }
}
