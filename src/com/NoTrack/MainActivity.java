package com.NoTrack;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;


import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
public class MainActivity extends Activity  
{
		
	//	private TextView mMsgText = null;
		private WebView webView = null;
		//private EditText mIpEditext = null;
		protected void onCreate(Bundle savedInstanceState) 
		{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main);
			
				webView = (WebView) findViewById(R.id.webView);
				WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
		//webView.loadUrl("file:///android_asset/www/index.html");		
					
			init("file:///android_asset/www/index.html");//http://yaaw.ghostry.cn/
			
		}
		
	 private void init(String urlname){
        
				//webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //WebView加载web资源
       webView.loadUrl(urlname);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
       webView.setWebViewClient(new WebViewClient(){
           @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
             view.loadUrl(url);
            return true;
           }
           });
        }
		//改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();//返回上一页面
                return true;
            }
            else
            {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}



