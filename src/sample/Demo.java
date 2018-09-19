/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author meshpaul
 */
public class Demo {

    static int fiboN1=0,fiboN2=1,fiboN3=0;
    static boolean printFirst=false;

    /**
     * Java 8 / Lambda approach to streamFibonachi fibonacci series.
     * Fibonacci always start as classic (e.g. 0, 1, 1, 2, 3, 5)
     * @param series Number of how many fibonacci number should be generated
     * @return List holding resulting fibonacci number.
     */
    public static List<Integer> streamFibonachi(int series) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(series)
                .map(n -> n[0])
                .collect(toList());
    }
    
    
    public static void printFiboRecursion(int count){
        
        if (!printFirst){
            System.out.println("Runnig printFiboRecursion");
            System.out.print(fiboN1+" "+fiboN2);
            printFirst=true;
        }
        
        if (count>0)
        {
           fiboN3=fiboN1+fiboN2;
           fiboN1=fiboN2;
           fiboN2=fiboN3;
            System.out.print(" "+fiboN3);
            
            printFiboRecursion(count-1);
        }
    }
    
    
    static void printFiboClassicLoop(int count){
       System.out.println("\nprintFiboClassicLoop");
       System.out.print("0 1");
       int fibo1=0,fibo2=1,fibo3=0;
       for (int i=0; i< count; i++){
           fibo3=fibo1+fibo2;
           fibo1=fibo2;
           fibo2=fibo3;
           System.out.print(" "+fibo3);
       }
        
    }

    
    public static void bubleSort(int[] array){
        
        int arrLenth = array.length;
        
        int innerCounter=0;
        
        int interCnt=0;
        
        for (int outr=arrLenth; outr >= 0; outr--){
            for (int innr=0; innr < arrLenth-1; innr++){
                  innerCounter=innr+1;
                  
                  if (array[innr] > array[innerCounter]){
                      int swapValue = array[innr];
                      array[innr] = array[innerCounter];
                      array[innerCounter]= swapValue;
                      
                  }
                  // System.out.print(Arrays.toString(array)+"\n");
                  innerCounter++;
            }
            
            innerCounter++;
        }
        System.out.println("Took "+innerCounter+" iterations to finish algorithm");
    }
    
    
    
    public static void streamBubbleSort(int[] arr){
        System.out.println("\n streamBubbleSort");
        int arrLenght=arr.length;
        
        final AtomicInteger cntr2 = new AtomicInteger(0);
        
        IntStream.range(0, arrLenght -1)
                .flatMap(i -> IntStream.range(i+1, arrLenght-1))
                .forEach(j -> {
                    if (arr[j-1]>arr[j]){
                        int tmp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = tmp;
                    }
                   System.out.println("interation "+ cntr2.incrementAndGet()+" "+Arrays.toString(arr));
                }
                       
                
                );
        
        System.out.println("final product"+Arrays.toString(arr));
        
        System.out.println("It took "+cntr2.get()+" iterations");
    }
    
    
    public static void optimizedBubleSort(int[] arr){
       int i = 0, arrLength = arr.length, counter=0;
       boolean swapNeeded = true;
       
       while (i < arrLength & swapNeeded ){
           swapNeeded = false;
           for (int j = 1; j < arrLength-1; j++){
                   if (arr[j-1]>arr[j]){
                        int tmp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = tmp;
                        swapNeeded = true;
                    }
                   counter++;
           }
           if (!swapNeeded)
               break;
           counter++;
           i++;
       }
       
       System.out.println("Optimized sort took "+counter);
    }
    
    

        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           System.out.println(streamFibonachi(20));
           
           printFiboRecursion(20);
           printFiboClassicLoop(20);
           System.out.println();
           int[] work ={5,3,1,60,20,75,24};
           
           bubleSort(work);
           
           streamBubbleSort(work);
           optimizedBubleSort(work);
    }
    
    
    
    
}
