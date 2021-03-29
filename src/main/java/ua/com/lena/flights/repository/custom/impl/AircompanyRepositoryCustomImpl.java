package ua.com.lena.flights.repository.custom.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lena.flights.repository.custom.AircompanyRepositoryCustom;

import javax.persistence.EntityManager;

@Repository
public class AircompanyRepositoryCustomImpl implements AircompanyRepositoryCustom {
    private final EntityManager entityManager;

    public AircompanyRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public int drop(long id) {
        return entityManager
                .createNativeQuery("delete from aircompany where id = ? and " +
                        "not exists(select * from flight where aircompany_id = ?) and " +
                        "not exists(select * from airplane where aircompany_id = ?)")
                .setParameter(1, id)
                .setParameter(2, id)
                .setParameter(3, id)
                .executeUpdate();
    }
}
