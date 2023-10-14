import java.util.Scanner;

class Solution {
    public int strStr(String a, String b) {
        if (b.isEmpty()) {
            return 0;
        }

        int[] l = computeLPS(b);

        for (int i = 0, j = 0; i < a.length(); ) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
                if (j == b.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = l[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }

    private int[] computeLPS(String b) {
        int[] l = new int[b.length()];
        for (int x = 0, i = 1; i < b.length(); ) {
            if (b.charAt(i) == b.charAt(x)) {
                l[i++] = ++x;
            } else if (x > 0) {
                x = l[x - 1];
            } else {
                l[i++] = 0;
            }
        }
        return l;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter haystack: ");
        String a = s.nextLine();
        System.out.print("Enter needle: ");
        String b = s.nextLine();

        Solution solution = new Solution();
        int i = solution.strStr(a, b);
        System.out.println("Output: " + i);
    }
}
