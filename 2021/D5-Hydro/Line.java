import java.util.ArrayList;

public class Line {
    private Point   p1,p2;

    Line(Point p1, Point p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1()
    {
        return p1;
    }

    public Point getP2()
    {
        return p2;
    }

    public int getMaxXY()
    {
        if (p1.getMaxXY() > p2.getMaxXY())
            return p1.getMaxXY();
        else
            return p2.getMaxXY();
    }


    public static int getMaxXY(ArrayList<Line> lines)
    {
        int max=-1;
        for (int i = 0 ; i < lines.size() ; i++)
        {
            if (lines.get(i).getMaxXY() > max)
            {
                max = lines.get(i).getMaxXY();
            }
        }
        return max;
    }

    public static void draw(int[][] board, Line line) throws Exception
    {
        if (line.getP1().getX() == line.getP2().getX()) //same x
        {
            if (line.getP1().getY() <= line.getP2().getY())
            {
                for (int i = line.getP1().getY() ; i <= line.getP2().getY() ; i++)
                    board[line.getP1().getX()][i]++;
            }
            else
            {
                for (int i = line.getP2().getY() ; i <= line.getP1().getY() ; i++)
                    board[line.getP1().getX()][i]++;
            }
        }
        else if (line.getP1().getY() == line.getP2().getY())
        {
            if (line.getP1().getX() <= line.getP2().getX())
            {
                for (int i = line.getP1().getX() ; i <= line.getP2().getX() ; i++)
                    board[i][line.getP1().getY()]++;
            }
            else
            {
                for (int i = line.getP2().getX() ; i <= line.getP1().getX() ; i++)
                    board[i][line.getP1().getY()]++;
            }
        
        }
        else
        {
            Point p1,p2;
            int incX,incY = 1;
            if (line.getP1().getY() < line.getP2().getY())
            {
                p1 = line.getP1();
                p2 = line.getP2();
            }
            else
            {
                p1 = line.getP2();
                p2 = line.getP1();
            }

            //p1.y < p2.y  / or \
            if (p2.getX() < p1.getX())
                incX = -1;
            else
                incX = 1;

            int x,y;
            for (x = p1.getX(),y = p1.getY() ; ((incX == -1 && x >= p2.getX()) || (incX == 1 && x <= p2.getX())) && y <= p2.getY(); x += incX,y++ )
                    board[x][y]++;

        }
    }
}
