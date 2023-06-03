package ru.vsu.sviridov.carschedule.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Entity
@Table(name = "models")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @OneToOne
    @JoinColumn(name = "ID_brand", referencedColumnName = "id")
    private Brand brand;

    @Column(name = "model_name")
    private String modelName;

    public Model(Brand brand) {
        this.brand = brand;
    }
}
