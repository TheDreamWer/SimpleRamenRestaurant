package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The class to operate system time
 *
 */
public class SystemTime implements Serializable {

	private static final long serialVersionUID = 1L;

	private long timeGap = 0L;

	/**
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public long diffDate(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime());

	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public long diffDate(Date date) {
		return (getDate().getTime() - date.getTime());

	}

	/**
	 * 
	 * @param ms
	 * @return
	 */
	public String msToString(long ms) {
		long second = ms / 1000;
		long hours = second / 3600;
		second = second % 3600;
		long minutes = second / 60;
		second = second % 60;

		return hours + ": " + minutes + ": " + second;
	}

	/**
	 * 
	 * @param second
	 * @return
	 */
	public String secondToString(long second) {
		long hours = second / 3600;
		second = second % 3600;
		long minutes = second / 60;
		second = second % 60;

		return hours + " hours " + minutes + " minutes " + second + " seconds ";
	}

	/**
	 * 
	 * @return
	 */
	public Date getDate() {
		Date date = new Date();
		date.setTime(date.getTime() + timeGap * 1000);
		return date;

	}

	/**
	 * 
	 * @param timeGap
	 */
	public void setTimeGap(long timeGap) {
		this.timeGap = timeGap;
	}

	/**
	 * 
	 * @return
	 */
	public long getTimeGap() {
		return timeGap;
	}

	/**
	 * 
	 * @return
	 */
	public String getDateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(getDate());
	}
}
