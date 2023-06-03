package ru.vsu.sviridov.carschedule.dto;

import ru.vsu.sviridov.carschedule.model.Car;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
@Data
public class RequestDto {

    private BigInteger id;
    private Car car;
    private String status;
    private String consumables;
    private LocalDateTime date;
}
