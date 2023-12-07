import java.util.ArrayList;
// In this question, you are going to help Mike Wazowski. He wants to download video
// games but his computer has limited storage of N GB. Each game Gi takes up Ai GB
// of space and has Bi Metacritic score. Metacritic score is between 0 and 100. A high
// score signals high-quality games. Mike’s aim is to maximize the Metacritic score of
// the games on his computer. Write a recursive function that takes an array of games
// as input and returns the scores of the games he should download to achieve the
// maximum score. Note that he can either download or not download, partially
// downloading a game is not possible. In addition, he can download each game at
// most once.


class ScoreAndPickedArray
{
    public int score;
    public boolean[] picked_games;

    ScoreAndPickedArray(int score, boolean[] picked_games)
    {
        this.score = score;
        this.picked_games = picked_games;
    }
}

public class Question2 {

    // our aim is to maximize the metacritic score without exceeding the space
    // available in the computer.
    // we have an ArrayList of Game objects: we choose and download from them.

    public static ScoreAndPickedArray pick_games_helper(
        ArrayList<Game> games, int computer_space, 
        int total_score, int total_weight, 
        int idx, boolean[] picked_games)
    {
        if(idx >= games.size())
        {
            return new ScoreAndPickedArray(total_score, picked_games);
        }

        ScoreAndPickedArray s2 = pick_games_helper(
            games, 
            computer_space, 
            total_score, 
            total_weight, 
            idx + 1, picked_games.clone());

        boolean[] with_cur = picked_games.clone();
        if(computer_space >= total_weight + games.get(idx).space)
        {
            with_cur[idx] = true;
            ScoreAndPickedArray s1 = pick_games_helper(
                games, 
                computer_space, 
                total_score + games.get(idx).metacriticScore, 
                total_weight + games.get(idx).space, 
                idx + 1, with_cur);
            
            if(s1.score > s2.score)
            {
                return s1;
            }
            else
            {
                return s2;
            }
        }
        else
        {
            return s2;
        }
    }

    public static int[] pick_games(ArrayList<Game> games, int computer_space)
    {
        boolean[] picked_games = new boolean[games.size()];
        for(int i = 0; i < games.size(); ++i)
        {
            picked_games[i] = false;
        }

        ScoreAndPickedArray q = pick_games_helper(
            games, computer_space, 0, 0, 0, picked_games
        );

        int size = 0;
        for(boolean b : q.picked_games)
        {
            if(b) size++;
        }

        int[] picked_games_scores = new int[size];
        
        int j = 0;
        for(int i = 0; i < q.picked_games.length; ++i)
        {
            if(q.picked_games[i]) 
                picked_games_scores[j++] = games.get(i).metacriticScore;
        }

        return picked_games_scores;
    }

    public static void main(String[] args) {
        ArrayList<Game> games = new ArrayList<Game>();

        Game g1 = new Game("Game A", 100, 50);
        Game g2 = new Game("Game B", 50, 10);
        Game g3 = new Game("Game C", 60, 45);

        games.add(g1);
        games.add(g2);
        games.add(g3);

        int[] q = pick_games(games, 110);
        for(int p : q)
        {
            System.out.println(p);
        }
    }

}
