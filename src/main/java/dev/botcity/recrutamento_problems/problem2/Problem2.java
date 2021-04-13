package dev.botcity.recrutamento_problems.problem2;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections.map.MultiKeyMap;

/**
 *
 * Problema: - Implementar um Geolocator
 *
 * - As coordenadas de todas cidades americanas est�o em ./res/uscitiesv1.5.csv
 *
 * - Considere que o Geolocator poderá receber milhares de requisições de
 * coordenadas por minuto. Portanto o método getCoordinate() não deverá ser
 * responsável por carregar coordenadas. As coordenadas já precisam estar em
 * memória de alguma forma.
 *
 * - Se usar uma estratégia de indexação, lembre-se que existem cidades com o
 * mesmo nome em estados distintos.
 *
 */
public class Problem2 {

    private Geolocator myGeolocator;

    /**
     * Instancie sua implementação no método abaixo
     */
    private void createGeolocation() {
        final MultiKeyMap mapCordinate = new MultiKeyMap();
        
        try {
            CSVReader reader = new CSVReader(new FileReader("./res/uscitiesv1.5.csv"));
            reader.skip(1);
            for (String[] column : reader.readAll()) {
                Coordinate coordinate = new Coordinate(Double.parseDouble(column[6]), Double.parseDouble(column[7]));
                mapCordinate.put(column[1], column[2], coordinate);
            }
        } catch (Exception ex) {
            Logger.getLogger(Problem2.class.getName()).log(Level.SEVERE, "Falha ao processar csv!", ex);
        }

        myGeolocator = new Geolocator() {
            public Coordinate getCoordinate(String cityAscii, String stateId) {
                return (Coordinate) mapCordinate.get(cityAscii, stateId);
            }
        };
    }

    /**
     * NÃO ALTERAR MÉTODO EVAL
     */
    private void eval() {

        boolean failed = false;
        if (myGeolocator == null) {
            System.out.println("[FAIL] Objeto \"myGeoImplementation\" não instanciado. Veja método createGeolocation()");
            return;
        }

        Coordinate c;

        // Boulevard Park-WA
        c = myGeolocator.getCoordinate("Springville", "NY");

        if (c != null && c.getLat() == 42.5084 && c.getLng() == -78.6696) {
            System.out.println("[OK] Coordenada de \"Springville-NY\" está correta: 42.5084, -78.6696");
        } else {
            System.out.println("[FAIL] Coordenada de \"Springville-NY\" está incorreta");
            failed = true;
        }

        // San Francisco-CA
        c = myGeolocator.getCoordinate("San Francisco", "CA");

        if (c != null && c.getLat() == 37.7562 && c.getLng() == -122.4430) {
            System.out.println("[OK] Coordenada de \"San Francisco-CA\" está correta: 37.7562, -122.4430");
        } else {
            System.out.println("[FAIL] Coordenada de \"San Francisco-CA\" está incorreta");
            failed = true;
        }

        // New York-NY
        c = myGeolocator.getCoordinate("New York", "NY");

        if (c != null && c.getLat() == 40.6943 && c.getLng() == -73.9249) {
            System.out.println("[OK] Coordenada de \"New York-NY\" está correta: 40.6943, -73.9249");
        } else {
            System.out.println("[FAIL] Coordenada de \"New York-NY\" está incorreta");
            failed = true;
        }

        if (!failed) {
            System.out.println("PROBLEM SOLVED!");
        }
    }

    /**
     * NÃO ALTERAR MÉTODO MAIN
     */
    public static void main(String[] args) {

        Problem2 p = new Problem2();
        p.createGeolocation();
        p.eval();
        System.exit(0);
    }
}
