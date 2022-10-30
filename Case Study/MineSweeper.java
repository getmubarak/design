import java.util.*;

public class MineSweeper {

    private int[][] fieldVisible = new int[10][10];
    private int[][] fieldHidden = new int[10][10];

    public void displayVisible()
    {
        System.out.print("\t ");
        for(int i=0; i<10; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<10; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++)
            {
                if(fieldVisible[i][j]==0)
                {
                    System.out.print("?");
                }
                else if(fieldVisible[i][j]==50)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(fieldVisible[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }

    public void displayHidden()
    {
        System.out.print("\t ");
        for(int i=0; i<10; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<10; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++)
            {
                if(fieldHidden[i][j]==0)
                {
                    System.out.print(" ");
                }
                else if(fieldHidden[i][j]==100)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(fieldHidden[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }

    public void fixVisible(int i, int j)
    {
        fieldVisible[i][j] = 50;
        if(i!=0)
        {
            fieldVisible[i-1][j] = fieldHidden[i-1][j];
            if(fieldVisible[i-1][j]==0) fieldVisible[i-1][j] = 50;
            if(j!=0)
            {
                fieldVisible[i-1][j-1] = fieldHidden[i-1][j-1];
                if(fieldVisible[i-1][j-1]==0) fieldVisible[i-1][j-1]=50;

            }
        }
        if(i!=9)
        {
            fieldVisible[i+1][j]=fieldHidden[i+1][j];
            if(fieldVisible[i+1][j]==0) fieldVisible[i+1][j]=50;
            if(j!=9)
            {
                fieldVisible[i+1][j+1]= fieldHidden[i+1][j+1];
                if(fieldVisible[i+1][j+1]==0) fieldVisible[i+1][j+1] = 50;
            }
        }
        if(j!=0)
        {
            fieldVisible[i][j-1]=fieldHidden[i][j-1];
            if(fieldVisible[i][j-1]==0) fieldVisible[i][j-1] = 50;
            if(i!=9)
            {
                fieldVisible[i+1][j-1]=fieldHidden[i+1][j-1];
                if(fieldVisible[i+1][j-1]==0) fieldVisible[i+1][j-1] = 50;
            }
        }
        if(j!=9)
        {
            fieldVisible[i][j+1]=fieldHidden[i][j+1];
            if(fieldVisible[i][j+1]==0) fieldVisible[i][j+1] = 50;
            if(i!=0)
            {
                fieldVisible[i-1][j+1]=fieldHidden[i-1][j+1];
                if(fieldVisible[i-1][j+1]==0) fieldVisible[i-1][j+1] = 50;
            }
        }
    }

    public void fixNeighbours(int i, int j)
    {
        Random random = new Random();
        int x = random.nextInt()%4;

        fieldVisible[i][j] = fieldHidden[i][j];

        if(x==0)
        {
            if(i!=0)
            {
                if(fieldHidden[i-1][j]!=100)
                {
                    fieldVisible[i-1][j] = fieldHidden[i-1][j];
                    if(fieldVisible[i-1][j]==0)  fieldVisible[i-1][j] = 50;
                }
            }
            if(j!=0)
            {
                if(fieldHidden[i][j-1]!=100)
                {
                    fieldVisible[i][j-1] = fieldHidden[i][j-1];
                    if(fieldVisible[i][j-1]==0)  fieldVisible[i][j-1] = 50;
                }

            }
            if(i!=0 && j!=0)
            {
                if(fieldHidden[i-1][j-1]!=100)
                {
                    fieldVisible[i-1][j-1] = fieldHidden[i-1][j-1];
                    if(fieldVisible[i-1][j-1]==0)  fieldVisible[i-1][j-1] = 50;
                }

            }
        }
        else if(x==1)
        {
            if(i!=0)
            {
                if(fieldHidden[i-1][j]!=100)
                {
                    fieldVisible[i-1][j] = fieldHidden[i-1][j];
                    if(fieldVisible[i-1][j]==0)  fieldVisible[i-1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(fieldHidden[i][j+1]!=100)
                {
                    fieldVisible[i][j+1] = fieldHidden[i][j+1];
                    if(fieldVisible[i][j+1]==0)  fieldVisible[i][j+1] = 50;
                }

            }
            if(i!=0 && j!=9)
            {
                if(fieldHidden[i-1][j+1]!=100)
                {
                    fieldVisible[i-1][j+1] = fieldHidden[i-1][j+1];
                    if(fieldVisible[i-1][j+1]==0)  fieldVisible[i-1][j+1] = 50;
                }
            }
        }
        else if(x==2)
        {
            if(i!=9)
            {
                if(fieldHidden[i+1][j]!=100)
                {
                    fieldVisible[i+1][j] = fieldHidden[i+1][j];
                    if(fieldVisible[i+1][j]==0)  fieldVisible[i+1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(fieldHidden[i][j+1]!=100)
                {
                    fieldVisible[i][j+1] = fieldHidden[i][j+1];
                    if(fieldVisible[i][j+1]==0)  fieldVisible[i][j+1] = 50;
                }

            }
            if(i!=9 && j!=9)
            {
                if(fieldHidden[i+1][j+1]!=100)
                {
                    fieldVisible[i+1][j+1] = fieldHidden[i+1][j+1];
                    if(fieldVisible[i+1][j+1]==0)  fieldVisible[i+1][j+1] = 50;
                }
            }
        }
        else
        {
            if(i!=9)
            {
                if(fieldHidden[i+1][j]!=100)
                {
                    fieldVisible[i+1][j] = fieldHidden[i+1][j];
                    if(fieldVisible[i+1][j]==0)  fieldVisible[i+1][j] = 50;
                }
            }
            if(j!=0)
            {
                if(fieldHidden[i][j-1]!=100)
                {
                    fieldVisible[i][j-1] = fieldHidden[i][j-1];
                    if(fieldVisible[i][j-1]==0)  fieldVisible[i][j-1] = 50;
                }

            }
            if(i!=9 && j!=0)
            {
                if(fieldHidden[i+1][j-1]!=100)
                {
                    fieldVisible[i+1][j-1] = fieldHidden[i+1][j-1];
                    if(fieldVisible[i+1][j-1]==0)  fieldVisible[i+1][j-1] = 50;
                }
            }
        }
    }

    public boolean playMove()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int i= sc.nextInt();
        System.out.print("Enter Column Number: ");
        int j= sc.nextInt();

        if(i<0 || i>9 || j<0 || j>9 || fieldVisible[i][j]!=0)
        {
            System.out.print("\nIncorrect Input!!");
            return true;
        }

        if(fieldHidden[i][j]==100)
        {
            displayHidden();
            System.out.print("Oops! You stepped on a mine!\n============GAME OVER============");
            return false;
        }
        else if(fieldHidden[i][j]==0)
        {
            fixVisible(i, j);
        }
        else
        {
            fixNeighbours(i, j);
        }

        return true;
    }

    public void buildHidden()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                int cnt=0;
                if(fieldHidden[i][j]!=100)
                {

                    if(i!=0)
                    {
                        if(fieldHidden[i-1][j]==100) cnt++;
                        if(j!=0)
                        {
                            if(fieldHidden[i-1][j-1]==100) cnt++;
                        }

                    }
                    if(i!=9)
                    {
                        if(fieldHidden[i+1][j]==100) cnt++;
                        if(j!=9)
                        {
                            if(fieldHidden[i+1][j+1]==100) cnt++;
                        }
                    }
                    if(j!=0)
                    {
                        if(fieldHidden[i][j-1]==100) cnt++;
                        if(i!=9)
                        {
                            if(fieldHidden[i+1][j-1]==100) cnt++;
                        }
                    }
                    if(j!=9)
                    {
                        if(fieldHidden[i][j+1]==100) cnt++;
                        if(i!=0)
                        {
                            if(fieldHidden[i-1][j+1]==100) cnt++;
                        }
                    }

                    fieldHidden[i][j] = cnt;
                }
            }
        }

        //displayHidden();
    }

    public void setupField(int diff)
    {
        int var=0;
        while(var!=10)
        {
            Random random = new Random();
            int i = random.nextInt(10);
            int j = random.nextInt(10);
            //System.out.println("i: " + i + " j: " + j);
            fieldHidden[i][j] = 100;
            var++;
        }
        buildHidden();
    }

    public boolean checkWin()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                if(fieldVisible[i][j]==0)
                {
                    if(fieldHidden[i][j]!=100)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void startGame()
    {
        System.out.println("\n\n================Welcome to Minesweeper ! ================\n");
        setupField(1);

        boolean flag = true;
        while(flag)
        {
            displayVisible();
            flag = playMove();
            if(checkWin())
            {
                displayHidden();
                System.out.println("\n================You WON!!!================");
                break;
            }
        }
    }



    public static void main(String[] args)
    {
        MineSweeper M = new MineSweeper();
        M.startGame();
    }

}
