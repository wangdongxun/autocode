package com.martin;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlRead
{
    private static Map<String, String> xmlMap = new HashMap();

    public XmlRead()
            throws Exception
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try
        {
            filePath = URLDecoder.decode(url.getPath(), "utf-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }
        File file = new File(filePath);
        filePath = file.getAbsolutePath();
        Document doc = db.parse(filePath + "/autocode.xml");
        Element root = doc.getDocumentElement();
        parseXml(root.getChildNodes());
    }

    public void parseXml(NodeList list)
            throws Exception
    {
        for (int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);
            short nodeType = node.getNodeType();
            if ((node != null) && (nodeType == 1))
            {
                NamedNodeMap map = node.getAttributes();
                Node nameNode = map.getNamedItem("name");
                Node valueNode = map.getNamedItem("value");
                if ((nameNode != null) && (valueNode != null)) {
                    xmlMap.put(nameNode.getNodeValue(), valueNode.getNodeValue());
                } else {
                    parseXml(node.getChildNodes());
                }
            }
        }
    }

    public Map<String, String> getXml()
            throws Exception
    {
        return xmlMap;
    }
}
