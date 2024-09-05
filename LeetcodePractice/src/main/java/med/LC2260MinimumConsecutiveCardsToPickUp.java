package med;

import java.util.HashMap;
import java.util.Map;

public class LC2260MinimumConsecutiveCardsToPickUp {

    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LC2260MinimumConsecutiveCardsToPickUp minimumConsecutiveCardsToPickUp = new LC2260MinimumConsecutiveCardsToPickUp();
        System.out.println(minimumConsecutiveCardsToPickUp.minimumCardPickup(cards));
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
