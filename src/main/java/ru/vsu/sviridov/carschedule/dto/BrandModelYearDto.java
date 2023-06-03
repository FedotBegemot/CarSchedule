package ru.vsu.sviridov.carschedule.dto;

import lombok.Data;
import ru.vsu.sviridov.carschedule.model.Model;

import java.math.BigInteger;

@Data
public class BrandModelYearDto {

    private BigInteger id;
    private Model model;
    private Integer year;

}
