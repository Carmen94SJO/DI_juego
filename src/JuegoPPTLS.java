import java.util.Scanner;

public class JuegoPPTLS {
    private int puntosJugador = 0;
    private int puntosCPU = 0;
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println("=== PIEDRA, PAPEL, TIJERA, LAGARTO, SPOCK ===");

        while (true) {
            mostrarPuntuacion();
            Opcion jugador = pedirJugada();
            if (jugador == null) {
                System.out.println("¡Gracias por jugar!");
                break;
            }

            Opcion cpu = Opcion.aleatoria();
            System.out.println("\nTú: " + jugador.getNombre());
            System.out.println("CPU: " + cpu.getNombre());

            determinarGanador(jugador, cpu);
        }
    }

    private void mostrarPuntuacion() {
        System.out.printf("\nPuntuación -> Jugador: %d | CPU: %d\n", puntosJugador, puntosCPU);
    }

    private Opcion pedirJugada() {
        System.out.println("\nElige tu jugada:");
        System.out.println("1. Piedra");
        System.out.println("2. Papel");
        System.out.println("3. Tijera");
        System.out.println("4. Lagarto");
        System.out.println("5. Spock");
        System.out.println("0. Salir");
        System.out.print("> ");

        String entrada = sc.nextLine();
        try {
            int opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1: return Opcion.PIEDRA;
                case 2: return Opcion.PAPEL;
                case 3: return Opcion.TIJERA;
                case 4: return Opcion.LAGARTO;
                case 5: return Opcion.SPOCK;
                case 0: return null;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    return pedirJugada();
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Intenta de nuevo.");
            return pedirJugada();
        }
    }

    private void determinarGanador(Opcion jugador, Opcion cpu) {
        if (jugador == cpu) {
            System.out.println("¡Empate!");
        } else if (jugador.venceA(cpu)) {
            System.out.println("¡Ganaste! " + jugador.mensajeVictoria(cpu));
            puntosJugador++;
        } else {
            System.out.println("Perdiste... " + cpu.mensajeVictoria(jugador));
            puntosCPU++;
        }
    }

    public static void main(String[] args) {
        new JuegoPPTLS().iniciar();
    }
}
