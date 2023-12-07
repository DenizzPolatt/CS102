import java.util.Random;

/**
 * @author Alp Batu Aksan
 */
public class Hangman
{

    private static int maxAllowedIncorrectTries = 6;
    private StringBuffer secretWord, knownSoFar, allLetters, usedLetters;
    private int numIncorrectTries;

    /**
     * @author Sertaç Derya 22003208, Umut Arda Filiz 22102323, Barış Sunar 22003479
     */
    public Hangman(){
        this.secretWord = chooseSecretWord();
        this.allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        this.usedLetters= new StringBuffer();
        this.numIncorrectTries = 0;
        this.knownSoFar = new StringBuffer();

        for(int i = 0; i < this.secretWord.length(); i++)
        {
            this.knownSoFar.append("_");
        }
    }

    /*
    This method takes character as a paramater to control its existence in the secret word 
    and makes necessary changes on some variables (numberOfIncorrectTries, usedLetters, knownSoFar). 
    After making changes, it returns the number of occurrences of the character in the secret word.
    */

    public int tryThis(char controlChar){
        //assuming that validity of the paramater was checked in main method, this part
        //aims to solve possible problems that might be caused by case of the letter 
        controlChar = Character.toUpperCase (controlChar);
        String tempSecretWord = this.secretWord.toString().toUpperCase();

        //checking whether that letter is given before and 
        //assuming it is an incorrect try if it is used before
        if (this.usedLetters.indexOf ("" + controlChar) > -1) {
            this.numIncorrectTries ++;
            return 0;
        }
        else {
            this.usedLetters.append (controlChar);
        }

        //calculating the number of occurences of the given letter
        int numberOfOccurrence = 0;

        for (int i = 0; i < tempSecretWord.length(); i++) {
            if (tempSecretWord.charAt(i) == controlChar) {
                numberOfOccurrence++;
                this.knownSoFar.replace (i, i + 1, "" + controlChar); //updating the known part of the secret word
            }
        }

        //increasing the number of incorrect tries if letter does not occur in secret word 
        if (numberOfOccurrence == 0) {
            this.numIncorrectTries++;
        }

        //returning the number of occurences
        return numberOfOccurrence;
    }
    
    /**
    * !! you need to import java.util.Random
    * Method randomly chooses a word from an array of words.
    * For choosing words that are hard we used these sites:
    * https://wordcounter.net/blog/tag/difficult-words
    * @author Melih Riza Yıldız & Tuna Saygın
    * @return result in terms of StringBuffer. This result will be used to initialize the instance variable called "secretWord"
    */
    private StringBuffer chooseSecretWord()
    {
        //Potential secret words stored in an array.
        String[] secretWordList = {"EMBARRASSMENT","FLUORESCENT", "ACCOMODATE","PSYCHIATRIST",
        "QUESTIONNAIRE","NECESSARY","MISCHEVIOUS","OCCASIONALLY","PNEUMONIA","RESTAURANT",
        "MILLENNIUM","RIDICULOUS","PHENOMENON", "SIXTH","RURAL", "COLONEL", "IRONIC","IRREGARDLESS",
        "LIEUTENANT", "DIDACTIC", "FEBRUARY","BEHAVIOUR", "DEVELOPMENT" };
        // creating a random object and choosing the index number of a word
        Random rand = new Random();
        int chosenIndex = rand.nextInt(secretWordList.length); // which word is chosen from the wordList as an index number
        StringBuffer result = new StringBuffer(secretWordList[chosenIndex]); // secret word as the type of a StringBuffer
        return result;
    }

    public boolean isGameOver()
    {
        if(hasLost()) return true;
        else if(knownSoFar.toString().equals(secretWord.toString())) return true;
        return false;
    }

    public boolean hasLost(){
        return numIncorrectTries > maxAllowedIncorrectTries;
    }
    
    public StringBuffer getSecretWord()
    {
        return secretWord;
    }
    public StringBuffer getKnownSoFar()
    {
        return knownSoFar;
    }
    public StringBuffer getUsedLetters()
    {
        return usedLetters;
    }
    public StringBuffer getAllLetters()
    {
        return allLetters;
    }
    public int getIncorrectTries()
    {
        return numIncorrectTries;
    }

    public int getMaxAllowedIncorrectTries()
    {
        return maxAllowedIncorrectTries;
    }
}
