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
public interface Hello extends com.inprise.vbroker.CORBA.Object, HelloApp_Eppic.HelloOperations, org.omg.CORBA.portable.IDLEntity {
}
