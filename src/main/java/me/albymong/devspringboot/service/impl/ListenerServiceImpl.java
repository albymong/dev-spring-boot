package me.albymong.devspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.albymong.devspringboot.data.entity.ListenerEntity;
import me.albymong.devspringboot.data.repository.ListenerRepository;
import me.albymong.devspringboot.service.ListenerService;

@Service
public class ListenerServiceImpl implements ListenerService {

    private ListenerRepository listenerRepository;

    @Autowired
    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public ListenerEntity getEntity(Long id) {
        return listenerRepository.findById(id).get();
    }

    @Override
    public void saveEntity(ListenerEntity listener) {
        listenerRepository.save(listener);
    }

    @Override
    public void updateEntity(ListenerEntity listener) {
        ListenerEntity foundListener = listenerRepository.findById(listener.getId()).get();
        foundListener.setName(listener.getName());

        listenerRepository.save(foundListener);
    }

    @Override
    public void removeEntity(ListenerEntity listener) {
        listenerRepository.delete(listener);
    }
}
