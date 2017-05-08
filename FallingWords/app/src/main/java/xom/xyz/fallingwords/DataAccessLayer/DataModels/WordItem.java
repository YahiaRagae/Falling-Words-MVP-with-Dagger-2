package xom.xyz.fallingwords.DataAccessLayer.DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by yahia on 5/8/17.
 */


public class WordItem {

    @SerializedName("text_eng")
    @Expose
    private String textEng;
    @SerializedName("text_spa")
    @Expose
    private String textSpa;

    public String getTextEng() {
        return textEng;
    }

    public void setTextEng(String textEng) {
        this.textEng = textEng;
    }

    public String getTextSpa() {
        return textSpa;
    }

    public void setTextSpa(String textSpa) {
        this.textSpa = textSpa;
    }

}
