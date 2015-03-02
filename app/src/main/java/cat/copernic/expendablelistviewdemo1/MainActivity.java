package cat.copernic.expendablelistviewdemo1;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListAdapter mAdapter;
        ExpandableListView epView = (ExpandableListView) findViewById(R.id.expandableListView);
        mAdapter = new MyExpandableListAdapter();
        epView.setAdapter(mAdapter);

        epView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView arg0, View arg1,
                                        int groupPosition, long arg3) {
                if (groupPosition == 5) {

                }

                // Aqui podriamos cambiar si quisieramos el comportamiento de apertura y cierre de las listas explandibles mediante los metodos collapseGroup(int groupPos) y expandGroup(int groupPos)

                return false;
            }
        });

        epView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent,
                                        View v, int groupPosition, int childPosition,
                                        long id) {
                if (groupPosition == 0 && childPosition == 0) {

                }

                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        // Sample data set. children[i] contains the children (String[]) for
        // groups[i].
        private String[] groups = { "TECLADOS", "RATONES",
                "MONITORES" };
        private String[][] children = { { "Logitech TK820","Matias Laptop Pro ", "Razer BlackWidow", "Rosewill Helios RK-9200", "Logitech K350 Wireless" },
                { "Logitech G600 MMO", "Razer Ouroboros", "Qpad 5K", "Roccat Kone Pure", "Logitech G500s", "Tesoro Shrike", "Razer Deathadder" },
                { "DELL ULTRASHARP", "BENQ XL2420Z", "ASUS PB287Q", "SAMSUNG U28D590D" } };

        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
            int i = 0;
            try {
                i = children[groupPosition].length;

            } catch (Exception e) {
            }

            return i;
        }

        public TextView getGenericView() {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 150);

            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(lp);
            // Center the text vertically
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setTextColor(Color.BLACK);
            // Set the text starting position
            textView.setPadding(75, 0, 0, 0);
            return textView;
        }

        public TextView getGenericView1() {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 120);//64

            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(lp);
            // Center the text vertically
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setTextColor(Color.BLUE);
            // Set the text starting position
            textView.setPadding(100, 0, 0, 0);
            return textView;
        }

        public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getGenericView1();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
        }

        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        public int getGroupCount() {
            return groups.length;
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public boolean hasStableIds() {
            return true;
        }



    }

}
