package playingcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class playingCards {
    public static final String[] SUITS = {"♥","♣","♦","♠"};
    public static void main(String[] args) {
        List<card> deck = buyDECK();
        System.out.println("刚买回来的牌:");
        System.out.println(deck);
        shuffle(deck);
        System.out.println("洗过的牌:");
        System.out.println(deck);
        // 三个人，每个人轮流抓 5 张牌
        List<List<card>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        //飘三叶
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("剩余的牌:");
        System.out.println(deck);
        System.out.println("A 手中的牌:");
        System.out.println(hands.get(0));
        System.out.println("B 手中的牌:");
        System.out.println(hands.get(1));
        System.out.println("C 手中的牌:");
        System.out.println(hands.get(2));
    }

    //买一副牌
    private static List<card> buyDECK() {
        List<card> deck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            String suit = SUITS[i];
            for (int j = 2; j <= 10 ; j++) {
                String rank = "";
                card card = new card(rank+j,suit);
                deck.add(card);
            }
            deck.add(new card("A",suit));
            deck.add(new card("J",suit));
            deck.add(new card("Q",suit));
            deck.add(new card("K",suit));
        }
        deck.add(new card("大王","大王"));
        deck.add(new card("小王","小王"));
        return deck;
    }

    private static void swap(List<card> deck, int i, int j) {
        card t = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,t);
    }

    private static void shuffle (List<card> deck) {
        Random random = new Random();
        for (int i = deck.size() - 1; i > 0 ; i--) {
            int r = random.nextInt(i);
            swap(deck,i,r);
        }
    }


}
