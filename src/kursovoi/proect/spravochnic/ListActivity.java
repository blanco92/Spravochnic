package kursovoi.proect.spravochnic;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity  extends Activity {
	
	private EditText et;
	private ListView lv1; //даем название listview - lv1
	private ArrayList<String> array_sort= new ArrayList<String>();
	int textlength=0;
	int p=0,pi=0;
	
   //Создаем массив из тем:
   private String lv_arr[]={"Написание программы Hello World!","Ввод данных с клавиатуры","Простой апплет","Понятие интерфейса","Потоки","События (mouseDown, mouseMove, Event)","Кнопки (Button)","Передача параметров в апплет","Вывод изображения на экран","Обзор событий (mouseEnter и mouseExit)","Обзор событий.Продолжение"};
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.listl);
   
 		
		 lv1=(ListView)findViewById(R.id.lister);  //получаем идентификатор ListView
		 lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr)); //устанавливаем массив в ListView
		 lv1.setTextFilterEnabled(true);
         et = (EditText) findViewById(R.id.EditText01);
		 
		 et.addTextChangedListener(new TextWatcher()
		 {
		 public void afterTextChanged(Editable s)
		 {
                                                         
		 }
		 public void beforeTextChanged(CharSequence s,
		 int start, int count, int after)
		 {
		 }
		 public void onTextChanged(CharSequence s,
		 int start, int before, int count)
		 {
		 textlength = et.getText().length();
		 array_sort.clear();
		 pi=0;
		 for (int i = 0; i < lv_arr.length; i++)
		 {
		 if (textlength <= lv_arr[i].length())
		 {
		 if(et.getText().toString().equalsIgnoreCase((String)lv_arr[i].subSequence(0,textlength)))
		 {
		  array_sort.add(lv_arr[i]); 
		  if(pi == 0){
			  p = i;
			  pi = 1;
		  }
		 }
		    }
		 lv1.setAdapter(new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_list_item_1, array_sort));
		 }
		 }
		 });
		 
		 //Обрабатываем клик по пункту:
		 lv1.setOnItemClickListener(new OnItemClickListener() {
			 public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				 
				//Позиция элемента, по которому кликнули
				String itemname = new Integer(position + p).toString();	
				
				//Создаем новый intent
			 	Intent intent = new Intent();
				intent.setClass(ListActivity.this, ViewActivity.class);
					Bundle b = new Bundle();
					b.putString("defStrID", itemname); //defStrID - уникальная строка, отправим itemname в другое Activity
					intent.putExtras(b);
				startActivity(intent); //запускаем intent
				 }
		 });
    }

}
