import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class DrawImg {
	private static Font mFont = new Font("宋体", Font.BOLD, 12);

	  public static void main(String[] args) {
	    double[] value = { 18.57d, 2.25d, 10.83d, 16.38d, 14.35d };
	    createimage(value, 18.57d);
	  }
	  
	  /**
	   * 绘制图生片
	   * @param value
	   * @param maxvalue
	   */
	  private static void createimage(double[] value, double maxvalue) {
	    try {
	      int width = 764, height = 168;
	      BufferedImage image = new BufferedImage(width, height,
	          BufferedImage.TYPE_INT_RGB);

	      // 绘制图像
	      Graphics g = image.getGraphics();
	      // 背景色
	      g.setColor(new Color(255, 255,255));
	      g.fillRect(1, 1, width - 1, height - 1);
	      g.setColor(new Color(255, 255,255));
	      g.drawRect(0, 0, width - 1, height - 1);
	      
	      //初始化下部默认部分
	      g.setColor(new Color(227, 227, 227));
	      g.fillRect(0, 108, width, 60);
	      g.drawRect(0, 108, width, 60);
	      
	      int y = 108;
	      //保存y轴数据高度的数组
	      int[] tempy = new int[5];
	      int temp_y = 0;
	      //开始绘图
	      for(int i = 0;i<= value.length;i++){
	        if(i < value.length){
	          temp_y = y-(int)Math.round(60*(value[i]/maxvalue));
	          tempy[i] = temp_y;
	        }
	        Polygon filledPolygon=new Polygon();
	        if(i == 0){
	          filledPolygon.addPoint(0,y);    
	          filledPolygon.addPoint(68,y);    
	          filledPolygon.addPoint(68,temp_y);    
	          g.setColor(new Color(227, 227, 227)); 
	          g.fillPolygon(filledPolygon);
	          g.drawPolygon(filledPolygon);
	        }else if(i > 0 && i < value.length){
	          filledPolygon.addPoint(i*136-68,tempy[i-1]);    
	          filledPolygon.addPoint(i*136-68,y);
	          filledPolygon.addPoint((i+1)*136-68,y); 
	          filledPolygon.addPoint((i+1)*136-68,temp_y);    
	          g.setColor(new Color(227, 227, 227)); 
	          g.fillPolygon(filledPolygon);
	          g.drawPolygon(filledPolygon);
	        }else{
	          filledPolygon.addPoint(i*136-68,tempy[i-1]);    
	          filledPolygon.addPoint(i*136-68,y);
	          filledPolygon.addPoint(width,y);   
	          g.setColor(new Color(227, 227, 227)); 
	          g.fillPolygon(filledPolygon);
	          g.drawPolygon(filledPolygon);
	        }
	      }
	      
	      //在图上加上图标
	      for(int j = 0;j<value.length;j++){
	        BufferedImage img = ImageIO.read(new File("C:\\Zdisk-E\\1.png")); 
	        g.drawImage(img, (j+1)*136-76,tempy[j]-8, 16, 16, null);
	      }
	      
	      //在图标上部写字
	      Color c = new Color(181, 181, 181);
	      for(int j = 0;j<value.length;j++){
	        g.setColor(c);
	        g.setFont(mFont);
	        g.drawString(value[j]+"MB", (j+1)*136-92,tempy[j]-16);
	      }
	      g.dispose();
	      
	      // 产生图像
	      String filename = "C:\\Zdisk-E\\createqximg.jpg";
	      File file = new File(filename);
	      if (!file.exists()) {
	        file.createNewFile();
	      }
	      FileOutputStream s = new FileOutputStream(file);
	      ImageIO.write(image, "JPEG", s);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
