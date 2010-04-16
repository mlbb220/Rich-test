package HelloApp_Eppic;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "hello.idl"
 * <li> <b>IDL Name</b>      ::HelloApp::Hello
 * <li> <b>Repository Id</b> IDL:HelloApp/Hello:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface Hello {
  ...
};
 * </pre>
 */
public abstract class HelloPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, HelloApp_Eppic.HelloOperations {

  public HelloApp_Eppic.Hello _this () {
   return HelloApp_Eppic.HelloHelper.narrow(super._this_object());
  }

  public HelloApp_Eppic.Hello _this (org.omg.CORBA.ORB orb) {
    return HelloApp_Eppic.HelloHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:HelloApp/Hello:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("sayHello", new int[] { 0, 0 });
    _methods.put("shutdown", new int[] { 0, 1 });
  }

  public org.omg.CORBA.portable.OutputStream _invoke (java.lang.String opName,
                                                      org.omg.CORBA.portable.InputStream _input,
                                                      org.omg.CORBA.portable.ResponseHandler handler) {
    int[] method = (int[]) _methods.get(opName);
    if (method == null) {
      throw new org.omg.CORBA.BAD_OPERATION();
    }
    switch (method[0]) {
      case 0: {
        return HelloApp_Eppic.HelloPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (HelloApp_Eppic.HelloOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
      java.lang.String _result = _self.sayHello();
      _output = _handler.createReply();
      _output.write_string((java.lang.String)_result);
      return _output;
    }
    case 1: {
      _self.shutdown();
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }
  }
}
