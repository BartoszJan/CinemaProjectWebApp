package com.bjanczak.service;

import com.bjanczak.model.Showing;
import com.bjanczak.repository.ShowingRepository;
import com.bjanczak.service.interfaces.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingServiceImpl implements ShowingService {

    @Autowired
    private ShowingRepository showingRepository;

    @Override
    public Showing getShowing(Integer showingId) {
        return showingRepository.getOne(showingId);
    }

    @Override
    public List<Showing> getShowings() {
        return showingRepository.findAll();
    }

    @Override
    public void addShowing(Showing showing) {
        showingRepository.save(showing);
    }

    @Override
    public void deleteShowing(Showing showing) {
        showingRepository.delete(showing);
    }
}
