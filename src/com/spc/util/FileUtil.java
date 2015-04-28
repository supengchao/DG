package com.spc.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import android.content.Context;
import android.os.Environment;
import android.widget.LinearLayout;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.ProgressCallback;
import com.avos.avoscloud.SaveCallback;
import com.loopj.android.image.SmartImageView;
import com.spc.view.progressbutton.CircularProgressButton;

public class FileUtil {
//	static AVQuery<AVObject> avObject= new AVQuery<AVObject>("_File");

	/**
	 * 
	 * 苏鹏超创建于20152015-4-14下午3:31:14
	 * void
	 * TODO 使用ProgressButton加载，上传文件
	 */
	public static void uploadFile(String fileName,final CircularProgressButton button){
		if(ProgressUtil.isReadyReset(button) ){
			button.setProgress(0);
		}else{

			try {
				AVFile file = AVFile.withAbsoluteLocalPath(fileName, Environment.getExternalStorageDirectory()+"/" + fileName);

				file.saveInBackground(new SaveCallback() {

					@Override
					public void done(AVException e) {
						if(e!=null){
							ProgressUtil.setErrorShow(button);
						}else{
							ProgressUtil.setOKShow(button);
							//上传成功
						}
					}
				}, new ProgressCallback() {

					@Override
					public void done(Integer progress) {
						//					button.setProgress(progress);
					}
				});

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 苏鹏超创建于20152015-4-15下午4:07:51
	 * void
	 * TODO 使用ProgressButton加载，下载文件
	 */
	public static void downFile(final Context mContext,final String fileName,final LinearLayout ll_image,final CircularProgressButton button){
		//		AVQuery<AVObject> avObject= new AVQuery<AVObject>("_File");
		if(ProgressUtil.isReadyReset(button) ){
			button.setProgress(0);
		}else{
			AVQuery<AVObject> avObject= new AVQuery<AVObject>("_File");
			avObject.findInBackground(new FindCallback<AVObject>() {

				@Override
				public void done(List<AVObject> arg0, AVException arg1) {
					if(arg1==null){
						for (AVObject avObject : arg0) {
							if(fileName.equals(avObject.getString("name"))){
								SmartImageView siv=new SmartImageView(mContext);
								siv.setImageUrl(avObject.getString("url"));
								ll_image.addView(siv);

							}
						}
						ProgressUtil.setOKShow(button);
					}else{
						ProgressUtil.setErrorShow(button);
					}
				}
			});}
		//下面代码是通过ObjectId来获取图片的文件，然后下载
		//		AVFile.withObjectIdInBackground("552cc375e4b0456cb6051f47", new GetFileCallback<AVFile>() {
		//	      @Override
		//	      public void done(AVFile avFile, AVException e) {
		//	    	  String url=avFile.getUrl();
		//	    	  imageView.setImageUrl(url);
		////	        avFile.getDataInBackground(new GetDataCallback() {
		////	          @Override
		////	          public void done(byte[] bytes, AVException e) {
		////	            Log.d("leancloud", "done,size is " + bytes.length);
		////	          }
		////	        });
		//	      }
		//	    });
	}
	/**
	 * 
	 * 苏鹏超创建于20152015-4-15下午4:48:25
	 * void
	 * TODO 删除指定文件名的所有文件
	 */
	public static void deleteFile(final CircularProgressButton button,final String fileName){
		if(ProgressUtil.isReadyReset(button) ){
			button.setProgress(0);
		}else{
			AVQuery<AVObject> avObject= new AVQuery<AVObject>("_File");
			avObject.findInBackground(new FindCallback<AVObject>() {

				@Override
				public void done(List<AVObject> arg0, AVException arg1) {
					if(arg1==null){
						for (AVObject object : arg0) {
							if(fileName.equals(object.getString("name"))){
								object.deleteInBackground();
							}
						}
						ProgressUtil.setOKShow(button);
					}else{
						ProgressUtil.setErrorShow(button);
					}
				}
			});}
	}


}
