package com.openxoft.blink.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.openxoft.blink.R;
import com.openxoft.blink.activities.LoginActivity;
import com.openxoft.blink.activities.MainActivity;
import com.openxoft.blink.activities.ProviderActivity;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.api.ApiService;
import com.openxoft.blink.model.LocationList;
import com.openxoft.blink.model.LoginDetail;
import com.openxoft.blink.model.MainMenuResponse;
import com.openxoft.blink.model.MenuBaseClass;
import com.openxoft.blink.model.Service;
import com.openxoft.blink.model.SignUpData;
import com.openxoft.blink.model.User;
import com.openxoft.blink.util.DateUtil;
import com.openxoft.blink.util.PrefUtil;
import com.openxoft.blink.util.ProgressUtil;
import com.openxoft.blink.util.Warning;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this com.openxoft.blink.fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this com.openxoft.blink.fragment.
 */
public class HomeFragment extends Fragment implements com.android.datetimepicker.date.DatePickerDialog.OnDateSetListener {

    AutoCompleteTextView mRegionsCity;
    Spinner mCategories,mSubCategory,mAdult,mChild,mInfant;
    Button mSearch;
    String cityName=null;
    ArrayAdapter<String>categoryAdapter;
    ArrayAdapter<String>subCategoryAdapter;
    TextView mDate;
    Calendar calendar=Calendar.getInstance();
    private MenuBaseClass object=null;
    private String pax_type=null;
    private String no_Of_Adult=null;
    private String no_Of_Child=null;

    // the com.openxoft.blink.fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    List<String>category;
    List<String>subcategory;

    List<MenuBaseClass>hotelSubCategory;
    RadioGroup mPaxType;
    RadioButton individual,group;

    private OnFragmentInteractionListener mListener;
    MainMenuResponse mainMenuResponse=null;

    public HomeFragment() {
        // Required empty public constructor
    }

    private void initViews(View view)
    {
        mRegionsCity=(AutoCompleteTextView)view.findViewById(R.id.locations);
        mCategories=(Spinner)view.findViewById(R.id.category);
        mSubCategory=(Spinner)view.findViewById(R.id.subcategory);
        mAdult=(Spinner)view.findViewById(R.id.spin_adult);
        mChild=(Spinner)view.findViewById(R.id.spin_child);
        mPaxType=(RadioGroup)view.findViewById(R.id.rg_paxtype);

        individual=(RadioButton)view.findViewById(R.id.rb_individual);
        group=(RadioButton)view.findViewById(R.id.rb_group);

        mInfant=(Spinner)view.findViewById(R.id.spin_infant);
        mDate=(TextView)view.findViewById(R.id.tv_bookingdate);
        mSearch=(Button)view.findViewById(R.id.bt_search);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInput())
                {
                    if(mPaxType.getCheckedRadioButtonId()==R.id.rb_individual)
                    {
                        pax_type=individual.getText().toString();
                    }
                    else
                    {
                        pax_type=group.getText().toString();
                    }


                 Log.d(ApiParams.KEY_LOCATION,String.valueOf(object.getSERLOCATIONID()));
                    Log.d(ApiParams.KEY_CATEGORY_CODE,String.valueOf(object.getMENUID()));
                    Log.d(ApiParams.KEY_SUB_CATEGORY_CODE,String.valueOf(object.getSUBMENUID()));
                    Log.d(ApiParams.KEY_NO_ADULT,no_Of_Adult);
                    Log.d(ApiParams.KEY_PAX_TYPE,pax_type);
                    Log.d(ApiParams.KEY_USER_NAME,PrefUtil.getString(getActivity(),ApiParams.KEY_USER_NAME,ApiParams.KEY_USER_NAME));
                    Log.d(ApiParams.KEY_USER_PASSWORD,PrefUtil.getString(getActivity(),ApiParams.KEY_USER_PASSWORD,ApiParams.KEY_USER_PASSWORD));
                    String data=PrefUtil.getString(getActivity(),ApiParams.KEY_USEROBJECT,ApiParams.KEY_USEROBJECT);
                  LoginDetail loginDetail=new Gson().fromJson(data,LoginDetail.class);
                    Log.d(ApiParams.KEY_FROM_DATE,mDate.getText().toString());
                    Log.d(ApiParams.KEY_ACCESS_ID,loginDetail.getData().getULACCESSID());
                    loginCall();
                   // searchServices();


                }
                //startActivity(new Intent(getActivity(),ProviderActivity.class));
            }
        });
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                com.android.datetimepicker.date.DatePickerDialog.newInstance(HomeFragment.this,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show(getActivity().getFragmentManager(),"DatePicker");
            }
        });

        IntilizeFields();


    }

    private boolean validateInput()
    {
       if(object==null)
       {
           Toast.makeText(getActivity(), Warning.NEED_TO_SELECT_SUB_SERVICE,Toast.LENGTH_SHORT).show();

       }
        if(mDate.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),Warning.NEED_TO_SELECT_DATE,Toast.LENGTH_SHORT).show();

        }
        if(no_Of_Adult==null)
        {
            Toast.makeText(getActivity(),Warning.NEED_TO_SELECT_ADULTS,Toast.LENGTH_SHORT).show();
        }
        else
        {
            return true;
        }
        return false;
    }
private void searchServices()
{
    String data=PrefUtil.getString(getActivity(),ApiParams.KEY_USEROBJECT,ApiParams.KEY_USEROBJECT);
    LoginDetail loginDetail=new Gson().fromJson(data,LoginDetail.class);

    Retrofit retrofit=new Retrofit.Builder().baseUrl(ApiParams.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    ApiService apiService=retrofit.create(ApiService.class);
    Call<List<Service>>call=apiService.makeSearch(ApiParams.TAG_SERVICE_DETAIL,
            PrefUtil.getString(getActivity(),ApiParams.KEY_USER_NAME,ApiParams.KEY_USER_NAME),
            PrefUtil.getString(getActivity(),ApiParams.KEY_USER_PASSWORD,ApiParams.KEY_USER_PASSWORD),String.valueOf(object.getSERLOCATIONID()),String.valueOf(object.getMENUID()),String.valueOf(object.getSUBMENUID()),mDate.getText().toString(),pax_type,
            String.valueOf(no_Of_Adult),String.valueOf(no_Of_Child),String.valueOf(0),loginDetail.getData().getULACCESSID());
    call.enqueue(new Callback<List<Service>>() {
        @Override
        public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
            Log.d("Response",response.body().get(0).getLanguages());
        }

        @Override
        public void onFailure(Call<List<Service>> call, Throwable t) {

            Log.d("Failure",t.getMessage());

        }
    });

}
   /* Call<List<Service>>makeSearch(@Field(ApiParams.TAG)String tag,
                                  @Field(ApiParams.KEY_USER_NAME)String userName,
                                  @Field(ApiParams.KEY_USER_PASSWORD)String userPassword,
                                  @Field(ApiParams.KEY_LOCATION)String location,
                                  @Field(ApiParams.KEY_CATEGORY_CODE)String categoryCode,
                                  @Field(ApiParams.KEY_SUB_CATEGORY_CODE)String subCategoryCode,
                                  @Field(ApiParams.KEY_FROM_DATE)String fromDate,
                                  @Field(ApiParams.KEY_PAX_TYPE)String paxType,
                                  @Field(ApiParams.KEY_NO_ADULT)String no_of_adult,
                                  @Field(ApiParams.KEY_NO_CHILD)String no_of_child,
                                  @Field(ApiParams.KEY_NO_INFANT)String no_of_infant,
                                  @Field(ApiParams.KEY_ACCESS_ID)String access_id

    );*/
   private void loginCall() {

        ProgressUtil.showProgressDialog(getActivity());
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiParams.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
       String data=PrefUtil.getString(getActivity(),ApiParams.KEY_USEROBJECT,ApiParams.KEY_USEROBJECT);
       LoginDetail loginDetail=new Gson().fromJson(data,LoginDetail.class);

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Service>>call=apiService.makeSearch(ApiParams.TAG_SERVICE_DETAIL,PrefUtil.getString(getActivity(),ApiParams.KEY_USER_NAME,ApiParams.KEY_USER_NAME),
                PrefUtil.getString(getActivity(),ApiParams.KEY_USER_PASSWORD,ApiParams.KEY_USER_PASSWORD),
                String.valueOf(object.getSERLOCATIONID()),String.valueOf(object.getMENUID()),
                String.valueOf(object.getSUBMENUID()),mDate.getText().toString(),pax_type,String.valueOf(no_Of_Adult),String.valueOf(0),String.valueOf(0),loginDetail.getData().getULACCESSID());
       call.enqueue(new Callback<List<Service>>() {
           @Override
           public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {

               Log.d("Response",response.body().get(0).getCurrency());

                    ProgressUtil.hideProgressDialog();

           }

           @Override
           public void onFailure(Call<List<Service>> call, Throwable t) {

               Log.d("Failure",t.getMessage().toString());
              ProgressUtil.hideProgressDialog();
           }
       });



    }

    private void IntilizeFields() {
        final String adult[]={"Adult","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
        final String child[]={"Child","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
        String infant[]={"Infant","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
        final List<String> locationslist=new ArrayList<>();
        category=new ArrayList<>();
        subcategory=new ArrayList<>();
        hotelSubCategory=new ArrayList<>();

        String data=PrefUtil.getString(getActivity(),ApiParams.SINGUP_DATA,ApiParams.SINGUP_DATA);
        Log.d("Home Data",data);
        SignUpData signUpData = new Gson().fromJson(data, SignUpData.class);
if(signUpData!=null)
{
    for(int i=0;i<signUpData.getLocationList().size();i++)
    {
        LocationList locationList=signUpData.getLocationList().get(i);
        locationslist.add(locationList.getCITY());
    }
}

        mRegionsCity.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,locationslist));
        TextView textView=new TextView(getActivity());
        textView.setText("Select City/ Region");

        mRegionsCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(mRegionsCity.getText().toString().isEmpty()&& mCategories.getVisibility()!=View.GONE)
                {
                    mCategories.setVisibility(View.GONE);
                    if(mSubCategory.getVisibility()!=View.GONE)
                    {
                        mSubCategory.setVisibility(View.GONE);
                    }
                }

            }
        });
        mRegionsCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cityName=mRegionsCity.getText().toString();
                getMenuSubMenuData();
            }
        });

        categoryAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,category);
        mCategories.setAdapter(categoryAdapter);
        mCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Position",String.valueOf(i));
                fillSubCategory(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        subCategoryAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,subcategory);
        mSubCategory.setAdapter(subCategoryAdapter);
        mSubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:

                        break;
                    case 1:

                        object=hotelSubCategory.get(i-1);
                        break;
                    case 2:
                        object=hotelSubCategory.get(i-1);
                         break;
                    case 3:

                        object=hotelSubCategory.get(i-1);
                        break;
                    case 4:
                        object=hotelSubCategory.get(i-1);
                        break;

                    case 5:
                        object=hotelSubCategory.get(i-1);
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mAdult.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,adult));
        mChild.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,child));
        mInfant.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,infant));
        mAdult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(i==0)
               {

               }
                else
               {
                   no_Of_Adult=adult[i];
                   Log.d("No of Adult",no_Of_Adult);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {

                }
                else
                {
                    no_Of_Child=child[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    /**
     * Use this factory method to create a new instance of
     * this com.openxoft.blink.fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of com.openxoft.blink.fragment HomeFragment.
     */

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this com.openxoft.blink.fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDateSet(com.android.datetimepicker.date.DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        calendar.set(year,monthOfYear,dayOfMonth);

        DateUtil.resetDate(getActivity(),mDate,calendar);

    }

    /**
     * This interface must be implemented by activities that contain this
     * com.openxoft.blink.fragment to allow an interaction in this com.openxoft.blink.fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

    private void getMenuSubMenuData()
    {
        category.clear();


        Retrofit retrofit=new Retrofit.Builder().baseUrl(ApiParams.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService=retrofit.create(ApiService.class);
        Call<MainMenuResponse>call=apiService.getMenuSubMenuDetails(ApiParams.TAG_MENU_SUBMENU,cityName);
        call.enqueue(new Callback<MainMenuResponse>() {
            @Override
            public void onResponse(Call<MainMenuResponse> call, Response<MainMenuResponse> response) {
                mainMenuResponse=response.body();

                fillMainMenu();
            }

            @Override
            public void onFailure(Call<MainMenuResponse> call, Throwable t) {

                Log.d("Failure",t.getMessage());

            }
        });
    }

    private void fillMainMenu() {
        mCategories.setVisibility(View.VISIBLE);
        category.add("Select Service");

        if(mainMenuResponse.getHotel().size()>0)
        {
            category.add(mainMenuResponse.getHotel().get(0).getMENU());

        }
        if(mainMenuResponse.getTransportation().size()>0)
        {
            category.add(mainMenuResponse.getTransportation().get(0).getMENU());

        }
        if(mainMenuResponse.getToursAndExcursions().size()>0)
        {
            category.add(mainMenuResponse.getToursAndExcursions().get(0).getMENU());

        }
        if(mainMenuResponse.getPackages().size()>0)
        {
            category.add(mainMenuResponse.getPackages().get(0).getMENU());

        }
        if(mainMenuResponse.getEntertainmentMore().size()>0)
        {
            category.add(mainMenuResponse.getEntertainmentMore().get(0).getMENU());

        }
        categoryAdapter.notifyDataSetChanged();

    }

    private void fillSubCategory(int position)
    {
        subcategory.clear();
        subcategory.add("Select Sub Service");
        hotelSubCategory.clear();






        mSubCategory.setVisibility(View.VISIBLE);
        switch (position)
        {
            case 0:
                if(mSubCategory.getVisibility()!=View.GONE)
                {
                    mSubCategory.setVisibility(View.GONE);
                }

                break;
            case 1:
                for(int i=0;i<mainMenuResponse.getHotel().size();i++)
                {
                    subcategory.add(mainMenuResponse.getHotel().get(i).getSUBMENU());
                    hotelSubCategory.add(mainMenuResponse.getHotel().get(i));
                }
                break;
            case 2:
                for(int i=0;i<mainMenuResponse.getTransportation().size();i++)
                {
                    subcategory.add(mainMenuResponse.getTransportation().get(i).getSUBMENU());
                    hotelSubCategory.add(mainMenuResponse.getTransportation().get(i));
                }
                break;
            case 3:
                for(int i=0;i<mainMenuResponse.getToursAndExcursions().size();i++)
                {
                    subcategory.add(mainMenuResponse.getToursAndExcursions().get(i).getSUBMENU());
                    hotelSubCategory.add(mainMenuResponse.getToursAndExcursions().get(i));
                }
                break;
            case 4:
                for(int i=0;i<mainMenuResponse.getPackages().size();i++)
                {
                    subcategory.add(mainMenuResponse.getPackages().get(i).getSUBMENU());
                    hotelSubCategory.add(mainMenuResponse.getPackages().get(i));

                }
                break;
            case 5:
                for(int i=0;i<mainMenuResponse.getEntertainmentMore().size();i++)
                {
                    subcategory.add(mainMenuResponse.getEntertainmentMore().get(i).getSUBMENU());
                    hotelSubCategory.add(mainMenuResponse.getEntertainmentMore().get(i));
                }
                break;

        }
        subCategoryAdapter.notifyDataSetChanged();



    }



}
