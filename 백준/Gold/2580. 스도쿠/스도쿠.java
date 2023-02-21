import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.StringBuilder;


public class Main {
	public static ArrayList zero = new ArrayList<int[]>();
	// 0이 나온 위치의 인덱스를 저장할 ArrayList
	public static int[][] board = new int[9][9];
	public static int[] array;
	public static int count = 0; // 0이 나온 칸의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				// 칸의 값이 0이라면 그 인덱스를 zero에 저장
				if (board[i][j] == 0) {
					int[] temp = new int[2];
					temp[0] = i; temp[1] = j;
					zero.add(temp);
				}
			}
		}
		// dfs로 탐색해야할 깊이를 결정할 변수
		count = zero.size();
		array = new int[count];
		
		dfs(0);
		
		// 출력하기
		StringBuilder sb = new StringBuilder();
		int depth = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == 0) 
					sb.append(array[depth++] + " ");
				else 
					sb.append(board[i][j] + " ");	
				
				
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
	public static void dfs(int depth) {
		// 0을 다 채우면 탐색 끝
		// = zero list의 원소 수 만큼 깊이에 도달하면 0을 모두 채운 것
		if(depth == count) {
			return;
		}
		
		// zero에 0번째 원소부터 차례로 값을 꺼내옴
		int[] index = (int[]) zero.get(depth);
			
		for(int i = 1; i <= 9; i++) {
			// 숫자는 1~9까지 올 수 있다
			if(check(index[0], index[1], i)) {
				// 해당 칸에 check함수를 통해 i값이 가능한지 확인
				// 가능하다면 해당 값을 고정하고 depth + 1 탐색
				board[index[0]][index[1]] = i;
				array[depth] = i;
				dfs(depth + 1);
				board[index[0]][index[1]] = 0;
				
				// 만약 모든 값이 채워졌다면 (값을 저장하는 array 배열이 모두 찼다면 탐색을 멈춤)
				// 정답이 여러개인 경우 모든 정답을 탐색할 수 있음(time over)
				if(array[count - 1] != 0) {
					return;
				}
			}
		}
	}
	
	// board[row][col]에 n이 위치할 수 있는지 확인하는 함수
	public static boolean check(int row, int col, int n) {
		for(int i = 0; i < 9; i++) {
			// baord[row][col]과 동일한 행-열에 숫자 n이 존재하는지 체크
			if(board[row][i] == n || board[i][col] == n)
				return false;
		}
		
		// board[row][col]이 존재하는 사각형 내부에 숫자 n이 존재하는지 체크
		// 사각형의 시작행/열 인덱스? 각 값을 3으로 나눈 몫에 다시 3을 곱하여 얻을 수 있음
		int sqRow = (row / 3) * 3 ; int sqCol = (col / 3) * 3;
		
		for(int i = sqRow; i < sqRow + 3; i++) {
			for(int j = sqCol; j < sqCol + 3; j++) {
				if(board[i][j] == n)
					return false;
			}
		}
		
		return true;
	}
}