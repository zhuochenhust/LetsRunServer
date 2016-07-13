package com.tarena.util;

/*
 * Created on 2006-2-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author smlzhang
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class PageStatus {

	public PageStatus() {
	}

	/**
	 * �����ʼ����������Сʱ,ͨ�� �����˵����Ʒֱ�Ϊ StartYear,StartMonth,StartDay,StartHour
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return html�ַ���
	 * @throws Exception
	 */
	public static String getStartYearMonthDayHourHtml(
			HttpServletRequest request, String yearSessionName,
			String MonthSessionName, String DaySessionName,
			String HourSessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautStartDate = Tools.getDefaultStartDate();

		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = defautStartDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='StartYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautStartDate[1];
		}
		sb.append("<select name='StartMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			select = defautStartDate[2];
		}
		sb.append("<select name='StartDay'>");
		for (int day = 1; day <= 31; day++) {
			if (day == select) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(HourSessionName)));
		} catch (Exception e) {
			select = 0;
		}
		sb.append("&nbsp;<select name='StartHour'>");
		for (int hour = 0; hour <= 23; hour++) {
			if (hour == select) {
				sb.append("<option selected value=" + hour + ">" + hour
						+ "</option>");
			} else {
				sb.append("<option value=" + hour + ">" + hour + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}

	/**
	 * �����������������Сʱ,ͨ�� �����˵����Ʒֱ�Ϊ EndYear,EndMonth,EndDay,EndHour
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return
	 * @throws Exception
	 */
	public static String getEndYearMonthDayHourHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName,
			String DaySessionName, String HourSessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautEndDate = Tools.getDefaultEndDate();
		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = defautEndDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='EndYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautEndDate[1];
		}
		sb.append("<select name='EndMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			select = defautEndDate[2];
		}
		sb.append("<select name='EndDay'>");
		for (int day = 1; day <= 31; day++) {
			if (day == select) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(HourSessionName)));
		} catch (Exception e) {
			select = 23;
		}
		sb.append("&nbsp;<select name='EndHour'>");
		for (int hour = 0; hour <= 23; hour++) {
			if (hour == select) {
				sb.append("<option selected value=" + hour + ">" + hour
						+ "</option>");
			} else {
				sb.append("<option value=" + hour + ">" + hour + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}

	/**
	 * �����ǰ����,ͨ�� �����˵����Ʒֱ�Ϊ StartYear,StartMonth
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @return html�ַ���
	 * @throws Exception
	 */
	public static String getNowYearMonthHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautStartDate = Tools.getNowDateArr();

		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = defautStartDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='StartYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautStartDate[1];
		}
		sb.append("<select name='StartMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		return new String(sb.toString().getBytes("GB2312"));
	}
	
	/**
	 * �����ʼ����������,ͨ�� �����˵����Ʒֱ�Ϊ StartYear,StartMonth,StartDay
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return html�ַ���
	 * @throws Exception
	 */
	public static String getStartYear2006MonthDayHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName,
			String DaySessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautStartDate = Tools.getDefaultStartDate();

		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = 2006;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='StartYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautStartDate[1];
		}
		sb.append("<select name='StartMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			select = defautStartDate[2];
		}
		sb.append("<select name='StartDay'>");
		for (int day = 1; day <= 31; day++) {
			if (day == select) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}



	/**
	 * �����ʼ����������,ͨ�� �����˵����Ʒֱ�Ϊ StartYear,StartMonth,StartDay
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return html�ַ���
	 * @throws Exception
	 */
	public static String getStartYearMonthDayHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName,
			String DaySessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautStartDate = Tools.getDefaultStartDate();

		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = defautStartDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='StartYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautStartDate[1];
		}
		sb.append("<select name='StartMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			select = defautStartDate[2];
		}
		sb.append("<select name='StartDay'>");
		for (int day = 1; day <= 31; day++) {
			if (day == select) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}

	/**
	 * �����������������,ͨ�� �����˵����Ʒֱ�Ϊ EndYear,EndMonth,EndDay
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return
	 * @throws Exception
	 */
	public static String getEndAptYearMonthDayHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName,
			String DaySessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautEndDate = Tools.getDefaultEndDate();
		int selectDay = 0;
		int selectYear = 0, selectMonth = 0;
		try {
			selectYear = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			selectYear = defautEndDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='EndYear' onChange='form1.submit();'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == selectYear) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			selectMonth = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			selectMonth = defautEndDate[1];
		}
		sb.append("<select name='EndMonth' onChange='form1.submit();'>");
		for (int month = 1; month <= 12; month++) {
			if (month == selectMonth) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			selectDay = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			selectDay = defautEndDate[2];
		}
		if (!Tools.isNull(request.getParameter("EndYear"))) {
			selectYear = Integer.parseInt(request.getParameter("EndYear"));
		}
		if (!Tools.isNull(request.getParameter("EndMonth"))) {
			selectMonth = Integer.parseInt(request.getParameter("EndMonth"));
		}
		int lastDay = Tools.getLastDayInt(selectYear, selectMonth);
		sb.append("<select name='EndDay'>");
		for (int day = 1; day <= lastDay; day++) {
			if (day == selectDay) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}
	/**
	 * �����������������,ͨ�� �����˵����Ʒֱ�Ϊ EndYear,EndMonth,EndDay
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return
	 * @throws Exception
	 */
	public static String getYesterdayYearMonthDayHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName,
			String DaySessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautEndDate = Tools.getYesterDayDateArr();
		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = defautEndDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='EndYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautEndDate[1];
		}
		sb.append("<select name='EndMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			select = defautEndDate[2];
		}
		sb.append("<select name='EndDay'>");
		for (int day = 1; day <= 31; day++) {
			if (day == select) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}


	/**
	 * �����������������,ͨ�� �����˵����Ʒֱ�Ϊ EndYear,EndMonth,EndDay
	 * 
	 * @param request
	 * @param yearSessionName
	 * @param MonthSessionName
	 * @param DaySessionName
	 * @return
	 * @throws Exception
	 */
	public static String getEndYearMonthDayHtml(HttpServletRequest request,
			String yearSessionName, String MonthSessionName,
			String DaySessionName) throws Exception {
		HttpSession session = request.getSession(true);
		int[] defautEndDate = Tools.getDefaultEndDate();
		int select = 0;
		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(yearSessionName)));
		} catch (Exception e) {
			select = defautEndDate[0];
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<select name='EndYear'>");
		for (int year = 2004; year <= 2016; year++) {
			if (year == select) {
				sb.append("<option selected value=" + year + ">" + year
						+ "</option>");
			} else {
				sb.append("<option value=" + year + ">" + year + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(MonthSessionName)));
		} catch (Exception e) {
			select = defautEndDate[1];
		}
		sb.append("<select name='EndMonth'>");
		for (int month = 1; month <= 12; month++) {
			if (month == select) {
				sb.append("<option selected value=" + month + ">" + month
						+ "</option>");
			} else {
				sb.append("<option value=" + month + ">" + month + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");

		try {
			select = Integer.parseInt(String.valueOf(session
					.getAttribute(DaySessionName)));
		} catch (Exception e) {
			select = defautEndDate[2];
		}
		sb.append("<select name='EndDay'>");
		for (int day = 1; day <= 31; day++) {
			if (day == select) {
				sb.append("<option selected value=" + day + ">" + day
						+ "</option>");
			} else {
				sb.append("<option value=" + day + ">" + day + "</option>");
			}
		}
		sb.append("</select>");
		sb.append("��");
		return new String(sb.toString().getBytes("GB2312"));
	}

	/**
	 * �����ܵ���ֵ����session��
	 * 
	 * @param request
	 * @param input
	 *            ���ؼ�������
	 * @param var
	 *            ���ֵ�ı���
	 * @param sessionname
	 * @return
	 */
	public static String setSession(HttpServletRequest request, String input,
			String var, String sessionname) {
		var = request.getParameter(input);
		HttpSession session = request.getSession(true);
		if (!Tools.isNull(var)) {
			session.setAttribute(sessionname, var);
		} else {
			var = String.valueOf(session.getAttribute(sessionname));
		}
		return var;
	}

	public static void main(String[] args) {
	}
}
