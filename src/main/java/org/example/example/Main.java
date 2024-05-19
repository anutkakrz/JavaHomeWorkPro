package org.example.example;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.example.example.Generator.generateTeams;
import static org.example.example.Generator.getPlays;

public class Main {
    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        Set<Team<Pupil>> teamsPupils = Generator.generateTeams(25, 4, Pupil.class);
        Set<Team<Teenager>> teamsTeenagers = Generator.generateTeams(25, 4, Teenager.class);
        Set<Team<Adult>> teamsAdults = Generator.generateTeams(25, 4, Adult.class);

        getPlays(teamsPupils);
        getPlays(teamsTeenagers);
        getPlays(teamsAdults);

        System.out.println(teamsPupils);
        System.out.println(teamsTeenagers);
        System.out.println(teamsAdults);




    }
}
