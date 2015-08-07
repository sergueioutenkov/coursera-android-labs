package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create variables named 	
	// mCreate, mRestart, mStart and mResume 	
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.

	private int mCreate;
	private int mRestart;
	private int mStart;
	private int mResume;

	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.

	// TODO: Create variables for each of the TextViews
	private TextView textCreate;
	private TextView textRestart;
	private TextView textStart;
	private TextView textResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		textCreate = (TextView) findViewById(R.id.create);
		textRestart = (TextView) findViewById(R.id.restart);
		textStart = (TextView) findViewById(R.id.start);
		textResume = (TextView) findViewById(R.id.resume);

		Button closeButton = (Button) findViewById(R.id.bClose);
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();

			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mRestart=savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);

		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// TODO:
		mCreate++;
		displayCounts();




	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// TODO:
		mStart++;
		displayCounts();




	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// TODO:
		mResume++;
		displayCounts();



	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// TODO:
		mRestart++;
		displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);
	}


	public void displayCounts() {

		textCreate.setText("onCreate() calls: " + mCreate);
		textStart.setText("onStart() calls: " + mStart);
		textResume.setText("onResume() calls: " + mResume);
		textRestart.setText("onRestart() calls: " + mRestart);

	}
}
