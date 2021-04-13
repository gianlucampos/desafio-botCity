package dev.botcity.recrutamento_problems.problem2;

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
//		myGeolocator = new YourImplementationHere();
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
