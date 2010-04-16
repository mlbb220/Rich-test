/*
 * Copyright (c) 2002-2009 Affiliated Computer Services, Inc.
 * All rights reserved.
 *
 * This item contains confidential and trade secret information and may not be
 * transferred, published, disclosed, reproduced, or used by any party without
 * the express written permission of Affiliated Computer Services, Inc.
 */

package rich.corba.eppic;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import java.io.FileInputStream;
import java.util.Properties;

public class HelloServerIOR
{

  public static void main(String args[])
  {
    try
    {
      Properties prop = new Properties();
      prop.load(HelloServerIOR.class
          .getResourceAsStream("/rich/corba/eppic/corba_prop"));
      // create and initialize the ORB
      String[] test = null;
      ORB orb = org.omg.CORBA.ORB.init(test, prop);
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      POA _poa;

      String _poaName = "test_poa";
      org.omg.CORBA.Policy[] policies = {
          rootpoa.create_lifespan_policy(LifespanPolicyValue.PERSISTENT),
          rootpoa.create_id_assignment_policy(IdAssignmentPolicyValue.USER_ID) };
      // Create myPOA with the right policies
      _poa = rootpoa.create_POA(_poaName, rootpoa.the_POAManager(), policies);

      
      Servant servant = new HelloImpl();
      String name = "Hello1";
      
      _poa.activate_object_with_id(name.getBytes(), servant);
      // get reference to rootpoa & activate the POAManager

      // get object reference from the servant
      org.omg.CORBA.Object ref = _poa.servant_to_reference(servant);

      System.out.println(orb.object_to_string(ref));
      System.out.println("HelloServer ready and waiting ...");

      // wait for invocations from clients
      rootpoa.the_POAManager().activate();
      orb.run();
    }

    catch (Exception e)
    {
      System.err.println("ERROR: " + e);
      e.printStackTrace(System.out);
    }

    System.out.println("HelloServer Exiting ...");

  } // end main
} // end class
