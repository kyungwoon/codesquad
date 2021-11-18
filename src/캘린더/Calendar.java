package 캘린더;

public class Calendar {

	private static final int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEEPmonthDay = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeepYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int num) {
		if (isLeepYear(year)) {
			return LEEPmonthDay[num - 1];
		} else {
			return monthDay[num - 1];
		}
	}

	public void printSampleCalendar(int year, int month) {
		int monthDay = getMaxDaysOfMonth(year,month);
		System.out.println("      " + year + "년 " + month + "월");
		System.out.println("  일 월  화  수 목  금 토");
		System.out.println("---------------------");
		for (int i = 1; i <= monthDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}
}
