import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Policia> policias = new ArrayList<>();
    private static ArrayList<Arma> armas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1 -> cargarPolicia();
                case 2 -> cargarArma();
                case 3 -> verificarCondicionesArma();
                case 4 -> mostrarPoliciasYArmas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Sistema de Administración de Armas ---");
        System.out.println("1. Cargar Policía");
        System.out.println("2. Cargar Arma y asignarla a un Policía");
        System.out.println("3. Verificar condiciones de uso de un arma");
        System.out.println("4. Mostrar policías y sus armas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void cargarPolicia() {
        System.out.print("Ingrese el nombre del policía: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del policía: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el legajo del policía: ");
        int legajo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Policia policia = new Policia(nombre, apellido, legajo);
        policias.add(policia);
        System.out.println("Policía cargado exitosamente.");
    }

    private static void cargarArma() {
        if (policias.isEmpty()) {
            System.out.println("Debe cargar al menos un policía antes de agregar un arma.");
            return;
        }

        System.out.println("Seleccione el tipo de arma:");
        System.out.println("1. Arma Corta");
        System.out.println("2. Arma Larga");
        int tipoArma = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la cantidad de municiones: ");
        int municiones = scanner.nextInt();
        System.out.print("Ingrese el alcance en metros: ");
        int alcance = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el calibre: ");
        int calibre = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el estado (NUEVA, EN MANTENIMIENTO, EN USO): ");
        String estado = scanner.nextLine();

        System.out.println("Seleccione un policía para asignar el arma:");
        for (int i = 0; i < policias.size(); i++) {
            System.out.println((i + 1) + ". " + policias.get(i));
        }
        int indicePolicia = scanner.nextInt() - 1;
        scanner.nextLine();

        Policia policia = (indicePolicia >= 0 && indicePolicia < policias.size()) ? policias.get(indicePolicia) : null;
        if (policia == null) {
            System.out.println("Selección de policía no válida.");
            return;
        }

        Arma arma;
        if (tipoArma == 1) { // Arma Corta
            System.out.print("¿Es automática? (true/false): ");
            boolean esAutomatica = scanner.nextBoolean();
            scanner.nextLine();
            arma = new ArmaCorta(municiones, alcance, marca, calibre, estado, policia, esAutomatica);
        } else { // Arma Larga
            System.out.print("¿Tiene sello RENAR? (true/false): ");
            boolean selloRENAR = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Ingrese una descripción de uso: ");
            String descripcionUso = scanner.nextLine();
            System.out.print("Ingrese el nivel (1-5): ");
            int nivel = scanner.nextInt();
            scanner.nextLine();
            arma = new ArmaLarga(municiones, alcance, marca, calibre, estado, policia, selloRENAR, descripcionUso, nivel);
        }

        armas.add(arma);
        System.out.println("Arma cargada y asignada al policía exitosamente.");
    }

    private static void verificarCondicionesArma() {
        if (armas.isEmpty()) {
            System.out.println("No hay armas cargadas en el sistema.");
            return;
        }

        System.out.println("Seleccione un arma para verificar sus condiciones:");
        for (int i = 0; i < armas.size(); i++) {
            System.out.println((i + 1) + ". " + armas.get(i));
        }
        int indiceArma = scanner.nextInt() - 1;
        scanner.nextLine();

        Arma arma = (indiceArma >= 0 && indiceArma < armas.size()) ? armas.get(indiceArma) : null;
        if (arma != null) {
            System.out.println("¿El arma está en condiciones para ser usada en enfrentamiento? " + arma.estaEnCondiciones());
        } else {
            System.out.println("Selección de arma no válida.");
        }
    }

    private static void mostrarPoliciasYArmas() {
        if (policias.isEmpty()) {
            System.out.println("No hay policías cargados en el sistema.");
            return;
        }

        System.out.println("--- Listado de Policías y sus Armas ---");
        for (Policia policia : policias) {
            System.out.println(policia);
            for (Arma arma : armas) {
                if (arma.getPolicia().equals(policia)) {
                    System.out.println("  - " + arma);
                }
            }
        }
    }
}