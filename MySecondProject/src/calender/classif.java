package calender;

import java.util.Scanner;

public class classif {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		Date date2 = new Date();
		
		date.ShowDate();
		System.out.println("\n--------------------------------\n");

		date.AddDay(-20);
		date.ShowDate();
		date.AddDay(-395);
		date.ShowDate();
		date.AddDay(-40);
		date.ShowDate();
		
		System.out.println("\n--------------------------------\n");
		
		date2.AddDay(11);
		date2.ShowDate();
		date2.AddDay(395);
		date2.ShowDate();
		date2.AddDay(175);
		date2.ShowDate();
		
//		date.AddMonth(1);
//		date.ShowDate();
//		
//		date.AddYear(10);
//		date.ShowDate();
//		date.AddYear(-20);
//		date.ShowDate();
		
	}
	
}

class Date {
	int year;
	int month;
	int day;
	
	public Date() {
		this.year = 2023;
		this.month = 06;
		this.day = 20;
	}
	
	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// 1, 3, 5, 7, 8, 10, 12 = 31days
	// 4, 6, 9, 11 = 30 days
	// 2 = 29 days
	
	void AddDay(int num) {
		this.year += num / 365;
		num %= 365;
		
		if (num < 0) {		// 양수 계산
			while (num != 0) {
				num++;
				this.day--;

				if ((this.month == 5 || this.month == 7 || this.month == 9 || this.month == 12) && this.day < 1) {
					this.day = 30;
					this.month--;
				}
				else if ((this.month == 2 || this.month == 4 || this.month == 6 || this.month == 8 || this.month == 9 || this.month == 11) && this.day < 1) {
					this.day = 31;
					this.month--;
				}
				else if (this.month == 1 && this.day < 1) {
					this.day = 31;
					this.month = 12;
					this.year--;
				}
				else if (this.month == 3 && this.day < 1) {
					this.day = 29;
					this.month--;
				}
			}
		}
		else if (num > 0) {		// 음수 계산
			while (num != 0) {
				num--;
				this.day++;
				
				if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && this.day > 30) {
					this.day = 1;
					this.month++;
				}
				else if ((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) && this.day > 31) {
					this.day = 1;
					this.month++;
				}
				else if (this.month == 12 && this.day > 31) {
					this.day = 1;
					this.month = 1;
					this.year++;
				}
				else if (this.month == 2 && this.day > 29) {
					this.day = 1;
					this.month++;
				}
			}
		}
	}
	
//	void AddMonth(int num) {
//		int year = (this.month + num) / 12;
//		this.month = (this.month + num) % 12;
//		if (this.month == 2 && this.day > 29) {
//			this.day = 29;
//		}
//		else if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && this.day > 30) {
//			this.day = 30;
//		}
//		else if (this.month < 1) {
//			this.year += year;
//			this.month
//		}
//		else {
//			System.out.println("abnormal approach");
//		}
//	}
	
	void AddYear(int num) {
		this.year += num;
	}
	void ShowDate() {
		System.out.printf("\n현재 날짜는 %d년 %d월 %d일 입니다.\n", this.year, this.month, this.day);
	}
}