/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JUnitMockito;

/**
 *
 * @author santi
 */

//COMENTARIO:
/*
-Para hacer una prueba Unitaria primero necesitamos la clase, con sus metodos, a la que queremos hacerle la prueba. Por ejemplo OperacionesMatematicas
-Compilamos el proyecto y luego en la carpeta Project Files del proyecto abrimos pom.xml. Dentro copiamos dentro de la entiqueta <dependencies> lo siguente:
    
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.8.0</version>
        <scope>test</scope>
    </dependency>

-Luego volvemos a compilar el proyecto y comprobamos en la carpeta Test Dependencies que existe "mockito-core-5.8.0.jar"
-En la clase que vamos a realizar la prueba le hacemos al archivo de la clase click derecho y buscamos "Tools". Dentro buscamos "Create/Update Tests", creamos el test
-Se creará una carpeta nueva llamada Test Package con la clase nueva. Para ver si funciona el test hacemos click derecho en ese archivo y seleccionamos Test File

*/

public class OperacionesMatematicas{

    private Servicio servicio;

    public OperacionesMatematicas(Servicio servicio){
        this.servicio = servicio;
    }
    
    public int sumar(int a, int b){
        return this.servicio.sumar(a, b);
    }
    
    public int restar(int a, int b){
        return this.servicio.restar(a, b);
    }

    
}
