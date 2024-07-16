import java.util.*;

public class WordLadder {

    public static boolean isValidWord(String word, Set<String> dictionary) {
        return dictionary.contains(word);
    }

    public static boolean oneLetterDiff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static List<String> wordLadder(String start, String end, Set<String> dictionary) {
        if (start.equals(end)) {
            return Collections.singletonList(start);
        }

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(start));
        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String currentWord = path.get(path.size() - 1);

            for (String word : dictionary) {
                if (!visited.contains(word) && oneLetterDiff(currentWord, word)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(word);
                    if (word.equals(end)) {
                        return newPath;
                    }
                    queue.add(newPath);
                    visited.add(word);
                }
            }
        }

        return null; // No valid transformation found
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList("face", "bace", "back", "bock", "book"));
        String startWord = "face";
        String endWord = "book";

        List<String> result = wordLadder(startWord, endWord, dictionary);
        if (result != null) {
            System.out.println(String.join(" -> ", result));
        } else {
            System.out.println("No valid transformation found.");
        }
    }
}

