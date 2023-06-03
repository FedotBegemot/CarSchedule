package ru.vsu.sviridov.carschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Entity
@Table(name = "brand_model_year")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandModelYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @OneToOne
    @JoinColumn(name = "ID_model", referencedColumnName = "id")
    private Model model;

    @Column(name = "year")
    private Integer year;

    public BrandModelYear(Model model) {
        this.model = model;
    }
}
