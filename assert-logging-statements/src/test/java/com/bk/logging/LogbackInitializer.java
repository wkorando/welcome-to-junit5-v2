package com.bk.logging;

import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Example of creating a custom JUnit5 annotation. Can simply annotate test
 * class with @LogbackInitializer to achieve same effect of
 * of @ExtendWith(LogbackInitializerExtension.class)
 * 
 * @author William.Korando
 *
 */
@ExtendWith(LogbackInitializerExtension.class)
public @interface LogbackInitializer {

}
