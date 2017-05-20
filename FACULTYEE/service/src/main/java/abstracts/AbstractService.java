package abstracts;

import dao.IDAO;
import entities.AbstractEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import service.IService;
import utils.HibernateUtil;

/**
 * Created by ivan on 14.05.2017.
 */

public abstract class AbstractService<T extends AbstractEntity> implements IService<T> {


    private static Logger logger = Logger.getLogger(AbstractService.class);

    private IDAO<T> dao;

   protected AbstractService(IDAO<T> dao){this.dao = dao;}
}
