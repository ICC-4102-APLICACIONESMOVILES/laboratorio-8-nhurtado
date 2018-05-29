package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Form.class,
        parentColumns = "questionId",
        childColumns = "questionId",
        onDelete = CASCADE))

public class Answer {
    @PrimaryKey
    private int uid;

    @NonNull
    private int questionId;

    @ColumnInfo(name = "text")
    private String text;

    public Answer(int uid, String text) {
        this.uid = uid;
        this.text = text;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getquestionId() {
        return questionId;
    }

    public void setquestionId(int questionId) {
        this.questionId = questionId;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }
}
