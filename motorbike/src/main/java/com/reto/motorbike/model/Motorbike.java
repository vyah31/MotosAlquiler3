/**
*
*
* @author Sebas A.
*/

package com.reto.motorbike.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name = "motorbike")
@Getter //Se hace la anotación de Getter y Setter para hacer automaticamente 
@Setter // los constructores de los atributos.
public class Motorbike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String brand;
    @Column(name = "years") //La palabra 'year' es reservada de SQL. Por lo que se hace esta
    private Integer year;   //anotación para poder usar este atributo.
    private String description;

    /*Relaciones: Una categoria se relaciona con muchas motocicletas y una motocicleta
    sólo se relaciona con una categoria */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("motorbikes")
    private Category category;

    /*Relaciones: Una motocicleta se relaciona con muchos mensajes y un mensaje
    sólo se relaciona con una motocicleta */
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "motorbike")
    @JsonIgnoreProperties({ "motorbike", "client" })
    private List<Message> messages;

    /*Relaciones: Una motocicleta se relaciona con muchas reservaciones y una reservación
    sólo se relaciona con una motocicleta */
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "motorbike")
    @JsonIgnoreProperties({ "motorbike", "messages" })
    public List<Reservation> reservations;
}
