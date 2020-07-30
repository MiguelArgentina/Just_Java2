

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the Increment button is clicked.
     */
    public void Increment(View view) {

        quantity = quantity + 1;
        display(quantity);
        clearPriceAndThanks();

    }

    /**
     * This method is called when the Decrement button is clicked.
     */
    public void Decrement(View view) {

        if (quantity == 1) {
            return;
        }
        quantity = quantity - 1;
        display(quantity);
        clearPriceAndThanks();

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = quantity * 5;
        String priceMessage = getString(R.string.txtPriceText) + NumberFormat.getCurrencyInstance().format(price);
        priceMessage = priceMessage + "\n\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        displayMessage(getString(R.string.txtPriceText) + " " + NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void clearPriceAndThanks() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(getString(R.string.txtPriceText));

    }

}