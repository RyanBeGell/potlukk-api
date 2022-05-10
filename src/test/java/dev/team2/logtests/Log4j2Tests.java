package dev.team2.logtests;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class Log4j2Tests {
    @Test
    void All_Types_log_test(){
        log.info("This is a log test");
        log.debug("This is a log test");
        log.error("This is a log test");
        log.warn("This is a log test");
    }
}
