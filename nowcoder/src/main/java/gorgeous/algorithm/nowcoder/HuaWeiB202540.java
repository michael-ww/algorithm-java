package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

// 最长的顺子
public class HuaWeiB202540 {

    public static void main(String[] args) {
        // String input = "3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A\n4-5-6-7-8-8-8";
        String input = "3-3-3-3-8-8-8-8\nK-K-K-K";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] handCards = scanner.nextLine().split("-");
        String[] playedCards = scanner.nextLine().split("-");
        int[] leftCards = getLeftCards(handCards, playedCards);
        System.err.println(getLongestChain(leftCards));
    }

    private static int[] getLeftCards(String[] handCards, String[] playedCards) {
        int[] cards = new int[12];
        Arrays.fill(cards, 4);

        for (String card : handCards) {
            Integer key = getCardKey(card);
            if (key < 0 || key >= cards.length) {
                continue;
            }
            cards[key]--;
        }

        for (String card : playedCards) {
            Integer key = getCardKey(card);
            if (key < 0 || key >= cards.length) {
                continue;
            }
            cards[key]--;
        }

        return cards;
    }

    private static String getLongestChain(int[] leftCards) {
        String answer = "NO-CHAIN";
        int maxLength = 0, leftCardsIndex = 0;
        while (leftCardsIndex < 8) {
            List<String> al = new ArrayList<>();
            StringJoiner sj = new StringJoiner("-");
            for (int rightIndex = leftCardsIndex; rightIndex < leftCards.length; rightIndex++) {
                if (leftCards[rightIndex] > 0) {
                    al.add(getCard(rightIndex));
                    sj.add(getCard(rightIndex));
                } else {
                    leftCardsIndex = rightIndex;
                    break;
                }
            }
            if (al.size() >= 5 && al.size() >= maxLength) {
                maxLength = al.size();
                answer = sj.toString();
            }
            leftCardsIndex++;
        }
        return answer;
    }

    private static Integer getCardKey(String card) {
        Map<String, Integer> cardToValue = new HashMap<>();
        cardToValue.put("J", 11);
        cardToValue.put("Q", 12);
        cardToValue.put("K", 13);
        cardToValue.put("A", 14);
        if (cardToValue.containsKey(card)) {
            return cardToValue.get(card) - 3;
        } else {
            return Integer.parseInt(card) - 3;
        }
    }

    private static String getCard(Integer key) {
        Map<Integer, String> valueToCard = new HashMap<>();
        key += 3;
        valueToCard.put(11, "J");
        valueToCard.put(12, "Q");
        valueToCard.put(13, "K");
        valueToCard.put(14, "A");
        if (valueToCard.containsKey(key)) {
            return valueToCard.get(key);
        } else {
            return key.toString();
        }
    }
}
