import java.util.HashMap;

public class RepeatedChar {
    private String str;
    private HashMap<Character,Integer> map = new HashMap<>();

    public RepeatedChar(String str) {
        this.str = str;
    }
    public Character findRepeated() {
        for (Character c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (map.containsKey(c)) {
                return c;
            }
            else {
                map.put(c,1);
            }
        }
        return Character.MAX_VALUE;
    }

}
