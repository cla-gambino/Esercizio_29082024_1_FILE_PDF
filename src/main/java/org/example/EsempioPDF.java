package org.example;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class EsempioPDF {

    private static String PATH_FILE = "C:\\Users\\klodd\\Desktop\\iText\\provaDue.pdf";
    private static Font fontRossoGrassetto = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD, BaseColor.RED);
    private static Font grassetto = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(PATH_FILE)));
            document.open();

            // metadati
            document.addTitle("PDF Tabella");
            document.addSubject("Creazione di un file PDF in JAVA con IText");
            document.addKeywords("PDF, JAVA, IText");
            document.addAuthor("Claudio");
            document.addCreator("Claudio");

            // paragrafo
            Paragraph titoloTabella = new Paragraph("Esempio tabella", grassetto);
            document.add(titoloTabella);
            document.add(new Paragraph(" "));

            PdfPTable table = getPdfPTable();

            document.add(table);

            document.add(new Paragraph(" "));

            Paragraph titoloLista = new Paragraph("Esempio lista", fontRossoGrassetto);
            document.add(titoloLista);
            document.add(new Paragraph(" "));

            // lista
            List list = new List(true, false);
            list.add(new ListItem("Primo elemento"));
            list.add(new ListItem("Secondo elemento"));
            list.add(new ListItem("Terzo elemento"));
            document.add(list);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PdfPTable getPdfPTable() {
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("5.8");
        table.addCell("1.6");
        table.addCell("9.7");
        table.addCell("2.5");
        table.addCell("5.7");
        table.addCell("3.4");
        return table;
    }
}
