package by.nc.dev3.finalproject.abstracts;

import by.nc.dev3.finalproject.entities.AbstractEntity;
import by.nc.dev3.finalproject.service.IDAOService;
import by.nc.dev3.finalproject.utils.HibernateUtil;

/**
 * Created by ivan on 08.05.2017.
 */
public abstract class AbstractService<T extends AbstractEntity> implements IDAOService<T> {
    protected static HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    protected final String TRANSACTION_SUCCEEDED = "Transaction succeeded";
    protected final String TRANSACTION_FAILED = "Error was thrown in service: ";


}
