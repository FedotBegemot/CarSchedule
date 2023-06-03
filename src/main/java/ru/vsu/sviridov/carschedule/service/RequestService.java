package ru.vsu.sviridov.carschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.sviridov.carschedule.model.Request;
import ru.vsu.sviridov.carschedule.repository.RequestRepository;

import java.math.BigInteger;

@Service
@Transactional(readOnly = true)
public class RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Iterable<Request> getRequests() {
        return requestRepository.findAll();
    }

    @Transactional
    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    @Transactional
    public void delete(Integer id) {
        requestRepository.deleteById(id);
    }

//    public Request getRequest(Integer id) {
//        return RequestRepository.findById(id).orElseThrow(ProductNotFoundException::new);
//    }

//    @Transactional
//    public void deleteByName(String name) {
//        requestRepository.deleteByName(name);
//    }

    @Transactional
    public BigInteger insertOnConflict(Request request) {
        return requestRepository.insertOnConflict(request.getCar().getVinCode());
    }

}
