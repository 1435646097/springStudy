package com.paigu.interview.webservice.interceptor;

import cn.hutool.core.util.XmlUtil;
import com.paigu.interview.webservice.config.CachedStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
public class OutPutInterceptor extends AbstractPhaseInterceptor<Message> {

    public static final String jakarta_XML_WS_WSDL_OPERATION = "jakarta.xml.ws.wsdl.operation";

    public OutPutInterceptor() {
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        try {

            OutputStream os = message.getContent(OutputStream.class);
            CachedStream cs = new CachedStream();
            message.setContent(OutputStream.class, cs);
            message.getInterceptorChain().doIntercept(message);
            CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
            InputStream in = csnew.getInputStream();
            String xml = IOUtils.toString(in);
            log.info("未处理--响应的xml：" + xml);
            Document document = XmlUtil.readXML(xml);
            String operation = message.get(jakarta_XML_WS_WSDL_OPERATION).toString();
            StringBuffer stringBuffer = new StringBuffer();
            if (operation.contains("reconciliation")){
                //解析报文
                NodeList uidNodeList = document.getElementsByTagName("uid");
                NodeList statusNodeList = document.getElementsByTagName("status");
                stringBuffer.append("<ns1:reconciliationAccountsResponse xmlns:ns1=\"http://nmdidmsso.taiwanmobile.com\">");
                stringBuffer.append("<ns1:out>");
                for (int i = 0; i < uidNodeList.getLength(); i++) {
                    stringBuffer.append("<ns2:User xmlns:ns2=\"http://webservice.prj.com'>");
                    stringBuffer.append("<status xmIns=\"http://ebserviceprj.com\">" + statusNodeList.item(i).getTextContent() + "</status>");
                    stringBuffer.append("<uid xmIns=\"http://ebserviceprj.com\">" + uidNodeList.item(i).getTextContent() + "</uid>");
                    stringBuffer.append("</ns2:User>");
                }
                stringBuffer.append("</ns1:out>");
                stringBuffer.append("</ns1:reconciliationAccountsResponse>");
            } else if (operation.contains("changePassword")) {
                NodeList returnNodeList = document.getElementsByTagName("return");
                String textContent = returnNodeList.item(0).getTextContent();
                stringBuffer.append("<ns1:changePasswordResponse xmlns:ns1=\"http://nmdidmsso.taiwanmobile.com\">");
                stringBuffer.append("<ns1:out>");
                stringBuffer.append("<ns2:status>" +textContent+ "</ns2:status>");
                stringBuffer.append("</ns1:out>");
                stringBuffer.append("</ns1:changePasswordResponse>");
            }

            // 解析报文

            StringBuilder sb = new StringBuilder();
            sb = sb.append("<soap:Envelope ")
                   .append("xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" ")
                   .append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ")
                   .append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">")
                   .append("<soap:Body>")
                   //.append("<ns1:reconciliationAccountsResponse xmlns:ns1=\"http://nmdidmsso.taiwanmobile.com\">")
                   //.append("<ns1:out>")
                   .append(stringBuffer)
                   //.append("</ns1:out>")
                   //.append("</ns1:reconciliationAccountsResponse>")
                   .append("</soap:Body></soap:Envelope>");

            // 这里对xml做处理，处理完后同理，写回流中
            log.info("已处理--响应的xml：" + sb.toString());
            IOUtils.copy(new ByteArrayInputStream(sb.toString().getBytes()), os);
            cs.close();
            os.flush();
            message.setContent(OutputStream.class, os);

        } catch (Exception e) {
            log.error("Error when split original inputStream. CausedBy : " + "\n" + e);
        }
    }
}
