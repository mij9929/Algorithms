import java.util.*;

class Node {
    public int x;
    public int y;
    public int num;
    public Node left;
    public Node right;
    
    public Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
    
    public String toString(){
        return "x = " + x + ", y = " + y + ", num = " + num + "\n";
    }
}

class Solution {
    public ArrayList<Integer> preList;
    public ArrayList<Integer> postList;
    
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        int[][] answer = new int[2][len];
        preList = new ArrayList<>();
        postList = new ArrayList<>();
        
        Node[] nodes = new Node[len];
        for(int i=0; i<len; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        // 자식들을 어떻게?
        // 일단 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y) return Integer.compare(o1.x, o2.x); // x좌표는 더 작은 숫자
            else return Integer.compare(o2.y, o1.y); // y값은 더 큰 숫자
        });
        
        for(int i=1; i<len; i++) {
            Node parent = nodes[0];
            Node current = nodes[i];
            determinePosition(parent, current);
        }
        
        preOrder(nodes[0]);
        postOrder(nodes[0]);
        answer[0] = preList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postList.stream().mapToInt(Integer::intValue).toArray();
            
        return answer;
    }
    
    private void determinePosition(Node parent, Node child){
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else determinePosition(parent.left, child);
        }
        else {
            if(parent.right == null) parent.right = child;
            else determinePosition(parent.right, child);
        }
        return;
    } 
    
    private void preOrder(Node node) {
        if(node == null) return;
        preList.add(node.num);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    private void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postList.add(node.num);
    }
}