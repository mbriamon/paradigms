public class Homework8 {
    public boolean check(char[] correctPositions, String word) {
        // If correctPositions is empty, we automatically return true
        if (correctPositions.length == 0) return true;

        for (int i = 0; i < correctPositions.length; i++) {
            char expected = correctPositions[i];
            char actual = word.charAt(i);

            if (expected == '*') {
                // Match anything: continue to next character
                continue;
            } else if (expected != actual) {
                // If it's not a match, return false
                return false;
            }
        }

        // All characters matched
        return true;
    }
}
