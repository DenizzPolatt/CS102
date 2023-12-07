/**
 * hangman
 */
public class Hangman
{

    public boolean charExists(char c)
    {
        for(int i = 0; i < chosenWord.length(); i++)
        {
            if(chosenWord.charAt(i) == c) return true;
        }
        return false;
    }

    public void tryThis(char givenchar)
        {

            if(usedLetters == null)
            {
                String secretWord = "";
                for(int i = 0; i < chosenWord.length(); i++)
                {
                    secretWord += "*";
                }

                StringBuffer knownSoFar = secretWord;
            }

            if(charExists(c))
            {
                knownSoFar = knownSoFar.replace(i, i, c);
            }
            else if(!charExists(c)) numIncorrectTries++;

        }

    public static void main(String[] args)
    {
        System.out.print("deniz");
    }
    
}