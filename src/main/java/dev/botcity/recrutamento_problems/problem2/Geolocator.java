package dev.botcity.recrutamento_problems.problem2;

import java.awt.Point;

public interface Geolocator {
	Coordinate getCoordinate(String cityAscii, String stateId);
}
