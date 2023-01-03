/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.raj3100.projects.certificategenerator;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Oasimul Hasan Raj
 * github.com/hasanraj3100
 * email: oasimulhasanraj@outlook.org
 */
public class CreatePDF {

    public static void generate(Certificate certificate) throws FileNotFoundException, MalformedURLException, IOException{
        // Putting all the data to seperate variables 
        String filename=certificate.getId();
        String idString= certificate.getId();
        String name=certificate.getName();
        String courseName= certificate.getCourse();
       String departmentName= "";
       String score= certificate.getScore();
       String firstPronoun= (certificate.getGender()==Gender.MALE) ? "He" : "She";
       String secondPronoun= (certificate.getGender()==Gender.MALE) ? "his" : "her";;
       String pronoun=(certificate.getGender()==Gender.MALE) ? "he" : "she";
       String date= new SimpleDateFormat("dd-MM-yyyy").format(certificate.getDate());
        
       
       // Assigining Departmentname by checking the enums
       switch(certificate.getDepartment()) {
           case SoftwareEngineering:
               departmentName="Software Engineering";
               break;
           case ComputerScienceEngineering:
               departmentName="Computer Science Engineering";
               break;
           case Architecture:
               departmentName="Architecture";
               break;
           case ElectricalEngineering:
               departmentName="Electrical Engineering";
               break;
           case LawAndJustice:
               departmentName="Law and Justice";
       }
       
        String pathString= "Certificates/"+filename+".pdf";
        String path=pathString;
        ImageData data= ImageDataFactory.create("images/backimage.png");
        ImageData dataforLogo= ImageDataFactory.create("images/signature.png");
        Image image1= new Image(data);
         image1.scaleAbsolute(580f, 830f);
        image1.setFixedPosition(5, 5);
        
        Image signature= new Image(dataforLogo);
        signature.scaleAbsolute(110, 76);
       
        PdfWriter pdfWriter= new PdfWriter(path);
        PdfDocument pdfDocument= new PdfDocument(pdfWriter);
        
        PdfFont font= PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
        PdfFont timesfont= PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont boldfont= PdfFontFactory.createFont(FontConstants.COURIER_BOLD);
        
        //ID

        Text id= new Text(idString);
        id.setFont(boldfont);
        Paragraph pForID= new Paragraph().add(id);
        pForID.setTextAlignment(TextAlignment.CENTER);
        
        
        Text text1= new Text("\nCERTIFICATE").setFont(font);
        text1.setFontSize(35f);
        Text text2= new Text("\nof achievement").setFont(timesfont);
        text2.setFontSize(18f);
        Paragraph paragraph= new Paragraph()
                .add(text1)
                .add(text2);
        
        paragraph.setTextAlignment(TextAlignment.CENTER);
        
        
        // Second paragraph
        
        PdfFont anotherFont= PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        
        Text presentedText= new Text("\nTHIS CERTIFICATE IS PRESENTED TO");
        presentedText.setFontSize(16f);
        
        Text personName= new Text("\n"+name);
        personName.setFontSize(28f);
        personName.setFont(anotherFont);
        
        
        Paragraph p2= new Paragraph().add(presentedText);
        p2.add(personName);
        p2.setTextAlignment(TextAlignment.CENTER);
        
        pdfDocument.addNewPage();
        
       // PageSize ps= PageSize.LETTER.rotate();
       
       // Third
       
       
    
       
       
       // writing the first paragraph in segments to dynamically change certain parts
       
       Text segmentText1= new Text("\n\nFor successfully completing the ");
       Text segmentText2= new Text(courseName);
       Text segmentText3= new Text(" course offered by the Department of ");
       Text segmentText4= new Text(departmentName);
       Text segmentText5= new Text(" at ABC Center. ");
       Text segmentText6= new Text(firstPronoun);
       Text segmentText7= new Text(" demonstrated a strong understanding of the ");
       Text segmentText8= new Text(courseName);
       Text segmentText9= new Text(" and achieved a score of ");
       Text segmentText10= new Text(score+ "%.");
       
       // Bolding only the dynamic segments
       
       PdfFont helveticaBold= PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
       segmentText2.setFont(helveticaBold);
       segmentText4.setFont(helveticaBold);
       segmentText8.setFont(helveticaBold);
       segmentText10.setFont(helveticaBold);
       
       
       
      // Text firstText= new Text("Software Engineering at [Institution Name]. [He/She]  C programming language83%.");
    //   firstText.setFontSize(13f);
       Paragraph firstParagraph= new Paragraph();
       firstParagraph.add(segmentText1);
       firstParagraph.add(segmentText2);
       firstParagraph.add(segmentText3);
       firstParagraph.add(segmentText4);
       firstParagraph.add(segmentText5);
       firstParagraph.add(segmentText6);
       firstParagraph.add(segmentText7);
       firstParagraph.add(segmentText8);
       firstParagraph.add(segmentText9);
       firstParagraph.add(segmentText10);
       
       firstParagraph.setTextAlignment(TextAlignment.JUSTIFIED);
       
       
       // Forth
       
       // Writing the second paragraphs in segments 
       Text secondSegmentText1= new Text("\nThis achievement reflects ");
       Text secondSegmentText2= new Text(secondPronoun);
       Text secondSegmentText3= new Text(" dedication to learning and determination to succeed in the field of ");
       Text secondSegmentText4= new Text(departmentName);
       Text secondSegmentText5= new Text(". We are confident that ");
       Text secondSegmentText6=new Text(pronoun);
       Text secondSegmentText7=new Text(" has the skills and knowledge necessary to excel in ");
       Text secondSegmentText8=new Text(secondPronoun);
       Text secondSegmentText9= new Text(" future endeavors.");
       
       
      
       // Adding segments to the paragraph
       Text thirdText= new Text("\n\nCongratulations on a job well done!\n");
       thirdText.setFontSize(13f);
       Paragraph secondParagraph= new Paragraph();
       secondParagraph.add(secondSegmentText1);
       secondParagraph.add(secondSegmentText2);
       secondParagraph.add(secondSegmentText3);
       secondParagraph.add(secondSegmentText4);
       secondParagraph.add(secondSegmentText5);
       secondParagraph.add(secondSegmentText6);
       secondParagraph.add(secondSegmentText7);
       secondParagraph.add(secondSegmentText8);
       secondParagraph.add(secondSegmentText9);
       secondParagraph.add(thirdText);
       secondParagraph.setTextAlignment(TextAlignment.JUSTIFIED);
        
       
       //Date
       Text daText= new Text("\nDate: "+date +"\n");
       daText.setFontSize(13f);
       Paragraph dateParagraph= new Paragraph();
       dateParagraph.add(daText);
 
       
       // Signature
       Text instName= new Text("Michael Jordan\n");
       instName.setFontSize(13f);
       Text postName=new Text("Instructor");
       Paragraph lastParagraph= new Paragraph();
       lastParagraph.add(instName);
       lastParagraph.add(postName);
       
        
        Document document= new Document(pdfDocument);
        document.setBackgroundColor(Color.PINK);
        document.setTopMargin(40f);
        document.setLeftMargin(55f);
        document.setRightMargin(55f);
        
        
        
        document.add(image1);
        document.add(pForID);
        document.add(paragraph);
        document.add(p2);
        document.add(firstParagraph);
        document.add(secondParagraph);
        document.add(dateParagraph);
        document.add(signature);
        document.add(lastParagraph);
        document.close();
        
        System.out.println("Hello World!");
    }
}
