package tests;

import static org.junit.Assert.*;

import org.junit.Rule;

import com.example.pojo.Film;
import com.example.pojo.Session;
import com.example.pojo.User;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import dao.FilmDAO;
import dao.SessionDAO;
import dao.UserDAO;

import org.junit.Test;

public class TestPerformance {

	 @Rule
	 public JUnitPerfRule rule = new JUnitPerfRule(new HtmlReportGenerator("performance/report.html"));
	 @Test
	 @JUnitPerfTest(threads = 20, durationMs = 2000)
	 @JUnitPerfTestRequirement(meanLatency = 100)
	 public void testFilmSave() throws Exception {
		 FilmDAO.getInstance().save(new Film(1,"Star Wars",2));
	 }
	 
	 //easter eggs
	 
	 @Test
	 @JUnitPerfTest(threads = 20, durationMs = 2000)
	 @JUnitPerfTestRequirement(meanLatency = 100)
	 public void testSessionSave() throws Exception {
		 SessionDAO.getInstance().save(new Session(1,java.sql.Date.valueOf("2023-07-15"),"12:30",1));
	 }
	 
	 
	 @Test
	 @JUnitPerfTest(threads = 20, durationMs = 2000)
	 @JUnitPerfTestRequirement(meanLatency = 100)
	 public void testUserSave() throws Exception {
		 UserDAO.getInstance().save(new User(1,"Geronimo","Domingos","geridoming@gmail.com","megustanlasbellotas@1"));
	 }
	 
	 
	  @Test
	  @JUnitPerfTest(threads = 1, durationMs = 1_000, maxExecutionsPerSecond = 1_000)
	  public void testUserSaveFail() throws InterruptedException {
		UserDAO.getInstance().save(new User(1,"Geronimo","Domingos","geridoming@gmail.com","megustanlasbellotas@1"));
	    Thread.sleep(2);
	    throw new IllegalStateException("testing failure");
	  }

}
