import java.util.LinkedList;
import java.util.List;

public class Evaluation {
    interface Function5<One, Two, Three, Four, Five> {
        public Five apply(One one, Two two, Three three, Four four);
    }

    public static List<Long> time(Function5<Integer, Integer, Integer, Integer, ?> function, int amount, int resolution) {
        LinkedList<Long> timings = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            long startTime = System.nanoTime();
            function.apply(resolution + 1, resolution / 2, resolution / 2, resolution / 2);
            long endTime = System.nanoTime();
            timings.add(endTime - startTime);
        }
        return timings;
    }

    public static void timeOverAllRanges(Function5<Integer, Integer, Integer, Integer, ?> function, int amount) {
        LinkedList<Integer> resolutions = new LinkedList<>();
        resolutions.add(100);
        resolutions.add(500);
        resolutions.add(1000);

        for (int resolution : resolutions) {
            List<Long> list = time(function, amount, resolution);
            double average = list.stream().mapToLong(l -> l).average().orElse(-1);
            System.out.println("Average over " + amount + " tries, (resolution: " + resolution + ") = " + average);
            System.gc();
        }
    }
}
