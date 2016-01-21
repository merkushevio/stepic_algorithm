package test_task;


import java.util.HashMap;

public class Main {
    private static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        //Map, keys that bits before transition and values - bits after transition
            map.put("0000", "0000");
            map.put("0001", "1000");
            map.put("0010", "0001");
            map.put("0011", "0010");
            map.put("0100", "0000");
            map.put("0101", "0010");
            map.put("0110", "1011");
            map.put("0111", "1011");
            map.put("1000", "0100");
            map.put("1001", "0101");
            map.put("1010", "0111");
            map.put("1011", "1111");
            map.put("1100", "1101");
            map.put("1101", "1110");
            map.put("1110", "0111");
            map.put("1111", "1111");
        //Check argument
        if (args.length < 1) {
            return;
        }
        //Print it
        System.out.println(args[0]);
        //Run methods
        pyramid(args[0]);
    }
    //method transform the pyramid until the pyramid more than 1 length
    public static void pyramid(String string) {
        int n = string.length()/4;
        StringBuilder builder = new StringBuilder();
        int k = 0;
        for (int i = 0; i < n; i++) {
            builder.append(transition(string.substring(i * 4, k + 4)));
            k += 4;
        }
        string = builder.toString();
        System.out.println(string);
        if (string.length() > 1) {
            pyramid(string);
        } else return;
    }
    //Method transition group from pyramid until bits not equals 0000 or 1111
    public static String transition(String substring) {
        while (substring != null) {
            substring = map.get(substring);
            System.out.println(substring);
            if (substring.equals("1111") ) {
                return "1";
            }
            if (substring.equals("0000")) {
                return "0";
            }
        }
        return "";
    }
}
