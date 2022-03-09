import java.util.*;
/**
 * lzw
 */
public class lzw {

    public static String encode(String msg){
        int dictSize = 256;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            map.put(String.valueOf((char)i), i);
        }
        StringBuilder output = new StringBuilder();
        String foundChar = "";
        for (Character c : msg.toCharArray()) {
            String charToFind = foundChar+c;
            if(map.containsKey(charToFind)){
                foundChar = charToFind;
            }else{
                output.append(map.get(foundChar)+" ");
                map.put(charToFind,dictSize++);
                foundChar = String.valueOf(c);
            }
        }
        if(!foundChar.isEmpty()){
            output.append(map.get(foundChar));
        }
        return output.toString();
    }
    public static String decode(String msg){
        int dictSize = 256;
        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            map.put(i,String.valueOf((char)i));
        }
        String[] sarr = msg.split(" ");
        String character = map.get(Integer.parseInt(sarr[0]));
        StringBuilder output = new StringBuilder(character);
        List<String> list = new ArrayList<>(Arrays.asList(sarr));
        list.remove(0);
        sarr = list.toArray(new String[0]);
        for (String code : sarr) {
            String entry = map.containsKey(Integer.parseInt(code))?
                            map.get(Integer.parseInt(code)): character+character.charAt(0);
            output.append(entry);
            map.put(dictSize++, character+entry.charAt(0));
            character = entry;
        }
return output.toString();

    }




    public static void main(String[] args) {
        String msg = "aabbab";
        String encoded = encode(msg);
        String decoded = decode(encoded);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}