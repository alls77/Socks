package org.courses.web.soap;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Type;
import org.courses.web.soap.ITypeService;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.ITypeService",
        serviceName = "TypeService"
)
public class TypeService implements ITypeService {


    DAO<Type, Integer> dao;
    public TypeService(DAO<Type, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void save(Collection<Type> entity) {
        dao.save(entity);
    }

    @Override
    public Type read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Type> readAll() {
        return dao.readAll();
    }

    @Override
    public Collection<Type> find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
