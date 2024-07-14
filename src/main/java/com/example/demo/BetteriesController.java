package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/batteries")
public class BetteriesController {

    @Autowired
    BetteriesService service;

    @PostMapping
    public Object save(@Valid @RequestBody Betteries body){
        try {
            return service.save(body);
        } catch (Exception e) {
            return e;
        }
    }

    @GetMapping
    public Map<String, Object> getBatteries(@RequestParam String postcodeRange) {
        String[] range = postcodeRange.split("-");
        String startPostcode = range[0];
        String endPostcode = range[1];

        List<Betteries> batteries = service.getBatteriesByPostcodeRange(startPostcode, endPostcode);

        List<String> batteryNames = batteries.stream()
                .map(Betteries::getName)
                .collect(Collectors.toList());

        int totalWattCapacity = batteries.stream()
                .mapToInt(Betteries::getWattCapacity)
                .sum();

        double averageWattCapacity = batteries.isEmpty() ? 0 : (double) totalWattCapacity / batteries.size();

        return Map.of(
                "batteryNames", batteryNames,
                "statistics", Map.of(
                        "totalWattCapacity", totalWattCapacity,
                        "averageWattCapacity", averageWattCapacity
                )
        );
    }


}
