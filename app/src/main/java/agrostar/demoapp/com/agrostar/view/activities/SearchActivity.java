package agrostar.demoapp.com.agrostar.view.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ImageView;

import java.util.List;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.utils.OfflineData;
import agrostar.demoapp.com.agrostar.utils.UtilsMethod;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Deep Verma on 22/5/16.
 */
public class SearchActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.edtSearchProduct)
    EditText edtSearchProduct;
    @Bind(R.id.searchAutoCompleteListView)
    ListView searchAutoCompleteListView;
    ArrayAdapter<String> adapter;
    List<String> searchedProduct;
    @Bind(R.id.backButton)
    ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        UtilsMethod.getInstance(this).setStatusBar(this);
        searchedProduct = OfflineData.getInstance(this).getProductsArray();
        adapter = new ArrayAdapter<String>(this, R.layout.searchproduct, R.id.product_name, searchedProduct);
        searchAutoCompleteListView.setAdapter(adapter);
        searchEvent();
        backbutton.setOnClickListener(this);
    }

    private void searchEvent() {
        edtSearchProduct.setSingleLine();
        edtSearchProduct.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButton) {
            finish();
        }
    }
}
