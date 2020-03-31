package textFromImage;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;


public class txtFrmImg {
	public static void main(String[] args) {
		TessBaseAPI  instance = new TessBaseAPI();
		
		instance.Init("D:\\New folder\\readText", "eng");
		
		
		PIX image = lept.pixRead("D:\\New folder\\readText\\img.jpg");
		
		instance.SetImage(image);
		
		BytePointer bytePointer = instance.GetUTF8Text();
		String output = bytePointer.getString();
		System.out.println(output);
	}
}
