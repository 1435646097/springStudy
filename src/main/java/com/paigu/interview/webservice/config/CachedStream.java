package com.paigu.interview.webservice.config;

import org.apache.cxf.io.CachedOutputStream;
import java.io.IOException;
/**
 * @author lihuanxin
 * @Description
 * @create 2020-11-16 19:08
 */
public class CachedStream extends CachedOutputStream {
    public CachedStream() {
        super();
    }
    protected void doFlush() throws IOException {
        currentStream.flush();
    }
    protected void doClose() throws IOException {
    }
    protected void onWrite() throws IOException {
    }
}
