package com.paigu.interview.main;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlUtilMain {
    public static void main(String[] args) {
        String xmlString = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <soap:Body>\n" +
                "        <ns2:reconciliationAccountsResponse xmlns:ns2=\"http://nmdidmsso.taiwanmobile.com\">\n" +
                "            <return>\n" +
                "                <status>1</status>\n" +
                "                <uid>liaoximing</uid>\n" +
                "            </return>\n" +
                "            <return>\n" +
                "                <status>1</status>\n" +
                "                <uid>paigu</uid>\n" +
                "            </return>\n" +
                "            <return>\n" +
                "                <status>0</status>\n" +
                "                <uid>wuxiyang</uid>\n" +
                "            </return>\n" +
                "        </ns2:reconciliationAccountsResponse>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";

        Document document = XmlUtil.readXML(xmlString);
        NodeList uidNodeList = document.getElementsByTagName("uid");
        NodeList statusNodeList = document.getElementsByTagName("status");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < uidNodeList.getLength(); i++) {
            stringBuffer.append("<ns2:User xmlnsns2=\"http://webservice.prj.com'>");
            stringBuffer.append("<status xmIns=\"http://ebserviceprj.com\">" + statusNodeList.item(i).getTextContent() + "</status>");
            stringBuffer.append("<uid xmIns=\"http://ebserviceprj.com\">" + uidNodeList.item(i).getTextContent() + "</uid>");
            stringBuffer.append("/ns2:User");
        }
    }
}
