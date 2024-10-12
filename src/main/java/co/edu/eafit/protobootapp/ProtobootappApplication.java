package co.edu.eafit.protobootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//App para hallar el cuadrado y el cubo de un número
//Se lanza y se ejecuta con http://localhost:8080 o la URL específica al proveedor cloud
@SpringBootApplication
@RestController
public class ProtobootappApplication {

    Calculadora calculadora;
    
    public static void main(String[] args) {
        SpringApplication.run(ProtobootappApplication.class, args);
    }

    //Se ejecuta con http://localhost:8080/
    @GetMapping("/")
    public String index() {
        return String.format("Bienvenido! Esta aplicación ayuda a elevar números cualquiera a sus potencias.");
    }    

    //Se ejecuta con http://localhost:8080/hola o http://localhost:8080/hola?nombre=John
    @GetMapping("/hola")
    public String hola(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre) {
        return String.format("Hola %s!", nombre);
    }
    
    //Se ejecuta con http://localhost:8080/cuadrado o http://localhost:8080/cuadrado?numero=5
    @GetMapping("/cuadrado")
    public String cuadrado(@RequestParam(value = "numero", defaultValue = "0") Double numero) {
        this.calculadora = new Calculadora();
        return String.format("El cuadrado de %f es %f", numero, this.calculadora.cuadrado(numero));
    }
    
    //Se ejecuta con http://localhost:8080/cubo o http://localhost:8080/cubo?numero=5
    @GetMapping("/cubo")
    public String cubo(@RequestParam(value = "numero", defaultValue = "0") Double numero) {
        this.calculadora = new Calculadora();
        return String.format("El cubo de %f es %f", numero, this.calculadora.cubo(numero));
    }
}
