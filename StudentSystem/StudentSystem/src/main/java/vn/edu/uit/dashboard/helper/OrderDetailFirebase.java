package vn.edu.uit.dashboard.helper;

import java.util.Calendar;
import java.util.Date;

public class OrderDetailFirebase {
	private int quantity;
	private int status;
	private long timetick;
	
	public OrderDetailFirebase(int quantity, int status) {
		this.quantity = 	quantity;
		this.status = status;
		this.setTimetick();
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the timetick
	 */
	public long getTimetick() {
		return timetick;
	}

	/**
	 * @param timetick the timetick to set
	 */
	public void setTimetick(long timetick) {
        this.timetick = timetick;
	}
	
	public void setTimetick() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
        this.timetick = calendar.getTimeInMillis();
	}
}