package org.courses.web.soap;

import org.courses.domain.hbm.*;

import javax.jws.WebService;

import java.util.Collection;

@WebService
public
interface IManufactureService {
    void save(Collection<Manufacture> entity);
    Manufacture read(int id);
    Collection<Manufacture> readAll();
    Collection<Manufacture> find(String filter);
    void delete(int id);
}
