package net.f3322.godlw.mapper;


import net.f3322.godlw.entity.ClientEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {
    List<ClientEntity> findAll();
    int addClient(ClientEntity clientEntity);
    int updateClient(ClientEntity clientEntity);
}
