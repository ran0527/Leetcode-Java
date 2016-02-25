public class ValidWordAbbr {
    HashMap<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String,String>();
        for (String str: dictionary) {
            String temp = getStr(str);
            if (map.containsKey(temp)) {
                if (!map.get(temp).equals(str)) {
                    map.put(temp, "");
                }
            } else {
                map.put(temp, str);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getStr(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }

    private String getStr(String str) {
        if(str.length() <= 2) {
            return str;
        }
        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
