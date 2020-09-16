package dev.esz.algorithms.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Given a number of coordinates for the battleship as string and a number of coordinates for hits,
// decide the number of ships sunken and the number of ships hit (but not entirely sunken).
// Input is given as: 1A 3B, 5C 7D ... for the ship coordinates.
// Input is given as: 1A 2B ... for the hits.
public class BattleShip {
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Ship {
        public Coordinate topLeft;
        public Coordinate bottomRight;

        public Ship(Coordinate topLeft, Coordinate bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }
    }

    private int getNumber(String string) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(string);
        while (m.find()) {
            return Integer.parseInt(m.group());
        }
        return -1;
    }

    private char getCharacter(String string) {
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(string);
        while (m.find()) {
            return m.group().toCharArray()[0];
        }
        return '0';
    }

    private List<Ship> getShipsCoordinates(String S) {
        List<Ship> result = new ArrayList<>();
        String[] ships = S.split(",");
        for (String ship : ships) {
            String[] coordinates = ship.split(" ");
            int n1 = getNumber(coordinates[0]);
            int m1 = getCharacter(coordinates[0]) - 'A';
            int n2 = getNumber(coordinates[1]);
            int m2 = getCharacter(coordinates[1]) - 'A';
            result.add(new Ship(new Coordinate(n1, m1), new Coordinate(n2, m2)));
        }

        return result;
    }

    private boolean[][] getHitsMap(int N, String T) {
        boolean[][] map = new boolean[N + 1][N + 1];
        String[] hits = T.split(" ");
        for (String hit : hits) {
            int n1 = getNumber(hit);
            int m1 = getCharacter(hit) - 'A';
            map[n1][m1] = true;
        }
        return map;
    }

    private String computeNumberOfHits(List<Ship> ships, boolean[][] hitMap) {
        int fullHitCounter = 0;
        int partialHitCounter = 0;
        for (Ship ship : ships) {
            boolean wasAtLeastAHit = false;
            boolean everyPositionWasHit = true;
            for (int i = ship.topLeft.x; i <= ship.bottomRight.x; i++) {
                for (int j = ship.topLeft.y; j <= ship.bottomRight.y; j++) {
                    if (hitMap[i][j]) {
                        wasAtLeastAHit = true;
                    } else {
                        everyPositionWasHit = false;
                    }
                }
            }
            if (everyPositionWasHit) {
                fullHitCounter++;
            } else {
                if (wasAtLeastAHit) {
                    partialHitCounter++;
                }
            }
        }
        return fullHitCounter + "," + partialHitCounter;
    }


    public String solution(int N, String S, String T) {
        List<Ship> shipCoordinates = getShipsCoordinates(S);
        boolean[][] hitsMap = getHitsMap(N, T);
        return computeNumberOfHits(shipCoordinates, hitsMap);
    }
}
