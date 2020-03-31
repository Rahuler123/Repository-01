package textFromImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

	public class txtFrmImgToFile {
		public static void main(String[] args) throws IOException {
			TessBaseAPI  instance = new TessBaseAPI();
			instance.Init("D:\\New folder\\readText", "eng");
			
			PIX image = lept.pixRead("D:\\New folder\\readText\\img.jpg");
			instance.SetImage(image);
			
			BytePointer bytePointer = instance.GetUTF8Text();
			String output = bytePointer.getString();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(("D:\\New folder\\readText\\text of Image\\ImgOutput.txt")));
			 writer.write(output);
			 writer.close();
			  
			   System.out.println("Your image is readed and created as text file");
			   
			   System.out.println(output);
		}
	}
