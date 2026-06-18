import java.util.*;

class Solution {
    public int minCandidate = 2;
    public List<Integer> list = new ArrayList<>();

    public String[] solution(String[] expressions) {
        int idx = 0;
        int[][] numArr = new int[expressions.length][3];
        StringBuilder sb = new StringBuilder();

        for (String expression : expressions) {
            int[] nums = new int[3];
            Arrays.fill(nums, -1);

            String[] split = expression.split(" ");
            int idx2 = 0;

            for (String s : split) {
                if (s.equals("+") || s.equals("-")) {
                    sb.append(s);
                } else if (s.equals("X")) {
                    continue;
                } else if (s.equals("=")) {
                    continue;
                } else {
                    int num = Integer.parseInt(s);
                    nums[idx2++] = num;

                    while (num > 0) {
                        minCandidate = Math.max(minCandidate, num % 10 + 1);
                        num /= 10;
                    }
                }
            }

            numArr[idx++] = nums;
        }

        String commands = sb.toString();

        for (int i = minCandidate; i <= 9; i++) {
            list.add(Integer.valueOf(i));
        }

        for (int i = 0; i < expressions.length; i++) {
            check(
                String.valueOf(numArr[i][0]),
                String.valueOf(numArr[i][1]),
                String.valueOf(numArr[i][2]),
                String.valueOf(commands.charAt(i))
            );
        }

        List<String> answer = new ArrayList<>();

        for (String expression : expressions) {
            String[] split = expression.split(" ");

            String a = split[0];
            String command = split[1];
            String b = split[2];
            String result = split[4];

            if (!result.equals("X")) {
                continue;
            }

            String firstResult = null;
            boolean isDiffrent = false;

            for (int n : list) {
                int numA = Integer.parseInt(a, n);
                int numB = Integer.parseInt(b, n);

                int calculated;

                if (command.equals("+")) {
                    calculated = numA + numB;
                } else {
                    calculated = numA - numB;
                }

                String converted = Integer.toString(calculated, n);

                if (firstResult == null) {
                    firstResult = converted;
                } else if (!firstResult.equals(converted)) {
                    isDiffrent = true;
                    break;
                }
            }

            if (isDiffrent) {
                answer.add(a + " " + command + " " + b + " = ?");
            } 
            
            else {
                answer.add(a + " " + command + " " + b + " = " + firstResult);
            }
        }
        
    
        return answer.toArray(new String[0]);
    }

    public void check(String a, String b, String result, String command) {
        for (int i = minCandidate; i <= 9; i++) {
            if (result.equals("-1")) {
                continue;
            }

            int parseResult = Integer.parseInt(result, i);
            int parseA = Integer.parseInt(a, i);
            int parseB = Integer.parseInt(b, i);

            if (command.equals("+")) {
                if ((parseA + parseB) != parseResult) {
                    list.remove(Integer.valueOf(i));
                }
            } else {
                if (parseA - parseB != parseResult) {
                    list.remove(Integer.valueOf(i));
                }
            }
        }
    }
}