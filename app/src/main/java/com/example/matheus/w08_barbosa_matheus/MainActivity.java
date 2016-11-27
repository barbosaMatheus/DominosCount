package com.example.matheus.w08_barbosa_matheus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //current points
    public int pts = 0;

    //undo stack
    public Stack undo_stack = new Stack( );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //handles all button clicks
    @Override
    public void onClick( View v ) {
        //get label and button
        Button button = ( Button ) v;
        String text = button.getText( ).toString( );
        TextView label = ( TextView ) findViewById( R.id.count_label );

        //if it's the clear button
        if( text.equalsIgnoreCase( "Clear" ) ) {
            pts = 0; //clear points
            undo_stack.clear( ); //clear undo stack
        }
        //if it's the undo button
        else if( text.equalsIgnoreCase( "Undo" ) ) {
            if( undo_stack.empty( ) ) return; //if stack is empty just return here

            int previous = ( int ) undo_stack.pop( ); //pop from stack
            pts -= previous; //subtract from pts
            label.setText( Integer.toString( pts ) ); //update label
        }
        //if it's a number button
        else {
            int val_to_add = Integer.parseInt( button.getText( ).toString( ) ); //retrieve number from button
            undo_stack.push( val_to_add ); //push to undo stack
            pts += val_to_add; //add to points
        }

        label.setText( Integer.toString( pts ) ); //update label
    }

}
