package group2;
import java.util.*;

public class ConferenceManager {

	private ArrayList<Conference> conferences = new ArrayList<Conference>();
	
	public ConferenceManager() {
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
		Conference[] result = JSONHelper.deserializeFromFile("data/conferences.json", conferences.toArray(new Conference[0]).getClass());

		if (result != null) {
			for(Conference x : result) {
				conferences.add(x);
			}
		}
	}
	
	private void saveConferences() {
		System.out.println("saved conferences");
		JSONHelper.serializeToFile("data/conferences.json", conferences);
	}
}
