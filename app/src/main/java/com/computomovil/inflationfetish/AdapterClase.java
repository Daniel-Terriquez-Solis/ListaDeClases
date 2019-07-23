package com.computomovil.inflationfetish;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterClase extends BaseAdapter {

    List<Clase> clases = new ArrayList<>();
    Context context;

    public AdapterClase(){

    }

    public AdapterClase(List<Clase> clases, Context context){
        this.clases = clases;
        this.context = context;
    }


    @Override
    public int getCount() {
        return clases.size();
    }

    @Override
    public Object getItem(int position) {
        return clases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final Context context = parent.getContext();
            final Clase claseActual = clases.get(position);
            LinearLayout view = new LinearLayout(context);
            view.setOrientation(LinearLayout.VERTICAL);
            view.setPadding(5, 5, 5, 5);
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, GenQR.class);
                    intent.putExtra("ID", String.valueOf(claseActual.getId()));
                    context.startActivity(intent);
                }
            });

            LinearLayout view2a = new LinearLayout(context);
            view2a.setOrientation(LinearLayout.HORIZONTAL);
            view2a.setMinimumHeight(90);

            LinearLayout view3 = new LinearLayout(context);
            view3.setOrientation(LinearLayout.VERTICAL);
            view3.setGravity(Gravity.CENTER);
            view3.setPadding(5, 0, 50, 0);

            TextView name = new TextView(context);
            name.setText(claseActual.getName());
            view3.addView(name);
            TextView hour = new TextView(context);
            String textHour = claseActual.getHourStart() + "     -     " + claseActual.getHourEnd();
            hour.setText(textHour);
            view3.addView(hour);
            view2a.addView(view3);

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            if(claseActual.getHourStart() == currentHour){
                Button attendanceButton = new Button(context);
                attendanceButton.setText(context.getResources().getString(R.string.button_confirmar));
                attendanceButton.setBackgroundColor(context.getResources().getColor(R.color.attandanceGreen));
                attendanceButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final int pos = position;
                        final List<Clase> clases = AdapterClase.this.clases;
                        clases.get(pos).setAttended(true);
                        clases.get(pos).setHappened(true);
                        for (int i = 0; i < pos; i++){
                            clases.get(i).setHappened(true);
                        }
                    }
                });
                view2a.addView(attendanceButton);
            }
            view.addView(view2a);


            LinearLayout view2b = new LinearLayout(context);
            view2b.setOrientation(LinearLayout.HORIZONTAL);
            view2b.setMinimumHeight(10);
            if(claseActual.isAttended()&&claseActual.isHappened()){
                view2b.setBackgroundColor(context.getResources().getColor(R.color.attandanceGreen));
            }else if (claseActual.isHappened()){
                view2b.setBackgroundColor(context.getResources().getColor(R.color.skipRed));
            }
            view.addView(view2b);
            return view;
        }
        return convertView;
    }

    public void guardarClases(List<Clase> clases){

    }

    public List<Clase> getCourses() {
        return clases;
    }

    public void setCourses(List<Clase> clases) {
        this.clases = clases;
    }
}