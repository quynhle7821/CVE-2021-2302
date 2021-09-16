# CVE-2021-2302

Author: quynhle

Gadget chain
 
    javax.management.BadAttributeValueExpException.readObject()
      oracle.security.jps.az.internal.common.principals.toString()
	    oracle.security.jps.az.internal.common.principals.getResolvedPrincipal()
	         . . . con.newInstance() . . .
	      com.tangosol.coherence.mvel2.sh.ShellSession()
	      com.tangosol.coherence.mvel2.sh.ShellSession.exec()
	              . . . MVEL expression . . .
      --->   RCE
      
# Lab Environment
- Orace Weblogic Server: 12.1.2.3
- Oracle Business Intelligence: 12.1.2.4
- Oracle Database 19c

# PoC
![gif](https://user-images.githubusercontent.com/34308443/133580416-7373d471-98c9-44a6-b8a5-2248a14e1209.gif)

