public class StringSolution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right > left) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, i + k - 1);
            while (end > start) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("  ");
            }
        }
        if (builder.length() == 0) {
            return s;
        }
        int left = s.length() - 1;
        s += builder.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    /**
     * 151
     *
     * @param s s
     * @return r
     */
    public String reverseWords(String s) {
        // 1. erase the useless spaces of s at start and end and middle
        StringBuilder sb = removeSpaces(s);
        // 2. reverse the whole string
        reverseWholeString(sb, 0, sb.length() - 1);
        // 3. reverse each word
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder removeSpaces(String s) {
        int start = 0;
        int end = s.length() - 1;
        // erase spaces at start and end
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            /*With the situation that The new char is not
            space or the last char at sb is not space,
            c can be appended to sb.
             */
            // if c equals ' ', then see the last char of sb.
            // if two situations failed, there are multiple spaces
            // This is a
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public void reverseWholeString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        // double pointer
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseWholeString(sb, start, end - 1);
            start = end + 1;
            // Now, end is the next one of start
            end = start + 1;
        }
    }

    private void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            chars[begin] ^= chars[end];
            chars[end] ^= chars[begin];
            chars[begin] ^= chars[end];
            begin++;
            end--;
        }
    }

    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(2 % 7);
    }
}
