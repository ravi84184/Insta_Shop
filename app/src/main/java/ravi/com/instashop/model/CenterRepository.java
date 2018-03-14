/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package ravi.com.instashop.model;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CenterRepository {

    private static CenterRepository centerRepository;

//    private ArrayList<ProductCategoryModel> listOfCategory = new ArrayList<ProductCategoryModel>();
    private ConcurrentHashMap<String, ArrayList<SubcatItemModel>> mapOfProductsInCategory = new ConcurrentHashMap<String, ArrayList<SubcatItemModel>>();
    private List<SubcatItemModel> listOfProductsInShoppingList = Collections.synchronizedList(new ArrayList<SubcatItemModel>());
//    private List<Set<String>> listOfItemSetsForDataMining = new ArrayList<>();

    public static CenterRepository getCenterRepository() {

        if (null == centerRepository) {
            centerRepository = new CenterRepository();
        }
        return centerRepository;
    }

    public List<SubcatItemModel> getListOfProductsInShoppingList() {
        return listOfProductsInShoppingList;
    }

    public void setListOfProductsInShoppingList(List<SubcatItemModel> listOfProductsInShoppingList) {
        this.listOfProductsInShoppingList = listOfProductsInShoppingList;
    }

    public ConcurrentHashMap<String, ArrayList<SubcatItemModel>> getMapOfProductsInCategory() {
        return mapOfProductsInCategory;
    }

    public void setMapOfProductsInCategory(ConcurrentHashMap<String, ArrayList<SubcatItemModel>> mapOfProductsInCategory) {
        this.mapOfProductsInCategory = mapOfProductsInCategory;
    }


}
