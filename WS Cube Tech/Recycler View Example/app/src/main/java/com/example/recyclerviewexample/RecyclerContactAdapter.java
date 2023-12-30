package com.example.recyclerviewexample;


// Import necessary Android classes
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//create class RecyclerContactAdapter extends with
//RecyclerView.Adapter<inside this type RecyclerContactAdapter.ViewHolder then alt+enter and create class then extend then create a constructor inside it>
//again alt+enter and implement 3 methods. That's all.

// Define a RecyclerContactAdapter class that extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>
public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    // Declare instance variables
    Context context;
    ArrayList<ContactModel> arrContact;

    // Define a constructor that takes a context and an ArrayList of ContactModel objects
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }

    // Override onCreateViewHolder method to inflate the contact_row layout and return a new ViewHolder object
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);      // attachToRoot = always false means not fixed
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Override onBindViewHolder method to bind data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set the contact image, name, and number in the ViewHolder's views
        holder.imgContact.setImageResource(arrContact.get(position).img);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);


//        For updation
        // Set onClickListener for the contact row to allow updating contact information
        holder.liRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a dialog to allow updating contact information
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNumber = dialog.findViewById(R.id.editNumber);
                Button submitBtn = dialog.findViewById(R.id.submitBtn);

                TextView heading = dialog.findViewById(R.id.heading);

                heading.setText("Update Contact");

                submitBtn.setText("Update");


                editName.setText(arrContact.get(position).name);
                editNumber.setText(arrContact.get(position).number);

                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";

                        if (!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        }else {
                            Toast.makeText(context, "Please enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!editNumber.getText().toString().equals("")) {
                            number = editNumber.getText().toString();
                        }else {
                            Toast.makeText(context, "Please enter contact Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.set(position,new ContactModel(arrContact.get(position).img,name,number));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


//        For deletion
        // Set onLongClickListener for the contact row to allow deleting contacts
        holder.liRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // Create an AlertDialog to confirm deleting a contact
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure, want to delete")
                        .setIcon(R.drawable.baseline_delete_forever_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContact.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();

                return true;
            }
        });


//        For animation
        // Call setAnimation method to animate the ViewHolder
        setAnimation(holder.itemView,position);
    }


    // Override getItemCount method to return the size of the ArrayList of contacts
    @Override
    public int getItemCount() {

        return arrContact.size();
    }



    // Define a ViewHolder class that extends RecyclerView.ViewHolder and declares views for contact information
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        ImageView imgContact;
        LinearLayout liRow;

        // Define a constructor that sets the views in the ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.c_name);
            txtNumber = itemView.findViewById(R.id.c_number);
            imgContact = itemView.findViewById(R.id.c_image);
            liRow = itemView.findViewById(R.id.liRow);
        }
    }


    // Declare an instance variable for the last index and a method to set animation for the ViewHolder
    private  int lastIndex = -1;
    private  void  setAnimation(View viewToAnimate, int position){
        if (position > lastIndex) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.setAnimation(slideIn);
            lastIndex = position;
        }
    }
}
