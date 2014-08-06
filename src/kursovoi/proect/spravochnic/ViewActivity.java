package kursovoi.proect.spravochnic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class ViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE); //�������� ���������
        
        setContentView(R.layout.view);
        
        //�������� ���������:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        Bundle bundle = getIntent().getExtras();
		String itemname = "j" + bundle.getString("defStrID"); //�������� ������ � ��������� ��� �������
		
		Context context = getBaseContext(); //�������� ��������
		
		//������ ��������� ���� �� ��������� �� �����
		String text = readRawTextFile(context, getResources().getIdentifier(itemname, "raw", "kursovoi.proect.spravochnic"));
		
        WebView myWebView = (WebView) findViewById(R.id.webview);
        String summary = "<html><body>" + text + "</body></html>";
         //��������� ����� � webview
        myWebView.loadDataWithBaseURL("x-data://base",summary, "text/html","utf-8", null);
    }
    
    public static String readRawTextFile(Context ctx, int resId) //������ ����� �� raw - ��������� �������� � ������������� �������
    {
         InputStream inputStream = ctx.getResources().openRawResource(resId);

            InputStreamReader inputreader = new InputStreamReader(inputStream);
            BufferedReader buffreader = new BufferedReader(inputreader);
             String line;
             StringBuilder text = new StringBuilder();

             try {
               while (( line = buffreader.readLine()) != null) {
                   text.append(line);
                   text.append('\n');
                 }
           } catch (IOException e) {
               return null;
           }
             return text.toString();
     }
}
