public class Game implements Cloneable {
    public String name;
    public int space;
    public int metacriticScore;

    public Game(String name, int space, int score)
    {
        this.name = name;
        this.space = space;
        this.metacriticScore = score;
    }
}
