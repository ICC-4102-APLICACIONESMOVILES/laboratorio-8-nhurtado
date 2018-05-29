package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Form.class,
        parentColumns = "uid",
        childColumns = "formId",
        onDelete = CASCADE))

public class Question {
    @PrimaryKey
    private int uid;

    @NonNull
    private int formId;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "type")
    private String type;

    public Question(int uid, int formId, String text, String type) {
        this.uid = uid;
        this.formId = formId;
        this.text = text;
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getText() {
        return text;
    }

    public void setText(String date) {
        this.text =text;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type =type;
    }
}
