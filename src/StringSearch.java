import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class StringSearch {
    String text = "the dog and the man go to the park";

    public static ArrayList<Integer> BMAlgorithm(String text, String searchKey) {
        ArrayList<Integer> results = new ArrayList<>();
        char[] textArray = text.toCharArray();
        char[] searchArray = searchKey.toCharArray();
        HashMap<Character, Integer> badChars = computeBadCharacter(searchArray);
        int textLength = textArray.length;
        int searchLength = searchArray.length;
        int txtPTR = 0;
        while (txtPTR < textLength - searchLength) {
            int patPTR = searchLength - 1;
            while (patPTR >= 0 && searchArray[patPTR] == textArray[txtPTR + patPTR]) {
                patPTR--;
            }
            if (patPTR == -1) {
                results.add(txtPTR);
                txtPTR++;
            }
            else {
                // If pattern contains the current character
                    // add occurance to textptr
                // else shift textptr entire searchkey length
                char currentChar = textArray[txtPTR + patPTR];
// ERROR HERE
                if (badChars.containsKey(currentChar)) {
                    int badchrget = badChars.get(currentChar);
                    int interval = patPTR - badchrget;
                    txtPTR += interval;
                } else {
                    txtPTR += patPTR + 1;
                }
            }
        }


        return results;
    }
    // Boyer-moore
        // Bad character rule
            // If last char != searchKey && does not exist in search key, we can skip the whole sequence
        // Good suffix rule
    public static HashMap<Character, Integer> computeBadCharacter(char[] searchArray) {
        HashMap<Character, Integer> badChars = new HashMap<>();
        int searchLength = searchArray.length;
        for (int i = 0; i < searchLength; i++) {
            badChars.put(searchArray[i], i);
        }
        return badChars;
    }

}
