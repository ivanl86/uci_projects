package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;


public class TimeKeeperTest {

	private final double EPSILON = 1e-3;
	
	
	@Test
    public void testAllActivitiesInOneCategory() {
		// FILL IN
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(14.0, tk.getTotalTimeForCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(100.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER), EPSILON);
    }
	
	
	@Test
	public void testNoActivities() {
		// FILL IN
		TimeKeeper tk = new TimeKeeper();
		
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER), EPSILON);
	}
	
	
	@Test
	public void testDuplicateActivities() {
		// FILL IN
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Go for a run with Mommy", 1.0, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Go for a run with Mommy", 1.0, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Afternoon nap", 2.0, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Afternoon nap", 2.0, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Sunbathe", 0.5, Activity.Category.OTHER));
		tk.doActivity(new Activity("Sunbathe", 0.5, Activity.Category.OTHER));
		tk.doActivity(new Activity("Eat dinner", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Eat dinner", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		
		assertEquals(4.6, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(24.33862433862434, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.2, tk.getTotalTimeForCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(1.058201058201058, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(2.0, tk.getTotalTimeForCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(10.58201058201058, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(11.0, tk.getTotalTimeForCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(58.2010582010582, tk.getPercentageOfTimeSpentInCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(1.1, tk.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
		assertEquals(5.82010582010582, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER), EPSILON);
	}
}