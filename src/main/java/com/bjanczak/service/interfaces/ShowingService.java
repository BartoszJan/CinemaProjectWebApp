package com.bjanczak.service.interfaces;


import com.bjanczak.model.Showing;

import java.util.List;

public interface ShowingService {

    Showing getShowing(Integer showingId);

    List<Showing> getShowings();

    void addShowing(Showing showing);

    void deleteShowing(Showing showing);
}
