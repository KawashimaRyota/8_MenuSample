package com.example.menusample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {
    //リストビューを表すフィールド
    private ListView _lvMenu;
    //リストビューに表示するリストデータ
    private List<Map<String, Object>> _menuList;
    //SimpleAdapterも第4引数fromに使用する定数フィールド
    private static final String[] FROM = {"name", "price"};
    //SimpleAdapterの第5引数toに使用する定数フィールド
    private static final int[] TO = {R.id.tvMenuName, R.id.tvMenuPrice};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        //画面部品ListViewを取得し、フィールドに格納
        _lvMenu = findViewById(R.id.lvMenu);
        //定食メニューListオブジェクトをprivateメソッドを利用して用意し、フィールドに格納
        _menuList = createTeishokuList();
        //SimpleAdapterを生成
        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, _menuList, R.layout.row, FROM, TO);
        //アダプタの登録
        _lvMenu.setAdapter(adapter);
        //リストタップのリストクラス登録
        _lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private List<Map<String, Object>> createTeishokuList() {
        //定食メニューリスト用のListオブジェクトを用意
        List<Map<String, Object>> menuList = new ArrayList<>();
        //からあげ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "からあげ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のからあげにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //ハンバーグ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //生姜焼き定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "大判生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //ステーキ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "100gサーロインステーキにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //野菜炒め定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //とんかつ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "三軒豚のとんかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //ミンチかつ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("desc", "ミンチかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //チキンカツ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "チキンカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //コロッケ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 750);
        menu.put("desc", "コロッケにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        //オールスター定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "オールスター定食");
        menu.put("price", 1200);
        menu.put("desc", "80gサーロインステーキとミニとんかつ、ミニハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行のデータを取得。SimpleAdapterでは1行分のデータはMap型
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
            //定食名と金額を取得
            String menuName = (String) item.get("name");
            Object menuPrice = (Object) item.get("price");
            //インテントオブジェクトを生成
            Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);
            //第2画面に送るデータを格納
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice+"円");
            //第2画面の起動
            startActivity(intent);
        }
    }
}