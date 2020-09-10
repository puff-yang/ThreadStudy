package com.work;


import com.itextpdf.io.font.PdfEncodings;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.vo.FormatRecordVO;
import com.vo.QuestAndAnswerVO;
import org.junit.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ClassName PdfTest
 * @Description
 * @Author ymy
 * @Date 2020-08-26 16:00
 * @Version 1.0
 */
public class PdfTest {
    public static void main(String[] args) {
        //创建文本
        Document document = new Document();
        try {
            //写入文本到文件中
            PdfWriter.getInstance(document, new FileOutputStream("Paragraph1.pdf"));
            //打开文本
            document.open();
            //定义字体
            BaseFont bfChinese=null;
          // Font signFont = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.BLACK);

            try {
                bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);

            } catch (Exception e) {
                e.printStackTrace();
            }
            Font signFont = new Font(bfChinese , 12, Font.NORMAL);


            //start
            PdfTest pdfTest=new PdfTest();
            FormatRecordVO formatRecordVO =pdfTest.getData();


            //定义问卷名称
            Font headFont = new Font(bfChinese , 24, Font.BOLD);
            Paragraph headParagraph = new Paragraph();
            Chunk headChunk = new Chunk(formatRecordVO.getQuestnaireName(),headFont);
            headParagraph.add(headChunk);
            headParagraph.setAlignment(Element.ALIGN_CENTER);
            headParagraph.setSpacingAfter(15f);

            //定义问卷
            Font contentFont = new Font(bfChinese , 12, Font.NORMAL);
            Paragraph contentParagraph =new Paragraph(25);
            for (QuestAndAnswerVO questList: formatRecordVO.getQuesList()){
                StringBuilder sb=new StringBuilder();
                sb.append(questList.getQuesSeq()).append(".").append(questList.getQuesName())
                        .append("\n\t\t\t").append(questList.getQuesAnswer()).append("\n");
                Chunk chunk = new Chunk(sb.toString(),contentFont);
                contentParagraph.add(chunk);
                contentParagraph.setSpacingAfter(10f);

            }

//            //下划线位置
//            Paragraph lineparagraph = new Paragraph();
//            Chunk underlinechunk=new Chunk("  ");
//            underlinechunk.setUnderline(1,5).setCharacterSpacing(240);
//            lineparagraph.setSpacingBefore(20);
//            lineparagraph.add(underlinechunk);


            //设置签字位置
            Paragraph sighparagraph = new Paragraph();
            //水平
            sighparagraph.setFirstLineIndent(255);
            //垂直距离
            sighparagraph.setSpacingBefore(50);
            String singStr="客户签名: __________________";
            Chunk sign = new Chunk(singStr,signFont);
            sighparagraph.add(sign);

            //签名日期
            Paragraph dateParagraph = new Paragraph();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy 年 MM 月 dd 日");
            String dateStr=sdf.format(new Date());
            Chunk date=new Chunk(dateStr,signFont);
            //字符间距
            date.setCharacterSpacing(2);
            dateParagraph.add(date);
            dateParagraph.setFirstLineIndent(255);
            dateParagraph.setSpacingBefore(20);

            //添加段落
            document.add(headParagraph);
            document.add(contentParagraph);
            //document.add(lineparagraph);
            document.add(sighparagraph);
            document.add(dateParagraph);

            //关闭文本
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




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


        quesList.add(questAndAnswerVO3);
        quesList.add(questAndAnswerVO3);
        quesList.add(questAndAnswerVO3);
        quesList.add(questAndAnswerVO3);
        quesList.add(questAndAnswerVO3);

        formatRecordVO.setQuesList(quesList);
        return formatRecordVO;
    }


    @Test
    public void testFile(){

        File file=new File("Praph1.pdf");
        System.out.println(file.exists());
    }

}
