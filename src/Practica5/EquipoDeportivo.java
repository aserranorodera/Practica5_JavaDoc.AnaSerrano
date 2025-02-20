package Practica5;

/**
 * Representa un equipo deportivo con una lista de jugadores y sus minutos jugados.
 * @author ANA SERRANO RODERA
 * @version Version 1.0
 */
public class EquipoDeportivo {
    /**
     * Estas son las constantes
     */
    public static final int MAX_JUGADORES = 6;
    public static final int MAX_MINUTOS = 120;
    /**
     * Estos son los atributos
     */
    private String [] jugadores;
    int posicionJugador = 0;
    private int [] minutosPorJugador;
    int posicionMinutos = 0;
    private String nombre;
    private int cantidadJugadores;
    private String siglas ="";

    /**
     * Constructor de la clase EquipoDeportivo.
     * @param nombre: Es el nombre del equipo deportivo.
     * @param cantidadJugadores: Es el número de jugadores del equipo.
     * En este constructor sacamos las siglas de los nombres del equipo deportivo
     */
    public EquipoDeportivo(String nombre, int cantidadJugadores){
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        int posicionEspacio = 0;
        String palabra;
        String restante = nombre;
        if(cantidadJugadores>MAX_JUGADORES){
            System.err.println("ERROR:NUMERO DE JUGADORES INVÁLIDO.");
        } else {
            jugadores = new String[MAX_JUGADORES];
            minutosPorJugador = new int[MAX_JUGADORES];
        }
        while (posicionEspacio!=-1) {
            posicionEspacio = restante.indexOf(' ');
            if (posicionEspacio == -1) {
                palabra = restante;
                if (palabra.length() > 2) {
                    String primeraLetra = String.valueOf(palabra.charAt(0));
                    siglas = siglas.concat(primeraLetra);
                }
            } else {
                palabra = restante.substring(0, posicionEspacio);
                restante = restante.substring(posicionEspacio + 1);
                if (palabra.length() > 2) {
                    String primeraLetra = String.valueOf(palabra.charAt(0));
                    siglas = siglas.concat(primeraLetra);
                    siglas = siglas.toUpperCase();
                }
            }

        }
    }

    /**
     * @return  devuelve el nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre, establece un nuevo nombre para el equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return devuelve la cantidad de jugadores del equipo.
     */
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    /**
     * @return devuelve la lista de jugadores del equipo.
     */
    public String[] getJugadores() {
        return jugadores;
    }

    /**
     * @param jugadores, establece una nueva lista de jugadores.
     */
    public void setJugadores(String[] jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * @return devuelve un array con los minutos jugados (por cada jugador).
     */
    public int[] getMinutosPorJugador() {
        return minutosPorJugador;
    }

    /**
     * @param minutosPorJugador, establece los minutos jugados por cada jugador.
     */
    public void setMinutosPorJugador(int[] minutosPorJugador) {
        this.minutosPorJugador = minutosPorJugador;
    }

    /**
     * @return devuelve las siglas generadas a partir del nombre del equipo.
     */
    public String getSiglas() {
        return siglas;
    }

    /**
     * Añade un jugador al equipo con los minutos jugados.
     *
     * @param nombre, es el nombre del jugador.
     * @param minutosJugados, son los minutos jugados por el jugador.
     * @return true si el jugador fue añadido correctamente y false si el jugador no ha sido añadido.
     * Comprueba si los minutosJugados son ocrrectos y si la lista está llena
     */
    public boolean anyadirJugador (String nombre, int minutosJugados){
        boolean anyadido = false;
        if (minutosJugados<MAX_MINUTOS){
            if (jugadores[MAX_JUGADORES-1] == null){
                jugadores [posicionJugador] = nombre;
                minutosPorJugador [posicionMinutos] = minutosJugados;
                posicionJugador++;
                posicionMinutos++;
                anyadido = true;
            }else {
                System.err.println("Error: lista llena.");
            }
        } else{
            System.err.println("Error: Minutos incorrectos, jugador no añadido.");
        }
        return anyadido;
    }

    /**
     * Este metodo muestra por pantalla la información del equipo (el nombre, siglas, cantidad de jugadores y la lista de jugadores con sus minutos jugados).
     */
    public void mostrarDatosEquipo (){
        System.out.println("****" + nombre.toUpperCase() + " (" + siglas + ") ****");
        System.out.println("Total jugadores: " + cantidadJugadores);
        for(int cont=0; cont<jugadores.length; cont++){
            System.out.println("[" + jugadores[cont] + ", " + minutosPorJugador[cont] + "]");
        }
    }

}
