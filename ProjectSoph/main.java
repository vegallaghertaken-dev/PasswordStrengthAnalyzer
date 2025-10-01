package ProjectSoph;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// Code Project: Gambling 
/* To Implement:

    Strings:
 * .length()
 * .charAt(index)
 * .substring(start,end)
 * .contains(), .startsWith(), .endswith()
 * .replace(), .replaceAll()
 * .split()
 * .repeat()
 * .UUID.randomUUID()
 
    Collections/Arrays:
 * .toString()
 * .sort()
 * .equals(arr1,arr2)
 * .shuffle()
 * .reverse()
 
    Characters:
 * .isDigit()
 * .isLetter()
 * .toUpperCase(), .toLowerCase()
 
 */


public class main {

    public static int getRandomNumber(int min, int max){

        // Check max > min
        if (max <= min){
            return (-1);
        } else if (max > min){
            Random rand = new Random();
            int chosen = rand.nextInt(min,max);
            return (chosen);
        }
        return (-1);
    }

    public static void main (String[] args){

        // Strings, other
        Scanner scnr = new Scanner(System.in);
        String prompt = "Guess a number: ";
        String prompt_level = "Choose level: ";
        String current_level = "Insane";

        // Bools
        boolean did_guess = false;
        boolean debug_mode = true;
        boolean user_custom_level = true;
        boolean break_code = false;

        // Ints, arrays
        int guess = 0;
        int min = 0;
        int max = 1500;
        int level_num = max;
        Map<String, Integer> level_map = new HashMap<>();
            level_map.put("Insane",50);
            level_map.put("Difficult",100);
            level_map.put("Easy",250);
            level_map.put("Debug",max);

        // Clear terminal
        System.out.println("");
        System.out.println("");
        System.out.println("---- OUTPUT ----");
        System.out.println("debug_mode: "+debug_mode);
        System.out.println("user_custom_level: "+user_custom_level);
        System.out.println("current_level: "+current_level);
        System.out.println("break_code: "+break_code);
        System.out.println("level_options: "+"Insane, Difficult, Easy, Debug");
        System.out.println("");
        System.out.println("max: "+max);
        System.out.println("min: "+min);
        System.out.println("----------------");
        System.out.println("");
        System.out.println("");

        // Prompt level option
        if (user_custom_level == true && !break_code){
            System.out.print(prompt_level);
            String chosen_level = scnr.nextLine();
            if (chosen_level.equals("STOP")){
                break_code = true;
                System.out.println("// *Code stopped upon request");
                return;
            }

            current_level = chosen_level;

            if (level_map.containsKey(current_level)){
                level_num = level_map.get(current_level);
            } else {
                System.out.println("Level '"+current_level+"' doesn't exist.");
                return;
            }
        } else if (user_custom_level == false){
            if (level_map.containsKey(current_level)){
                level_num = level_map.get(current_level);
            } else {
                System.out.println("Level '"+current_level+"' doesn't exist.");
                return;
            }
        }
    
        // While loop for guesses
        while (did_guess == false && !break_code){
            // Prompt and receive guess
            System.out.print(prompt);
            String response = scnr.nextLine();
            if (response.equals("STOP")){
                break_code = true;
                System.out.println("// *Code stopped upon request");
                break;
            }

            int random = getRandomNumber(min,max);
            guess = Integer.parseInt(response);
            
            // Compare guess to randomnumber
            if (Math.abs(random-guess) <= level_num){ 
                System.out.println("// Great Guess, within "+level_num+"! Your guess was "+guess+", and the number was "+random+".");
                did_guess = true;
            } else {
                System.out.println("// Bad Guess!");
            }

            if (debug_mode == true){
                System.out.println("// *debug_mode: "+"(level: "+current_level+" <= "+ level_num+") "+"(guess: "+guess+") "+"(random: "+random+") (accuracy: "+(Math.abs(random-guess))+" off)");
            }
        }

        scnr.close();

    }
    
}
