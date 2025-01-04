class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int unitNumber = 0;

        for (int[] boxType : boxTypes) {
            map.put(boxType[1], map.getOrDefault(boxType[1], 0) + boxType[0]);
        }

        Set<Integer> keys = map.keySet();
        ArrayList<Integer> keyList = new ArrayList<>(keys);
        keyList.sort(Comparator.reverseOrder());

        for (Integer unit : keyList) {
            System.out.println(unit);
            Integer numberOfBoxes = map.get(unit);
            for (int i = 0; i < numberOfBoxes; i++) {
                if (truckSize > 0 && map.get(unit) > 0) {
                    unitNumber += unit;
                    truckSize--;
                    map.put(unit, map.get(unit) - 1);
                }
            }
        }

        return unitNumber;
    }
}