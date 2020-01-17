package hh;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
 
//哈夫曼树 演示
public class Huffman {
 
    private ConcurrentHashMap<Character, String> codeTabe = new ConcurrentHashMap<>();
    private Node root;
    //创建编码表 通常是对一次数据编码时要生成这个表，然后解编时再通过这个表来解码
    public void createCodeTable(String str) {
        //统计每个字符出现的次数并排序
        TreeSet<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int cmp = o1.frequency - o2.frequency;
                return cmp == 0 ? -1 : cmp;
            }
        });
 
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int count = 0;
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
 
        //排序
        for (char key : hashMap.keySet()) {
            treeSet.add(new Node(key, hashMap.get(key)));
        }
 
        //开始创建哈夫曼树
        Node firstNode = treeSet.pollFirst();
        Node secondNode;
        Node newNode;
        while ((secondNode = treeSet.pollFirst()) != null) { //一个个移除，不为空时
            newNode = new Node(' ', firstNode.frequency + secondNode.frequency);
            newNode.leftNode = firstNode;
            newNode.rightNode = secondNode;
            treeSet.add(newNode);
            firstNode = treeSet.pollFirst();
        }
 
        root= firstNode;// 记录好树的根节点
 
        //通过遍历树去创建一个字符对应的字典，方便编码时直接取码
        bianli1(firstNode, new StringBuilder(100));
    }
 
    //遍历哈夫曼树
    private void bianli1(Node node,StringBuilder sb) {
        if (node != null) {
            if (node.leftNode == null) { //实际上这个时候左右子节点都为空了
                codeTabe.put(node.aChar, sb.toString());
                return;
            } else {
                sb.append('0');
                bianli1(node.leftNode, sb);
                //移除当前这个结点的后加的编码
                sb.setLength(sb.length() - 1);
                sb.append('1');
                bianli1(node.rightNode, sb);
                //移除当前这个结点的后加的编码
                sb.setLength(sb.length() - 1);
            }
        }
 
 
    }
 
    public String enCode(String str) throws Exception {
        StringBuilder sb = new StringBuilder(100);
        String hafumanCode;
        for (int i = 0; i < str.length(); i++) {
            if (!codeTabe.containsKey(str.charAt(i))) {
                throw new Exception("can not find the coding of the char:" + str.charAt(i));
            }
 
            sb.append(codeTabe.get(str.charAt(i))+",");
        }
 
        return sb.toString();
    }
 
    //解码
    public String deCode(String hafuman) throws Exception {
        StringBuilder sb = new StringBuilder(100);
        Node firstNode = this.root;
        if(firstNode.leftNode==null || firstNode.rightNode==null){
            return String.valueOf(firstNode.aChar);
        }
        for(int i=0;i<hafuman.length();i++){
            if(hafuman.charAt(i)=='0'){
                firstNode = firstNode.leftNode;
            }
            else if(hafuman.charAt(i)=='1'){
                firstNode = firstNode.rightNode;
            }
            else{
              //  throw  new Exception("checked the invalidate char, must be '1' or '0' !");
                continue;
            }
 
            if(firstNode.leftNode==null){ //找到了原始编码
                sb.append(firstNode.aChar);
                //找到后一次搜索应该继续从根开始
                firstNode = this.root;
            }
        }
 
        return sb.toString();
    }
}
