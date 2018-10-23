package com.blue.tooth;

import android.app.*;
import android.os.*;
import android.bluetooth.*;
import android.view.View;
import android.widget.*;
import java.util.*;
import android.content.*;

public class MainActivity extends Activity 
{
	private final static int REQUEST_ENABLE_BT = 1;
	Button on,off;
	Intent bluetoothenable;
	BluetoothAdapter mybluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		on=(Button) findViewById(R.id.bl_on);
		off=(Button) findViewById(R.id.bl_off);
		mybluetooth=BluetoothAdapter.getDefaultAdapter();
		bluetoothenable= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		blueetoothon();
		bluetoothoff();
    }
	void bluetoothoff(){
		off.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(mybluetooth.isEnabled()){
						mybluetooth.disable();
					}
				}
				
			
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO: Implement this method
	if(requestCode==REQUEST_ENABLE_BT){
		if(resultCode==RESULT_OK){
			Toast.makeText(getApplicationContext(),"bluetooth enabled",Toast.LENGTH_LONG).show();
		}else if(resultCode==RESULT_CANCELED){
			Toast.makeText(getApplicationContext(),"bluetooth enabling cancelled",Toast.LENGTH_SHORT).show();
		}
	}
	}
	
	void blueetoothon(){
		on.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					if(mybluetooth==null){
						Toast.makeText(getApplicationContext(),"Bluetooth not supported",Toast.LENGTH_LONG).show();
					}else{
						if(!mybluetooth.isEnabled()){
							startActivityForResult(bluetoothenable,REQUEST_ENABLE_BT);
						}
					}
				}
				
			});
	}
}
