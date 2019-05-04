package org.courses.data.DAO.hbm;

import org.apache.commons.validator.routines.IntegerValidator;
import org.courses.domain.hbm.Composition;
import org.courses.domain.hbm.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class CompositionDao extends BaseDao<Composition, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public CompositionDao(SessionFactory factory) {
        super(factory, Composition.class);
    }


    @Override
    public Collection<Composition> find(String filter) {
        return null;
    }
}
