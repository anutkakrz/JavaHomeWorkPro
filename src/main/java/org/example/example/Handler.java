package org.example.example;

import java.util.HashMap;
import java.util.Map;

public class Handler {
/*
* какая команда сколько раз сыграла int gameCount
* кол-во побед winCounter
* турнирная таблица map ключ название команды значение результат игры
* */
private  Map<Team<? extends Participant>,Team<? extends Participant>> turnamentMap = new HashMap<>();
private  Map<Team<? extends Participant>,Integer> turnamentWinGameMap = new HashMap<>();

}
