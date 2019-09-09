package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText numbInput;
	private Button button ;
	int random ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.numbInput =findViewById(R.id.number_input);
//		outputText = findViewById(R.id.text_output);
		this.button=  findViewById(R.id.guess_button);
		this.initRandomNumber();
		// TODO: bind layout di sini
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random r = new Random();
		this.random= r.nextInt(100);
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		initRandomNumber();
		String input = numbInput.getText().toString();

		if(input.equals("")){
			Toast.makeText(this, "Masukkan Angka Random (1 - 100)",Toast.LENGTH_SHORT).show();
		}else{
			int numb = Integer.parseInt(numbInput.getText().toString());
			if (numb==random){
				this.button.setEnabled(false);
				Toast.makeText(this, R.string.right_answer,Toast.LENGTH_SHORT).show();
			}else if(numb<=random){
				Toast.makeText(this, R.string.lt_answer,Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, R.string.gt_answer,Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		this.numbInput.setText("");
		this.button.setEnabled(true);
	}
}
