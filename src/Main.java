import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String text = Gui.getStatesString();
        String searchKey = "assa";
        ArrayList<Integer> results = StringSearch.BMAlgorithm(text, searchKey);
        System.out.println(results);
    }
}
