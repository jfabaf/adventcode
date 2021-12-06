public class Board {
    int[][] numbers;
    boolean[][] marked;
    int         lastDraw;
    boolean     isWinner;

    Board(int[][] numbers)
    {
        this.numbers = numbers;
        lastDraw = 0;
        marked = new boolean[numbers.length][numbers[0].length];
    }

    void draw(int number)
    {
        lastDraw = number;
        for (int i = 0 ; i < numbers.length ; i++)
            for (int j = 0 ; j < numbers[i].length ; j++)
            {
                if (numbers[i][j] == number)
                    marked[i][j] = true;
            }
    }

    boolean isWasWinner()
    {
        return isWinner;
    }
    boolean isWinner()
    {
        boolean aux;
        if (isWinner)
            return false; //only return winner once

        for (int i = 0 ; i < marked.length ; i++)
        {
            aux = true;
            for(int j = 0 ; j < marked[i].length ; j++)
                aux = aux && marked[i][j];
            
            if (aux)
            {
                isWinner = true;
                return true;
            }
        }

        for (int j = 0 ; j < marked[0].length ; j++)
        {
            aux = true;
            for (int i = 0 ; i < marked.length ; i++)
                aux = aux && marked[i][j];

            if (aux)
            {
                isWinner = true;
                return true;
            }
        }

        return false;
    }

    int score()
    {
        int score = 0;

        if (this.isWasWinner())
        {
            for (int i = 0 ; i < marked.length ; i++)
                for(int j = 0 ; j < marked[i].length ; j++)
                    if (marked[i][j] == false)
                        score += numbers[i][j];
                
        }
        
        return score*lastDraw;
    }
}
