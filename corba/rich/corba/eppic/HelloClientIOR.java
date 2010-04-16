/*
 * Copyright (c) 2002-2009 Affiliated Computer Services, Inc.
 * All rights reserved.
 *
 * This item contains confidential and trade secret information and may not be
 * transferred, published, disclosed, reproduced, or used by any party without
 * the express written permission of Affiliated Computer Services, Inc.
 */

package rich.corba.eppic;


import java.util.Properties;

import HelloApp_Eppic.Hello;
import HelloApp_Eppic.HelloHelper;

public class HelloClientIOR
{
  
  public static Class[] NARROW_PARAMS = null;
  static
  {
    try
    {
      NARROW_PARAMS = new Class[1];
      NARROW_PARAMS[0] = Class.forName("org.omg.CORBA.Object");
    }
    catch (ClassNotFoundException e)
    {
    }
  }
  static Hello helloImpl;
  String[] x = new String[6];

  public static void main(String args[])
  {
    try
    {
      Properties prop = new Properties();
      prop.load(HelloServerIOR.class
          .getResourceAsStream("/rich/corba/eppic/corba_prop"));
      // create and initialize the ORB
      String[] test = null;
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(test, prop);
      // create and initialize the ORB

      System.out.println("ORB initialised\n");
      String ior = "IOR:000000000000001749444c3a48656c6c6f4170702f48656c6c6f3a312e30000000000001000000000000006c000102000000000e31302e3233372e38312e313639000fee00000021afabcb00000000205d84ef1c00000001000000000000000000000004000000000a0000000000000100000001000000200000000000010001000000020501000100010020000101090000000100010100";

      org.omg.CORBA.Object helloIOR = orb.string_to_object(ior);
      Object[] objs = {helloIOR};
      com.inprise.vbroker.CORBA.Object helloTest = (com.inprise.vbroker.CORBA.Object) 
        (Class.forName("HelloApp_Eppic.HelloHelper").getMethod("narrow", NARROW_PARAMS).invoke(null, objs));

      
      
      boolean bound = !helloTest._non_existent();
      if (bound || helloTest._is_local())
      {
        System.out.println("not bound");
      } else
      {
        System.out.println(helloTest);
      }

    } catch (Exception e)
    {
      System.out.println("ERROR : " + e);
      e.printStackTrace(System.out);
    }
  } // end main

} // end class
