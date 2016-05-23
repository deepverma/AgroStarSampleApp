package agrostar.demoapp.com.agrostar.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.models.ProductsDTO;

/**
 * Created by Deep Verma on 22-05-2016.
 */
public class OfflineData {

    public static void setIsLocaleChanged(boolean isLocaleChanged) {
        OfflineData.isLocaleChanged = isLocaleChanged;
    }

    public boolean isLocaleChanged() {
        return isLocaleChanged;
    }

    public static String getLangSelected() {
        return langSelected;
    }

    public static void setLangSelected(String lang) {
        langSelected = lang;
    }

    private static String langSelected = "en";

    static boolean isLocaleChanged = true;
    public static OfflineData instance;
    private static Context ctx;

    public Map<String, List<ProductsDTO>> getProductsMap() {
        return productsMap;
    }

    private Map<String, List<ProductsDTO>> productsMap;

    public static synchronized OfflineData getInstance(Context context) {

        if (context != null) {
            ctx = context;
        }
        if (instance == null) {
            instance = new OfflineData();
        }
        if (isLocaleChanged) {
            instance.productsMap = instance.createProductListMap();
            isLocaleChanged = false;
        }
        return instance;
    }

    private ArrayList<String> productsList = new ArrayList<>();

    public static Context getCtx() {
        return ctx;
    }

    public ArrayList<String> getProductsArray() {
        return productsList;
    }

    private Map<String, List<ProductsDTO>> createProductListMap() {
//        trie = new Trie();
        productsList.clear();
        Map<String, List<ProductsDTO>> productListMap = new HashMap<>();
        String cropType[] = ctx.getResources().getStringArray(R.array.crop_type);
//        Not added this data in String.xml as it is overhead to code iterate through array and create a 2D array

        String cropNameList[][];
        if (langSelected.equals("en")) {

            cropNameList = new String[][]{{"Cotton", "Tea", "Coffee", "Jute", "Sugarcane"},
                    {"Maize", "Rice", "Wheat", "Barley", "Sorghum"}
                    , {"Canola", "Sunflower", "Soybeans", "flaxseed", "Rapeseed"},
                    {"WaterMelon", "Papaya", "Orange", "Apple", "Banana"}};
        } else {
//            hindi

            cropNameList = new String[][]{{"कपास", "चाय", "कॉफी", "जूट", "गन्ना"},
                    {"मक्का", "चावल", "गेहूँ", "जौ", "चारा"}
                    , {"कैनोला", "सूरजमुखी", "सोयाबीन", "सन का बीज", "रेपसीड"},
                    {"तरबूज", "पपीता", "नारंगी", "सेब", "केला"}};
        }
        String cropPriceList[][] = {{"200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg"},
                {"200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg"}
                , {"200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg"},
                {"200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg", "200 Rs/Kg"}};
        Integer cropImageList[][] = {{R.drawable.cotton, R.drawable.tea_product, R.drawable.coffee, R.drawable.jute, R.drawable.sugar_cane}
                , {R.drawable.maize, R.drawable.rice, R.drawable.wheat, R.drawable.barley, R.drawable.sorghum},
                {R.drawable.canola, R.drawable.sunflowewr, R.drawable.soyabeans, R.drawable.flaxseed, R.drawable.rapeseed}
                , {R.drawable.watermelon, R.drawable.papaya, R.drawable.orange, R.drawable.apple, R.drawable.banana}};
//        List<ProductsDTO> productList;
        ProductsDTO productsDTO;
        for (int j = 0; j < 4; j++) {
            List<ProductsDTO> productList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                productsDTO = new ProductsDTO();
                productsDTO.setProductName(cropNameList[j][i]);
                productsDTO.setPrice(cropPriceList[j][i]);
                productsDTO.setImageIds(cropImageList[j][i]);
                productList.add(productsDTO);
                //trie.addWord(cropNameList[j][i]);
                productsList.add(cropNameList[j][i]);
            }
            productListMap.put(cropType[j], productList);
        }

        return productListMap;
    }
}
