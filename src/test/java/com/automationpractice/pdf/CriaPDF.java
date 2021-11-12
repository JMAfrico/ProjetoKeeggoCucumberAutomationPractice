package com.automationpractice.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class CriaPDF {

	private static Document CriaPDFs(File dir2) throws Throwable{
		
		String file = "C:/Aprendizado/automation/evidencias/evidencias.pdf";
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, new FileOutputStream(file));
		OutputStream os = new FileOutputStream(dir2 + ".pdf");
		PdfWriter.getInstance(doc, os);
		return doc;
		
	}
}
