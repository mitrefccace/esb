package org.mitre.fcc.broker;

import org.apache.camel.Exchange;
import org.apache.commons.fileupload.RequestContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class AceRequestContext implements RequestContext {

	private Exchange exchange;

	public AceRequestContext(Exchange exchange) {
		this.exchange = exchange;
	}

	public String getCharacterEncoding() {
		return StandardCharsets.UTF_8.toString();
	}

	//could compute here (we have stream cache enabled)
	public int getContentLength() {
		return (int) -1;
	}

	public String getContentType() {
		return exchange.getIn().getHeader("Content-Type").toString();
	}

	public InputStream getInputStream() throws IOException {
		return this.exchange.getIn().getBody(InputStream.class);
	}
}