package net.f3322.godlw.service.Impl;

import net.f3322.godlw.entity.ClientEntity;
import net.f3322.godlw.mapper.ClientMapper;
import net.f3322.godlw.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientEntity> findAll() {
        List<ClientEntity> clientEntities=clientMapper.findAll();
        return null;
    }

    @Override
    public int addClient(ClientEntity clientEntity) {

        return clientMapper.addClient(clientEntity);
    }

    public int insertorupdate(){
        int flag=0;

        return  flag;
    }
}
