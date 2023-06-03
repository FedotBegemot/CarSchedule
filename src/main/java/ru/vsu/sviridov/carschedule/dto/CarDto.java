package ru.vsu.sviridov.carschedule.dto;

import lombok.Data;
import ru.vsu.sviridov.carschedule.model.BrandModelYear;
import ru.vsu.sviridov.carschedule.model.Owner;

@Data
public class CarDto {

    private String vinCode;
    private Owner owner;
    private BrandModelYear brandModelYear;
    private String licensePlate;
    private String colour;
    private String bodyNumber;
    private Integer engineNumber;
    private String engineModel;

}
