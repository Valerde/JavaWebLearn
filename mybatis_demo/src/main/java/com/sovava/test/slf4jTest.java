package com.sovava.test;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月16日 22:53
 **/
public class slf4jTest {
    protected  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test(){
//        while (true)
            this.logger.debug(String.valueOf(Math.random()));
    }



}
