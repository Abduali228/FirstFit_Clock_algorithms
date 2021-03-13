package com.example.ProjectForZamira;

import java.io.IOException;
import java.util.Scanner;

public class Main {
        static void firstFit(int blockSize[], int m,
                             int processSize[], int n)
        {
            int allocation[] = new int[n];

            // Initially no block is assigned to any process
            for (int i = 0; i < allocation.length; i++)
                allocation[i] = -1;

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (blockSize[j] >= processSize[i])
                    {
                        allocation[i] = j;

                        blockSize[j] -= processSize[i];

                        break;
                    }
                }
            }

            System.out.println("\nProcess No.\tProcess Size\tBlock no.");
            for (int i = 0; i < n; i++)
            {
                System.out.print(" " + (i+1) + "\t\t" +
                        processSize[i] + "\t\t");
                if (allocation[i] != -1)
                    System.out.print(allocation[i] + 1);
                else
                    System.out.print("Not Allocated");
                System.out.println();
            }
        }

        public static void main(String[] args)throws IOException
        {
            Clock clock = new Clock();
            Scanner sc = new Scanner(System.in);
            int[] blockSize = new int[5];
            for(int i = 0 ;i<5;i++){
                System.out.println("");
                blockSize[i] = sc.nextInt();
            }
            int[] processSize = new int[4];
            for (int i=0;i< 4;i++){
                processSize[i] = sc.nextInt();
            }
            // 100 200 300 400 500
            int m = blockSize.length;
            int n = processSize.length;

            firstFit(blockSize, m, processSize, n);

            // Eldar sverhu stoit first fit, a snizu CLOCK. ok?

            String reference_string = "";
            int frames = 0;

            reference_string = "0 4 1 4 2 4 3 4 2 4 0 4 1 4 2 4 3 4";
            frames = 3;

            Clock.printHitsAndFaults(reference_string,frames);

            reference_string = "2 5 10 1 2 2 6 9 1 2 10 2 6 1 2 1 6 9 5 1";
            frames = 4;

            Clock.printHitsAndFaults(reference_string,frames);
        }
}
