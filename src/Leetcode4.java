public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int i = binarySearch(nums1, nums2, left, right);

        int j = (m + n + 1) / 2 - i;

        int nums1LeftMax;
        if(i == 0) {
            nums1LeftMax = Integer.MIN_VALUE;
        } else {
            nums1LeftMax = nums1[i - 1];
        }

        int nums1RightMin;
        if(i == m) {
            nums1RightMin = Integer.MAX_VALUE;
        } else {
            nums1RightMin = nums1[i];
        }

        int nums2LeftMax;
        if(j == 0) {
            nums2LeftMax = Integer.MIN_VALUE;
        } else {
            nums2LeftMax = nums2[j - 1];
        }

        int nums2RightMin;
        if(j == n) {
            nums2RightMin = Integer.MAX_VALUE;
        } else {
            nums2RightMin = nums2[j];
        }

        if((m + n) % 2 == 0) {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }

    }

    private int binarySearch(int[] nums1, int[] nums2, int left, int right) {
        while (left <= right) {
            int leftPart = (left + right) / 2;
            int rightPart = (nums1.length + nums2.length + 1) / 2 - leftPart;
            int nums1Left;
            if(leftPart > 0) {
                nums1Left = nums1[leftPart - 1];
            } else {
                nums1Left = Integer.MIN_VALUE;
            }

            int nums1Right;
            if(leftPart < nums1.length) {
                nums1Right = nums1[leftPart];
            } else {
                nums1Right = Integer.MAX_VALUE;
            }

            int nums2Left;
            if(rightPart > 0) {
                nums2Left = nums2[rightPart - 1];
            } else {
                nums2Left = Integer.MIN_VALUE;
            }

            int nums2Right;
            if(rightPart < nums2.length) {
                nums2Right = nums2[rightPart];
            } else {
                nums2Right = Integer.MAX_VALUE;
            }

            if(nums1Left <= nums2Right && nums2Left <= nums1Right) {
                return leftPart;
            } else if(nums1Left > nums2Right) {
                right = leftPart - 1;
            } else {
                left = leftPart + 1;
            }

        }
        return -1;
    }
}
