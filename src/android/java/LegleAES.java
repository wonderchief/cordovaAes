package cc.legle.plugin.aesplugin;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LegleAES extends CordovaPlugin {
	
	/**
	 * cordova回调
	 */
	private CallbackContext callbackContext;

	/**
	 * 状态(批量上传和单个上传)
	 */
	private boolean flag;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {

	}


	@Override
	public boolean execute(String action, JSONArray args,CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		String key=args.getString(0);
		String txt=args.getString(1);
		Log.d("=======",action);
		Log.d("=======",key);
		Log.d("=======",txt);
		try {
			if(action.equals("encrypto")){
				try {
					String s = AES.encrypt(txt, key);
					Log.d("=======",s);
					callbackContext.success(s);
				}catch (Exception ex){
					Log.e("=======",ex.getStackTrace().toString());
					callbackContext.error(ex.getMessage());
				}

			}
			else if(action.equals("decrypto"))
			{
				try {
					String s = AES.decrypt(txt, key);
					Log.d("=======",s);
					callbackContext.success(s);
				}catch(Exception ex)
				{
					Log.e("=======",ex.getStackTrace().toString());
					callbackContext.error(ex.getMessage());
				}
			}
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}

}
