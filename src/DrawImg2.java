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
		// �ڃȴ��д���ͼ��
		 int width  = 600;
		 int height = 500;
		 BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		 // ����ͼ��
		 Graphics g = image.getGraphics();
		 Graphics2D g2d = (Graphics2D) g;
		 // ����ɫ
		 g.setColor(new Color(240, 249, 255));

		 g.fillRect(0, 0, width, height);
		 // ������ɫ
		 g.setColor(Color.BLACK);
		 g.setFont(new Font("����", Font.PLAIN, 22));
		 g.drawString("������2007���ϰ��������ͳ��", 15, 25);
		 int visit[] = new int[6];
		 for (int i = 0; i < visit.length; i++) {
		     visit[i] = 1 + (int) (Math.random() * 100);
		 }

		 String mongth[] = { "1��", "2��", "3��", "4��", "5��", "6��" };

		 g.setFont(new Font("����", Font.BOLD, 16));
		 g.drawString("����������λ����Σ�", 20, 50);
		 g.drawString("�·�", 550, 465);
		 g.setFont(new Font("SanSSerif", Font.PLAIN, 12));

		 int visitValue = 0;
		 //������
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

		 //�۵�����
		 for (int i = 0; i < mongth.length; i++) {
		     drawHigh[i] = 445 - (int) (Math.ceil(visit[i] * 3.8));
		     drawwidth[i] = 110 + i * 80;
		     g.drawString(mongth[i], 110 + i * 80, 465);
		 }

		 //g2d.setXORMode(Color.WHITE);
		 //���ߴ�ϸ
		 g2d.setStroke(new BasicStroke(3.0f));
		 //���ߵ���ɫ
		 g2d.setPaint(Color.RED);
		 //������
		 g2d.drawPolyline(drawwidth, drawHigh, mongth.length);
		 // ����ͼ��
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
