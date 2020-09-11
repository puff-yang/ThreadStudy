package com.work;


import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.work.vo.FormatRecordVO;
import com.work.vo.QuestAndAnswerVO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PDF
 * @Description
 * @Author ymy
 * @Date 2020-08-27 11:10
 * @Version 1.0
 */
public class PDF {
    public static void main(String[] args) {

        PdfDocument pdfDocument = null;
        PdfWriter writer =null;
        try {
            writer = new PdfWriter("pic/merger.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PdfFont font =null;
        try {

            font =PdfFontFactory.createFont("main/resources/simhei.ttf", PdfEncodings.IDENTITY_H, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PdfDocument pdfDoc = new PdfDocument( writer);
        Document document=new Document(pdfDoc);
        Paragraph headParagraph=new Paragraph();

        //start
        PDF pdfTest=new PDF();
        FormatRecordVO formatRecordVO =pdfTest.getData();

        String headContent= formatRecordVO.getQuestnaireName();
        Text headText= new Text(headContent);
        headParagraph.add(headText);






        Paragraph paragraph2=new Paragraph();




        for (int i=0;i<100;i++){
            Text text = new Text("初始位置");
            text.setText("填充\n初始位置初始位置初始位置初始位置初始位置初始位置初始位置初始位置初始位置");
            //text.setHorizontalScaling(2);设置水平缩放
            //text.setSkew(1,1); 倾斜
            text.setTextRise(2);
//            paragraph1.add(text);
//            paragraph1.setFont(font);


            Text text1 = new Text("阿斯顿second line");
            paragraph2.add(text1);
            paragraph2.setFont(font);
        }
        document.add(headParagraph);
        document.add(paragraph2);


        document.close();
    }

    private FormatRecordVO getData(){
        FormatRecordVO formatRecordVO =new FormatRecordVO();
        formatRecordVO.setQuestnaireId(1L);
        formatRecordVO.setBusinessKey("1189087647654345");
        formatRecordVO.setQuestnaireName("残疾问卷");
        formatRecordVO.setIpsnNo(1L);
        formatRecordVO.setIpsnName("汪啸风");
        formatRecordVO.setNoticeId(1443L);

        List<QuestAndAnswerVO> quesList =new ArrayList<>();
        QuestAndAnswerVO questAndAnswerVO=new QuestAndAnswerVO();
        questAndAnswerVO.setQuesName("是否有肿块？");
        questAndAnswerVO.setQuesSeq("1");
        questAndAnswerVO.setQuesAnswer("是");
        quesList.add(questAndAnswerVO);

        QuestAndAnswerVO questAndAnswerVO1=new QuestAndAnswerVO();
        questAndAnswerVO1.setQuesName("是否有以下症状？");
        questAndAnswerVO1.setQuesSeq("2");
        questAndAnswerVO1.setQuesAnswer("关节痛、抽搐、贫血");
        quesList.add(questAndAnswerVO1);

        QuestAndAnswerVO questAndAnswerVO3=new QuestAndAnswerVO();
        questAndAnswerVO3.setQuesName("首次得知患病的时间是：");
        questAndAnswerVO3.setQuesSeq("3");
        questAndAnswerVO3.setQuesAnswer("2020-08-12");
        quesList.add(questAndAnswerVO3);

        formatRecordVO.setQuesList(quesList);
        return formatRecordVO;
    }
}
