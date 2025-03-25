import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    List<Integer> array = new ArrayList<>();
    Map<Integer, Integer> indexMap = new HashMap<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        array.add(val);
        indexMap.put(val, array.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        int index = indexMap.get(val);
        int lastValue = array.get(array.size() - 1);
        array.set(index, lastValue);
        indexMap.put(lastValue, index);
        array.remove(array.size() - 1);
        indexMap.remove(val); 

        return true;
    }

    public int getRandom() {
        int idx = ThreadLocalRandom.current().nextInt(array.size());
        return array.get(idx);
    }
}