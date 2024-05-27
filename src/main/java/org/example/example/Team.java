package org.example.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
@Setter
public class Team<T extends Participant> {
    private String teamName;
    private List<T> list = new ArrayList<>();
    private double points;
    private int gameCounter;
    private int winCounter;
    private int losCounter;
    private int drawCounter;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addNewParticipant(T newParticipant) {
        list.add(newParticipant);
    }

    public void play(Team<T> team) {
        String winner;
        Random random = new Random();
        int i = random.nextInt(2);
        if(i == 0) {
            winner = this.teamName;
        } else {
            winner = team.teamName;
        }

        System.out.println("WINNER: " + winner);
    }
}