package cc.legle.plugin.aesplugin;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;

import android.util.Log;

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
	public boolean execute(String action, String key,String txt,CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		try {
			if(action.equal('encrypto')){
				callbackContext.success(AES.encrypt(txt,key));
			}
			else if(action.equal('decrypto'))
			{
				callbackContext.success(AES.decrypt(txt,key));
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}

}
