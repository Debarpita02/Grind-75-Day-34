import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] LETTERS = {
        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = LETTERS[digit - '2'];

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String digits1 = "23";
        List<String> result1 = solution.letterCombinations(digits1);
        System.out.println(result1); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        String digits2 = "";
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println(result2); // Output: []

        String digits3 = "2";
        List<String> result3 = solution.letterCombinations(digits3);
        System.out.println(result3); // Output: ["a","b","c"]
    }
}
