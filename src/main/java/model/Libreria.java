package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "librerias")
public class Libreria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String dueno;
    @Column
    private String direccion;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "librerias_libros", joinColumns = @JoinColumn(name = "libreria_id"),inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;

    public Libreria(String nombre, String dueno, String direccion){
        this.nombre = nombre;
        this.dueno = dueno;
        this.direccion = direccion;
    }
}
