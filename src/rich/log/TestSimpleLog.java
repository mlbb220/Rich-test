package rich.log;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.SimpleLog;

public class TestSimpleLog extends TestCase{

	public void testLog(){
		Log log = LogFactory.getLog("testSimpleLog");
		log.debug("debug");
		log.info("info");
		log.fatal("fatal");
		SimpleLog a = new SimpleLog("testsimplelog");
		a.debug("debug");
		
	}
}
