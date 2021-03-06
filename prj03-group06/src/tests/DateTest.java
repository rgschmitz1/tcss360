package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.EventQueue;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weather.WeatherController;
import weather.WeatherGUI;
import weather.WeatherStation;

/**
 * Runs tests on the date panel
 */
public class DateTest {
	WeatherGUI gui;
	WeatherStation station;
	WeatherController controller;
	
        /**
	 * Set up the program for test
	 */
	@BeforeEach
	public void setUp() {
		gui = new WeatherGUI();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.start();
            }
        });
        station = new WeatherStation(true);
        controller = new WeatherController(station, gui);
        
        Thread thread = new Thread(controller);
        thread.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test to get the day of the week
	 */
	@Test
	public void testDayOfWeek() {
		String date = gui.getDate();
		String day = date.substring(6, 9);
		Date currentDate = new Date();
		String today = currentDate.toString();
		String currentDay = today.substring(0, 3);
		if (day.equals(currentDay)) {
			assertTrue(true);
		} else {
			fail("Days of the week don't match");
		}
	}
	
	/**
	 * Test to get the month of the year
	 */
	@Test
	public void testMonth() {
		String date = gui.getDate();
		String month = date.substring(11, 14);
		Date currentDate = new Date();
		String today = currentDate.toString();
		String currentMonth = today.substring(4, 7);
		if (month.equals(currentMonth)) {
			assertTrue(true);
		} else {
			fail("Months of the year don't match");
		}
	}
	
	/**
	 * Test to get the day of the month
	 */
	@Test
	public void testMonthDay() {
		String date = gui.getDate();
		String monthDay = date.substring(15, 17);
		Date currentDate = new Date();
		String today = currentDate.toString();
		String currentMonthDay = today.substring(8, 10);
		if (monthDay.equals(currentMonthDay)) {
			assertTrue(true);
		} else {
			fail("Days of the month don't match");
		}
	}
	
	/**
	 * Test to get the year number
	 */
	@Test
	public void testYear() {
		String date = gui.getDate();
		String year = date.substring(19, 23);
		Date currentDate = new Date();
		String today = currentDate.toString();
		String currentYear = today.substring(today.length()-4, today.length());
		if (year.equals(currentYear)) {
			assertTrue(true);
		} else {
			fail("Year numbers don't match");
		}
	}
}
