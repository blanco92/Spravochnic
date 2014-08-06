package kursovoi.proect.spravochnic;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ListActivityA extends Activity {

	private EditText et;
	private ListView lv1; //���� �������� listview - lv1
	private ArrayList<String> array_sort= new ArrayList<String>();
	int textlength=0;
	int p=0,pi=0;
	
   //������� ������ �� ���:
   private String lv_arr[]={"��������","��������� � ��������� ����� ���������� Eclipse � SDK Tools","�������� ������ � �� ��������","ListView � Android","�������� ���� ����� � ������������ ���� � Android","Intent Filter","�������� � ����� Activity","�������� ������. SQLite","������ - ListView","Spinner � ���������� ������","Touch � ��������� �������"};
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.listl);
   
 		
		 lv1=(ListView)findViewById(R.id.lister);  //�������� ������������� ListView
		 lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr)); //������������� ������ � ListView
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
		 lv1.setAdapter(new ArrayAdapter<String>(ListActivityA.this,android.R.layout.simple_list_item_1, array_sort));
		 }
		 }
		 });
		  
		 //������������ ���� �� ������:
		 lv1.setOnItemClickListener(new OnItemClickListener() {
			 public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				 
				//������� ��������, �� �������� ��������
				String itemname = new Integer(position + p).toString();	
				 
				//������� ����� intent
			 	Intent intent = new Intent();
				intent.setClass(ListActivityA.this, ViewActivityA.class);
					Bundle b = new Bundle();
					b.putString("defStrID", itemname); //defStrID - ���������� ������, �������� itemname � ������ Activity
					intent.putExtras(b);
				startActivity(intent); //��������� intent
				 }
		 });	   
    }
    
    
}
