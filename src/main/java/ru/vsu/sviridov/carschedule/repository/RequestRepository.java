package ru.vsu.sviridov.carschedule.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vsu.sviridov.carschedule.model.Request;

import java.math.BigInteger;

public interface RequestRepository extends CrudRepository<Request, Integer> {

    @Query(value = "insert into requests (application_date, status, car_vin_code, consumables) " +
            "values (:application_date, :status, :car_vin_code, :consumables) " +
            "ON CONFLICT(car_vin_code) DO UPDATE SET car_vin_code = excluded.car_vin_code RETURNING id;",
            nativeQuery = true)

    BigInteger insertOnConflict(@Param("car_vin_code") String car_vin_code);
}
