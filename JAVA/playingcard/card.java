package playingcard;

public class card {
    //牌面值
    public String rank;
    //花色
    public String suit;

    @Override
    public String toString() {
        return String.format("[%s %s]",suit,rank);
    }

    public card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
