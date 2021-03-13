package com.example.ProjectForZamira;

import java.util.*;

public class Clock
{
    static boolean findAndUpdate(int x,int arr[],
                                 boolean second_chance[],int frames)

    {
        int i;

        for(i = 0; i < frames; i++)
        {

            if(arr[i] == x)
            {
                second_chance[i] = true;
                return true;
            }
        }

        return false;

    }


    static int replaceAndUpdate(int x,int arr[], boolean second_chance[],int frames,int pointer)
    {
        while(true)
        {

            if(!second_chance[pointer])
            {
                arr[pointer] = x;

                return (pointer+1)%frames;
            }

            second_chance[pointer] = false;

            pointer = (pointer+1)%frames;
        }
    }

    static void printHitsAndFaults(String reference_string,
                                   int frames)
    {
        int pointer,i,l,x,pf;

        pointer = 0;

        pf = 0;

        int arr[] = new int[frames];

        Arrays.fill(arr,-1);

        boolean second_chance[] = new boolean[frames];

        String str[] = reference_string.split(" ");

        l = str.length;

        for(i = 0; i<l; i++)
        {

            x = Integer.parseInt(str[i]);

            if(!findAndUpdate(x,arr,second_chance,frames))
            {
                pointer = replaceAndUpdate(x,arr,
                        second_chance,frames,pointer);

                pf++;
            }
        }

        System.out.println("Total page faults were "+pf);
    }
}