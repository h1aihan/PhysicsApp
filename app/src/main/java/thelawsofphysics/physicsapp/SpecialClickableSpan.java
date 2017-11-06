package thelawsofphysics.physicsapp;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

class SpecialClickableSpan extends ClickableSpan {
    private String text;
    private Context myContext;
    SpecialClickableSpan(String text, Context c){
        super();
        this.text = text;
        myContext = c;
    }

    @Override
    public void onClick(View widget) {
        if(text.equals("="))
        {
            Intent startIntent = new Intent(myContext, Equation.class);
            TextView equation = (TextView)widget;
            startIntent.putExtra("substitute", equation.getText().toString());
            myContext.startActivity(startIntent);
        }
        else
        {
            Intent startIntent = new Intent(myContext, SearchPage.class);
            startIntent.putExtra("search", text);
            myContext.startActivity(startIntent);
        }
    }
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(false);
    }
}
