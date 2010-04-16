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
public interface HelloOperations {
  /**
   * <pre>
   *   string sayHello ();
   * </pre>
   */
  public java.lang.String sayHello ();

  /**
   * <pre>
   *   oneway void shutdown ();
   * </pre>
   */
  public void shutdown ();

}
