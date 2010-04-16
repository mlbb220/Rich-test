
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
public class HelloPOATie extends HelloPOA {
  private HelloApp_Eppic.HelloOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public HelloPOATie (final HelloApp_Eppic.HelloOperations _delegate) {
    this._delegate = _delegate;
  }

  public HelloPOATie (final HelloApp_Eppic.HelloOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public HelloApp_Eppic.HelloOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final HelloApp_Eppic.HelloOperations delegate) {
    this._delegate = delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   string sayHello ();
   * </pre>
   */
  public java.lang.String sayHello () {
    return this._delegate.sayHello();
  }

  /**
   * <pre>
   *   oneway void shutdown ();
   * </pre>
   */
  public void shutdown () {
    this._delegate.shutdown();
  }

}
