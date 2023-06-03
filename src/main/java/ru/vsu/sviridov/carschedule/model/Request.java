package ru.vsu.sviridov.carschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @OneToOne
    @JoinColumn(name = "car_vin_code", referencedColumnName = "vin_code")
    private Car car;

    @Column(name = "status")
    private String status;

    @Column(name = "consumables")
    private String consumables;

    @Column(name = "application_date")
    private LocalDate date;

    public Request(Car car) {
        this.car = car;
        this.date = LocalDate.now();
    }
}

