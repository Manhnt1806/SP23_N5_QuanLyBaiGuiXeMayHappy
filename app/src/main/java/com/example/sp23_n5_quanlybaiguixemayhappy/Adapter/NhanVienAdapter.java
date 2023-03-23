package com.example.sp23_n5_quanlybaiguixemayhappy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.NhanVien;
import com.example.sp23_n5_quanlybaiguixemayhappy.R;

import java.util.List;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {

    private Context context;
    private int resource;
    private List<NhanVien> objects;
    private LayoutInflater inflater;


    public NhanVienAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            convertView = inflater.inflate(R.layout.item_listview_qlnhanvien,null);
            holder.tvidNv = (TextView)convertView.findViewById(R.id.item_lv_idNv);
            holder.tvtenNv = (TextView)convertView.findViewById(R.id.item_lv_nameNv);
            holder.tvpassNv = (TextView)convertView.findViewById(R.id.item_lv_passNv);
            holder.tvSdtNv = (TextView)convertView.findViewById(R.id.item_lv_SdtNv);
            holder.tvStatusNv = (TextView)convertView.findViewById(R.id.item_lv_statusNv);
            holder.tvChucvuNv = (TextView)convertView.findViewById(R.id.item_lv_ChucvuNv);

            holder.temp1 = (TextView)convertView.findViewById(R.id.temp_1);
            holder.temp2 = (TextView)convertView.findViewById(R.id.temp_2);
            holder.temp3 = (TextView)convertView.findViewById(R.id.temp_3);
            holder.temp4 = (TextView)convertView.findViewById(R.id.temp_4);
            holder.temp5 = (TextView)convertView.findViewById(R.id.temp_5);
            holder.temp6 = (TextView)convertView.findViewById(R.id.temp_6);

            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        NhanVien nv = objects.get(position);
        holder.tvidNv.setText(String.valueOf(nv.getIdNV()));
        holder.tvtenNv.setText(nv.getTenNV());
        holder.tvSdtNv.setText(nv.getSdtNV());
        holder.tvpassNv.setText(nv.getPassNV());
        holder.tvStatusNv.setText(String.valueOf(nv.getStatusNV()));
        holder.tvChucvuNv.setText(nv.getChucVu());

        holder.temp1.setText("Mã nhân Viên: ");
        holder.temp2.setText("Tên nhân viên: ");
        holder.temp3.setText("Số điện thoại: ");
        holder.temp4.setText("Mật khẩu: ");
        holder.temp5.setText("Trạng thái: ");
        holder.temp6.setText("Chức vụ: ");

        return convertView;
    }

    public class ViewHolder{
        TextView tvidNv,tvtenNv,tvpassNv,tvStatusNv,tvSdtNv,tvChucvuNv,temp1,temp2,temp3,temp4,temp5,temp6;
    }
}
