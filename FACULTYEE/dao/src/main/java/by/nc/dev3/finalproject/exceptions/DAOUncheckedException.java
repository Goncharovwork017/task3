package by.nc.dev3.finalproject.exceptions;

/**
 * Created by ivan on 03.05.2017.
 */
public class DAOUncheckedException extends RuntimeException {

    public DAOUncheckedException() {
    }

    public DAOUncheckedException(String message) {
        super(message);
    }

    public DAOUncheckedException(Exception e) {

            super(e);
    }
}
