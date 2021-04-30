/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author ketanmalik
 */
public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookingView bookingPdf = (BookingView) map.get("bookingPdf");
        if (bookingPdf == null) {
            Paragraph heading = new Paragraph("Booking information could not be retrieved", FontFactory.getFont(FontFactory.TIMES, 30, Font.BOLD, new Color(0, 0, 0)));
            heading.setAlignment(1);
            doc.add(heading);
            return;
        }
        Paragraph heading = new Paragraph("Booking Confirmation\n\n", FontFactory.getFont(FontFactory.TIMES, 40, Font.BOLD, new Color(0, 0, 0)));
        heading.setAlignment(1);
        doc.add(heading);
        Paragraph b_id = new Paragraph("Booking ID: " + bookingPdf.getBooking_id(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph e_name = new Paragraph("Event: " + bookingPdf.getEvent_name(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph venue = new Paragraph("Venue: " + bookingPdf.getVenue(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph e_date_time = new Paragraph("Event Date: " + bookingPdf.getDate_time(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph screen = new Paragraph("Screen: " + bookingPdf.getScreen(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph seats = new Paragraph("Seats Booked: " + bookingPdf.getSeats(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph price = new Paragraph("Booking Price: " + bookingPdf.getPrice(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph b_date = new Paragraph("Booking Date & Time: " + bookingPdf.getBooking_date(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph c_name = new Paragraph("Booked For: " + bookingPdf.getCustomer_name(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        Paragraph c_contact = new Paragraph("Contact: " + bookingPdf.getCustomer_contact(), FontFactory.getFont(FontFactory.TIMES, 15, new Color(70, 70, 70)));
        doc.add(b_id);
        doc.add(e_name);
        doc.add(venue);
        doc.add(e_date_time);
        doc.add(screen);
        doc.add(seats);
        doc.add(price);
        doc.add(b_date);
        doc.add(c_name);
        doc.add(c_contact);
    }
}
