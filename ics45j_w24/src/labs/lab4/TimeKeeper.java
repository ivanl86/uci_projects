package labs.lab4;

public class TimeKeeper {
	// ADD YOUR INSTANCE VARIABLES HERE
	double workTime;
	double playTime;
	double exerciseTime;
	double sleepTime;
	double otherTime;
	double totalTime;
	
	/**
	 * Constructs a new TimeKeeper, with no activities
	 */
	public TimeKeeper() {
		// FILL IN
		workTime = 0;
		playTime = 0;
		exerciseTime = 0;
		sleepTime = 0;
		otherTime = 0;
		totalTime = 0;
	}
	
	
	/**
	 * Causes TimeKeeper to record the given activity
	 * 
	 * @param a	the activity to record
	 */
	public void doActivity(Activity a) {
		// FILL IN
		switch (a.getCategory()) {
			case WORK:
				workTime += a.getTime();
				break;
			case PLAY:
				playTime += a.getTime();
				break;
			case EXERCISE:
				exerciseTime += a.getTime();
				break;
			case SLEEP:
				sleepTime += a.getTime();
				break;
			default:
				otherTime += a.getTime();
		}
		
		totalTime += a.getTime();
	}
	
	
	/**
	 * Returns the total time (in hours) spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total time (in hours) spent in the category	
	 */
	public double getTotalTimeForCategory(Activity.Category category) {
		switch (category) {
		case WORK:
			return workTime;
		case PLAY:
			return playTime;
		case EXERCISE:
			return exerciseTime;
		case SLEEP:
			return sleepTime;
		default:
			return otherTime;
		}
//		return -1.0; // FIX ME
	}
	
	
	/**
	 * Returns the total percentage of time spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total percentage of time spent in the category	
	 */
	public double getPercentageOfTimeSpentInCategory(Activity.Category category) {
		if (totalTime == 0) {
			return 0.0;
		}
		switch (category) {
		case WORK:
			return workTime / totalTime * 100;
		case PLAY:
			return playTime / totalTime * 100;
		case EXERCISE:
			return exerciseTime / totalTime * 100;
		case SLEEP:
			return sleepTime / totalTime * 100;
		default:
			return otherTime / totalTime * 100;
		}
//		return -1.0; // FIX ME
	}
}




