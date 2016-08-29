import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class DrawImg2 {
	
	public void draw(){
		// 在內存中创建图像
		 int width  = 600;
		 int height = 500;
		 BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		 // 绘制图像
		 Graphics g = image.getGraphics();
		 Graphics2D g2d = (Graphics2D) g;
		 // 背景色
		 g.setColor(new Color(240, 249, 255));

		 g.fillRect(0, 0, width, height);
		 // 字体颜色
		 g.setColor(Color.BLACK);
		 g.setFont(new Font("宋体", Font.PLAIN, 22));
		 g.drawString("新浪网2007年上半年访问量统计", 15, 25);
		 int visit[] = new int[6];
		 for (int i = 0; i < visit.length; i++) {
		     visit[i] = 1 + (int) (Math.random() * 100);
		 }

		 String mongth[] = { "1月", "2月", "3月", "4月", "5月", "6月" };

		 g.setFont(new Font("宋体", Font.BOLD, 16));
		 g.drawString("访问量（单位：万次）", 20, 50);
		 g.drawString("月份", 550, 465);
		 g.setFont(new Font("SanSSerif", Font.PLAIN, 12));

		 int visitValue = 0;
		 //画横线
		 for (int i = 418; i > 0; i -= 38) {
		     g.setColor(Color.BLACK);
		     g.drawString("" + visitValue, 36, (i + 27));
		     g.setColor(Color.LIGHT_GRAY);
		     g.drawLine(80, (i + 27), 520, (i + 27));
		     visitValue += 10;
		 }
		 g.setColor(Color.BLACK);
		 g.drawLine(80, 40, 80, 445);
		 g.drawLine(80, 445, 550, 445);
		 int drawHigh[] = new int[mongth.length];
		 int drawwidth[] = new int[mongth.length];

		 //折点坐标
		 for (int i = 0; i < mongth.length; i++) {
		     drawHigh[i] = 445 - (int) (Math.ceil(visit[i] * 3.8));
		     drawwidth[i] = 110 + i * 80;
		     g.drawString(mongth[i], 110 + i * 80, 465);
		 }

		 //g2d.setXORMode(Color.WHITE);
		 //折线粗细
		 g2d.setStroke(new BasicStroke(3.0f));
		 //折线的颜色
		 g2d.setPaint(Color.RED);
		 //画折线
		 g2d.drawPolyline(drawwidth, drawHigh, mongth.length);
		 // 产生图像
		 g.dispose();

		 FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Zdisk-E\\2.jpg");
			 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
			 encoder.encode(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
//		 ServletOutputStream sos = response.getOutputStream();
//		 
//		 out.clear();
//		 out = pageContext.pushBody();
	}
	
	public static void main(String[] args) {
		new DrawImg2().draw();
	}
}
