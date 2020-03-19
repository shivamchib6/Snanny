package com.example.snanny.NaniClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.snanny.R;

public class SettingsFragment extends Fragment implements View.OnClickListener {
    LinearLayout linearLayoutprofile,
    linearLayoutterms,linearLayoutfaq;
    ImageView profile,termsimage,faqimage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_fragment,container,false);

        findIds(v);
        linearLayoutprofile.setOnClickListener(this);
        linearLayoutterms.setOnClickListener(this);
        linearLayoutfaq.setOnClickListener(this);

        return v;
    }

    private void findIds(View v) {
        linearLayoutprofile = v.findViewById(R.id.profilesettingslinear);
        linearLayoutterms = v.findViewById(R.id.termssettingslinear);
        linearLayoutfaq = v.findViewById(R.id.faqsettingsprofile);
        profile = v.findViewById(R.id.imageviewprofilesettings);
        termsimage = v.findViewById(R.id.imageviewlegalsettings);
        faqimage = v.findViewById(R.id.imageviewfaqsettings);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){

            case R.id.profilesettingslinear:
                profileAnim();
                ProfileSettings ps = new ProfileSettings();
                openFragment(ps);

                break;
            case R.id.termssettingslinear:
                termAnim();
                break;
            case R.id.faqsettingsprofile:
                faqAnim();
                break;




        }

    }

    private void faqAnim() {
        linearLayoutprofile.setBackgroundResource(R.drawable.textview_background);
        linearLayoutterms.setBackgroundResource(R.drawable.textview_background);
        linearLayoutfaq.setBackgroundResource(R.drawable.clicked_background_layout);
        // Arrow Modification
        profile.setImageResource(R.drawable.ic_right_black_arrow_24dp);
        termsimage.setImageResource(R.drawable.ic_right_black_arrow_24dp);
        faqimage.setImageResource(R.drawable.whitearrow);

    }

    private void termAnim() {
        linearLayoutprofile.setBackgroundResource(R.drawable.textview_background);
        linearLayoutterms.setBackgroundResource(R.drawable.clicked_background_layout);
        linearLayoutfaq.setBackgroundResource(R.drawable.textview_background);
        //Arrow Modification
        profile.setImageResource(R.drawable.ic_right_black_arrow_24dp);
        termsimage.setImageResource(R.drawable.whitearrow);
        faqimage.setImageResource(R.drawable.ic_right_black_arrow_24dp);

    }

    private void profileAnim() {
        linearLayoutprofile.setBackgroundResource(R.drawable.clicked_background_layout);
        linearLayoutterms.setBackgroundResource(R.drawable.textview_background);
        linearLayoutfaq.setBackgroundResource(R.drawable.textview_background);
        //Arrow Modification
        profile.setImageResource(R.drawable.whitearrow);
        termsimage.setImageResource(R.drawable.ic_right_black_arrow_24dp);
        faqimage.setImageResource(R.drawable.ic_right_black_arrow_24dp);

    }
    private void openFragment(Fragment hm) {
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.framelayout1,hm);
        fm.commit();
    }
}
