package example.micronaut.gateway;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        System.out.println("MICRONAUT_HTTP_SERVICES_BOOKS_URL=" + System.getenv("MICRONAUT_HTTP_SERVICES_BOOKS_URL"));
        Micronaut.run(Application.class);
    }
}