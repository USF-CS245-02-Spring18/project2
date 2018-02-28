import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


/** Test file for CompactPrefixTree class.
 *  Note that this class provides only minimal testing.
 *  You are responsible for thoroughly testing the project on your own. */
public class CompactPrefixTreeTest {
    static final int NUM_SUGGESTIONS = 4;

    @Test
    public void testSimpleTree1() {
        CompactPrefixTree tree = new CompactPrefixTree();
        // create the tree shown in the project description
        tree.add("cat");
        tree.add("ape");
        tree.add("apple");
        tree.add("cart");
        tree.add("cats");
        tree.add("cat");
        tree.add("demon");
        tree.add("dog");
        tree.add("demons");

        String output = "test" + File.separator + "simpleTree1";
        tree.printTree(output);

        Path actual = Paths.get(output);  // your output
        Path expected = Paths.get("test" + File.separator + "expectedSimpleTree1"); // instructor's

        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
        } catch (IOException e) {
            Assert.fail(" File check failed: " + e.getMessage());
        }
        if (count <= 0)
            Assert.fail(" File check failed, files are different" );
    }

    @Test
    public void testSimpleTree2() {
        CompactPrefixTree tree = new CompactPrefixTree();
        // create a simple tree #2
        tree.add("liberty");
        tree.add("life");
        tree.add("lavender");
        tree.add("list");
        tree.add("youtube");
        tree.add("your");
        tree.add("you");
        tree.add("wrist");
        tree.add("wrath");
        tree.add("wristle");

        String output = "test" + File.separator + "simpleTree2";
        tree.printTree(output);

        Path actual = Paths.get(output);  // your output
        Path expected = Paths.get("test" + File.separator + "expectedSimpleTree2"); // instructor's

        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
        } catch (IOException e) {
            Assert.fail(" File check failed: " + e.getMessage());
        }
        if (count <= 0)
            Assert.fail(" File check failed, files are different" );
    }

    @Test
    public void testComplexTree() {
        // Create a tree from words in the file "words_ospd.txt"
        CompactPrefixTree tree = new CompactPrefixTree("words_ospd.txt");

        String output = "test" + File.separator + "wordsTree";
        tree.printTree(output);

        Path actual = Paths.get(output);  // your output
        Path expected = Paths.get("test" + File.separator + "expectedWordsTree"); // instructor's

        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
        } catch (IOException e) {
            Assert.fail(" File check failed: " + e.getMessage());
        }
        if (count <= 0)
            Assert.fail(" File check failed, files are different" );
    }

    @Test
    public void testCheckSmallDictionary() {
        Dictionary d = new CompactPrefixTree();
        boolean passed = true;

        String words[] = {"cat", "cart","dog", "apple", "ape", "breakfast", "breakneck", "queasy", "quash",
                "quail", "quick", "reason", "rickshaw", "reality"};

        String nonWords[] = {"carts", "ap", "break", "qu", "reasons", "buttercup", "under"};

        for (int i = 0; i < words.length; i++)  {
            d.add(words[i]);
        }
        for (int i = 0; i < nonWords.length; i++) {
            if (d.check(nonWords[i])) {
                Assert.fail("Found word:" + nonWords[i] + ", shoudn't have");
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (!d.check(words[i])) {
                Assert.fail("Failed to find word: " + words[i]);
            }
        }
    }

    @Test
    public void testCheckLargeDictionary() {
        String filename = "words_ospd.txt";
        Dictionary d = new CompactPrefixTree(filename); // added words from file to the dictionary
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // read each word from the file and check if it in the dictionary
                if (line.length() > 0) {
                    if (!d.check(line)) {
                        Assert.fail("Failed to find word: " + line);
                    }
                    for (int i = 0; i <= line.length(); i++) {
                        if (!d.checkPrefix(line.substring(0, i))) {
                            Assert.fail("Failed to find prefix: " + line.substring(0, i) + " of " + line);
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            Assert.fail("Could not read from the file: " + e);
        }
    }

    @Test
    /** Note: this method does not check whether your suggestions are reasonable.
     * It just checks the number of suggestions and whether each suggestion is a
     * valid word in the dictionary.
     *
     */
    public void testSuggestions() {
        System.out.println("In test Suggestions ---");
        String filename = "words_ospd.txt";
        Dictionary d = new CompactPrefixTree(filename); //adds words from file to the dictionary

        String goodWords[] = { "cat", "baseball", "original"};
        for (int i = 0; i < goodWords.length; i++)  {
                String result[] = d.suggest(goodWords[i], NUM_SUGGESTIONS);
                if (result == null) {
                    Assert.fail("Your suggest method returned a null.");
                }
                if (result.length != 1) {
                    System.out.println("Word " + goodWords[i] + " is in the dictionary -- suggest should return 1 item");
                    System.out.println("   " + result.length + " items returned instead");
                    Assert.fail();
                }
        }

        String badWords[] = {"accer", "fatte", "flox", "forg", "forsoom"};
        for (int i = 0; i < badWords.length; i++)
        {
            System.out.println("Trying " + badWords[i]);
            String result[] = d.suggest(badWords[i], NUM_SUGGESTIONS);
            if (result.length != NUM_SUGGESTIONS) {
                String feedback = "Didn't get correct number of suggestions for " + badWords[i] +
                        System.lineSeparator() + "  Expected " + NUM_SUGGESTIONS +
                        ", got " + result.length + System.lineSeparator();
                Assert.fail(feedback);
            }
            for (int j = 0; j < result.length; j++) {
                System.out.println("  " + result[j]);
                if (!d.check(result[j])) {
                    Assert.fail("Suggestion " + result[j] + " not in dictionary.");
                }
            }
        }

    }

}

