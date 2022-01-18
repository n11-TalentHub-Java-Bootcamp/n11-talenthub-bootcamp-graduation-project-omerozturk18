package com.omerozturk.N11GraduationProject.gen.utilities.service;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
//@NoArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity,D extends JpaRepository> {

    private D dao;

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E e){
        return (E) dao.save(e);
    }

    public void delete(E e){
        dao.delete(e);
    }

    public D getDao() {
        return dao;
    }
}
