/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author santi
 */
public class Streams {
    
    
    //LO COMENTADO ABAJO VA EN EL MAIN
    /*
    List<Curso> cursos = new ArrayList<Curso>();
		
    cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
    cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
    cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
    cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
    cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));


    System.out.println(cantidadCursosMayorCincoHoras(cursos));

    System.out.println(cantidadCursosMenorDosHoras(cursos));

    tituloCursoCantidadVideoMayorCincuenta(cursos);

    tituloTresCursosMayorDuracion(cursos);

    duracionTotalCursos(cursos);

    System.out.println(duracionTotalCursos(cursos));

    librosMayorDuracionAPromedio(cursos);

    cursosCantidadAlumnosMenorQuinientos(cursos);

    cursoMayorDuracion(cursos);

    System.out.println(titulosCursos(cursos));
    
    */   
    
    //METODOS DE LOS EJERCICIOS
    
    //1. Obtener la cantidad de cursos con una duración mayor a 5 horas
	
    public static long cantidadCursosMayorCincoHoras(List<Curso> lista) {
            return lista.stream().filter( c -> c.getDuracion()>5).count();
    }


    //2. Obtener la cantidad de cursos con una duración menor a 2 horas.

    public static long cantidadCursosMenorDosHoras(List<Curso> lista) {
            return lista.stream().filter( c -> c.getDuracion()<2).count();
    }


    //3. Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.

    public static void tituloCursoCantidadVideoMayorCincuenta(List<Curso> lista) {
            lista.stream().filter(c -> c.getVideos() > 50).map(Curso::getTitulo).forEach(System.out::println);
    }


    //4. Mostrar en consola el título de los 3 cursos con mayor duración.

    public static void tituloTresCursosMayorDuracion(List<Curso> lista) {
            lista.stream().sorted(Comparator.comparing(Curso::getDuracion).reversed()).limit(3).map(Curso::getTitulo).forEach(System.out::println);
    }


    //5. Mostrar en consola la duración total de todos los cursos.

    public static double duracionTotalCursos(List<Curso> lista) {
            return lista.stream().mapToDouble(Curso::getDuracion).sum();
    }


    //6. Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.

    public static void librosMayorDuracionAPromedio(List<Curso> lista) {
            double promedioDuracion = lista.stream().mapToDouble(Curso::getDuracion).average().orElse(0);
            lista.stream().filter(curso -> curso.getDuracion() > promedioDuracion).forEach(curso -> System.out.println(curso.getTitulo()));
    }


    //7. Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.


    public static void cursosCantidadAlumnosMenorQuinientos(List<Curso> lista) {
            lista.stream().filter(curso -> curso.getAlumnos() < 500).forEach(curso -> System.out.println(curso.getDuracion()));
    }



    //8. Obtener el curso con mayor duración

    public static void cursoMayorDuracion(List<Curso> lista) {
             Optional<Curso> cursoConMayorDuracion = lista.stream().max(Comparator.comparingDouble(Curso::getDuracion));
             cursoConMayorDuracion.ifPresent(curso -> System.out.println(curso.getTitulo() + " - " + curso.getDuracion()));
    }


    //9. Crear una lista de Strings con todos los títulos de los cursos.

    public static String titulosCursos(List<Curso> lista) {
            List<String> titulosCursos = lista.stream().map(Curso::getTitulo).collect(Collectors.toList());
            String resultado = String.join(", ", titulosCursos);
            return resultado;
    }

    
    /*
    // Ejemplo 1: Filtrar cursos con duración entre 5 y 10 horas
    
        List<Curso> cursosEntre5y10Horas = listaCursos.stream()
                .filter(c -> c.getDuracion() >= 5 && c.getDuracion() <= 10)
                .collect(Collectors.toList());

    
        // Ejemplo 2: Obtener la cantidad total de videos en todos los cursos
    
        int totalVideos = listaCursos.stream()
                .mapToInt(Curso::getVideos)
                .sum();

    
        // Ejemplo 3: Contar la cantidad de cursos por cantidad de alumnos
    
        Map<Integer, Long> cursosPorAlumnos = listaCursos.stream()
                .collect(Collectors.groupingBy(Curso::getAlumnos, Collectors.counting()));

    
        // Ejemplo 4: Encontrar el curso con la duración más corta
    
        Optional<Curso> cursoDuracionMasCorta = listaCursos.stream()
                .min(Comparator.comparingDouble(Curso::getDuracion));

    
        // Ejemplo 5: Concatenar los títulos de los cursos con duración mayor a 8 horas
    
        String titulosCursosMayorA8Horas = listaCursos.stream()
                .filter(c -> c.getDuracion() > 8)
                .map(Curso::getTitulo)
                .collect(Collectors.joining(", "));

    
        // Ejemplo 6: Obtener el promedio de alumnos por curso
    
        double promedioAlumnosPorCurso = listaCursos.stream()
                .mapToInt(Curso::getAlumnos)
                .average()
                .orElse(0);

    
        // Ejemplo 7: Dividir cursos en dos listas, una para cursos cortos y otra para cursos largos
    
        Map<Boolean, List<Curso>> cursosCortosYlargos = listaCursos.stream()
                .collect(Collectors.partitioningBy(c -> c.getDuracion() <= 5));

    
        // Ejemplo 8: Convertir la lista de cursos a un mapa usando el título como clave
    
        Map<String, Curso> mapaCursosPorTitulo = listaCursos.stream()
                .collect(Collectors.toMap(Curso::getTitulo, curso -> curso));

    
        // Ejemplo 9: Calcular el total de duración de cursos con más de 100 alumnos
    
        double totalDuracionCursosConMasDe100Alumnos = listaCursos.stream()
                .filter(c -> c.getAlumnos() > 100)
                .mapToDouble(Curso::getDuracion)
                .sum();

    
        // Ejemplo 10: Encontrar el curso más popular (con más alumnos inscritos)
    
        Optional<Curso> cursoMasPopular = listaCursos.stream()
                .max(Comparator.comparingInt(Curso::getAlumnos));

    
        // Ejemplo 11: Obtener la lista de cursos ordenados por cantidad de alumnos
    
        List<Curso> cursosOrdenadosPorAlumnos = listaCursos.stream()
                .sorted(Comparator.comparingInt(Curso::getAlumnos))
                .collect(Collectors.toList());

    
        // Ejemplo 12: Verificar si hay cursos con duración mayor a 20 horas
    
        boolean hayCursosMayorA20Horas = listaCursos.stream()
                .anyMatch(c -> c.getDuracion() > 20);

    
        // Ejemplo 13: Sumar la duración de cursos con más de 50 videos
    
        double duracionTotalCursosConMasDe50Videos = listaCursos.stream()
                .filter(c -> c.getVideos() > 50)
                .mapToDouble(Curso::getDuracion)
                .sum();

    
        // Ejemplo 14: Obtener la lista de títulos de cursos distintos
    
        List<String> titulosCursosDistintos = listaCursos.stream()
                .map(Curso::getTitulo)
                .distinct()
                .collect(Collectors.toList());

    
        // Ejemplo 15: Obtener el curso con la mayor cantidad de videos
    
        Optional<Curso> cursoConMasVideos = listaCursos.stream()
                .max(Comparator.comparingInt(Curso::getVideos));

    
    
        // Ejemplo 16: Filtrar cursos con duración menor al promedio general
    
        double promedioDuracionGeneral = listaCursos.stream()
                .mapToDouble(Curso::getDuracion)
                .average()
                .orElse(0);
        List<Curso> cursosDuracionMenorAlPromedio = listaCursos.stream()
                .filter(c -> c.getDuracion() < promedioDuracionGeneral)
                .collect(Collectors.toList());

    
        // Ejemplo 17: Contar la cantidad de cursos con títulos que contienen la palabra "Java"
    
        long cantidadCursosConJavaEnElTitulo = listaCursos.stream()
                .filter(c -> c.getTitulo().contains("Java"))
                .count();

    
        // Ejemplo 18: Obtener la duración total de cursos con al menos 200 alumnos
    
        double duracionTotalCursosConMasDe200Alumnos = listaCursos.stream()
                .filter(c -> c.getAlumnos() > 200)
                .mapToDouble(Curso::getDuracion)
                .sum();

    
        // Ejemplo 19: Dividir cursos en grupos según la duración
    
        Map<Integer, List<Curso>> cursosPorDuracion = listaCursos.stream()
                .collect(Collectors.groupingBy(c -> (int) c.getDuracion()));

    
        // Ejemplo 20: Obtener la cantidad total de alumnos en todos los cursos
    
        long totalAlumnos = listaCursos.stream()
                .mapToLong(Curso::getAlumnos)
                .sum();
        
        */
        
}
