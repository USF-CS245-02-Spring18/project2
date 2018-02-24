/** CompactPrefixTree class, implements Dictionary ADT and
 *  several additional methods. Can be used as a spell checker.
 *  Fill in code in the methods of this class. You may add additional methods. */
public class CompactPrefixTree implements Dictionary {

    private Node root; // the root of the tree

    /** Default constructor.
     * Creates an empty "dictionary" (compact prefix tree).
     * */
    public CompactPrefixTree(){
        root = new Node();
    }

    /**
     * Creates a dictionary ("compact prefix tree")
     * using words from the given file.
     * @param filename the name of the file with words
     */
    public CompactPrefixTree(String filename) {
        // FILL IN CODE:
        // Read each word from the file, add it to the tree


    }

    /** Adds a given word to the dictionary.
     * @param word the word to add to the dictionary
     */
    public void add(String word) {
        add(word.toLowerCase(), root); // Calling private add method
    }

    /**
     * Checks if a given word is in the dictionary
     * @param word the word to check
     * @return true if the word is in the dictionary, false otherwise
     */
    public boolean check(String word) {
        return check(word.toLowerCase(), root); // Calling private check method
    }

    /**
     * Checks if a given prefix is stored in the dictionary
     * @param prefix The prefix of a word
     * @return true if the prefix is in the dictionary, false otherwise
     */
    public boolean checkPrefix(String prefix) {
        return checkPrefix(prefix.toLowerCase(), root); // Calling private checkPrefix method
    }


    /**
     * Prints all the words in the dictionary, in alphabetical order,
     * one word per line.
     */
    public void print() {
        print("", root); // Calling private print method
    }

    /**
     * Print out the nodes of the compact prefix tree, in a pre-order fashion.
     * First, print out the root at the current indentation level
     * (followed by * if the node's valid bit is set to true),
     * then print out the children of the node at a higher indentation level.
     */
    public void printTree() {
        // FILL IN CODE


    }

    /**
     * Print out the nodes of the tree to a file, using indentations to specify the level
     * of the node.
     * @param filename the name of the file where to output the tree
     */
    public void printTree(String filename) {
        // FILL IN CODE
        // Same as printTree, but outputs info to a file


    }

    /**
     * Return an array of the entries in the dictionary that are as close as possible to
     * the parameter word.  If the word passed in is in the dictionary, then
     * return an array of length 1 that contains only that word.  If the word is
     * not in the dictionary, then return an array of numSuggestions different words
     * that are in the dictionary, that are as close as possible to the target word.
     * Implementation details are up to you, but you are required to make it efficient
     * and make good use ot the compact prefix tree.
     *
     * @param word The word to check
     * @param numSuggestions The length of the array to return.  Note that if the word is
     * in the dictionary, this parameter will be ignored, and the array will contain a
     * single world.
     * @return An array of the closest entries in the dictionary to the target word
     */

    public String[] suggest(String word, int numSuggestions) {
        // FILL IN CODE
        // Note: you need to create a private suggest method in this class
        // (like we did for methods add, check, checkPrefix)


        return null; // don't forget to change it
    }

    // ---------- Private helper methods ---------------

    /**
     *  A private add method that adds a given string to the tree
     * @param s the string to add
     * @param node the root of a tree where we want to add a new string

     * @return a reference to the root of the tree that contains s
     */
    private Node add(String s, Node node) {
        // FILL IN CODE


        return null; // don't forget to change it
    }


    /** A private method to check whether a given string is stored in the tree.
     *
     * @param s the string to check
     * @param node the root of a tree
     * @return true if the prefix is in the dictionary, false otherwise
     */
    private boolean check(String s, Node node) {
        // FILL IN CODE

        return false; // don't forget to change it
    }

    /**
     * A private recursive method to check whether a given prefix is in the tree
     *
     * @param prefix the prefix
     * @param node the root of the tree
     * @return true if the prefix is in the dictionary, false otherwise
     */
    private boolean checkPrefix(String prefix, Node node) {
        // FILL IN CODE

        return false; // don't forget to change it
    }

    /**
     * Outputs all the words stored in the dictionary
     * to the console, in alphabetical order, one word per line.
     * @param s the string obtained by concatenating prefixes on the way to this node
     * @param node the root of the tree
     */
    private void print(String s, Node node) {
        // FILL IN CODE

    }

    // FILL IN CODE: add a private suggest method. Decide which parameters
    // it should have

    // --------- Private class Node ------------
    // Represents a node in a compact prefix tree
    private class Node {
        String prefix; // prefix stored in the node
        Node children[]; // array of children (26 children)
        boolean isWord; // true if by concatenating all prefixes on the path from the root to this node, we get a valid word

        Node() {
            isWord = false;
            prefix = "";
            children = new Node[26]; // initialize the array of children
        }
    }

}
