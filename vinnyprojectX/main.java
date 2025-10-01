package vinnyprojectX;

import java.util.Random;

public class main {

    // getRandomNumber(): return random int
    public static int getRandomNumber(int min, int max){
        if (max > min){
            Random randomGenerator = new Random();
            int randomNumber = randomGenerator.nextInt(min,max);
            return randomNumber;
        } else {
            return -1;
        }
    }

    // isCaseSensitive(): return true/false, is every char the same
    public static boolean isCaseSensitive(String first, String second){
        if (first.length() > 0 && second.length() > 0){
            if (first.length() == second.length()){
                for (int i=0; i < first.length(); i++){
                    if (first.charAt(i) != second.charAt(i)){
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    // main(): primary method
    public static void main (String[] args){

        // E
        Boolean isCaseSensitive = isCaseSensitive("TEsT", "TEsT");
        if (isCaseSensitive == true){
            System.out.println(isCaseSensitive+": Same sentence case sensitive.");
        } else if (isCaseSensitive == false) {
            System.out.println(isCaseSensitive+ ": Not same sentence case sensitive.");
        }

    }

}
