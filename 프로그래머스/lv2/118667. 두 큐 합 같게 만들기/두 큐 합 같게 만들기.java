class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        long sum1 = 0;
        long sum2 = 0;
        int len = queue1.length;
        
        for(int i = 0; i < len; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if(sum1 == sum2) // 두 큐의 합이 같으면 return 0
            return answer = 0;
        
        long sum = sum1 + sum2;
        
        if(sum % 2 == 1) // 전체 합이 홀수이면 각 큐 합을 같게 만들 수 없음
            return answer = -1;
        
        long div = sum / 2;
        
        // 큐 특성 상(FIFO) 수의 순서는 바뀌지 않음. 배열을 어떻게 끊어 절반에 해당하는 값을 구할지의 문제
        // ex) [3, 2, 7, 2] [4, 6, 5, 1]의 큐는 >> [3, 2, 7, 2, 4, 6, 5, 1] 순서를 벗어나지 않음
        // 즉, 초기 큐의 합에서 크기에 따라 원소 하나씩을 넣고, 빼며 최솟값을 구할 수 있음
        // 모든 원소를 돌아 자신의 위치로 돌아온 경우 큐의 합이 같게 나눌 수 있는 방법이 없음을 의미
        
        int cnt = 0; 
        
        for(int i = 0; i < len * 2;) { // i : queue1의 head를 탐색할 index
            for(int j = 0; j < len * 2;) { // j : queue2의 head를 탐색할 index
                if(sum1 > div) {
                    // temp의 합이 div보다 클 때? queue1 head를 pop
                    if(i < len) 
                        sum1 -= queue1[i]; 
                    else
                        sum1 -= queue2[i % len];
                    i++;
                    cnt++;
                } else if(sum1 < div) {
                    // temp의 합이 div보다 작을 때? queue2 head pop > queue1 insert
                    if(j < len)
                        sum1 += queue2[j];
                    else
                        sum1 += queue1[j % len];
                    j++;
                    cnt++;
                }
                
                // 각 큐의 합이 동일하면 cnt return
                if(sum1 == div) {
                    return answer = cnt;
                } 
                
            }
        }
        
        // for문 종료 : 전체 큐 탐색했지만 동일하게 나눌 수 없는 경우
        return answer = -1;
    }
}