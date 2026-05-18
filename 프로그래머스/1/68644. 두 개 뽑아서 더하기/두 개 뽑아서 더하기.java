import java.util.*;

// class Solution {
//     public int[] solution(int[] numbers) {
        
        
//         ArrayList<Integer> array = new ArrayList<>();
        
//         for(int i=0; i<numbers.length - 1; i++) {
//             for(int j=1; j<numbers.length; j++) {
//                 if(i == j) continue;
//                 array.add(numbers[i] + numbers[j]);
//             }
//         }
        
//         int[] answer = array.stream()
//             .sorted()
//             .distinct()
//             .mapToInt(a -> a.intValue())
//             .toArray();
        
//         return answer;
//     }
// }

class Solution {
    public int[] solution(int[] numbers) {
        
        
        Set<Integer> set = new TreeSet<>();
        
        for(int i=0; i<numbers.length - 1; i++) {
            for(int j=i + 1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = set.stream()
            .mapToInt(a -> a.intValue())
            .toArray();
        
        return answer;
    }
}