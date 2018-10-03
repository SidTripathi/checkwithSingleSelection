package com.tuist.sudhanshu.checkwithsingleselection;

/**
 * Created by ronni on 03-10-2018.
 */


        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CheckBox;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

/**
 * Created by Parsania Hardik on 29-Jun-17.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    public static ArrayList<Model> imageModelArrayList;
    private Context ctx;
    int selected_position = -1;

    public CustomAdapter(Context ctx, ArrayList<Model> imageModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.ctx = ctx;
    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, final int position) {

        holder.checkBox.setText("Checkbox " + position);
        holder.checkBox.setChecked(imageModelArrayList.get(position).getSelected());
        holder.tvAnimal.setText(imageModelArrayList.get(position).getAnimal());

        // holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag(position);
        int selectedindexitem = 0;

        if (selected_position == position) {
            holder.checkBox.setChecked(true);

        } else {
            holder.checkBox.setChecked(false);

        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer pos = (Integer) holder.checkBox.getTag();
                Toast.makeText(ctx, imageModelArrayList.get(pos).getAnimal() + " clicked!", Toast.LENGTH_SHORT).show();

                if (((CheckBox) v).isChecked() && imageModelArrayList.get(pos).getSelected()) {
                    selected_position = position;
                    imageModelArrayList.get(pos).setSelected(true);
                } else {
                    selected_position = -1;
                    imageModelArrayList.get(pos).setSelected(false);
                }


                notifyDataSetChanged();

            }
        });

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer pos = (Integer) holder.checkBox.getTag();
                Toast.makeText(ctx, imageModelArrayList.get(pos).getAnimal() + " clicked!", Toast.LENGTH_SHORT).show();

                if (((LinearLayout) view).isClickable() && imageModelArrayList.get(pos).getSelected()) {
                    selected_position = position;
                    imageModelArrayList.get(pos).setSelected(true);
                    holder.checkBox.setChecked(true);
                } else {
                    selected_position = -1;
                    imageModelArrayList.get(pos).setSelected(true);
                    holder.checkBox.setChecked(false);
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        protected CheckBox checkBox;
        private TextView tvAnimal;
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.cb);
            tvAnimal = (TextView) itemView.findViewById(R.id.animal);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.line);

        }

    }
}