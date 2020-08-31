package com.example.menusample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

        registerForContextMenu(_lvMenu);
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

    private List<Map<String, Object>> createCurryList() {
        //カレーメニューリスト用のListオブジェクトを用意
        List<Map<String, Object>> menuList = new ArrayList<>();
        //ビーフカレーのデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 520);
        menu.put("desc", "特選スパイスをきかせた国産ビーフ100%のカレーです。");
        menuList.add(menu);
        //ポークカレーのデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産ポーク100%のカレーです。");
        menuList.add(menu);
        //チキンカレーのデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "チキンカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産鶏肉100%のカレーです。");
        menuList.add(menu);
        //ベジタブルカレーのデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "ベジタブルカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産野菜のカレーです。");
        menuList.add(menu);
        //ラムカレーのデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = new HashMap<>();
        menu.put("name", "ラムカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産ラム100%のカレーです。");
        menuList.add(menu);

        return menuList;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行のデータを取得。SimpleAdapterでは1行分のデータはMap型
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
            order(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //メニューインフレーターの取得
        MenuInflater inflater = getMenuInflater();
        //オプションメニュー用.xmlファイルをインフレート
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        //親クラスの同名メソッドを呼び出し、その戻り値を返却
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //選択されたメニューのIDを取得
        int itemId = item.getItemId();
        //IDのR値による処理の分岐
        switch (itemId) {
            //定食メニューが選択された場合の処理
            case R.id.menuListOptionTeishoku:
                //定食メニューリストデータの生成
                _menuList = createTeishokuList();
                break;
            //カレーメニューが選択された場合の処理
            case R.id.menuListOptionCurry:
                //定食メニューリストデータの生成
                _menuList = createCurryList();
                break;
        }
        //SimpleAdapterを選択されたメニューデータで生成
        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, _menuList, R.layout.row, FROM, TO);
        //アダプタの登録
        _lvMenu.setAdapter(adapter);
        //親クラスの同名のメソッドを呼び出し、その戻り値を返却
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        //親クラスの同名メソッドの呼び出し
        super.onCreateContextMenu(menu, view, menuInfo);
        //メニューインフレーターの取得
        MenuInflater inflater = getMenuInflater();
        //コンテキストメニュー用.xmlファイルをインフレート
        inflater.inflate(R.menu.menu_context_menu_list, menu);
        //コンテキストメニューのヘッダタイトルを設定
        menu.setHeaderTitle(R.string.menu_list_context_header);
    }

    private void order(Map<String, Object> menu) {
        //定食名と金額を取得
        String menuName = (String) menu.get("name");
        Integer menuPrice = (Integer) menu.get("price");
        //インテントオブジェクトを生成
        Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);
        //第2画面に送るデータを格納
        intent.putExtra("menuName", menuName);
        //MenuThanksActivityでのデータ受け取りと合わせるために、金額にここで「円」を追加する
        intent.putExtra("menuPrice", menuPrice+"円");
        //第2画面の起動
        startActivity(intent);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //長押しされたビューに関する情報が格納されたオブジェクトを取得
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //長押しされたリストのポジションを取得
        int listPosition = info.position;
        //ポジションから長押しされたメニュー情報Mapオブジェクトを取得
        Map<String, Object> menu = _menuList.get(listPosition);

        //選択されたメニューのIDを取得
        int itemId = item.getItemId();
        //IDのR値による処理の分岐
        switch (itemId) {
            case R.id.menuListContextDesc:
                //メニューの説明文字列を取得
                String desc = (String) menu.get("desc");
                //トーストを表示
                Toast.makeText(MenuListActivity.this, desc, Toast.LENGTH_LONG).show();
                break;
            case R.id.menuListContextOrder:
                //注文処理
                order(menu);
                break;
        }
        //親クラスの同名のメソッドを呼び出し、その戻り値を返却
        return super.onContextItemSelected(item);
    }
}