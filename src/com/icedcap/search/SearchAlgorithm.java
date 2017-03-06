package com.icedcap.search;

/**
 * 7 Algorithm of search.
 */
public class SearchAlgorithm {

    /**
     * Sequence Search. O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    public static int sequenceSerch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]) return i;
        }
        return -1;
    }

    /**
     * Binary Search.(non-recursive) O(lgn) time.
     *
     * @param arr
     * @param k
     * @return
     */
    public static int binarySearch(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > k) {
                r = mid - 1;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 插值查找，加强版二分查找。O(lg(lgn)) time.
     * <p>
     * 插值公式：(insertion - left)/ (right-left) = (k-arr[left])/(arr[right]-arr[left])
     *
     * @param arr
     * @param k
     * @return
     */
    public static int insertionSearch(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int insertion = left + (k - arr[left]) / (arr[right] - arr[left]) * (right - left);
            if (arr[insertion] == k) return insertion;
            if (arr[insertion] > k) right = insertion - 1;
            if (arr[insertion] < k) left = insertion + 1;
        }
        return -1;
    }

    /**
     * Fibonacci Search. O(lgn) time.
     * @param arr
     * @param key
     * @return
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        int breakPoint = 0;
        int k = 0;//斐波那契分割数值下标
        int i = 0;//序列元素个数
        int[] fib = createFibonacci(20);
        while (arr.length > fib[k] - 1) k++;//获取斐波那契分割数值下标

        while (left <= right) {
            breakPoint = left + fib[k - 1] - 1;
            if (arr[breakPoint] > key) {
                right = breakPoint - 1;
                k -= 1;
            } else if (arr[breakPoint] < key) {
                left = breakPoint + 1;
                k -= 2;
            } else {
                return breakPoint;

            }
        }
        return -1;
    }


    private static int[] createFibonacci(int size) {
        int[] fib = new int[size];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < size; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }



    public static void main(String[] args) {
        int[] orderSequence = {1, 4, 6, 7, 10, 22, 54};
        System.out.println(fibonacciSearch(orderSequence, 1));
    }

}
