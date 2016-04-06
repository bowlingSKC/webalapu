package webalapu.util;


import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.pdfbox.encoding.*;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import webalapu.backing.BaseBacking;
import webalapu.model.Ticket;
import webalapu.service.TicketManagerLocal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PDFParser extends BaseBacking implements Serializable{
    @EJB
    private TicketManagerLocal ticketManager;

    private List<Ticket> ticketList;

    //public static void main( String[] args ) throws IOException, COSVisitorException, DocumentException {
    public static void makePDF(){
        /*System.out.println("HERE");
        //listTickets();
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage( page );

        try {
            PDXObjectImage image = new PDJpeg(document, new FileInputStream("web/images/logo.jpg"));

            PDFont font = PDType1Font.TIMES_ROMAN;
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(image, 50, 600);
            contentStream.beginText();
            contentStream.setFont(font, 24);
            contentStream.moveTextPositionByAmount( 100, 500 );
            String text = "Moziélmény mozijegy";
            contentStream.drawString( text );
            contentStream.endText();
            contentStream.close();

            document.save( "Tickets.pdf");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("HERE!!");
        */
    }

    //@PostConstruct
    public String retrieveTickets(){
        ticketList = ticketManager.getAllTicket();
        return null;
    }

    public void createPDF() {
        /*try {
            Image img = Image.getInstance("web/images/logo.jpg");
            Document document = new Document(img);
            PdfWriter.getInstance(document, new FileOutputStream("Tickets2.pdf"));
            document.open();
            img = Image.getInstance("web/images/logo.jpg");
            document.setPageSize(img);
            document.newPage();
            img.setAbsolutePosition(0, 0);
            document.add(img);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void preProcessPDF(Object document) throws IOException,
            BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        ServletContext servletContext = (ServletContext)
                FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String logo = servletContext.getRealPath("") + File.separator + "images" +
        //        File.separator + "prime_logo.png";
        String logo = servletContext.getRealPath("") + File.separator +"images/logo.jpg";
        pdf.add(Image.getInstance(logo));
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

}
