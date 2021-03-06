package practiceproblems;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
 */
class IsomorphicString {
    static boolean isIsomorphic(String s, String t) {
        char[] m1 = new char[256];
        char[] m2 = new char[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            // it checks the count of the character in the array ;
            // for 'g' -> a[103] is 2 and 'd' -> a[100] is 2
            // if both are same both gets incremented together else return false
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = (char) (i + 1);
            m2[t.charAt(i)] = (char) (i + 1);
        }
        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
};