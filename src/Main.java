import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String text = "the dnd dog and the man go to the park";
        String searchKey = "and";
        ArrayList<Integer> results = StringSearch.BMAlgorithm(text, searchKey);
        System.out.println(results);
    }
}
