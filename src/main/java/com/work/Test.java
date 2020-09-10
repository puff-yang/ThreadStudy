package com.work;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName Test
 * @Description
 * @Author ymy
 * @Date 2020-08-27 09:02
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //创建文本

        Document document = new Document();
        try {
            //写入文本到文件中
            PdfWriter.getInstance(document, new FileOutputStream("Paragraph1.pdf"));
            //打开文本
            document.open();
            //定义段落
            Paragraph paragraph = new Paragraph();
            Chunk chunk1 = new Chunk("这是第一行，无缩略test1121312312312312");
            paragraph.add(chunk1);

            //插入十条文本块到段落中
//            int i=0;
//            for(i=0; i<10; i++){
//                paragraph.setIndentationLeft(50);
//                Chunk chunk = new Chunk("This is a sentence which is long " + i + ". ");
//                paragraph.add(chunk);
//            }

            //添加段落
            document.add(paragraph);
            //关闭文本
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
