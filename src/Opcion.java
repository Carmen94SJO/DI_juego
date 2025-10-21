import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum Opcion {
    PIEDRA("Piedra"),
    PAPEL("Papel"),
    TIJERA("Tijera"),
    LAGARTO("Lagarto"),
    SPOCK("Spock");

    private final String nombre;
    private final Map<Opcion, String> venceA = new HashMap<>();

    static {
        PIEDRA.venceA.put(LAGARTO, "Piedra aplasta Lagarto");
        PIEDRA.venceA.put(TIJERA, "Piedra aplasta Tijera");

        PAPEL.venceA.put(PIEDRA, "Papel cubre Piedra");
        PAPEL.venceA.put(SPOCK, "Papel desaprueba Spock");

        TIJERA.venceA.put(PAPEL, "Tijera corta Papel");
        TIJERA.venceA.put(LAGARTO, "Tijera decapita Lagarto");

        LAGARTO.venceA.put(SPOCK, "Lagarto envenena Spock");
        LAGARTO.venceA.put(PAPEL, "Lagarto come Papel");

        SPOCK.venceA.put(PIEDRA, "Spock vaporiza Piedra");
        SPOCK.venceA.put(TIJERA, "Spock rompe Tijera");
    }

    Opcion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean venceA(Opcion otra) {
        return venceA.containsKey(otra);
    }

    public String mensajeVictoria(Opcion otra) {
        return venceA.get(otra);
    }

    public static Opcion aleatoria() {
        Opcion[] valores = values();
        return valores[new Random().nextInt(valores.length)];
    }
}
