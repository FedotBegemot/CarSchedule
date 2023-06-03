package ru.vsu.sviridov.carschedule.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.sviridov.carschedule.model.Request;
import ru.vsu.sviridov.carschedule.service.RequestService;

@RestController
@RequestMapping("api/requests")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public Iterable<Request> getRequests() {
        return requestService.getRequests();
    }

//    @GetMapping("/{id}")
//    public Request getStore(@PathVariable("id") Integer id) {
//        return requestService.getRequest(id);
//    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody Request request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
        requestService.addRequest(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
//        requestService.getRequest(id);
        requestService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
