package org.courses.web.soap;

import org.courses.domain.hbm.Type;

import javax.jws.WebService;

import java.util.Collection;

@WebService
public interface ITypeService {
    void save(Collection<Type> entity);
    Type read(int id);
    Collection<Type> readAll();
    Collection<Type> find(String filter);
    void delete(int id);
}