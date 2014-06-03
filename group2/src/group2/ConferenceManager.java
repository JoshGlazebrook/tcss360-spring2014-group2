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
		System.out.println(conferences.size());
		Conference tmp = conferences.get(0);
		
		
		
		return conferences.toArray(new Conference[0]);
	}
	
	private void loadConferences() {
		Conference[] result = JSONHelper.deserializeFromFile("data/conferences.json", conferences.toArray(new Conference[0]).getClass());
		
		if (result != null)
			conferences.addAll(Arrays.asList(result));
		
	}
	
	private void saveConferences() {
		JSONHelper.serializeToFile("data/conferences.json", conferences);
	}
	
	
}
