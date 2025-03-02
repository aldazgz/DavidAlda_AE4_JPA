import controlador.Handler;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;

import java.util.Date;

public class Main {
    private static Handler handler;

    public static void main(String[] args) {
        handler = new Handler();
        cargarDatos();
        handler.mostrarLibros();
        handler.mostrarAutores();
        handler.mostrarLibrerias();
        handler.mostrarLibrosLibrerias();
    }

    private static void cargarDatos() {
        Autor autor1 = new Autor("JRR", "Tolkien", new Date(1892-1973, 9, 2));
        Autor autor2 = new Autor("Miguel", "de Cervantes", new Date(1547-1900, 9, 29));
        Autor autor3 = new Autor("Carlos", "Ruiz Zafón", new Date(1964-2020, 7, 19));

        handler.agregarAutor(autor1);
        handler.agregarAutor(autor2);
        handler.agregarAutor(autor3);

        Editorial editorial1 = new Editorial("Editorial Penguin", "Nueva York");
        Editorial editorial2 = new Editorial("Editorial Planeta", "Barcelona");

        handler.agregarEditorial(editorial1);
        handler.agregarEditorial(editorial2);

        Libro libro1 = new Libro("El Señor de los Anillos", 19.99);
        Libro libro2 = new Libro("La Sombra del Viento", 24.99);
        Libro libro3 = new Libro("Don Quijote de la Mancha", 29.99);
        Libro libro4 = new Libro("El Hobbit", 14.99);
        Libro libro5 = new Libro("El Príncipe de la Niebla", 14.99);
        Libro libro6 = new Libro("El Juego del Ángel", 14.99);
        Libro libro7 = new Libro("El Silmarillion", 9.99);
        Libro libro8 = new Libro("Marina", 19.99);

        handler.agregarLibro(libro1, 1, 1);
        handler.agregarLibro(libro2, 3, 2);
        handler.agregarLibro(libro3, 2, 2);
        handler.agregarLibro(libro4, 1, 1);
        handler.agregarLibro(libro5, 3, 2);
        handler.agregarLibro(libro6, 3, 2);
        handler.agregarLibro(libro7, 1, 1);
        handler.agregarLibro(libro8, 3, 2);

        Libreria libreria1 = new Libreria("Librería Páginas", "José López", "Calle Falsa 123");
        Libreria libreria2 = new Libreria("Librería La Casa del Libro", "Marcos Valverde", "Avenida Zaragoza 14");

        handler.agregarLibreria(libreria1);
        handler.agregarLibreria(libreria2);

        handler.agregarLibroLibreria(1,1);
        handler.agregarLibroLibreria(2,1);
        handler.agregarLibroLibreria(3,1);
        handler.agregarLibroLibreria(4,1);
        handler.agregarLibroLibreria(5,2);
        handler.agregarLibroLibreria(6,2);
        handler.agregarLibroLibreria(7,2);
        handler.agregarLibroLibreria(8,2);

        System.out.println("Datos de prueba insertados");
    }
}
