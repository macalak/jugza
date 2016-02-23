package ite

import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.MockitoAnnotations.initMocks

/**
 * Created by macalaki on 2/23/2016.
 */
class SomeGroovyStuffTest {
    private SomeStuff groovyStuff;

    @Mock PrintStream output

    @Before void beforeTest() {
        initMocks(this)
        groovyStuff = new SomeGroovyStuff(output)
    }

    @Test void shouldDoSomethingGroovy() {
        groovyStuff.doStuff()
        verify(output, times(1)).println("I'm doing some groovy stuff ...")
    }

}
