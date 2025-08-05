package com.example.stubdemo;

import com.example.stubdemo.dto.ResponseItem;
import com.example.stubdemo.dto.ResponseWrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StubController {

    @PostMapping(
            value = "/test",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseWrapper test(@RequestBody Map<String, Integer> body) {
        int count = body.getOrDefault("count", 1);
        List<ResponseItem> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String fn = "FirstName-" + i;
            String ln = "LastName-" + i;
            list.add(new ResponseItem(fn, ln));
        }

        return new ResponseWrapper(list);
    }
}