package com.lgx.test.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lgx.test.R;
import com.lgx.test.base.BaseFragment;
import com.lgx.test.common.CommonUtils;
import com.lgx.test.common.Constants;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.OnClick;

import static com.lgx.test.R.id.am20;
import static com.lgx.test.R.id.am21;
import static com.lgx.test.R.id.am22;
import static com.lgx.test.R.id.am23;
import static com.lgx.test.R.id.am24;

/**
 * Created by Harry on 2017/8/7.
 */

public class CommercialFragment extends BaseFragment {




    @BindView(R.id.commercialEditText)
    EditText mCommercialEditText;
    @BindView(R.id.commercialTextInput)
    TextInputLayout mCommercialTextInput;
    @BindView(R.id.submit)
    Button mSubmit;
    @BindView(R.id.reset)
    Button mReset;
    @BindView(R.id.yearSpinner)
    Spinner mYearSpinner;
    @BindView(R.id.rateSpinner)
    Spinner mRateSpinner;
    @BindView(R.id.rateEditText)
    EditText mRateEditText;
    @BindView(R.id.yearEditText)
    EditText mYearEditText;
    @BindView(R.id.am10)
    TextView mAm10;
    @BindView(am20)
    TextView mAm20;
    @BindView(R.id.am11)
    TextView mAm11;
    @BindView(am21)
    TextView mAm21;
    @BindView(R.id.am12)
    TextView mAm12;
    @BindView(am22)
    TextView mAm22;
    @BindView(R.id.am13)
    TextView mAm13;
    @BindView(am23)
    TextView mAm23;
    @BindView(R.id.am14)
    TextView mAm14;
    @BindView(am24)
    TextView mAm24;

    public static Fragment newInstance(boolean isLazy) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(BaseFragment.IS_LAZY, isLazy);
        CommercialFragment fragment = new CommercialFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_commercial;
    }

    @Override
    protected void initView() {
        initSpinner();
    }

    private void initSpinner() {
        // 将可选内容与ArrayAdapter连接起来
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, Constants.year);
        // 设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 将adapter 添加到spinner中
        mYearSpinner.setAdapter(adapter);
        mYearSpinner.setSelection(7, true);
        // 设置默认值
        mYearSpinner.setVisibility(View.VISIBLE);

        mYearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mYearEditText.setText(Constants.year[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 将可选内容与ArrayAdapter连接起来
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, Constants.rate);
        // 设置下拉列表的风格
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 将adapter 添加到spinner中
        mRateSpinner.setAdapter(adapter1);
        mRateSpinner.setSelection(6, true);
        // 设置默认值

        mRateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                java.math.BigDecimal bg = new java.math.BigDecimal(CommonUtils.getRate(position));
                String str = bg.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
                mRateEditText.setText(str);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void getData() {

    }


    @OnClick({R.id.submit, R.id.reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.submit:
                String value = mCommercialEditText.getText().toString();
                if (TextUtils.isEmpty(value)) {
                    mCommercialTextInput.setError("贷款总额不能为空");
                    return;
                }
                String yearValue = mYearEditText.getText().toString();
                if (TextUtils.isEmpty(yearValue)) {
                    new AlertDialog.Builder(getActivity()).setTitle("提示")
                            .setMessage("年限不能为空").setPositiveButton("OK", null)
                            .show();
                    return;
                }
                String rateValue = mRateEditText.getText().toString();
                if (TextUtils.isEmpty(rateValue)) {
                    new AlertDialog.Builder(getActivity()).setTitle("提示")
                            .setMessage("利率不能为空").setPositiveButton("OK", null)
                            .show();
                    return;
                }
                calculate(Double.parseDouble(value) * 10000, Double.parseDouble(yearValue) * 12, Double.parseDouble(rateValue) / 100);

                break;
            case R.id.reset:
                break;
        }
    }

    /**
     * @param ze   总额
     * @param nx   年限
     * @param rate 利率
     */
    public void calculate(double ze, double nx, double rate) {
        double zem = (ze * rate / 12 * Math.pow((1 + rate / 12), nx))
                / (Math.pow((1 + rate / 12), nx) - 1);
        double amount = zem * nx;
        double rateAmount = amount - ze;

        BigDecimal zemvalue = new BigDecimal(zem);
        double zemval = zemvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal amountvalue = new BigDecimal(amount);
        double amountval = amountvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal rateAmountvalue = new BigDecimal(rateAmount);
        double rateAmountval = rateAmountvalue.setScale(2,
                BigDecimal.ROUND_HALF_UP).doubleValue();

        double benjinm = ze / nx;
        double lixim = ze * (rate / 12);
        double diff = benjinm * (rate / 12);
        double huankuanm = benjinm + lixim;
        double zuihoukuan = diff + benjinm;
        double av = (huankuanm + zuihoukuan) / 2;
        double zong = av * nx;
        double zongli = zong - ze;

        BigDecimal huankuanmvalue = new BigDecimal(huankuanm);
        double huankuanmval = huankuanmvalue.setScale(2,
                BigDecimal.ROUND_HALF_UP).doubleValue();

        BigDecimal diffvalue = new BigDecimal(diff);
        double diffmval = diffvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal zongvalue = new BigDecimal(zong);
        double zongval = zongvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal zonglivalue = new BigDecimal(zongli);
        double zonglival = zonglivalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        mAm10.setText(ze + "元");
        mAm20.setText(ze + "元");

        mAm11.setText(nx + "月");
        mAm21.setText(nx + "月");

        mAm12.setText(zemval + "元");
        mAm22.setText("首月" + huankuanmval + ",月减" + diffmval);

        mAm13.setText(rateAmountval / 10000 + "万元");
        mAm23.setText(zonglival / 10000 + "万元");

        mAm14.setText(amountval / 10000 + "万元");
        mAm24.setText(zongval / 10000 + "万元");
    }
}
