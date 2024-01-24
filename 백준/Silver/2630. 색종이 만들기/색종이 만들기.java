import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < N; j++) {
                arr[i][j] = (Integer.parseInt(temp[j]) == 1)? 1 : -1;
            }
        }

        int length = 2;

        int blue = 0;
        int white = 0;

        while(length <= N) {
            for(int i = 0; i < N; i += length) {
                for(int j = 0; j < N; j += length) {
                    if(!isSameColor(arr, i, j, length)) {
                        int[] bw = cntPaper(arr, i, j, length);
                        blue += bw[0];
                        white += bw[1];
                    }
                }
            }
            length *= 2;
        }

        if(Math.abs(arr[0][0]) == N) {
            if(arr[0][0] > 0) {
                blue++;
            } else {
                white++;
            }
        }

        System.out.print(white + "\n" + blue);

    }

    // arr[startX][startY]를 기준으로 length 만큼의 블럭이 같은 색상인지 확인하는 함수
    // 같은 색상으로 칠해져 있다면, 정사각형의 좌측 상단 첫번째 블럭의 값을 * 2
    public static boolean isSameColor(int[][] arr, int startX, int startY, int length) {
        int color = arr[startX][startY];

        for(int i = 0; i < length; i += length/2) {
            for(int j = 0; j < length; j += length/2) {
                if(color != arr[i + startX][j + startY]) {
                    return false;
                }
            }
        }

        arr[startX][startY] = color * 2;
        return true;
    }

    public static int[] cntPaper(int[][] arr, int startX, int startY, int length) {
        int[] bw = new int[2];

        for(int i = 0; i < length; i += length/2) {
            for(int j = 0; j < length; j += length/2) {
                if(Math.abs(arr[startX + i][startY + j]) != length/2) {
                    continue;
                }

                if(arr[startX + i][startY + j] > 0) {
                    bw[0]++;
                } else {
                    bw[1]++;
                }
            }
        }

        return bw;
    }
}