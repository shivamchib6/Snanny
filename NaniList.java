package com.example.snanny.UserClasses;

class NaniList {
    int imageid;
    String naniname;

    public String getNaniname() {
        return naniname;
    }

    public void setNaniname(String naniname) {
        this.naniname = naniname;
    }

    public NaniList(int imageid, String naniname) {
        this.imageid = imageid;
        this.naniname = naniname;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
