
import java.util.*;
import java.io.*;

public class Main {
    public static class Gem implements Comparable<Gem> {
        public int weight;
        public int value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Gem o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Gem> gems = new ArrayList<>();
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            Gem gem = new Gem(weight, value);
            gems.add(gem);
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        Collections.sort(gems);

        long total = 0;
        int gemIndex = 0;
        PriorityQueue<Integer> bagValues = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            int bagWeight = bags[i];

            while (gemIndex < n && gems.get(gemIndex).weight <= bagWeight) {
                bagValues.offer(gems.get(gemIndex).value);
                gemIndex++;
            }

            if (!bagValues.isEmpty()) {
                total += bagValues.poll();
            }
        }

        System.out.println(total);
    }
}
