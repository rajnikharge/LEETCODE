import java.util.Scanner;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution merger = new Solution();

        System.out.print("Enter the length of the first array (nums1): ");
        int m = scanner.nextInt();
        int[] nums1 = new int[m];

        System.out.println("Enter elements for the first array (nums1):");
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Enter the length of the second array (nums2): ");
        int n = scanner.nextInt();
        int[] nums2 = new int[n];

        System.out.println("Enter elements for the second array (nums2):");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        merger.merge(nums1, m, nums2, n);

        System.out.println("Merged and sorted array:");
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
