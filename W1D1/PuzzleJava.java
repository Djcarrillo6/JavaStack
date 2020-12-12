import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.*;


public class PuzzleJava {

         public ArrayList printSum() {


            // Create an empty ArrayList
            ArrayList<Integer> myArray = new ArrayList<Integer>();
            ArrayList<Integer> newArray = new ArrayList<Integer>();

                myArray.add(3);
                myArray.add(5);
                myArray.add(1);
                myArray.add(2);
                myArray.add(7);
                myArray.add(9);
                myArray.add(8);
                myArray.add(13);
                myArray.add(25);
                myArray.add(32); 

            int sum = 0;

            // Loop over ArrayList
            for(Integer num : myArray){

                sum = sum + num;  

                if (num > 10 ){
                    newArray.add(num);
                }   
            }
            System.out.println("The total sum is: " + sum);
            System.out.println(newArray);
            return newArray;
        };


        public ArrayList shuffleAndPrint() {
            ArrayList<String> myArray = new ArrayList<String>();

            myArray.add("Nancy");
            myArray.add("Jinichi");
            myArray.add("Fujibayashi");
            myArray.add("Fujibayashi");
            myArray.add("Ishikawa");

            System.out.println("Original List : \n" + myArray); 
  
            Collections.shuffle(myArray); 
  
            System.out.println("\nShuffled List : \n" + myArray);
            return myArray; 
        };

        public ArrayList alphabetSoup() {
            ArrayList<String> alphabetArray = new ArrayList<String>();

            alphabetArray.add("a");
            alphabetArray.add("b");
            alphabetArray.add("c");
            alphabetArray.add("d");
            alphabetArray.add("e");
            alphabetArray.add("f");
            alphabetArray.add("g");
            alphabetArray.add("h");
            alphabetArray.add("i");
            alphabetArray.add("k");
            alphabetArray.add("j");
            alphabetArray.add("l");
            alphabetArray.add("m");
            alphabetArray.add("n");
            alphabetArray.add("o");
            alphabetArray.add("p");
            alphabetArray.add("q");
            alphabetArray.add("r");
            alphabetArray.add("s");
            alphabetArray.add("t");
            alphabetArray.add("u");
            alphabetArray.add("v");
            alphabetArray.add("w");
            alphabetArray.add("x");
            alphabetArray.add("y");
            alphabetArray.add("z");
 
            Collections.shuffle(alphabetArray); 
            String first = alphabetArray.get(0);
            String[] vowels = new String[]{"a", "e", "i", "o", "u"}; 

            // Convert String Array to List
            List<String> list = Arrays.asList(vowels);
        
            if(list.contains(first)){
            System.out.println("YOU DREW A VOWEL!!!");
            }
            String last = alphabetArray.get(25);

            System.out.println("First letter of shuffled array: " + first);
            System.out.println("Last letter of shuffled array: " + last);
            System.out.println("\nShuffled Alphabet Array : \n" + alphabetArray);

            return alphabetArray;

        };


}
