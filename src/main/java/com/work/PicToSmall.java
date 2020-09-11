package main.java.com.work;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @ClassName PicToSmall
 * @Description
 * @Author ymy
 * @Date 2020-09-02 14:20
 * @Version 1.0
 */
public class PicToSmall {


    /**
     * 图片压缩Utils
     *
     * @author worstEzreal
     * @version V1.1.0
     * @date 2018/3/12
     */


    public static void main(String[] args) throws IOException {
        String  base64=GetImageStr("pic/p1.jpeg");
        System.out.println(base64);

        GenerateImage(base64);



    }

        /**
         * 根据指定大小压缩图片
         *
         * @param imageBytes  源图片字节数组
         * @param desFileSize 指定图片大小，单位kb
         * @param imageId     影像编号
         * @return 压缩质量后的图片字节数组
         */
        public static byte[] compressPicForScale(byte[] imageBytes, long desFileSize, String imageId) {
            if (imageBytes == null || imageBytes.length <= 0 || imageBytes.length < desFileSize * 1024) {
                return imageBytes;
            }
            long srcSize = imageBytes.length;
            double accuracy = getAccuracy(srcSize / 1024);
            try {
                while (imageBytes.length > desFileSize * 1024) {
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);
                    Thumbnails.of(inputStream)
                            .scale(accuracy)
                            .outputQuality(accuracy)
                            .toOutputStream(outputStream);
                    imageBytes = outputStream.toByteArray();
                }
                System.out.println("【图片压缩】imageId={} | 图片原大小={}kb | 压缩后大小={}kb"+
                        imageId+ srcSize / 1024+ imageBytes.length / 1024);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return imageBytes;
        }

        /**
         * 自动调节精度(经验数值)
         *
         * @param size 源图片大小
         * @return 图片压缩质量比
         */
        private static double getAccuracy(long size) {
            double accuracy;
            if (size < 900) {
                accuracy = 0.85;
            } else if (size < 2047) {
                accuracy = 0.6;
            } else if (size < 3275) {
                accuracy = 0.44;
            } else {
                accuracy = 0.4;
            }
            return accuracy;
        }




    public static String GetImageStr(String imgFilePath) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    public static boolean GenerateImage(String imgStr) {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes  = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            bytes = compressPicForScale(bytes, 300, "x");// 图片小于300kb
            FileUtils.writeByteArrayToFile(new File("p2.jpeg"), bytes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
