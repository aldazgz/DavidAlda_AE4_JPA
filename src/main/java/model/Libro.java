package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import model.Editorial;
import model.Autor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private Double precio;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @ManyToMany(mappedBy = "libros",fetch = FetchType.EAGER)
    private List<Libreria> librerias;

    public Libro(String titulo, Double precio){
        this.titulo = titulo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo=" + titulo +
                ", precio=" + precio +
                ", editorial=" + (editorial != null ? editorial.getNombre() : "N/A") +
                ", autor=" + (autor != null ? autor.getNombre() : "N/A") +
                '}';
    }
}
