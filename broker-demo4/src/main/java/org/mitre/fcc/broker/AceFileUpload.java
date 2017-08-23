package org.mitre.fcc.broker;

import org.apache.camel.Exchange;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;

import java.util.List;

public class AceFileUpload extends FileUpload {

	public AceFileUpload() {
		super();
	}

	public AceFileUpload(FileItemFactory fileItemFactory) {
		super(fileItemFactory);
	}

	public List<FileItem> parseInputStream(Exchange exchange) throws FileUploadException {
		return parseRequest(new AceRequestContext(exchange));
	}
}