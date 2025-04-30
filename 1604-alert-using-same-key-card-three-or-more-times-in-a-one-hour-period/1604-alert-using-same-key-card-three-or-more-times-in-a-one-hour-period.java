import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        HashMap<String, List<Integer>> timeMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];

            String[] split = time.split(":");
            int convertedTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            timeMap.putIfAbsent(name, new ArrayList<>());
            timeMap.get(name).add(convertedTime);
        }

        for (Entry<String, List<Integer>> e : timeMap.entrySet()) {
            if (e.getValue().size() < 3) {
                continue;
            }
            Collections.sort(e.getValue());

            for (int i = 2; i < e.getValue().size(); i++) {
                if (e.getValue().get(i) - e.getValue().get(i - 2) <= 60) {
                    result.add(e.getKey());
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}