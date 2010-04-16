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

public class HelloClient
{
  static Hello helloImpl;
  String[] x = new String[6];

  public static void main(String args[])
  {
    try
    {
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      System.out.println("ORB initialised\n");

      // get the root naming context
      org.omg.CORBA.Object objRef = orb
          .resolve_initial_references("NameService");

      // Use NamingContextExt instead of NamingContext,
      // part of the Interoperable naming Service.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // resolve the Object Reference in Naming
      String name = "Hello1";
      helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

      System.out.println("Obtained a handle on server object: " + helloImpl);
      System.out.println(helloImpl.sayHello());
      helloImpl.shutdown();

    } catch (Exception e)
    {
      System.out.println("ERROR : " + e);
      e.printStackTrace(System.out);
    }
  } // end main

} // end class
