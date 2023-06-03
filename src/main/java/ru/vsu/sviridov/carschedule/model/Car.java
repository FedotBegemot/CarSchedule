package ru.vsu.sviridov.carschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @Column(name = "vin_code")
    private String vinCode;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    @OneToOne
    @JoinColumn(name = "model_year_id", referencedColumnName = "id")
    private BrandModelYear brandModelYear;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "colour")
    private String colour;

    @Column(name = "body_number")
    private String bodyNumber;

    @Column(name = "engine_number")
    private Integer engineNumber;

    @Column(name = "engine_model")
    private String engineModel;

    public Car(Owner owner, BrandModelYear brandModelYear) {
        this.owner = owner;
        this.brandModelYear = brandModelYear;
    }
}
