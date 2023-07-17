package chapter15;

public class UseStringMethods {
    static final String text = "The String class represents character strings.";
    public static void main(String[] args) {
        UseStringMethods practice = new UseStringMethods();

        practice.printWords(text);
        practice.findString(text, "string");
        practice.findAnyCaseString(text, "string");
        practice.countChar(text, 's');
        practice.printContainWords(text, "ss");
    }

    public void printContainWords(String str, String findStr) {
        String[] words = str.split(" ");

        for (String word: words) {
            if ( word.contains(findStr)) {
                System.out.println(word + " contains " + findStr);
                break;
            }
        }
    }

    public void countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }

        System.out.println("Char '" + c + "' count is " + count);
    }

    public void printWords(String str) {
        String[] splited = str.split(" ");
        for (String word : splited) {
            System.out.println(word);
        }
    }

    public void findString(String str, String findStr) {
        int findIndex = str.indexOf(findStr);
        System.out.println("string is appeared at " + findIndex);
    }

    public void findAnyCaseString(String str, String findStr) {
        String lowerStr = str.toLowerCase();
        String lowerFindStr = findStr.toLowerCase();

        int findIndex = lowerStr.indexOf(lowerFindStr);
        System.out.println("string is appeared at " + findIndex);
    }
}
