public class StringSearch {
    // Brute force
    // O(n) --slow
    // for each char in string
        // for each char in String
            // if string.subString(i, i + searchkey.length).equals(searchkey)
                // add i to results arrayList
            // Else i++
    
    // Boyer-moore
    // Compare searchkey to text.substring(searchkey.length) right to left
}
