/** Dictionary ADT with extra functionality: the ability to make spelling suggestions.
 *  You may not change anything in this class. */
public interface Dictionary {

    /** Adds a given word to the dictionary
     * @param word The word to add to the dictionary
     */
    public void add(String word);

    /**
     * Checks if a given word is in the dictionary
     * @param word The word to check
     * @return true if the word is in the dictionary, false otherwise
     */
    public boolean check(String word);

    /**
     * Checks if a given prefix is stored in the dictionary
     * @param prefix The prefix of a word
     * @return true if the prefix is in the dictionary, false otherwise
     */
    public boolean checkPrefix(String prefix);


    /**
     * Outputs all the words stored in the dictionary
     * to the console, in alphabetical order, one word per line.
     */
    public void print();

    /**
     * Returns an array of "suggestions" - the closest entries in the dictionary to
     * the target word
     * @param word the target word
     * @param numSuggestions the number of suggestions to return
     * @return the array with suggestions
     */
    public String [] suggest(String word, int numSuggestions);

}
