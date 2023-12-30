package com.mk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private RelativeLayout root;
    private boolean isGoBack = false;
    private boolean isFirst = true;
    private ImageView iamgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webView);
        root = (RelativeLayout) findViewById(R.id.root);
        initoperation();
    }

    private void initoperation() {
        initWebView();
        mWebView.loadUrl("file:///android_asset/index.html");
    }

    private void initWebView() {


        mWebView.setWebChromeClient(new WebChromeClient() {

            
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (isFirst)return; 

                view.setVisibility(View.GONE);

                if (newProgress == 100) {

                    
                    view.setVisibility(View.VISIBLE);
                    if (iamgeView != null)iamgeView.setVisibility(View.GONE);

                    
                    Animation translate_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_in_go);
                    Animation translate_out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_out_go);

                    
                    if (isGoBack){
                       translate_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_in_back);
                        translate_out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_out_back);
                    }
                    translate_in.setFillAfter(true);
                    translate_in.setDetachWallpaper(true);
                    translate_out.setFillAfter(true);
                    translate_out.setDetachWallpaper(true);

                   
                    if(null!=iamgeView)iamgeView.startAnimation(translate_out);
                    view.startAnimation(translate_in);

                    
                    translate_out.setAnimationListener(new Animation.AnimationListener(){
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            if(null!=iamgeView){
                                root.removeView(iamgeView);
                                iamgeView=null;
                                isGoBack = false;
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub
                        }

                        @Override
                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub
                        }
                    });

                }else{
                   

                    if(null==iamgeView){
                        iamgeView=new ImageView(MainActivity.this);
                        view.setDrawingCacheEnabled(true);
                        Bitmap bitmap=view.getDrawingCache();
                        if(null!=bitmap){
                            Bitmap b=   Bitmap.createBitmap(bitmap);
                            iamgeView.setImageBitmap(b);
                        }
                        root.addView(iamgeView);
                    }
                }

            }
        });


        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                isFirst = false;
                return super.shouldOverrideUrlLoading(view, url);
            }
        });


        
        WebSettings websettings = mWebView.getSettings();
        websettings.setJavaScriptEnabled(true); 
        websettings.setSupportZoom(true);
        websettings.setBlockNetworkImage(true);  
        websettings.setAppCacheEnabled(true);    
        websettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        websettings.setAllowFileAccess(true);    
        websettings.setDatabaseEnabled(true);    
        webSettings.setDatabaseEnabled(true);
        websettings.setDomStorageEnabled(true);  
        websettings.setDisplayZoomControls(false);
        websettings.setDefaultTextEncodingName("utf-8");
        websettings.setRenderPriority(WebSettings.RenderPriority.HIGH); 
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            isGoBack = true;
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}