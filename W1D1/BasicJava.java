import java.util.ArrayList;


public class BasicJava {

    // Write a method that prints numbers 1-255
    public ArrayList printI(){

        // Create an empty ArrayList
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        // Loop over range(1-255), and add each int to the ArrayList
        for (int i = 1; i <= 255; i++) {
            myArray.add(i);
        }
        // Print out the newly filled ArrayList
        System.out.print(myArray);

        // Return the newly created ArrayList
        return myArray;
    }


    // Write a method that prints all the odd numbers from 1 to 255.
    public ArrayList printII() {

         // Create an empty ArrayList
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        // Loop over range(1-255), and add each int to the ArrayList
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0){
            myArray.add(i);
            }
        }
        // Print out the newly filled ArrayList
        System.out.print(myArray);

        // Return the newly created ArrayList
        return myArray;

    }


    // Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far. For example, your output should be something like this

        public ArrayList printSum(){

        // Create an empty ArrayList
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        int sum = 0;

        

        // Loop over range(1-255), and add each int to the ArrayList
        for (int i = 0; i <= 255; i++) {
            

            myArray.add(i);
            sum = sum + i;

            // Print out for each iteration
            System.out.print("New number:" + i + "Sum:"  + sum);
        }


        // Return the newly created ArrayList
        return myArray;
    }


    // Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen. Being able to loop through each member of the array is extremely important.

    public int[] iterateAndPrint() {
        int[] myArray = {1, 3, 5, 7, 9, 13};

        for (int item : myArray) {
             System.out.println("Count is: " + item);
        }
        return myArray;
    }


    // Write a method (sets of instructions) that takes any array and prints the maximum value in the array. Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, negative numbers and zero.
    int arr[] = {2, 8, -7, 19};

    public int returnMax() {
        
        int i; 
           
         // Initialize maximum element 
         int max = arr[0]; 
        
         // Traverse array elements from second and 
         // compare every element with current max   
         for (i = 1; i < arr.length; i++) 
             if (arr[i] > max) 
                 max = arr[i]; 
        
         return max; 
    }

    

};