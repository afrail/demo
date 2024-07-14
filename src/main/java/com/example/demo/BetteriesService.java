package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetteriesService {

    @Autowired
    BetteriesRepo repo;

    Betteries save (Betteries body){
        return repo.save(body);
    }

    public List<Betteries> getBatteriesByPostcodeRange(String startPostcode, String endPostcode) {
        return repo.findByPostCodeBetween(startPostcode, endPostcode);
    }

}
