package com.service;

import com.model.Smartphone;
import com.repository.ISmartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneService implements ISmartPhoneService{
    @Autowired
    private ISmartRepository smartRepository;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        smartRepository.deleteById(id);
    }
}
