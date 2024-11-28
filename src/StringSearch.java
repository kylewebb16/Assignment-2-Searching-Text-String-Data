import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class StringSearch {
    String text = "the dog and the man go to the park";

    // Preforms the text search for search term using bad-character rule
    public static ArrayList<Integer> BMAlgorithm(String text, String searchKey) {
        // Set text and search inputs as char[] to iterate over
        ArrayList<Integer> results = new ArrayList<>();
        char[] textArray = text.toCharArray();
        char[] searchArray = searchKey.toCharArray();
        int searchLength = searchArray.length;
        // Adds chars in search term to a hash map to remember the last occurrence
        HashMap<Character, Integer> badChars = computeBadCharacter(searchArray);
        int textLength = textArray.length;
        // Declare text search pointer
        int i = 0;

        // Search through text until i is beyond possible range
        while (i < textLength - searchLength) {
            // Declare search key pointer to last char in term (to check from right to left and perform skips)
            int j = searchLength - 1;
            // Check if last char in search term matches corresponding char in text, move left if so
            while (j >= 0 && searchArray[j] == textArray[i + j]) {
                j--;
            }
            // If j == -1, every char matched, we found a match! add to results
            if (j == -1) {
                results.add(i);
                i++;
            }
            // Mismatch found, check if bad character found
            else {
                char currentChar = textArray[i + j];
                // If mismatched char does not exist in search key, skip past it
                int lastOccur = badChars.getOrDefault(currentChar, -1);

                i += Math.max(j - lastOccur, 1);
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

//    public static int[] goodSuffixTable(String searchKey) {
//        int length = searchKey.length();
//        int[] suffixShift = new int[length];
//        Arrays.fill(suffixShift, length);
//        for (int i = length - 1; i > 0; i--) {
//            String suffix = searchKey.substring(i);
//            for (int j = i - 1; j > 0; j--) {
//                if (searchKey.substring(j).startsWith(suffix)) {
//                    //             dist from end  -  suffix length
//                    suffixShift[i] = (length - j) - (length - i);
//                }
//            }
//
//        }
//        return suffixShift;
//    }
}
