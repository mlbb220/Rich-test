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
public final class HelloHolder implements org.omg.CORBA.portable.Streamable {
public HelloApp_Eppic.Hello value;

public HelloHolder () {
}

public HelloHolder (final HelloApp_Eppic.Hello _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = HelloApp_Eppic.HelloHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  HelloApp_Eppic.HelloHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return HelloApp_Eppic.HelloHelper.type();
}
}
