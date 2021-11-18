package 캘린더;

public class Calendar {

	private static final int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int num) {
		return monthDay[num - 1];
	}

	public void printSampleCalendar(int month) {
		int monthDay = getMaxDaysOfMonth(month);
		System.out.println("         " +month + "월");
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
