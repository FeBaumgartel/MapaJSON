package com.example.mapajson;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    private static final String TAG = "ParseJson";
    private List<Pessoas> pessoas;

    public ParseJson() {
        pessoas = new ArrayList<>();
    }

    public List<Pessoas> getPokemons() {
        return pessoas;
    }

    public boolean parse(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray pessoas = json.getJSONArray("pessoas");

            for (int i = 0; i < pessoas.length(); i++) {
                JSONObject pokemon = pessoas.getJSONObject(i);
                Pessoas p = new Pessoas();
                p.setNome(pokemon.getString("name"));
                p.setEmail(pokemon.getString("email"));
                p.setLatitude(pokemon.getString("latitude"));
                p.setLongitude(pokemon.getString("longitude"));
                this.pessoas.add(p);
            }
            return true;
        } catch (JSONException e) {
            Log.e(TAG, "parse: erro ao fazer parse do JSON: " + e.getMessage());
            return false;
        }
    }
}
