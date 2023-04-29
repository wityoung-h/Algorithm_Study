import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue heap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }
        
        while((int) heap.peek() < K) {
            if(heap.size() < 2) {
                answer = -1;
                break;
            }
            
            heap.add((int) heap.poll() + 2 * (int) heap.poll());
            answer++;
        }
        
        return answer;
    }
}