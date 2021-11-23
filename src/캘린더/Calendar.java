package 캘린더;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] monthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEEPmonthDay = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String SAVE_FILE = "calendar.dat";
	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		
		File f = new File(SAVE_FILE);
		if(!f.exists()) {
			return;
		}
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				String date = sc.next();
				String detail = sc.next();
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param date ex : "2021-11-01"
	 * @param plan
	 * @throws ParseException
	 */
	public void registerPlan(String strDate, String plan)  {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}

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
		final int standardWeek = 4; // 1970 / Jan / 1st = Thursday

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
