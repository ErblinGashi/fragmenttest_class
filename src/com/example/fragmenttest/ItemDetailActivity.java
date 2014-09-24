package com.example.fragmenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;


/**
 * Ky aktivitet shfaqet vet�m n� telefon, n� tablet shfaqen "kry-p�r-kry"
 * lista edhe p�rmbajtja, n� telefon shfaqet ky aktivitet n�se elementi selektohet.
 * Ky aktivitet �sht� vet�m nj� mbajt�s i fragmentit, kurgjo nuk ka p�rve�
 * fragmentin p�r detale.
 */
public class ItemDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // I tregojm� action bar q� d�shirojm� 
        // tek logo t� jet� "UP" e cila t� kthen n� faq�n e par�
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState nuk �sht� null n�se gjendja e fragmentit
        // �sht� ruajtur prej konfigurimit t� m�parsh�m (p�rshembull 
        // kur e kemi ndrru orientimin e pajisjes prej portrait n� landscape).
        // N� k�t� m�nyr� fragmenti ri-bashkohet automatikisht p�r mos t� 
        // pas� nevoj� q� manualisht ta shtojm� at�. E kemi spjeguar n�
        // or�t e m�parshme
        if (savedInstanceState == null) {
            // Rutina e nj�jt�, e krijojm� fragmentin dhe e shtojm� p�rmes
        	// n� aktivitet p�rmes FragmentTransaction
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            
            FragmentManager fManager = getSupportFragmentManager();
            
            FragmentTransaction fTransaction = fManager.beginTransaction();
            fTransaction.add(R.id.item_detail_container, fragment);
            fTransaction.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
        	// N�se kjo ID �sht� prezente (e l�shuar p�rmes setDisplayHomeAsUpEnabled())
            // at�her� n� krye t� aktivitetit ku �sht� emri, n�se ajo pull� preket
        	// kthehet n� fillim t� aplikacionit, se sa t� shkoj� prapa n� back stack.
        	// 
        	// P�r m� shum�, lexoni n�:
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
