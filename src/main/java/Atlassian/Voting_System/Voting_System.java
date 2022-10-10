package Atlassian.Voting_System;

import java.util.*;

public class Voting_System {
    Map<Character, Candidate> map;

    Voting_System() {
        this.map = new HashMap<>();
    }

    public void vote(String votes) {
        for (int i = 0; i < votes.length(); i++) {
            char name = votes.charAt(i);
            if (!map.containsKey(name)) map.put(name, new Candidate(name, 0));
            map.get(name).points += votes.length() - i;
        }
    }

    public List<Candidate> getRanks() {
        List<Candidate> list = new ArrayList<>(new ArrayList<>(map.values()));
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Voting_System voting_system = new Voting_System();
        voting_system.vote("ABC");
        voting_system.vote("BAC");
        voting_system.vote("ACB");
        voting_system.vote("CAB");
        System.out.println(voting_system.getRanks());
    }
}

class Candidate implements Comparable<Candidate> {
    char name;
    int points;
    Candidate(char name, int points) {
        this.name = name;
        this.points = points;
    }


    @Override
    public int compareTo(Candidate o) {
        return o.points == this.points ? this.name - o.name : o.points - this.points;
    }

    @Override
    public String toString() {
        return "[name=" + name + " points=" + points + "]";
    }
}
