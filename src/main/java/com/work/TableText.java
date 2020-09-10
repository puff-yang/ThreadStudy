package main.java.com.work;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.UnitValue;

/**
 * @ClassName TableText
 * @Description
 * @Author ymy
 * @Date 2020-08-27 16:47
 * @Version 1.0
 */
public class TableText {
    public static final String DEST2 = "test4.pdf";//文件路径
    public static void main(String srag[]) throws Exception{
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST2));
        Document doc = new Document(pdfDoc);//构建文档对象
        PdfFont sysFont = PdfFontFactory.createFont("main/resources/simhei.ttf", PdfEncodings.IDENTITY_H, true);//中文字体



        Table table = new Table(new float[]{2}).setWidth(UnitValue.createPercentValue(100));//构建表格以100%的宽度
        Cell cell1=new Cell().add(new Paragraph("表格1")).setFont(sysFont);//向表格添加内容
        //Cell cell2=new Cell(2,1).add(new Paragraph("表格2")).setFont(sysFont);
        table.addCell(cell1);
        //table.addCell(cell2);
        table.setFixedLayout();
        doc.add(table.setHorizontalAlignment(HorizontalAlignment.CENTER).setFixedPosition(1,100,500,80));//将表格添加入文档并页面居中

        Paragraph paragraph1=new Paragraph();

        for (int i=0;i<100;i++){
            Text text = new Text("初始位置");
            text.setText("填充\n初始位置初始位置初始位置初始位置初始位置初始位置初始位置初始位置初始位置");
            //text.setHorizontalScaling(2);设置水平缩放
            //text.setSkew(1,1); 倾斜
            text.setTextRise(2);
            paragraph1.add(text);
            paragraph1.setFont(sysFont);


        }
        doc.add(paragraph1);


        doc.close();
    }
}
