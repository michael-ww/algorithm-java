package gorgeous.algorithm.leetcode;

public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            throw new NullPointerException();
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int haystackIndex = i, needleIndex = 0;
            while (haystackIndex < haystack.length() && needleIndex < needle.length()
                    && haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
                haystackIndex++;
                needleIndex++;
            }
            if (needleIndex >= needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
