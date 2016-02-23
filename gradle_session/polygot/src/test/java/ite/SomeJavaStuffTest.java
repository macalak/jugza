package ite;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import java.io.PrintStream;

/**
 * Created by macalaki on 2/23/2016.
 */
public class SomeJavaStuffTest {
    private SomeStuff javaStuff;

    @Mock
    private PrintStream output;


    @Before
    public void beforeTest(){
        initMocks(this);
        javaStuff = new SomeJavaStuff(output);
    }

    @Test
    public void shouldDoJavaStuff() {
        javaStuff.doStuff();
        verify(output,times(1)).println("I'm doing some Java stuff...");
    }
}
