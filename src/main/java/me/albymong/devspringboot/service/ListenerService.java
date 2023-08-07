package me.albymong.devspringboot.service;

import me.albymong.devspringboot.data.entity.ListenerEntity;

public interface ListenerService {

    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listener);

    void updateEntity(ListenerEntity listener);

    void removeEntity(ListenerEntity listener);

}
