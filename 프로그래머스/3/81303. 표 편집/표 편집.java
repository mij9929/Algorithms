import java.util.*;

class Node {
    public Node prev;
    public Node next;
    public int idx;
    
    public Node(int idx) {
        this.idx = idx;
    }
    
    @Override
    public String toString() {
        return ""+idx;
    }
}

class Solution {
    public static Node[] nodes;
    public static Deque<Node> trash;
    public static Node current;
    public static char[] ans;
    
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        nodes = new Node[n]; // 넣을 리스트
        trash = new ArrayDeque<>(); //휴지통 
        ans = new char[n];
        Arrays.fill(ans, 'O');
        
        for(int i=0; i<n; i++){
            nodes[i] = new Node(i);
        }
        
        for(int i=0; i<n; i++) {
            if(i != 0) nodes[i].prev = nodes[i-1];
            if(i != n-1) nodes[i].next = nodes[i+1];
        }
    
        current = nodes[k];
        
        for(String s : cmd) {
            command(s);
        }
        
        return new String(ans);
    }
    
    public void command(String cmd) {
        String[] split = cmd.split(" ");
        if(split[0].equals("U") || split[0].equals("D")) {
            int m = Integer.parseInt(split[1]);
            if(split[0].equals("U"))
                move(m, -1);
            else
                move(m, 1);
        }
        
        else if(split[0].equals("C")) {
            Node push = current;
            
            Node prev = current.prev;
            Node next = current.next;
            if(prev != null) prev.next = next;
            if(next != null) next.prev = prev;
            
            trash.push(push);
            ans[current.idx] = 'X';
            
            if(current.next != null) current = current.next;
            else current = current.prev;

        }
        
        else if(split[0].equals("Z")) {
            Node backup = trash.pop();
            Node prev = backup.prev;
            Node next = backup.next;
            ans[backup.idx] = 'O';
            
            if(prev != null) prev.next = backup;
            if(next != null) next.prev = backup;
        }
    }
    
    public void move(int move, int direction) {
        if(direction == -1){
            for(int i=0; i<move; i++) {
                current = current.prev;
            }
        } else {
                for(int i=0; i<move; i++) {
                current = current.next;
            }
        }
    }
}