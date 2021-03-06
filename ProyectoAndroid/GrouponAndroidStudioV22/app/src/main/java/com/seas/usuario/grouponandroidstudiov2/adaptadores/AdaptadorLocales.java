package com.seas.usuario.grouponandroidstudiov2.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seas.usuario.grouponandroidstudiov2.R;
import com.seas.usuario.grouponandroidstudiov2.beans.Local;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class AdaptadorLocales extends ArrayAdapter<Local> {
		private ArrayList<Local> items;
		private Context context;
	
		public AdaptadorLocales(Context context,
                                ArrayList<Local> locales) {
			super(context, R.layout.list_item_relative, locales);
			this.items = locales;
			this.context = context;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			Local o = items.get(position);
			if (convertView == null) {
				LayoutInflater layoutInflater =
						(LayoutInflater) LayoutInflater.
						from(context);
				convertView = layoutInflater.inflate(R.layout.list_item_relative, null);
				holder = new ViewHolder();
				holder.icon = (ImageView) convertView.findViewById(R.id.icon);
				holder.text = (TextView) convertView.findViewById(R.id.row_toptext);
				convertView.setTag(holder);
			}

			holder = (ViewHolder) convertView.getTag();
			holder.text.setText(o.getLocalName());


			if (holder.icon != null) {
				new BitmapWorkerTask(holder.icon).execute(o.getUrlImagen());
			}
			return convertView;
		}
	class ViewHolder {
		ImageView icon;
		TextView text;
	}

	// ----------------------------------------------------
	// Load bitmap in AsyncTask
	// ref:
	// http://developer.android.com/training/displaying-bitmaps/process-bitmap.html
	class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
		private final WeakReference<ImageView>
				imageViewReference;
		private String imageUrl;

		public BitmapWorkerTask(ImageView imageView) {
			// Use a WeakReference to ensure the ImageView can be garbage
			// collected
			imageViewReference = new WeakReference<ImageView>
								(imageView);
		}

		// Decode image in background.
		@Override
		protected Bitmap doInBackground(String... params) {
			imageUrl = params[0];
			return loadImage(imageUrl);
		}

		// Once complete, see if ImageView is still around and set bitmap.
		@Override
		protected void onPostExecute(Bitmap bitmap) {
			if (imageViewReference != null && bitmap != null) {
				final ImageView imageView =
						imageViewReference.get();
				if (imageView != null) {
					imageView.setImageBitmap(bitmap);
				}
			}
		}

		private Bitmap loadImage(String URL) {
			Bitmap bitmap = null;
			InputStream in = null;
			try {
				in = openHttpConnection(URL);
				bitmap = BitmapFactory.decodeStream(in);
				in.close();
			} catch (IOException e1) {
			}
			return bitmap;
		}

		private InputStream openHttpConnection(String strURL)
				throws IOException {
			InputStream inputStream = null;
			URL url = new URL(strURL);
			URLConnection conn = url.openConnection();

			try {
				HttpURLConnection httpConn = (HttpURLConnection)
						conn;
				httpConn.setRequestMethod("GET");
				httpConn.connect();

				if (httpConn.getResponseCode() ==
						HttpURLConnection.HTTP_OK) {
					inputStream = httpConn.getInputStream();
				}
			} catch (Exception ex) {
			}
			return inputStream;
		}
	}

}
