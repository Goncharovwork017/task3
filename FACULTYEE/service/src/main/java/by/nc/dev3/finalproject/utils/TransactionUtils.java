package by.nc.dev3.finalproject.utils;

import by.nc.dev3.finalproject.exceptions.DAOUnException;
import by.nc.dev3.finalproject.exceptions.ServiceException;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 * Created by ivan on 09.05.2017.
 */
public class TransactionUtils {

    private static final String TRANSACTION_ROLLBACK_FAILED = "Error while rollback transaction: ";

    private TransactionUtils(){}

    public static void rollback(Transaction transaction, DAOUnException e) throws ServiceException {
        if(transaction != null){
            try {
                transaction.rollback();
            }
            catch(HibernateException he){
                throw new ServiceException(TRANSACTION_ROLLBACK_FAILED + e);
            }
        }
    }
}
