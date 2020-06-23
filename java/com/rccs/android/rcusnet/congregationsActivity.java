package com.rccs.android.rcusnet;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class congregationsActivity extends AppCompatActivity {

    private String TAG = com.rccs.android.rcusnet.congregationsActivity.class.getSimpleName();
    private ListView lv;
    private ArrayAdapter adapter;

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congregations);

        contactList = new ArrayList<>();
        new GetContacts().execute();

        // Declare Variables
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        lv = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item);
        lv.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                Log.d(TAG, "Filter: " + charSequence);
                adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {

            String jsonStr = "{\n" +
                    "\"churches\": [\n" +
                    " {\n" +
                    "   \"church\": \"First Reformed Church\",\n" +
                    "   \"city\": \"Aberdeen\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"818 9th Avenue SE Aberdeen SD 57401\",\n" +
                    "   \"phone\": \"605-225-6120\",\n" +
                    "   \"pastor\": \"Hank Bowen\",\n" +
                    "   \"email\": \"mailto:reformedaberdeen@gmail.com\",\n" +
                    "   \"web\": \"http://aberdeenreformed.com\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Salem Reformed Church\",\n" +
                    "   \"city\": \"Ashley\",\n" +
                    "   \"state\": \"ND\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"209 1st Ave. SW Ashley ND 58413\",\n" +
                    "   \"phone\": \"701-288-3265\",\n" +
                    "   \"pastor\": \"Dave Irwin\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Bakersfield\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"420 Columbus St Bakersfield CA 93305\",\n" +
                    "   \"phone\": \"661-587-3723\",\n" +
                    "   \"pastor\": \"Tracy Gruggett\",\n" +
                    "   \"email\": \"mailto:tgruggett@att.net\",\n" +
                    "   \"web\": \"http://www.bakersfieldreformed.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Reformation Church\",\n" +
                    "   \"city\": \"Blue Bell\",\n" +
                    "   \"state\": \"PA\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"1215 Union Meeting Rd Blue Bell PA 19422\",\n" +
                    "   \"phone\": \"570-785-4012\",\n" +
                    "   \"pastor\": \"Ron Potter\",\n" +
                    "   \"email\": \"mailto:HRC@nep.net\",\n" +
                    "   \"web\": \"http://www.refchurchbluebell.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Christ Reformed Church\",\n" +
                    "   \"city\": \"Casper\",\n" +
                    "   \"state\": \"WY\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"600 W 21st St Casper WY 82604\",\n" +
                    "   \"phone\": \"307-277-5901\",\n" +
                    "   \"pastor\": \"Matthew Powell\",\n" +
                    "   \"email\": \"mailto:mattpowell74@gmail.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Covenant Reformed Church\",\n" +
                    "   \"city\": \"Chico\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"1877 Hooker Oak Ave Chico CA 95927\",\n" +
                    "   \"phone\": \"530-345-2732\",\n" +
                    "   \"pastor\": \"Gary Mancilas\",\n" +
                    "   \"email\": \"mailto:gmancilas@comcast.net\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Trinity Covenant Reformed Church\",\n" +
                    "   \"city\": \"Colorado Springs\",\n" +
                    "   \"state\": \"CO\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"2511 N. Logan Ave Colorado Springs CO 80907\",\n" +
                    "   \"phone\": \"719-590-1477\",\n" +
                    "   \"pastor\": \"J.P. Mosley\",\n" +
                    "   \"email\": \"mailto:rev.j.p.mosley@gmail.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Greeley\",\n" +
                    "   \"state\": \"CO\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"501 10th Ave., Greeley, CO 80631\",\n" +
                    "   \"phone\": \"970-336-9927\",\n" +
                    "   \"pastor\": \"Jon Blair\",\n" +
                    "   \"email\": \"mailto:jwblair83@msn.com\",\n" +
                    "   \"web\": \"http://www.reformedgreeley.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Providence Reformed Church\",\n" +
                    "   \"city\": \"Limon\",\n" +
                    "   \"state\": \"CO\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"725 Michigan Ave., Limon, CO 80828\",\n" +
                    "   \"phone\": \"719-775-2791\",\n" +
                    "   \"pastor\": \"Jimmy John Hall\",\n" +
                    "   \"email\": \"mailto:pastorjimmyjohn2028hall@gmail.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"St. John's Reformed Church\",\n" +
                    "   \"city\": \"Lincoln\",\n" +
                    "   \"state\": \"NE\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"1101 S. 26th St., Lincoln, NE 68502\",\n" +
                    "   \"phone\": \"(402) 476-1827\",\n" +
                    "   \"pastor\": \"Lee Johnson\",\n" +
                    "   \"email\": \"mailto:rev.lee.j.johnson@gmail.com\",\n" +
                    "   \"web\": \"www.stjohnsrcus.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Omaha Reformed Church\",\n" +
                    "   \"city\": \"Omaha\",\n" +
                    "   \"state\": \"NE\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"4905 N. 96th St., Omaha, NE 68134\",\n" +
                    "   \"phone\": \"(402) 281-3263\",\n" +
                    "   \"pastor\": \"Randall Klynsma\",\n" +
                    "   \"email\": \"mailto:omahareformed.pastor@gmail.com\",\n" +
                    "   \"web\": \"http://www.omahareformed.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Emmanuel Reformed Church\",\n" +
                    "   \"city\": \"Sutton\",\n" +
                    "   \"state\": \"NE\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"110 S. Way Ave., Sutton, NE 68979\",\n" +
                    "   \"phone\": \"(402) 773-4218\",\n" +
                    "   \"pastor\": \"Joe Vusich\",\n" +
                    "   \"email\": \"mailto:jvusich@gmail.com\",\n" +
                    "   \"web\": \"http://www.pastorjoev.wordpress.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Hope Reformed Church\",\n" +
                    "   \"city\": \"Sutton\",\n" +
                    "   \"state\": \"NE\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"311 E. Hickory St., Sutton, NE 68979\",\n" +
                    "   \"phone\": \"(402) 773-4330\",\n" +
                    "   \"pastor\": \"Scott Henry\",\n" +
                    "   \"email\": \"mailto:shenry0328@gmail.com\",\n" +
                    "   \"web\": \"http://www.hopereformedrcus.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Zion Reformed Church\",\n" +
                    "   \"city\": \"Menno\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"220 S. Pine St., Menno, SD 57045\",\n" +
                    "   \"phone\": \"(605) 387-2816\",\n" +
                    "   \"pastor\": \"Travis Grassmid\",\n" +
                    "   \"email\": \"mailto:travisgrassmid@yahoo.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Mitchell\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"1021 S. Davison, Mitchell, SD 57301\",\n" +
                    "   \"phone\": \"(605) 996-2803\",\n" +
                    "   \"pastor\": \"Kevin Carroll\",\n" +
                    "   \"email\": \"mailto:pastor@gracereformed.com\",\n" +
                    "   \"web\": \"http://www.gracereformed.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Rapid City\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"5626 N. Haines Ave, Rapid City, SD 57701\",\n" +
                    "   \"phone\": \"(605) 399-1711\",\n" +
                    "   \"pastor\": \"David Fagrey\",\n" +
                    "   \"email\": \"mailto:dfagrey@gmail.com\",\n" +
                    "   \"web\": \"http://www.gracereformedrapidcity.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Trinity Reformed Church\",\n" +
                    "   \"city\": \"Sioux Falls\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"7301 S. Louise Ave., Sioux Falls, SD 57108\",\n" +
                    "   \"phone\": \"(605) 271-0754\",\n" +
                    "   \"pastor\": \"Maynard Koerner\",\n" +
                    "   \"email\": \"mailto:maykoerner@gmail.com\",\n" +
                    "   \"web\": \"http://www.trinityrcus.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Providence Reformed Church\",\n" +
                    "   \"city\": \"Vermillion\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"830 Madison St., Vermillion, SD 57069\",\n" +
                    "   \"phone\": \"(605) 624-4337\",\n" +
                    "   \"pastor\": \"Harvey Opp\",\n" +
                    "   \"email\": \"mailto:harveyopp@gmail.com\",\n" +
                    "   \"web\": \"http://www.providencercus.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Providence Reformed Church\",\n" +
                    "   \"city\": \"Rock Springs\",\n" +
                    "   \"state\": \"WY\",\n" +
                    "   \"classis\": \"South Central\",\n" +
                    "   \"address\": \"1001 9th St., Rock Springs, WY 82901\",\n" +
                    "   \"phone\": \"(307) 705-3683\",\n" +
                    "   \"pastor\": \"George Horner\",\n" +
                    "   \"email\": \"mailto:rcusgeorge@gmail.com\",\n" +
                    "   \"web\": \"http://www.providencerocksprings.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Rogers\",\n" +
                    "   \"state\": \"AR\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"3320 N. Second Street, Rogers, AR 72756\",\n" +
                    "   \"phone\": \"(479) 372-1108\",\n" +
                    "   \"pastor\": \"Steven Carr\",\n" +
                    "   \"email\": \"mailto:pastor@gracereformednwa.org\",\n" +
                    "   \"web\": \"http://www.gracereformednwa.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Peace Reformed Church\",\n" +
                    "   \"city\": \"Garner\",\n" +
                    "   \"state\": \"IA\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"1907 200th Street, Garner, IA 50438\",\n" +
                    "   \"phone\": \"641-923-3060\",\n" +
                    "   \"pastor\": \"Mark Larson\",\n" +
                    "   \"email\": \"mailto:peacereformedchurch@gmail.com\",\n" +
                    "   \"web\": \"http://www.peacereformedchurch.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Emmaus Road Reformed Church\",\n" +
                    "   \"city\": \"Eden Prarie\",\n" +
                    "   \"state\": \"MN\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"12000 Anderson Lakes Pkwy, Eden Prairie, MN 55438\",\n" +
                    "   \"phone\": \"(612) 751-2096\",\n" +
                    "   \"pastor\": \"Rev. Ryan Kron\",\n" +
                    "   \"email\": \"mailto:pastor@emmausroadrcus.org\",\n" +
                    "   \"web\": \"http://www.emmausroadrcus.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"St. Paul's Evangelical Reformed Church\",\n" +
                    "   \"city\": \"Hamburg\",\n" +
                    "   \"state\": \"MN\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"15480 County Road 31 Hamburg, MN 55339\",\n" +
                    "   \"phone\": \"(952) 467-3878\",\n" +
                    "   \"pastor\": \"Dan Schnabel\",\n" +
                    "   \"email\": \"mailto:Stpaulsrcus@gmail.com\",\n" +
                    "   \"web\": \"http://www.stpaulsrcus.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Redeemer Reformed Church\",\n" +
                    "   \"city\": \"Minneapolis\",\n" +
                    "   \"state\": \"MN\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"1300 Lilac Drive North, Golden Valley, MN 55427\",\n" +
                    "   \"phone\": \"(763) 417-9851\",\n" +
                    "   \"pastor\": \"Rev. Tim Marinelli\",\n" +
                    "   \"email\": \"mailto:debtor2mercy.eph2@gmail.com\",\n" +
                    "   \"web\": \"http://www.redeemerrcus.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Northland Reformed Church\",\n" +
                    "   \"city\": \"Kansas City\",\n" +
                    "   \"state\": \"MO\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"2901 NW Cookingham Drive, Kansas City, MO 64164\",\n" +
                    "   \"phone\": \"(816) 420-9700\",\n" +
                    "   \"pastor\": \"Christopher Campbell\",\n" +
                    "   \"email\": \"mailto:northlandreformed@gmail.com\",\n" +
                    "   \"web\": \"http://www.northlandreformed.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Peace Reformed Church\",\n" +
                    "   \"city\": \"Napoleon\",\n" +
                    "   \"state\": \"OH\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"638 Huddle Road, Napoleon, Ohio 43545\",\n" +
                    "   \"phone\": \"(419) 599-3106\",\n" +
                    "   \"pastor\": \"Rev. Steven Altman\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"http://www.peacercus.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Covenant Reformed Church\",\n" +
                    "   \"city\": \"Gettysburg\",\n" +
                    "   \"state\": \"PA\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"149 Centennial Road, Gettysburg, Pennsylvania 17325\",\n" +
                    "   \"phone\": \"(717) 398-2603\",\n" +
                    "   \"pastor\": \"Jay Fluck\",\n" +
                    "   \"email\": \"mailto:jefluck@msn.com\",\n" +
                    "   \"web\": \"www.rcusgettysburg.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Heritage Reformed Church\",\n" +
                    "   \"city\": \"Waymart\",\n" +
                    "   \"state\": \"PA\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"200 Belmont Turnpike, Waymart, Pennsylvania\",\n" +
                    "   \"phone\": \"(570) 785-4012\",\n" +
                    "   \"pastor\": \"Rev. Ron Potter\",\n" +
                    "   \"email\": \"mailto:reformed@nep.net\",\n" +
                    "   \"web\": \"http://www.heritagercus.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Salem Ebenezer Reformed Church\",\n" +
                    "   \"city\": \"Manitowoc\",\n" +
                    "   \"state\": \"WI\",\n" +
                    "   \"classis\": \"Covenant East\",\n" +
                    "   \"address\": \"6524 Hwy C, Manitowoc, WI 54220\",\n" +
                    "   \"phone\": \"(920) 726-4940\",\n" +
                    "   \"pastor\": \"Rev. Kyle Sorensen\",\n" +
                    "   \"email\": \"mailto:info@salemebenezer.org\",\n" +
                    "   \"web\": \"http://www.salemebenezer.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Covenant Reformed Church\",\n" +
                    "   \"city\": \"Grass Valley\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"407 W. Main St., Grass Valley, CA 95945\",\n" +
                    "   \"phone\": \"(530) 273-4673\",\n" +
                    "   \"pastor\": \"\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"crcgv.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Lancaster\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"121 Carriage Lane, Suite 111, Lancaster, CA 93534\",\n" +
                    "   \"phone\": \"(661) 940-4669\",\n" +
                    "   \"pastor\": \"\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"lancasterreformed.com\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Providence Reformed Church\",\n" +
                    "   \"city\": \"Lodi\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"245 E. Vine St. Lodi, CA 95240\",\n" +
                    "   \"phone\": \"(209) 367-0552\",\n" +
                    "   \"pastor\": \"Doug Schlegel\",\n" +
                    "   \"email\": \"mailto:pastor@prclodi.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Reheboth Reformed Church\",\n" +
                    "   \"city\": \"Los Angeles\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"13633 - 183rd St., Cerritos, CA 90703\",\n" +
                    "   \"phone\": \"(626) 820-9390\",\n" +
                    "   \"pastor\": \"Michael Voytek\",\n" +
                    "   \"email\": \"mailto:pastorvoytek@gmail.com\",\n" +
                    "   \"web\": \"RehobothReformedChurch.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Trinity Reformed Church\",\n" +
                    "   \"city\": \"Modesto\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"960 El Terino Ave., Modesto, CA 95350\",\n" +
                    "   \"phone\": \"(209) 523-3220\",\n" +
                    "   \"pastor\": \"Jonathan Merica\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"trinitymodesto.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Sacramento Covenant Reformed Church\",\n" +
                    "   \"city\": \"Sacramento\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"2020 16th Ave., Sacramento, CA 95822\",\n" +
                    "   \"phone\": \"(916) 451-1190\",\n" +
                    "   \"pastor\": \"Frank Walker\",\n" +
                    "   \"email\": \"mailto:drfhwalker@gmail.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Covenant Reformed Church\",\n" +
                    "   \"city\": \"San Diego\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"757 Maria Ave., Spring Valley, CA 91977\",\n" +
                    "   \"phone\": \"(619) 460-1321\",\n" +
                    "   \"pastor\": \"Gil Baloy\",\n" +
                    "   \"email\": \"mailto:SDCRC2012@gmail.com\",\n" +
                    "   \"web\": \"covenantrcus.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Ebenezer Reformed Church\",\n" +
                    "   \"city\": \"Shafter\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"235 James St., Shafter, CA 93263\",\n" +
                    "   \"phone\": \"(661) 746-6907\",\n" +
                    "   \"pastor\": \"Valentin Alpuche\",\n" +
                    "   \"email\": \"mailto:valpuche@gmail.com\",\n" +
                    "   \"web\": \"ebenezerrreforemed.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Valle De Gracia\",\n" +
                    "   \"city\": \"Shafter\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"235 James St., Shafter, CA 93263\",\n" +
                    "   \"phone\": \"(661) 910-2898\",\n" +
                    "   \"pastor\": \"Valentin Alpuche\",\n" +
                    "   \"email\": \"mailto:valpuche@gmail.com\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Calvary Reformed Chapel\",\n" +
                    "   \"city\": \"Stockton\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"5380 West Lane, Stockton, CA 95210\",\n" +
                    "   \"phone\": \"(209) 470-7174\",\n" +
                    "   \"pastor\": \"Jonathan Merica\",\n" +
                    "   \"email\": \"mailto:jon_a_merica@yahoo.com\",\n" +
                    "   \"web\": \"calvaryreformedchapel.com\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Grace Reformed Church\",\n" +
                    "   \"city\": \"Willows\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"148 W. Sycamore St., Willows, CA 95988\",\n" +
                    "   \"phone\": \"(530) 591-5382\",\n" +
                    "   \"pastor\": \"Eric Bristley\",\n" +
                    "   \"email\": \"mailto:gracercus@gmail.com\",\n" +
                    "   \"web\": \"gracercus.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"First Reformed Church\",\n" +
                    "   \"city\": \"Yuba City\",\n" +
                    "   \"state\": \"CA\",\n" +
                    "   \"classis\": \"Western\",\n" +
                    "   \"address\": \"9882 Garden Hwy., Yuba City, CA 95991\",\n" +
                    "   \"phone\": \"(530) 674-8797\",\n" +
                    "   \"pastor\": \"Sam Powell\",\n" +
                    "   \"email\": \"mailto:sampowell365@gmail.com\",\n" +
                    "   \"web\": \"reformedyubacity.org\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Harvest Reformed Church\",\n" +
                    "   \"city\": \"Minot\",\n" +
                    "   \"state\": \"ND\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"PO Box 804, Minot, ND 58702\",\n" +
                    "   \"phone\": \"(701) 340-7666\",\n" +
                    "   \"pastor\": \"Phil Poe\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"http://www.harvestreformedchurch.org/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"First Reformed Chapel\",\n" +
                    "   \"city\": \"Dickinson\",\n" +
                    "   \"state\": \"ND\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"257 1st Street East, Dickinson, ND 58601\",\n" +
                    "   \"phone\": \"(701) 974-4491\",\n" +
                    "   \"pastor\": \"Wes Brice\",\n" +
                    "   \"email\": \"mailto:wesbrice@yahoo.com\",\n" +
                    "   \"web\": \"http://www.FRCofD.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Eureka Reformed Church\",\n" +
                    "   \"city\": \"Eureka\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"310 F Ave., Eureka, SD 57437\",\n" +
                    "   \"phone\": \"(605) 284-2396\",\n" +
                    "   \"pastor\": \"James Grossmann\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"https://www.facebook.com/EurekaRCUS\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"First Reformed Church\",\n" +
                    "   \"city\": \"Herreid\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"601 N. Main St., Herreid, SD 57632\",\n" +
                    "   \"phone\": \"(605) 437-2209\",\n" +
                    "   \"pastor\": \"Cody Schwichtenberg\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"https://www.facebook.com/herreidreformedchurch/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Hosmer Reformed Church\",\n" +
                    "   \"city\": \"Hosmer\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"202 West 5th St., Hosmer, SD 57448\",\n" +
                    "   \"phone\": \"\",\n" +
                    "   \"pastor\": \"\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Hope Reformed Church\",\n" +
                    "   \"city\": \"Pierre\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"317 S. Garfield, Pierre, SD 57501\",\n" +
                    "   \"phone\": \"(605) 224-7846\",\n" +
                    "   \"pastor\": \"Paul Henderson\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"http://www.hopercus.com/\"\n" +
                    " },\n" +
                    " {\n" +
                    "   \"church\": \"Covenant Reformed Church\",\n" +
                    "   \"city\": \"Watertown\",\n" +
                    "   \"state\": \"SD\",\n" +
                    "   \"classis\": \"Northern Plains\",\n" +
                    "   \"address\": \"15 12th Ave NE, Watertown, SD 57201\",\n" +
                    "   \"phone\": \"(605) 878-4567\",\n" +
                    "   \"pastor\": \"Michael Lassley\",\n" +
                    "   \"email\": \"\",\n" +
                    "   \"web\": \"http://www.watertownrcus.org/\"\n" +
                    " }\n" +
                    "]\n" +
                    "}";

            // Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray churches = jsonObj.getJSONArray("churches");

                    // looping through All Contacts
                    for (int i = 0; i < churches.length(); i++) {
                        JSONObject c = churches.getJSONObject(i);
                        String church = c.getString("church");
                        String city = c.getString("city");
                        String state = c.getString("state");
                        String classis = c.getString("classis");
                        String address = c.getString("address");
                        String phone = c.getString("phone");
                        String pastor = c.getString("pastor");
                        String email = c.getString("email");
                        String web = c.getString("web");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("church", church);
                        contact.put("city", city);
                        contact.put("state", state);
                        contact.put("classis", classis);
                        contact.put("address", address);
                        contact.put("phone", phone);
                        contact.put("pastor", pastor);
                        contact.put("email", email);
                        contact.put("web", web);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(com.rccs.android.rcusnet.congregationsActivity.this, contactList,
                    R.layout.list_item, new String[]{ "church","city","state","classis","address","phone","pastor","email","web"},
                    new int[]{R.id.church,R.id.city,R.id.state,R.id.classis,R.id.address,R.id.phone,R.id.pastor,R.id.email,R.id.web});
            lv.setAdapter(adapter);
        }
    }
}

