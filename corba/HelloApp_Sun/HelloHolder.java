package HelloApp_Sun;

/**
* HelloApp/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from hello.idl
* Thursday, July 9, 2009 10:40:28 AM CST
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public HelloApp_Sun.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (HelloApp_Sun.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloApp_Sun.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloApp_Sun.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloApp_Sun.HelloHelper.type ();
  }

}
