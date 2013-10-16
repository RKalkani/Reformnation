package com.kalkani.reformnation;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

	private Context context = null;
	private ArrayList<Data> data = null;
	public static final int images[] = { R.drawable.img_1, R.drawable.img_2,
			R.drawable.img_3, R.drawable.img_4, R.drawable.img_8, };

	public MyListAdapter(Context context, ArrayList<Data> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Data getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public class ViewHolder {
		ImageView imageView;
		TextView title;

		public ViewHolder(View v) {
			imageView = (ImageView) v.findViewById(R.id.list_image);
			title = (TextView) v.findViewById(R.id.list_title);
		}

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		ViewHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.list_row, parent, false);
			holder = new ViewHolder(row);
			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}
		if (position < images.length) {
			holder.imageView.setImageResource(images[position]);
		} else {
			holder.imageView.setImageResource(R.drawable.splash);
		}
		holder.title.setText(data.get(position).getHeading());

		return row;
	}

}
