package es.deusto.ingenieria.aike.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * It implements the funcionality of a parser for an XML document that contains the
 * description of the problem environment.
 *  */
public abstract class InformationXMLReader extends DefaultHandler {

	/**
	 * problem environment information.
	 */
	private Object information = null;

	/**
	 * Constructor method.
	 * 
	 * @param fileXML
	 *            String that is the name of the XML file containing the 
	 *            information describing the problem environment.
	 */
	public InformationXMLReader(String fileXML) {
		this.processXML(fileXML);
	}

	/**
	 * It parses an XML file.
	 * 
	 * @param fileXML
	 *            String that is the name of the file to be parsed.
	 */
	private void processXML(String fileXML) {
		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			parserFactory.setValidating(true);
			parserFactory.setNamespaceAware(true);
			SAXParser parser = parserFactory.newSAXParser();
			parser.parse(fileXML, this);
		} catch (Exception ex) {
			System.err.println(this.getClass().getName()
					+ ".parseDocument(): " + ex);
		}
	}

	/**
	 * It returns the problem state information.
	 * 
	 * @return Object having the problem state information.
	 */
	public Object getInformation() {
		return this.information;
	}

	/**
	 * Implementation of the startElement method from class DefaultHandler. This
	 * is executed every time the parser finds a new XML element.
	 * 
	 * @param uri
	 *            String having the URL names space.
	 * @param localName
	 *            String having the element's name without the names space.
	 * @param qName
	 *            String having the element's name with the names space.
	 * @param attributes
	 *            Attributes having the list of element's attributes.
	 * @throws SAXException
	 */
	public abstract void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException;
}