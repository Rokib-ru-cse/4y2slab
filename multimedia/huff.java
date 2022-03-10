import java.util.*;

/**
 * huff
 */
class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    char data;
    HuffmanNode left, right;

    public int compareTo(HuffmanNode node) {
        return frequency - node.frequency;
    }
}

public class huff {
    static HuffmanNode root;
    private static Map<Character, String> charPrefixCodes = new HashMap<>();

    public static void setPrefixCodes(HuffmanNode node,StringBuilder prefix){
        if(node!=null){
            if(node.left==null&&node.right==null){
                charPrefixCodes.put(node.data,prefix.toString());
            }else{
                prefix.append('0');
                setPrefixCodes(node.left, prefix);
                prefix.deleteCharAt(prefix.length()-1);

                prefix.append('1');
                setPrefixCodes(node.right, prefix);
                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }

    public static HuffmanNode buildTree(Map<Character, Integer> frequency) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        Set<Character> ketSet = frequency.keySet();
        for (Character key : ketSet) {
            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.data = key;
            huffmanNode.frequency = frequency.get(key);
            huffmanNode.left = null;
            huffmanNode.right = null;
            priorityQueue.offer(huffmanNode);
        }
        assert priorityQueue.size() > 0;
        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.peek();
            priorityQueue.poll();
            HuffmanNode y = priorityQueue.peek();
            priorityQueue.poll();
            HuffmanNode sum = new HuffmanNode();
            sum.frequency = x.frequency + y.frequency;
            sum.data = '-';
            sum.left = x;
            sum.right = y;
            priorityQueue.offer(sum);
        }
        return priorityQueue.poll();
    }

    public static String encode(String msg) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character character : msg.toCharArray()) {
            if (!frequency.containsKey(character)) {
                frequency.put(character, 0);
            }
            frequency.put(character, frequency.get(character) + 1);
        }
        System.out.println("char frequency map = " + frequency);
        root = buildTree(frequency);
        setPrefixCodes(root,new StringBuilder());
        System.out.println("char prefix codes = "+charPrefixCodes);
        StringBuilder output = new StringBuilder();
        for(char c : msg.toCharArray()) {
            output.append(charPrefixCodes.get(c));
        }
        return output.toString();
    }

    public static String decode(String s){
        StringBuilder sb = new StringBuilder();
        HuffmanNode temp = root;
        System.out.println("encoded = "+s);
        for (char c:s.toCharArray()) {
            int j = Integer.parseInt(String.valueOf(c));
            if(j==0){
                temp = temp.left;
                if(temp.left==null&&temp.right==null){
                    sb.append(temp.data);
                    temp = root;
                }
            }
            if(j==1){
                temp = temp.right;
                if(temp.left==null&&temp.right==null){
                    sb.append(temp.data);
                    temp = root;
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String msg = "ABCD1%$^";
        System.out.println("original text" + msg);
        String encoded = encode(msg);
        String decoded = decode(encoded);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}