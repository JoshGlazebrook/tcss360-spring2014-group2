package group2;
import java.util.*;

public class ConferenceManager {

	private ArrayList<Conference> conferences;
	
	public ConferenceManager() {
		conferences = new ArrayList<Conference>();
		loadConferences();
	}
	
	public void addConference(Conference conf) {
		conferences.add(conf);
		saveConferences();
	}
	
	public void removeConference(Conference conf) {
		conferences.remove(conf);
		saveConferences();
	}
	
	public Conference[] getConferences() {
		return conferences.toArray(new Conference[0]);
	}
	
	private void loadConferences() {
		ArrayList<Conference> result = JSONHelper.deserializeFromFile("data/conferences.json", new ArrayList<Conference>().getClass());
	}
	
	private void saveConferences() {
		JSONHelper.serializeToFile("data/conferences.json", conferences);
	}
	
	
}
