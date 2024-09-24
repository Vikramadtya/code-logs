/*
 * Question : 605. Can Place Flowers
 * Link : https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Iterate over the array if before and after is not 1 then it can be planted check for such occurences 
 * Command : `java -ea CanPlaceFlowers.java`
 */

public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers solution = new CanPlaceFlowers();
        Boolean res = solution.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1);

        assert res.toString().equals("true")
                : "The output is not  'true' for '[1, 0, 0, 0, 1]' & '1' but '" + res.toString() + "'";
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        if (flowerbed.length == 1) {
            return (n == 1 && flowerbed[0] == 0);
        } else if (flowerbed.length == 0) {
            return false;
        } else {
            for (int i = 0; i < flowerbed.length; ++i) {
                if (flowerbed[i] != 1) {
                    if (i == 0) {
                        if (flowerbed[i + 1] != 1) {
                            n--;
                            flowerbed[i] = 1;
                        }
                    } else if (i == flowerbed.length - 1) {
                        if (flowerbed[i - 1] != 1) {
                            flowerbed[i] = 1;
                            n--;
                        }
                    } else if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return n <= 0;
    }
}
