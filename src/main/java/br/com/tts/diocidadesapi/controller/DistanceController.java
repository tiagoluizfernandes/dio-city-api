package br.com.tts.diocidadesapi.controller;

import br.com.tts.diocidadesapi.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tiago Luiz Fernandes
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/distances")
public class DistanceController {

    Logger logger = LoggerFactory.getLogger((DistanceController.class));

    private final DistanceService distanceService;

    @GetMapping(path = "/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam( name="from") Long city1,
                                   @RequestParam( name="to") Long city2 ){
        logger.info("byPoints");

        return ResponseEntity.ok(distanceService.distanceByPointsInMiles(city1,city2));

    }

    @GetMapping(path = "/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam( name="from") Long city1,
                         @RequestParam( name="to") Long city2 ){
        logger.info("byCube");

        return ResponseEntity.ok(distanceService.distanceByCubeInMeters(city1,city2));

    }

}
