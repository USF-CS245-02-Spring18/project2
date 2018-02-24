/** The Driver class for CompactPrefixTree */
public class Driver {
    public static void main(String[] args) {
            Dictionary dict = new CompactPrefixTree();
            dict.add("cat");
            dict.add("cart");
            dict.add("carts");
            dict.add("case");
            dict.add("doge");
            dict.add("doghouse");
            dict.add("wrist");
            dict.add("wrath");
            dict.add("wristle");
            dict.print();

            // Add other "tests"
    }
}
