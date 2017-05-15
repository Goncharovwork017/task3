import org.apache.log4j.Logger;

/**
 * Created by ivan on 14.05.2017.
 */
public class test {

    final static Logger logger = Logger.getLogger(test.class);

    public static void main(String[] args) {

        test obj = new test();
        obj.runMe("mkyong");
    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }


}
