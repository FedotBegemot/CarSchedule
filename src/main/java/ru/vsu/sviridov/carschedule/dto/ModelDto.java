package ru.vsu.sviridov.carschedule.dto;

import lombok.Data;
import ru.vsu.sviridov.carschedule.model.Brand;

import java.math.BigInteger;
@Data
public class ModelDto {

    private BigInteger id;
    private Brand brand;
    private String modelName;

}
