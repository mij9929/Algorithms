import java.util.ArrayList;

class Solution {
    private final String[] TYPES = {"+", "-", "*" };
    private int[] orders;
    private long answer;

    private ArrayList<Long> numbersOrigin;
    private ArrayList<String> operatorsOrigin;

    public long solution(String expression) {
        this.answer = 0;
        orders = new int[] {-1, -1, -1};
        int len = expression.length();
        numbersOrigin = new ArrayList<>();
        operatorsOrigin = new ArrayList<>();

        StringBuilder numbersBuilder = new StringBuilder();
        for(int i=0; i<len; i++){
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                numbersOrigin.add(Long.parseLong(numbersBuilder.toString()));
                numbersBuilder = new StringBuilder();
                operatorsOrigin.add(String.valueOf(ch));
            } else {
                numbersBuilder.append(ch);
            }
        }

        numbersOrigin.add(Long.parseLong(numbersBuilder.toString()));

        dfs(0);

        return answer;
    }

    private void dfs(int depth) {
        if(depth == 3) {
            long value = calculate();
            answer = Math.max(answer, value);
            return;
        }
        for(int i=0; i < orders.length; i++) {
            if(orders[i] == -1){
                orders[i] = depth;
                dfs(depth+1);
                orders[i] = -1;
            }
        }
    }

    private long calculate() {
        ArrayList<Long> numbers = new ArrayList<>(numbersOrigin);
        ArrayList<String> operators = new ArrayList<>(operatorsOrigin);
        
        for(int i=0; i<orders.length; i++) {
            int idx = orders[i];
            String operator = TYPES[idx];
            for(int j=0; j<operators.size(); j++) {
                if(operators.get(j).equals(operator)) {
                    long result = calculate2(numbers.get(j), numbers.get(j+1), operator);
                    numbers.set(j, result);
                    numbers.remove(j+1);
                    operators.remove(j);
                    j--;
                }
            }
        }

        return Math.abs(numbers.get(0));
    }

    private long calculate2(long a, long b, String op) {
        if(op.equals("+")) return a+b;
        if(op.equals("-")) return a-b;
        else return a*b;
    }
}