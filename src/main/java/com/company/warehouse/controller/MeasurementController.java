package com.company.warehouse.controller;

import com.company.warehouse.entity.Measurement;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurment(@RequestBody Measurement measurement){
        Result result = measurementService.addMeasurementSer(measurement);
        return result;
    }

    @GetMapping
    public List<Measurement>  getListMeasurement(){
        List<Measurement> measurementList = measurementService.getMeasurementList();
        return measurementList;
    }

    @GetMapping("/{id}")
    public Measurement getMeasurementId(@PathVariable Integer id){
        Measurement measurement = measurementService.getMeasurementId(id);
        return measurement;
    }
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        Result result = measurementService.deleteMeasurement(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement){
        Result result = measurementService.editMeasurement(id, measurement);
        return result;
    }

}
