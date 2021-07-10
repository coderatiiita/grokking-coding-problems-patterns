package com.patterns.ModifiedBinarySearch;

class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int left = 0, right = letters.length - 1;
        int ans = -1;

        while (left<=right) {
            int mid = left + (right - left)/2;
            if(letters[mid] > key) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return ans == -1 ? letters[0] : letters[ans];

    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
