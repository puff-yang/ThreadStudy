package main.java.com.work;

/**
 * @ClassName FreeWorkerTest
 * @Description
 * @Author ymy
 * @Date 2020-08-28 10:11
 * @Version 1.0
 */
public class FreeWorkerTest {
    private static final String DEST = "target/HelloWorld_CN_HTML_FREEMARKER.pdf";
    private static final String HTML = "template_freemarker.html";
    private static final String FONT = "main/resources/simhei.ttf";
//
//    private static Configuration freemarkerCfg = null;
//
//    static {
//        freemarkerCfg =new Configuration();
//        //freemarker的模板目录
//        try {
//            freemarkerCfg.setDirectoryForTemplateLoading(new File(PathUtil.getCurrentPath()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException, DocumentException {
//        Map<String,Object> data = new HashMap();
//        data.put("name","鲁家宁");
//        String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data,HTML);
//        JavaToPdfHtmlFreeMarker.createPdf(content,DEST);
//    }
//
//    public static void createPdf(String content,String dest) throws IOException, DocumentException {
//        // step 1
//        Document document = new Document();
//        // step 2
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
//        // step 3
//        document.open();
//        // step 4
//        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//        fontImp.register(FONT);
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                new ByteArrayInputStream(content.getBytes()), null, Charset.forName("UTF-8"), fontImp);
//        // step 5
//        document.close();
//
//    }
//
//    /**
//     * freemarker渲染html
//     */
//    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
//        Writer out = new StringWriter();
//        try {
//            // 获取模板,并设置编码方式
//            Template template = freemarkerCfg.getTemplate(htmlTmp);
//            template.setEncoding("UTF-8");
//            // 合并数据模型与模板
//            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
//            out.flush();
//            return out.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return null;
//    }

}
