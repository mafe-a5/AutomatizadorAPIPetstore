package karate;

import com.intuit.karate.junit5.Karate;

public class CicloVidaOrden {
    @Karate.Test
    Karate testCicloDeVida() {
        return Karate.run("CicloVidaOrden").relativeTo(getClass());
    }
}