package top.afool.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.afool.demo.service.StreamService;

@RestController
@RequestMapping("/stream")
public class StreamController {

    @Autowired
    private StreamService service;

    @PostMapping("/output")
    public ResponseEntity<String> send(@RequestBody String message) {
        boolean succeeded = service.sendToOutputChannel(message);

        return succeeded ? new ResponseEntity<>(message, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
