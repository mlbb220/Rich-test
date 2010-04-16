/*
 * Copyright (c) 2002-2009 Affiliated Computer Services, Inc.
 * All rights reserved.
 *
 * This item contains confidential and trade secret information and may not be
 * transferred, published, disclosed, reproduced, or used by any party without
 * the express written permission of Affiliated Computer Services, Inc.
 */

package rich.corba.sun;

import HelloApp_Sun.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import java.util.Properties;

public class HelloServer {

  public static void main(String args[]) {
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa =
        (POA)orb.resolve_initial_references("RootPOA");
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      HelloImpl helloImpl = new HelloImpl();
      helloImpl.setORB(orb);

      // get object reference from the servant
      org.omg.CORBA.Object ref =
        rootpoa.servant_to_reference(helloImpl);


      // and cast the reference to a CORBA reference
      Hello href = HelloHelper.narrow(ref);
  
      // get the root naming context
      // NameService invokes the transient name service
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Use NamingContextExt, which is part of the
      // Interoperable Naming Service (INS) specification.
      NamingContextExt ncRef =
        NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "Hello1";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println
        ("HelloServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();
    }
 
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
  
      System.out.println("HelloServer Exiting ...");
 
  } //end main
} // end class