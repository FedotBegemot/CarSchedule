package ru.vsu.sviridov.carschedule.dto;

import lombok.Data;

import java.math.BigInteger;
@Data
public class OwnerDto {

    private BigInteger id;
    private String name;
    private String phoneNumber;
    private String email;

}
