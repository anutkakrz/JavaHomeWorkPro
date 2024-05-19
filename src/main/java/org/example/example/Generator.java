package org.example.example;

import com.github.javafaker.Faker;

import java.util.*;

public class Generator {

    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static <T extends Participant> Set <Team<T>> generateTeams(int numberOfTeams, int participantsInTeam, Class<T> participantType) {
        Set<Team<T>> teams = new HashSet<>();
        for (int i = 0; i < numberOfTeams; i++) {
            Team<T> team = new Team<>(FAKER.team().name());
            team.setList(generateParticipants(participantsInTeam,participantType));
            teams.add(team);
        }
        return teams;
    }

    private static <T extends Participant> List<T> generateParticipants(int count, Class<T> participantType) {
        List<T> participants = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            T participant = null;
            if(participantType.equals(Pupil.class)) {
                participant = participantType.cast(new Pupil(FAKER.name().fullName(),RANDOM.nextInt(5,10)));
            }else if(participantType.equals(Teenager.class)) {
                participant = participantType.cast(new Teenager(FAKER.name().fullName(),RANDOM.nextInt(10,21)));
            }else if(participantType.equals(Adult.class)) {
                participant = participantType.cast(new Adult(FAKER.name().fullName(),RANDOM.nextInt(21,121)));
            }
            participants.add(participant);
        }
        return participants;
    }

    public static <T extends Participant> void getPlays(Set<Team<T>> teams) {
        List<Team<T>> teamList = new ArrayList<>(teams);
        int countJ = 1;
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = countJ; j < teamList.size(); j++) {
                int win = RANDOM.nextInt(3);
                if (i==j)continue;
                if (win == 0) {
                    teamList.get(i).setPoints(teamList.get(i).getPoints() + 0.5);
                    teamList.get(j).setPoints(teamList.get(j).getPoints() + 0.5);
                    teamList.get(i).setGameCounter(teamList.get(i).getGameCounter() + 1);
                    teamList.get(j).setGameCounter(teamList.get(j).getGameCounter() + 1);
                    teamList.get(i).setDrawCounter(teamList.get(i).getDrawCounter() + 1);
                    teamList.get(j).setDrawCounter(teamList.get(j).getDrawCounter() + 1);
                } else if (win == 1) {
                    teamList.get(i).setPoints(teamList.get(i).getPoints() + 1);
                    teamList.get(i).setGameCounter(teamList.get(i).getGameCounter() + 1);
                    teamList.get(j).setGameCounter(teamList.get(j).getGameCounter() + 1);
                    teamList.get(i).setWinCounter(teamList.get(i).getWinCounter() + 1);
                    teamList.get(j).setLosCounter(teamList.get(j).getLosCounter() + 1);
                } else if (win == 2) {
                    teamList.get(j).setPoints(teamList.get(j).getPoints() + 1);
                    teamList.get(i).setGameCounter(teamList.get(i).getGameCounter() + 1);
                    teamList.get(j).setGameCounter(teamList.get(j).getGameCounter() + 1);
                    teamList.get(j).setWinCounter(teamList.get(j).getWinCounter() + 1);
                    teamList.get(i).setLosCounter(teamList.get(i).getLosCounter() + 1);
                }
                System.out.println(i);
                System.out.println(j);
            }
            countJ = i + 1;
        }
    }



//
//
//    public static Set<Team<Pupil>> generate25TeamPupils() {
//        Set<Team<Pupil>> teamsPupils = new HashSet<>();
//        for (int i = 0; i < 25; i++) {
//            Team<Pupil> pupilTeam = new Team<>(FAKER.team().name());
//            pupilTeam.setList(generate4Pupils());
//            teamsPupils.add((pupilTeam));
//        }
//
//        return teamsPupils;
//    }
//
//    private static List<Pupil> generate4Pupils() {
//        List<Pupil> pupils = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            pupils.add(new Pupil(FAKER.name().name(), RANDOM.nextInt(5, 10)));
//        }
//        return pupils;
//
//    }
//
//    public static Set<Team<Teenager>> generate25TeamsTeenager() {
//        Set<Team<Teenager>> teenagersTeam = new HashSet<>();
//        for (int i = 0; i < 25; i++) {
//            Team<Teenager> teenagerTeam = new Team<>(FAKER.team().name());
//            teenagerTeam.setList(generate4Teenagers());
//            teenagersTeam.add(teenagerTeam);
//        }
//        return teenagersTeam;
//    }
//
//
//    private static List<Teenager> generate4Teenagers() {
//        List<Teenager> teenagers = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            teenagers.add(new Teenager(FAKER.name().name(), RANDOM.nextInt(10, 21)));
//        }
//        return teenagers;
//    }
//
//    public static Set<Team<Adult>> generate25TeamsAdult() {
//        Set<Team<Adult>> adultsTeam = new HashSet<>();
//        for (int i = 0; i < 25; i++) {
//            Team<Adult> adultTeam = new Team<>(FAKER.team().name());
//            adultTeam.setList(generate4Adults());
//            adultsTeam.add(adultTeam);
//        }
//        return adultsTeam;
//    }
//
//    private static List<Adult> generate4Adults() {
//        List<Adult> adults = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            adults.add(new Adult(FAKER.name().name(), RANDOM.nextInt(21, 121)));
//        }
//        return adults;
//    }

//    public static void getTurnamentMap(Set<Team<Pupil>> teams) {
//        List<Team<Pupil>> teamList = new ArrayList<>(teams);
//        int win = 0;
//        int countJ = 1;
//        for (int i = 0; i < teamList.size(); i++) {
//            for (int j = countJ; j < teamList.size(); j++) {
//
//                win = RANDOM.nextInt(0, 3);
//                if (win == 0) {
//                    teamList.get(i).setPoints(teamList.get(i).getPoints() + 0.5);
//                    teamList.get(j).setPoints(teamList.get(j).getPoints() + 0.5);
//                    teamList.get(i).setGameCounter(teamList.get(i).getGameCounter() + 1);
//                    teamList.get(j).setGameCounter(teamList.get(j).getGameCounter() + 1);
//                    teamList.get(i).setDrawCounter(teamList.get(i).getDrawCounter() + 1);
//                    teamList.get(j).setDrawCounter(teamList.get(j).getDrawCounter() + 1);
//                }
//                if (win == 1) {
//                    teamList.get(i).setPoints(teamList.get(i).getPoints() + 1);
//                    teamList.get(i).setGameCounter(teamList.get(i).getGameCounter() + 1);
//                    teamList.get(j).setGameCounter(teamList.get(j).getGameCounter() + 1);
//                    teamList.get(i).setWinCounter(teamList.get(i).getWinCounter() + 1);
//                    teamList.get(j).setLosCounter(teamList.get(j).getLosCounter() + 1);
//
//                }
//                if (win == 2) {
//                    teamList.get(j).setPoints(teamList.get(j).getPoints() + 1);
//                    teamList.get(i).setGameCounter(teamList.get(i).getGameCounter() + 1);
//                    teamList.get(j).setGameCounter(teamList.get(j).getGameCounter() + 1);
//                    teamList.get(j).setWinCounter(teamList.get(j).getWinCounter() + 1);
//                    teamList.get(i).setLosCounter(teamList.get(i).getLosCounter() + 1);
//
//                }
//                countJ++;
//
//            }countJ = i+1;
//
//        }
//    }
}






