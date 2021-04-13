package dev.botcity.recrutamento_problems.problem2;

public interface Geolocator {

    Coordinate getCoordinate(String cityAscii, String stateId);
}
