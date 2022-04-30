package com.company.warehouse.service;

import com.company.warehouse.entity.Measurement;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementSer(Measurement measurement){
        boolean byName = measurementRepository.existsByName(measurement.getName());
        if (byName){
            return new Result("bunday ulchov birligi mavjud",false);
        }

        measurementRepository.save(measurement);
        return new Result("muvaffaqiyatli saqlandi",true);
    }

    public List<Measurement> getMeasurementList(){
        List<Measurement> all = measurementRepository.findAll();
        return all;
    }

    public Measurement getMeasurementId(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            Measurement measurement = optionalMeasurement.get();
            return measurement;
        }
        return new Measurement();
    }

    public Result deleteMeasurement(Integer id) {
        measurementRepository.deleteById(id);
        return new Result("measurement delete", true);
    }

    public Result editMeasurement(Integer id, Measurement measurement){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()){
            return new Result("bunday measurement bazada mavjud emas",false);
        }
        Measurement measurement1 = optionalMeasurement.get();
        measurement1.setName(measurement.getName());
        measurement1.setActive(measurement.isActive());
        measurementRepository.save(measurement1);
        return new Result("ulchov birligi uzgartirildi", true);
    }
}
