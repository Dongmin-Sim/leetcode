class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int maxCandy = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= maxCandy);
        }

        return result;
    }
}