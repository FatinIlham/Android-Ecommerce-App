package com.example.ilham.shoe;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ilham.R;
import com.example.ilham.orderdetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class shoe_descfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String name,productid,price,purl;
    private Button addtocartbutton3,buynowbtn3;

    FirebaseDatabase rootnod;
    DatabaseReference referenc;

    private FirebaseUser UProfile;
    private DatabaseReference Ureference;
    private String UUserID;


    public shoe_descfragment() {

    }
    public shoe_descfragment(String name,String productid,String price,String purl) {

        this.name=name;
        this.productid=productid;
        this.price=price;
        this.purl=purl;
    }
    public static shoe_descfragment newInstance(String param1, String param2) {
        shoe_descfragment fragment = new shoe_descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_shoe_descfragment, container, false);

        ImageView imageholdershoe=view.findViewById(R.id.imageholdershoe);
        TextView nameholdershoe=view.findViewById(R.id.nameholdershoe);
        TextView productidholdershoe=view.findViewById(R.id.productidholdershoe);
        TextView priceholdershoe=view.findViewById(R.id.priceholdershoe);

        addtocartbutton3 =(Button)view.findViewById(R.id.addtocartbtnshoe);
        buynowbtn3=(Button)view.findViewById(R.id.Buynowbtnshoe);
        nameholdershoe.setText(name);
        productidholdershoe.setText(productid);
        priceholdershoe.setText(price);
        Glide.with(getContext()).load(purl).into(imageholdershoe);

        UProfile = FirebaseAuth.getInstance().getCurrentUser();
        Ureference = FirebaseDatabase.getInstance().getReference("Users");
        UUserID = UProfile.getUid();
        addtocartbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnod = FirebaseDatabase.getInstance();
                referenc = rootnod.getReference("addtocart/"+UUserID);

                addUserHelperClass3 helperClass3=new addUserHelperClass3(name,productid,price,purl);
                referenc.child(productid).setValue(helperClass3);
                Toast.makeText(getActivity(),"Product is added to your cart",Toast.LENGTH_SHORT).show();
            }
        });

        buynowbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), orderdetails.class);
                intent.putExtra("productid",productid);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });


        return view;
    }
    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.shoewrapper,new shoe_recfragment()).addToBackStack(null).commit();

    }
}
class addUserHelperClass3
{
    String name,productid,price,purl;

    public addUserHelperClass3() {
    }

    public addUserHelperClass3(String name, String productid, String price, String purl) {
        this.name = name;
        this.productid = productid;
        this.price = price;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}