#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *fptr;
    int currentdeep, lastdeep = -1;
    int increases = 0;
    if ((fptr = fopen("inputTest.txt","r")) == NULL)
    {
       printf("Error! opening file");

       // Program exits if the file pointer returns NULL.
       exit(1);
    }

    while (fscanf(fptr,"%d", &currentdeep) != EOF)
    {
        if (currentdeep > lastdeep && lastdeep != -1)
            increases++;

        lastdeep = currentdeep;
    }

    printf("Increases =%d\n", increases);

    fclose(fptr); 
    return 0;
}
