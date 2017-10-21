package com.lgx.test.fragments;

import android.app.AlertDialog;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.lgx.test.R;
import com.lgx.test.base.BaseFragment;
import com.lgx.test.common.CommonUtils;
import com.lgx.test.common.Constants;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.OnClick;

import static com.lgx.test.R.id.am24;

/**
 * Created by Harry on 2017/8/8.
 */

public class MixedFragment extends BaseFragment {
    @BindView(R.id.yearSpinner)
    Spinner mYearSpinner;
    @BindView(R.id.yearEditText)
    EditText mYearEditText;
    @BindView(R.id.reserveEditText)
    EditText mReserveEditText;
    @BindView(R.id.reserveTextInput)
    TextInputLayout mReserveTextInput;
    @BindView(R.id.rateEditText)
    EditText mRateEditText;
    @BindView(R.id.rateTextInput)
    TextInputLayout mRateTextInput;
    @BindView(R.id.commercialEditText)
    EditText mCommercialEditText;
    @BindView(R.id.commercialTextInput)
    TextInputLayout mCommercialTextInput;
    @BindView(R.id.rateSpinner)
    Spinner mRateSpinner;
    @BindView(R.id.rateCommericalEditText)
    EditText mRateCommericalEditText;
    @BindView(R.id.submit)
    Button mSubmit;
    @BindView(R.id.reset)
    Button mReset;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.am10)
    TextView mAm10;
    @BindView(R.id.am20)
    TextView mAm20;
    @BindView(R.id.am11)
    TextView mAm11;
    @BindView(R.id.am21)
    TextView mAm21;
    @BindView(R.id.am12)
    TextView mAm12;
    @BindView(R.id.am22)
    TextView mAm22;
    @BindView(R.id.am13)
    TextView mAm13;
    @BindView(R.id.am23)
    TextView mAm23;
    @BindView(R.id.am14)
    TextView mAm14;
    @BindView(am24)
    TextView mAm24;
    @BindView(R.id.t2)
    TableLayout mT2;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_mixed;
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


    @OnClick({R.id.submit, R.id.reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.submit:
                String valueReserve = mReserveEditText.getText().toString();
                String yearValue = mYearEditText.getText().toString();
                if (TextUtils.isEmpty(yearValue)) {
                    new AlertDialog.Builder(getActivity()).setTitle("提示")
                            .setMessage("年限不能为空").setPositiveButton("OK", null)
                            .show();
                    return;
                }
                if (TextUtils.isEmpty(valueReserve)) {
                    mReserveTextInput.setError("公积金贷款总额不能为空");
                    return;
                }else{
                    mReserveTextInput.setError("");
                }

                String value = mCommercialEditText.getText().toString();
                if (TextUtils.isEmpty(value)) {
                    mCommercialTextInput.setError("贷款总额不能为空");
                    return;
                }else{
                    mCommercialTextInput.setError("");
                }

                String rateValue = mRateEditText.getText().toString();
                if (TextUtils.isEmpty(rateValue)) {
                    new AlertDialog.Builder(getActivity()).setTitle("提示")
                            .setMessage("公积金利率不能为空").setPositiveButton("OK", null)
                            .show();
                    return;
                }

                String rateCommercialValue = mRateCommericalEditText.getText().toString();
                if (TextUtils.isEmpty(rateCommercialValue)) {
                    new AlertDialog.Builder(getActivity()).setTitle("提示")
                            .setMessage("商业贷款利率不能为空").setPositiveButton("OK", null)
                            .show();
                    return;
                }
                calculate(Double.parseDouble(valueReserve) * 10000, Double.parseDouble(yearValue) * 12, Double.parseDouble(rateValue) / 100,
                        Double.parseDouble(value) * 10000, Double.parseDouble(rateCommercialValue) / 100);

                break;
            case R.id.reset:
                break;
        }
    }

    @Override
    protected void getData() {

    }


    public void calculate(double ze, double nx, double rate, double ze1, double rate1) {
        double zem = (ze * rate / 12 * Math.pow((1 + rate / 12), nx))
                / (Math.pow((1 + rate / 12), nx) - 1);
        double amount = zem * nx;
        double rateAmount = amount - ze;

        double zem1 = (ze1 * rate1 / 12 * Math.pow((1 + rate1 / 12), nx))
                / (Math.pow((1 + rate1 / 12), nx) - 1);
        double amount1 = zem1 * nx;
        double rateAmount1 = amount1 - ze1;

        BigDecimal zemvalue = new BigDecimal(zem + zem1);
        double zemval = zemvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal amountvalue = new BigDecimal(amount + amount1);
        double amountval = amountvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal rateAmountvalue = new BigDecimal(rateAmount + rateAmount1);
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

        double benjinm1 = ze1 / nx;
        double lixim1 = ze1 * (rate1 / 12);
        double diff1 = benjinm1 * (rate1 / 12);
        double huankuanm1 = benjinm1 + lixim1;
        double zuihoukuan1 = diff1 + benjinm1;
        double av1 = (huankuanm1 + zuihoukuan1) / 2;
        double zong1 = av1 * nx;
        double zongli1 = zong1 - ze1;

        BigDecimal huankuanmvalue = new BigDecimal(huankuanm + huankuanm1);
        double huankuanmval = huankuanmvalue.setScale(2,
                BigDecimal.ROUND_HALF_UP).doubleValue();

        BigDecimal diffvalue = new BigDecimal(diff + diff1);
        double diffmval = diffvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal zongvalue = new BigDecimal(zong + zong1);
        double zongval = zongvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        BigDecimal zonglivalue = new BigDecimal(zongli + zongli1);
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
