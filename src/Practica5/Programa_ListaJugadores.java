package Practica5;
import java.util.Scanner;
/**
 * Esta es la clase principal, desde la que se ejecuta el programa
 *  Gestiona la interacción con el usuario para consultar la información sobre los equipos deportivos.
 * @author ANA SERRANO RODERA
 * @version 1.0
 */
public class Programa_ListaJugadores {

    /**
     * Metodo main, es el metodo principal
     * Permite al usuario buscar equipos por sus siglas y visualizar la información.
     * Muestra por pantalla al usuario el nombre del equipo, los jugadores y los minutos jugados por cada jugador
     */
    public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            EquipoDeportivo[] equipos = new EquipoDeportivo[5];

        /**
         * Creación de equipos y asignación de jugadores
         * Crea el equipo 1 y añade la información de los jugadores (nombre) y los minutos jugados (minutosJugados)
         */
        EquipoDeportivo realMadrid = new EquipoDeportivo("REAL MADRID CLUB DE FUTBOL", 6);
            equipos [0] = realMadrid;

            realMadrid.anyadirJugador("Vinícius Jr.", 85);
            realMadrid.anyadirJugador("Jude Bellingham", 90);
            realMadrid.anyadirJugador("Rodrygo", 78);
            realMadrid.anyadirJugador("Luka Modrić", 65);
            realMadrid.anyadirJugador("Toni Kroos", 70);
            realMadrid.anyadirJugador("Antonio Rüdiger", 88);

        /**
         * Crea el segundo equipo
          */
        EquipoDeportivo barcelona = new EquipoDeportivo("FUTBOL CLUB BARCELONA", 5);
            equipos [1] = barcelona;

            barcelona.anyadirJugador("Robert Lewandowski", 90);
            barcelona.anyadirJugador("Pedri", 85);
            barcelona.anyadirJugador("Gavi", 75);
            barcelona.anyadirJugador("Frenkie de Jong", 80);
            barcelona.anyadirJugador("Ronald Araújo", 90);

        /**
         * Crea el tercer equipo (los mismos datos que los anteriores cambiando jugadores y minutos)
          */
        EquipoDeportivo atleticoMadrid = new EquipoDeportivo("ATLÉTICO DE MADRID", 6);
            equipos[2] = atleticoMadrid;


            atleticoMadrid.anyadirJugador("Antoine Griezmann", 88);
            atleticoMadrid.anyadirJugador("Álvaro Morata", 80);
            atleticoMadrid.anyadirJugador("Koke", 85);
            atleticoMadrid.anyadirJugador("Memphis Depay", 65);
            atleticoMadrid.anyadirJugador(" Rodrigo de Paul",78);
            atleticoMadrid.anyadirJugador("José María Giménez", 90);

        /**
         * Crea el cuarto equipo
          */
        EquipoDeportivo realSociedad = new EquipoDeportivo("REAL SOCIEDAD", 5);
            equipos [3] = realSociedad;

            realSociedad.anyadirJugador("Mikel Oyarzabal", 82);
            realSociedad.anyadirJugador("Takefusa Kubo", 75);
            realSociedad.anyadirJugador("Brais Méndez", 88);
            realSociedad.anyadirJugador("Martín Zubimendi", 80);
            realSociedad.anyadirJugador("David Silva", 70);

        /**
         * Crea el último equipo
          */
        EquipoDeportivo sevilla = new EquipoDeportivo("SEVILLA FUTBOL CLUB", 6);
            equipos [4] = sevilla;
            sevilla.anyadirJugador("Youssef En-Nesyri", 88);
            sevilla.anyadirJugador("Ivan Rakitić", 85);
            sevilla.anyadirJugador("Jesús Navas", 80);
            sevilla.anyadirJugador("Lucas Ocampos", 70);
            sevilla.anyadirJugador("Marcos Acuña", 75);
            sevilla.anyadirJugador("Sergio Ramos",90);

            System.out.println("****EQUIPOS CREADOS****");
            boolean salir = false;

        /**
         * Este bucle, consulta los equipos por siglas
         * Le pide al usuario que equipo desea jugar o si quiere salir, en el bucle lo comprueba (si las siglas son o no correctas)
         */
        while (!salir){
                System.out.println("¿QUE EQUIPO QUIERES BUSCAR? INTRODUCE SUS SIGLAS");
                String siglas = teclado.nextLine();
                if (!siglas.equalsIgnoreCase("salir")){
                    int cont = 0;
                    boolean equipoEncontrado = false;
                    while (cont<equipos.length && !equipoEncontrado){
                        if (siglas.equals(equipos [cont].getSiglas())){
                            equipos[cont].mostrarDatosEquipo();
                            equipoEncontrado = true;
                        }
                        cont++;
                    }
                    if (!equipoEncontrado){
                        System.out.println("LAS SIGLAS INDICADAS NO HAN SIDO ENCONTRADAS EN EL SISTEMA.");
                    }
                } else {
                    salir = true;
                }

            }
        }
    }
