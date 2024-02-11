package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class tictactoe {
	
	public static void main (String[] args) {
		
		/** Tic Tac Toe 미니 게임 코드
		 * 생략한 예외처리 목록 :
		 * 		숫자 입력시 보드 판보다 작거나 큰 수를 입력 하는 경우
		 * 		이미 마킹한 인덱스에 덮어쓰는 하는 경우
		 * @author Kim
		 */
		
		Scanner scan = new Scanner(System.in);
		
		char[][] board = new char[3][3];
		char who = ' ';
		int row = 0, col = 0, i = 0, cnt_x = 0, cnt_y = 0, cnt_zl = 0, cnt_zr = 0, axis = 0;
		
		System.out.println("Tic Tac Toe Game Starts!\n\n");
		
		while (i++ <= 9) {
			// 보드 그래픽 그려주는 반복문
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.printf("%c ", board[j][k]);
					if (k == 2 && j != 2) {
						System.out.printf("\n--------\n");
					}
					else if (k != 2) {
						System.out.printf("| ");
					}
					else {
						System.out.println();
						System.out.println();
					}
				}	
			}
			
			// 승리 후 탈출 조건문
			if (cnt_x == 3 || cnt_y == 3 || cnt_zl == 3 || cnt_zr == 3) {
				System.out.println("\n----------\n" + who + " Wins!" + "\n----------");
				break;
			}
			
			
			// O, X 입력하는 조건문
			who = i % 2 != 0 ? (char)'O' : (char)'X';
			
			System.out.println("▼ Row & Col of \"" + who + "\" ▼");
			row = scan.nextInt();
			col = scan.nextInt();
			board[row][col] = who;
			
			System.out.println();
			
			// 승리 조건 비교 조건문
			// 가로
			for (int x = 0; x < 3; x++) {
				if (board[row][x] == who) {
					cnt_x++;
				}
			}
			// 세로
			for (int y = 0; y < 3; y++) {
				if (board[y][row] == who) {
					cnt_y++;
				}
			}
			// 대각선 좌측
			for (; axis < 3; axis++) {
				if (board[axis][axis] == who) {
					cnt_zl++;
				}
			}
			// 대각선 우측
			for (int zr = 0; zr < 3; zr++) {
				if (board[zr][--axis] == who) {
					cnt_zr++;
				}
			}
			// 승리 조건 미충족시 카운트 초기화
			if (cnt_x != 3 && cnt_y != 3 && cnt_zl != 3 && cnt_zr != 3) {
				cnt_x = 0;
				cnt_y = 0;
				cnt_zl = 0;
				cnt_zr = 0;
			}
			
			// 무승부 출력 조건문
			if (i > 8) {
				System.out.println("\n-------------\nDraw\n-------------");
				break;
			}
		}
		
	}
}