package labs.lab9;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Song implements Comparable<Song> {
	public static final Set<String> CATEGORIES;
	static {
		@SuppressWarnings("serial")
		Set<String> categoryNames = new LinkedHashSet<>() {{
			add("WorK");
			add("Exercise");
			add("Party");
			add("Sleep");
			add("Driving");
			add("Other");
		}};
		CATEGORIES = categoryNames;
	}
	public static final int SHARE_GROUP_SIZE = 3;
	public static final String FRIEND_GROUP = "Friends";
	public static final String FAMILY_GROUP = "Family";
	public static final String COWORKER_GROUP = "Coworkers";
	private String title;
	private String artist;
	private Map<String, Boolean> shareGroup; // FRIENDGROUP, FAMILYGROUP, COWORKERGROUP
	private String category; // work, exercise, party, sleep, driving, other
	private double runningTime;
	private String notes;
	
	// Map<String, Boolean> shareGroup,
	@SuppressWarnings("serial")
	public Song(String title, String artist, boolean[] checkedGroups, String category, double runningTime, String notes) {
		this.title = title;
		this.artist = artist;
		this.category = category;
		this.runningTime = runningTime;
		this.shareGroup = new HashMap<>() {{
			put(FRIEND_GROUP, checkedGroups[0]);
			put(FAMILY_GROUP, checkedGroups[1]);
			put(COWORKER_GROUP, checkedGroups[2]);
		}};
		this.notes = notes;
	}
	
//	public void setTitle(String title) {
//		this.title = title;
//	}
	
	public String getTitle() {
		return title;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setFriendGroup(boolean check) {
		shareGroup.put(FRIEND_GROUP, check);
	}
	
	public boolean getFriendGroup() {
		return shareGroup.get(FRIEND_GROUP);
	}
	
	public void setFamilyGroup(boolean check) {
		shareGroup.put(FAMILY_GROUP, check);
	}
	
	public boolean getFamilyGroup() {
		return shareGroup.get(FAMILY_GROUP);
	}
	
	public void setCoworkerGroup(boolean check) {
		shareGroup.put(COWORKER_GROUP, check);
	}
	
	public boolean getCoworkerGroup() {
		return shareGroup.get(COWORKER_GROUP);
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategroy() {
		return category;
	}
	
	public void setRunningTime(double runningTime) {
		this.runningTime = runningTime;
	}
	
	public double getRunningTime() {
		return runningTime;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getNotes() {
		return notes;
	}
	
	@Override
	public String toString() {
		return title;
	}
	
	@Override
	public boolean equals(Object otherSong) {
		if (otherSong instanceof Song) {
			return this.title.equals(((Song) otherSong).title);
		}
		return false;
	}

	@Override
	public int compareTo(Song otherSong) {
		if (title.compareTo(otherSong.title) < 0) {
			return -1;
		}
		if (title.compareTo(otherSong.title) > 0) {
			return 1;
		}
		return 0;
	}
}
