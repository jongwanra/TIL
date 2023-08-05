package equals_and_hashcode;
import java.util.HashMap;

public class Main  {
    public static void main(String[] args) {
        HashMap<Team, String> leaders = new HashMap<>();

        leaders.put(new Team("New York", "development"), "Anne");
        leaders.put(new Team("Boston", "development"), "Brian");
        leaders.put(new Team("Boston", "marketing"), "Charlie");

        Team myTeam = new Team("New York", "development");
        String myTeamLeader = leaders.get(myTeam);

        System.out.println("leaders = " + leaders);
        System.out.println("myTeamLeader = " + myTeamLeader);

    }
}
