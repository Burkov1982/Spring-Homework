package com.spring.service;

import com.spring.config.converters.ManufacturerConverter;
import com.spring.dao.ManufacturerRepository;
import com.spring.dao.model.Manufacturer;
import com.spring.dto.ManufacturerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerConverter manufacturerConverter;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository, ManufacturerConverter manufacturerConverter) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerConverter = manufacturerConverter;
    }

    public List<ManufacturerDTO> getAll(){
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        if (!manufacturers.isEmpty()) {
            return manufacturers.stream()
                    .map(manufacturerConverter::fromManufacturer)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Manufacturers not found");
        }
    }

    public ManufacturerDTO findById(UUID uuid) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(uuid);
        return manufacturer.map(manufacturerConverter::fromManufacturer)
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
    }

    public void saveOrUpdate(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void delete(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = manufacturerConverter.toManufacturer(manufacturerDTO);
        manufacturerRepository.delete(manufacturer);
    }
}
