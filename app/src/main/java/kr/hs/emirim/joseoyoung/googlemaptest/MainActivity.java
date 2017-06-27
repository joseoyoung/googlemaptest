package kr.hs.emirim.joseoyoung.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Switch;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap googleMap;
    SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.541,126.986),17));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public static final int ITEM_SATELLITE=1;//상수 선언
    public static final int ITEM_NORMAL=2;
    public static final int ITEM_WANGSIMNI=3;
    public static final int ITEM_Heangdang=4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, ITEM_SATELLITE, 0, "위성 지도");
        menu.add(0, ITEM_NORMAL, 0, "일반 지도");
        SubMenu hotMenu=menu.addSubMenu("핫 플레이스");
        hotMenu.add(0, ITEM_WANGSIMNI, 0, "왕십리");
        hotMenu.add(0, ITEM_Heangdang, 0, "행당중학교");
    //    menu.add(0, ITEM_WANGSIMNI, 0, "왕십리");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case ITEM_SATELLITE: googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case ITEM_NORMAL: googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case ITEM_WANGSIMNI: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.561332,127.035516),17));
                return true;
            case ITEM_Heangdang: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.554349,127.042513),17));
                return true;
        }
        return false;
    }
}
