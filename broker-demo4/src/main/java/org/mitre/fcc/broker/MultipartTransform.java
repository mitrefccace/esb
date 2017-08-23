package org.mitre.fcc.broker;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.camel.Exchange;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class MultipartTransform  {
	private final static Logger logger = LoggerFactory.getLogger(MultipartTransform.class);

	public void transform(Object body, Exchange exchange) {
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		AceFileUpload upload = new AceFileUpload(factory);

		java.util.List<FileItem> items;
		try {
			items = upload.parseInputStream(exchange);

			//here I assume I have only one, but I could split it here somehow and link them to camel properties...
			//with this, the first file sended with your multipart replaces the body
			// of the exchange for the next processor to handle it
			exchange.getIn().setBody(items.get(0).getInputStream());

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
