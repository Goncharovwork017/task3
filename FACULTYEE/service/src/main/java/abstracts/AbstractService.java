package abstracts;

import entities.AbstractEntity;
import service.IService;
import utils.HibernateUtil;

/**
 * Created by ivan on 14.05.2017.
 */
public abstract class AbstractService<T extends AbstractEntity> implements IService<T> {
    protected static HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    protected final String TRANSACTION_SUCCEEDED = "Transaction succeeded";
    protected final String TRANSACTION_FAILED = "Error was thrown in service: ";
}
