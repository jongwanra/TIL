package equals_and_hashcode;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		HashMap<Team, String> leaders = new HashMap<>();
		LinkedList<String> strings = new LinkedList<>();
		
		leaders.put(new Team("New York", "development"), "Anne");
		leaders.put(new Team("Boston", "development"), "Brian");
		leaders.put(new Team("Boston", "marketing"), "Charlie");
		
		Team myTeam = new Team("New York", "development");
		String myTeamLeader = leaders.get(myTeam);
		
		System.out.println("leaders = " + leaders);
		System.out.println("myTeamLeader = " + myTeamLeader);
		
	}
}
