package com.example.androidclientservertest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.os.Build;

public class ConfigureActivity extends Activity {

	public void configure(View view) {
		EditText ip = (EditText)findViewById(R.id.ip_address);
		EditText port = (EditText)findViewById(R.id.port);
		String ip_address = ip.getText().toString();
		int port_no = Integer.parseInt(port.getText().toString());
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		intent.putExtra("ip_address", ip_address);
		intent.putExtra("port_no", port_no);
		startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configure);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.configure, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_configure,
					container, false);
			
			AutoCompleteTextView actv = (AutoCompleteTextView)rootView.findViewById(R.id.ip_address);
			String[] ips = getResources().getStringArray(R.array.ip_addrs);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, ips);
			actv.setAdapter(adapter);
			
			actv = (AutoCompleteTextView)rootView.findViewById(R.id.port);
			String[] ports = getResources().getStringArray(R.array.ports);
			adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, ports);
			actv.setAdapter(adapter);
			
			return rootView;
		}
	}

}
