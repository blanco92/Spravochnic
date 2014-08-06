package kursovoi.proect.spravochnic;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	
	private static final int STOPSPLASH = 0;
	private static final long SPLASHTIME = 1800; //Время показа Splash картинки
	private ImageView splash;
	
	Button butt1,butt2;
	
	private Handler splashHandler = new Handler() { //создаем новый обработчик

		@Override
	    public void handleMessage(Message msg) {
		      switch (msg.what) {
		      case STOPSPLASH:
		         //убираем Splash картинку - меняем видимость
		         splash.setVisibility(View.GONE);
		         break;
		         }
		      super.handleMessage(msg);
		     }
		};	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        splash = (ImageView) findViewById(R.id.splashscreen);  //получаем индентификатор ImageView с Splash картинкой
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
        
        butt1 = (Button) this.findViewById(R.id.button1);
		butt1.setOnClickListener(this);
		butt2 = (Button) this.findViewById(R.id.button2);
		butt2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_settings:
        	Toast.makeText(this, "Программа для ознакомленния с языком java.Автор программы Пономаренко Даша.", Toast.LENGTH_LONG).show();
          return true;
        default:
          return super.onOptionsItemSelected(item);
        }
      }

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1 :
			Intent i = new Intent(this, kursovoi.proect.spravochnic.ListActivity.class);
			this.startActivity(i);
			break;
        case R.id.button2 :
        	Intent i2 = new Intent(this, kursovoi.proect.spravochnic.ListActivityA.class);
			this.startActivity(i2);
			break;	
		}
	}
}
