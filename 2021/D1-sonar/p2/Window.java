public class Window {
    private int[] values;
    private int nvalues;
    private int windowsSize;
    Window(int windowsSize)
    {
        this.windowsSize = windowsSize;
        values = new int[windowsSize];
        nvalues = 0;
    }

    void add(int value)
    {
        if (nvalues < windowsSize)
        {
            values[nvalues] = value;
            nvalues++;
        }
    }

    boolean complete()
    {
        return (nvalues == windowsSize);
    }

    int getSum()
    {
        int aux = 0;
        for (int i = 0 ; i < windowsSize ; i++)
        {
            aux += values[i];
        }
        return aux;
    }
}
