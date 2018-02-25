import java.io.File;
import java.io.IOException;
import java.util.*;

public class Mapa {

    static Map<Integer, Integer> map = new TreeMap<>();

    public static void increment(Integer numberToBeCounted){
        Integer currentCount = map.get(numberToBeCounted);

        if (currentCount != null){
            currentCount++;
        }
        else {
            currentCount = 1;
        }
        map.put(numberToBeCounted, currentCount);
    }

    public static List<Integer> wczytaj() throws IOException {

        File file = new File("C:\\IdeaProjects\\mapy2\\src\\liczby.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(Integer.valueOf(scanner.nextLine()));
        }
        return list;
    }
    public static void main(String[] args) throws Exception{
        List<Integer> list = wczytaj();

        for (Integer l:list){
            increment(l);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > 1)
                System.out.println("Liczba " + entry.getKey() + " wystąpiła " + entry.getValue()+ " razy");
            else
                System.out.println("Liczba " + entry.getKey() + " wystąpiła " + entry.getValue()+ " raz");

        }
    }
}

