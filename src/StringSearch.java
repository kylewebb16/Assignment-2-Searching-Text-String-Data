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
        int i = 0;
        while (i < textLength - searchLength) {
            int j = searchLength - 1;
            while (j >= 0 && searchArray[j] == textArray[i + j]) {
                j--;
            }
            if (j == -1) {
                results.add(i);
                i++;
            }
            else {
                // If pattern contains the current character
                    // add occurance to textptr
                // else shift textptr entire searchkey length
                char currentChar = textArray[i + j];
// ERROR HERE
                int lastOccurance = badChars.getOrDefault(currentChar, -1);
                // j - lastOccurance either shifts to
                i += Math.max(j - lastOccurance, 1);
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
