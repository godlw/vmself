package net.f3322.godlw.service;

import net.f3322.godlw.entity.ClientEntity;
import net.f3322.godlw.mapper.ClientMapper;

import java.util.List;

public interface ClientService {
    List<ClientEntity> findAll();
    int addClient(ClientEntity clientEntity);
}
