import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr_str = br.readLine().split(" ");
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(arr_str[i]);
		}
		
		ArrayList<Integer> longest = new ArrayList<Integer>();
		longest.add(arr[0]);
		
		for(int i = 1; i < N; i++) {
			int index = binarySearch(arr[i], longest, 0, longest.size());
			
			if(longest.size() <= index) {
				longest.add(arr[i]);
			} else {
				longest.set(index, arr[i]);
			}
		}
		
		System.out.print(longest.size());
		
		br.close();
	}
	
	// 동일한 값을 탐색하는 것이 아닌, 나보다 작은 최대값의 위치를 찾아야 함
	public static int binarySearch(int target, ArrayList<Integer> arr, int head, int tail) {
		if(target > (int) arr.get(tail - 1)) { // arr의 최대값이 나보다 큰 경우
			return tail; // 마지막 인덱스 + 1 값 반환
		}
		
		if(tail - head == 1) { //더 이상 탐색해야할 값이 없다면
			if((int) arr.get(tail - 1) >= target) 
				return head;
			else
				return tail;
		}
		
		int mid = (head + tail) / 2;
		
		if((int) arr.get(mid) == target) {
			return mid;
		} else if((int) arr.get(mid) > target){
			return binarySearch(target, arr, head, mid);
		} else {
			return binarySearch(target, arr, mid, tail);
		}
	}
}