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

public class HelloImpl extends HelloPOA

{
  private ORB orb;

  public void setORB(ORB orb_val)
  {
    orb = orb_val;
  }

  // implement sayHello() method
  public String sayHello()
  {
    return "\nHello world !!\n";
  }

  // implement shutdown() method
  public void shutdown()
  {
    orb.shutdown(false);
  }
} // end class
