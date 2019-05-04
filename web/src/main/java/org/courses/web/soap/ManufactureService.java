package org.courses.web.soap;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Manufacture;
import org.courses.web.soap.IManufactureService;
import org.courses.web.soap.ITypeService;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.IManufactureService",
        serviceName = "ManufactureService"
)
public class ManufactureService implements IManufactureService {

    DAO<Manufacture, Integer> dao;
    public ManufactureService(DAO<Manufacture, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void save(Collection<Manufacture> entity) {
        dao.save(entity);
    }

    @Override
    public Manufacture read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Manufacture> readAll() {
        return dao.readAll();
    }

    @Override
    public Collection<Manufacture> find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
