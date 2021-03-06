package com.myapplication.UIDesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapplication.UIDesign.BaseStation.BaseStationFragment;
import com.myapplication.UIDesign.Equipment.EquipmentFragment;
import com.myapplication.UIDesign.Overview.OverviewFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView overview,area,equipment,baseStation;
    private TextView overviewPoint,areaPoint,equipmentPoint,baseStationPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        initTabMenu();
        overview.setSelected(true);
        replaceFragment(new OverviewFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_menu_overview:
                setSelected();
                overview.setSelected(true);
                replaceFragment(new OverviewFragment());
                break;
            case R.id.tab_menu_area:
                setSelected();
                area.setSelected(true);
                break;
            case R.id.tab_menu_equipment:
                setSelected();
                equipment.setSelected(true);
                replaceFragment(new EquipmentFragment());
                break;
            case R.id.tab_menu_base_station:
                setSelected();
                baseStation.setSelected(true);
                replaceFragment(new BaseStationFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }

    private void bindView(){
        overview=(TextView)findViewById(R.id.tab_menu_overview);
        area=(TextView)findViewById(R.id.tab_menu_area);
        equipment=(TextView)findViewById(R.id.tab_menu_equipment);
        baseStation=(TextView)findViewById(R.id.tab_menu_base_station);

        overviewPoint=(TextView)findViewById(R.id.tab_menu_overview_point);
        areaPoint=(TextView)findViewById(R.id.tab_menu_area_point);
        equipmentPoint=(TextView)findViewById(R.id.tab_menu_equipment_point);
        baseStationPoint=(TextView)findViewById(R.id.tab_menu_base_station_point);

        overview.setOnClickListener(this);
        area.setOnClickListener(this);
        equipment.setOnClickListener(this);
        baseStation.setOnClickListener(this);
    }

    private void initTabMenu(){
        Drawable drawable=getResources().getDrawable(R.drawable.tab_menu_overview);
        drawable.setBounds(0,0,65,65);
        overview.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_area);
        drawable.setBounds(0,0,65,65);
        area.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_equipment);
        drawable.setBounds(0,0,65,65);
        equipment.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_base_station);
        drawable.setBounds(0,0,65,65);
        baseStation.setCompoundDrawables(null,drawable,null,null);

        overview.setOnClickListener(this);
        area.setOnClickListener(this);
        equipment.setOnClickListener(this);
        baseStation.setOnClickListener(this);
    }

    private void setSelected(){
        overview.setSelected(false);
        area.setSelected(false);
        equipment.setSelected(false);
        baseStation.setSelected(false);
    }
}