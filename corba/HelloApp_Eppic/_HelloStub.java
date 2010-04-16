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
public class _HelloStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements HelloApp_Eppic.Hello {
  final public static java.lang.Class _opsClass = HelloApp_Eppic.HelloOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:HelloApp/Hello:1.0"
  };

  /**
   * <pre>
   *   string sayHello ();
   * </pre>
   */
  public java.lang.String sayHello () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      java.lang.String _result;
      try {
        _output = this._request("sayHello", true);
        _input = this._invoke(_output);
        _result = _input.read_string();
        return _result;
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.portable.RemarshalException _exception) {
        continue;
      }
      finally {
        this._releaseReply(_input);
      }
    } else {
      final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("sayHello", _opsClass);
      if (_so == null) {
        continue;
      }
      final HelloApp_Eppic.HelloOperations _self = (HelloApp_Eppic.HelloOperations)_so.servant;
      try {
        return _self.sayHello();
      }
      finally {
        _servant_postinvoke(_so);
      }
    }
    }
  }

  /**
   * <pre>
   *   oneway void shutdown ();
   * </pre>
   */
  public void shutdown () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      try {
        _output = this._request("shutdown", false);
        _input = this._invoke(_output);
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.portable.RemarshalException _exception) {
        continue;
      }
      finally {
        this._releaseReply(_input);
      }
    } else {
      final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("shutdown", _opsClass);
      if (_so == null) {
        continue;
      }
      final HelloApp_Eppic.HelloOperations _self = (HelloApp_Eppic.HelloOperations)_so.servant;
      try {
        _self.shutdown();
      }
      finally {
        _servant_postinvoke(_so);
      }
    }
    break;
    }
  }

}
