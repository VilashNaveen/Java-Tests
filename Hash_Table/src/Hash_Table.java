import java.util.LinkedList;

public class Hash_Table {
    private class KeyValue {
        protected int key;
        protected String value;
        public KeyValue(int K, String V) {
            this.key = K;
            this.value = V;
        }
        public int get_key() {
            return key;
        }
        public String get_Value() {
            return value;
        }
    }

    private LinkedList<KeyValue>[] Table = new LinkedList[5];

    //get hash value
    private int hash (int key) {
        return key % Table.length;
    }

    //get function
    public void Put(int key, String value) {
        var index = hash(key);
        if (Table[index] == null)
            Table[index] = new LinkedList<>();

        for (var entry : Table[index]) {
            if (entry.get_key() == key) {
                entry.value = value;
                return;
            }
        }
        Table[index].addLast(new KeyValue(key,value));
    }

    //delete function
    public void Delete(int key) {
        var index = hash(key);
        for (int i = 0; i < Table[index].size(); i++) {
            if (Table[index].get(i).get_key() == key) {
                Table[index].remove(i);
            }
        }
    }

    //Get function
    public String Get(int key) {
        var index = hash(key);
        for (var entries : Table[index]) {
            if (entries.get_key() == key) {
                return entries.get_Value();
            }
        }
        return "Not Found";
    }

}
