package demo;

import java.util.Scanner;

public class findResult 
{  
 public static int FindMaxNum(int[] arr)
 {
   Scanner sc=new Scanner(System.in);
   int max=arr[0];
   for(int i=0;i<arr.length;i++)
   {
     if(max<arr[i])
     {
       max=arr[i];

     }
    
   }
   return max;
   
 }
 
 
 public boolean EvenorOdd(int a)
 {
   if(a%2==0)
   {
     return true;
   }
   
   return false;
 }

 
}