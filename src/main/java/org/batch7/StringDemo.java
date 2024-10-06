package org.batch7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringDemo {

    public static void main(String[] args){
        Logger log = LogManager.getLogger("StringDemo");


        log.info("for information only"); // info message
        log.debug("For debug message");
        log.error("For error message");
        log.warn("for warning message");
        log.fatal("for fatal message");
        log.trace("for trace message");


    }
}
