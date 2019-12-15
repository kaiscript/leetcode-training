package leetcode.binary;

/**
 * 278. First Bad Version
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        int start = 1;
        int end = n;
        int mid = start;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            }
            else
                end = mid;
        }
        return start;
    }

    boolean isBadVersion(int version){
        if (version == 4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(5));
    }

}
