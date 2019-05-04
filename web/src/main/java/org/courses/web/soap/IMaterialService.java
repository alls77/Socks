package org.courses.web.soap;

import org.courses.domain.hbm.*;

import javax.jws.WebService;

import java.util.Collection;

@WebService
public
interface IMaterialService {
    void save(Collection<Material> entity);
    Material read(int id);
    Collection<Material> readAll();
    Collection<Material> find(String filter);
    void delete(int id);
}