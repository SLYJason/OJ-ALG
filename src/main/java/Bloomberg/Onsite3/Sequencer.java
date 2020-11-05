package Bloomberg.Onsite3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sequencer {
    PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> (p1.number - p2.number));
    int prev = 0;

    public static void main(String args[] ) throws Exception {
        Sequencer sequencer = new Sequencer();
        // Case 1:
        // User enters in sequence: 1 aaa, 2 bbb, 4 ddd, 5 eee, 3 ccc, 6 fff.

        // Case 2:
        // User enters in sequence: 1 aaa, 3 ccc, 4 ddd.
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            sequencer.handle(Integer.valueOf(split[0]), split[1]);
        }
    }

    class Pair {
        int number;
        String data;
        public Pair(int number, String data) {
            this.number = number;
            this.data = data;
        }
    }

    private void handle(int number, String data) {
        Pair pair = new Pair(number, data);
        pq.offer(pair);
        while(!pq.isEmpty() && prev + 1 == pq.peek().number) {
            Pair p = pq.poll();
            prev = p.number;
            System.out.println(p.data);
        }
    }
}
