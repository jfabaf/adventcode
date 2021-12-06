import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.BitSet;
import java.util.ArrayList;


class Prueba2 {

    /*private static BitSet fromString(String binary) {
        BitSet bitset = new BitSet(binary.length());
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }*/
    
    public static void main(String[] args) throws Exception {
    //int numLine = 0;
    int     length = 0;
    int     ones, zeros;
    int     O2,CO2; 

    // Open the file
    FileInputStream fstream = new FileInputStream("inputTest.txt");
    BufferedReader  br = new BufferedReader(new InputStreamReader(fstream));

    ArrayList<String> all = new ArrayList<>();
    ArrayList<String> aux = null;
    ArrayList<String> left = null;

    String strLine;

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   
    {
        all.add(strLine);
    }

    //Close the input stream
    fstream.close();
    
    length = all.get(0).length();

    //oxygen generator rating
    left = new ArrayList<>(all);
    for (int i = 0 ; i < length && left.size() > 1 ; i++)
    {
        ones = 0;
        zeros = 0;
        for (int j = 0 ; j < left.size() ; j++)
        {
            switch(left.get(j).charAt(i))
            {
                case '0':
                    zeros++;
                    break;
                case '1':
                    ones++;
                    break;

            }
        }

        aux = new ArrayList<>();

        if (ones >= zeros)
        {
            for (int j = 0 ; j < left.size() ; j++)
            {
                switch(left.get(j).charAt(i))
                {
                    case '1':
                        aux.add(left.get(j));
                        break;
    
                }
            }
        }
        else
        {
            for (int j = 0 ; j < left.size() ; j++)
            {
                switch(left.get(j).charAt(i))
                {
                    case '0':
                        aux.add(left.get(j));
                        break;
    
                }
            }

        }
        left = new ArrayList<>(aux);

    }
    
    if (left.size() != 1)
    {
        throw new Exception("Error O2!!");
    }
    else
        O2 =  Integer.parseInt(left.get(0),2);


    //CO2 scrubber rating
    left = new ArrayList<>(all);
    for (int i = 0 ; i < length && left.size() > 1 ; i++)
    {
        ones = 0;
        zeros = 0;
        for (int j = 0 ; j < left.size() ; j++)
        {
            switch(left.get(j).charAt(i))
            {
                case '0':
                    zeros++;
                    break;
                case '1':
                    ones++;
                    break;

            }
        }

        aux = new ArrayList<>();

        if (zeros <= ones)
        {
            for (int j = 0 ; j < left.size() ; j++)
            {
                switch(left.get(j).charAt(i))
                {
                    case '0':
                        aux.add(left.get(j));
                        break;
    
                }
            }
        }
        else
        {
            for (int j = 0 ; j < left.size() ; j++)
            {
                switch(left.get(j).charAt(i))
                {
                    case '1':
                        aux.add(left.get(j));
                        break;
    
                }
            }

        }
        left = new ArrayList<>(aux);

    }
    
    if (left.size() != 1)
    {
        throw new Exception("Error CO2!!");
    }
    else
        CO2 =  Integer.parseInt(left.get(0),2);

    System.out.printf("Solución: %d\n",O2*CO2);


    }
}
