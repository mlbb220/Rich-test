package test.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class TestSAX extends DefaultHandler
{

  private StringBuffer buf;
  private String str;

  public TestSAX()
  {
    super();
  }

  public void startDocument() throws SAXException
  {
    buf = new StringBuffer();
    System.out.println("*******start to parse*******");
  }

  public void endDocument() throws SAXException
  {
    System.out.println("*******end parse ******");
  }

  public void startPrefixMapping(String prefix, String uri)
  {
    System.out.println(" prefix: " + prefix + " start!" + "URl:" + uri);
  }

  public void endPrefixMapping(String prefix)
  {
    System.out.println(" prefix: " + prefix + " end!");
  }

  public void startElement(String namespaceURI, String localName, String qName,
      Attributes atts)
  {
    System.out.println("*******start to parse element*******");
    System.out.println("element:" + qName);
    for (int i = 0; i < atts.getLength(); i++)
    {
      System.out.println("element:" + atts.getQName(i) + ";value:"
          + atts.getValue(i));
    }
  }

  public void endElement(String namespaceURI, String localName, String fullName)
      throws SAXException
  {
    str = buf.toString();
    System.out.println("buf = " + buf + " || length = " + buf.length());
    System.out.println("str = " + str.trim() + " || length = "
        + str.trim().length());
    buf.delete(0, buf.length());
    System.out.println("******" + namespaceURI + "end element" + localName
        + "********" + fullName);
  }

  public void characters(char[] chars, int start, int length)
      throws SAXException
  {
    System.out.println("characters:" + start + ":"+length);
    buf.append(chars, start, length);
  }


}
