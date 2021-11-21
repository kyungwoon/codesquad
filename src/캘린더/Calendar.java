package 캘린더;

public class Calendar {

	private static final int[] monthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEEPmonthDay = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeepYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int num) {
		if (isLeepYear(year)) {
			return LEEPmonthDay[num];
		} else {
			return monthDay[num];
		}
	}

	public void printSampleCalendar(int year, int month) {
		System.out.println("      " + year + "년 " + month + "월");
		System.out.println("  일 월  화  수 목  금 토");
		System.out.println("---------------------");

		// get week automatically
		int week = getweek(year, month, 1);

		for (int i = 0; i < week; i++) {
			System.out.print("   ");
		}

		// print first line
		int monthDay = getMaxDaysOfMonth(year, month);
		int count = 7 - week;
		int secondLine = count;
		if (count < 7) {
			secondLine = count;
		} else {
			secondLine = 0;
		}

		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		count++;
		// print second line to last
		for (int i = count; i <= monthDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == secondLine) {
				System.out.println();
			}
		}
	}

	private int getweek(int year, int month, int day) {
		int syear = 1970;
		final int standardWeek = 3; // 1970 / Jan / 1st = Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta;
			if (isLeepYear(i)) {
				delta = 366;
				count += delta;
			} else {
				delta = 365;
				count += delta;
			}
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;

		}

		count += day;

		int week = (count + standardWeek) % 7;

		return week;
	}
}
