
public class HangmanLogic {

    private String word;
    private String guessedLetters;
    private int numberOfFaults;

    public HangmanLogic(String word) {
        this.word = word.toUpperCase();
        this.guessedLetters = "";
        this.numberOfFaults = 0;
    }

    public int numberOfFaults() {
        return this.numberOfFaults;
    }

    public String guessedLetters() {
        return this.guessedLetters;
    }

    public int losingFaultAmount() {
        return 12;
    }

    public void guessLetter(String letter) {
        // program here the functionality for making a guess
        letter = letter.toUpperCase();

        // if the letter has already been guessed, nothing happens
        if (this.guessedLetters.indexOf(letter) > -1) {
            return;
        }

        // it the word does not contains the guessed letter, number of faults increase
        if (this.word.indexOf(letter) == -1) {
            this.numberOfFaults++;
        }
        // the letter is added among the already guessed letters
        this.guessedLetters += letter;
    }

    public String hiddenWord() {
        // program here the functionality for building the hidden word
        String hiddenWord = "";
        char[] guessed = guessedLetters.toCharArray();

        // create the hidden word by interating through this.word letter by letter
        // if the letter in turn is within the guessed words, put it in to the hidden word
        // if the letter is not among guessed, replace it with _ in the hidden word 
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            boolean found = false;
            for (int j = 0; j < guessed.length; j++) {
                if (letter == guessed[j]) {
                    found = true;
                    break;
                }
            }
            if (found) {
                hiddenWord += letter;
            }
            else {
                hiddenWord += "_";
            }
        }
        // return the hidden word at the end
        return hiddenWord;
    }
}
